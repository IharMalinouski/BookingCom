package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class BookingSteps {

    String city;
    String nameHotel;
    String hotel;

    private static final String RATING = "//*[text() ='%s']/ancestor::*[@class='_84f6fd780 _f98eca565']//*[@class='_9c5f726ff bd528f9ea6']";

    @Given("User is looking for hotel {string} city")
    public void userIsLookingForHotelIsCity(String city) {
        this.city = city;
    }

    @When("User does search")
    public void userDoesSearch() {
        open("https://www.booking.com/");
        $(By.id("ss")).sendKeys(city);
        $(".sb-searchbox__button").click();

    }

    @Then("Hotel {string} should be on the first page")
    public void hotelHamptonByHiltonMinskCityCentreShouldBeOnTheFirstPage(String hotel) {
        ArrayList<String> hotelsNames = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath("//*[@data-testid='title']"))) {
            hotelsNames.add(element.getText());
        }
        Assert.assertTrue(hotelsNames.contains(hotel));
    }

    @Then("Hotel {string} should be on the first page with the name {string}")
    public void hotelHotelShouldBeOnTheFirstPageWithTheNameNameHotel(String hotel, String nameHotel) {
        this.nameHotel = nameHotel;
        this.hotel = hotel;
        ArrayList<String> hotelsNames = new ArrayList<>();
        for (SelenideElement element : $$(By.xpath(String.format(RATING, nameHotel)))) {
            hotelsNames.add(element.getText());
            System.out.println(hotelsNames); // sout чисто для проверить респонс
            Assert.assertEquals(hotelsNames.toString(), hotel.toString());
        }
    }
}
