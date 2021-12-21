Feature: Search for booking.com

  Scenario: Search by city criteria
    Given User is looking for hotel 'Minsk' city
    When User does search
    Then Hotel 'Hampton by Hilton Minsk City Centre' should be on the first page

  Scenario Outline: Search by different cities criteria
    Given User is looking for hotel '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page

    Examples:
      | City  | Hotel                               |
      | Minsk | Hampton by Hilton Minsk City Centre |
      | Brest | Brest Central Apartment             |
      | Gomel | Apartment On Lenina 20              |


  Scenario Outline: Comparison of hotel ratings from a feature file
    Given User is looking for hotel '<City>' city
    When User does search
    Then Hotel '<Rating>' should be on the first page with the name '<NameHotel>'

    Examples:
      | City  | Rating | NameHotel                           |
      | Minsk | [8,4]  | Гостиница Беларусь                  |
      | Minsk | [8,6]  | Виктория Спа Минск                  |
      | Minsk | [9,2]  | Imperial Palace Hotel               |
      | Minsk | [9,1]  | DoubleTree by Hilton Минск          |
      | Minsk | [8,7]  | Renaissance Minsk Hotel by Marriott |
      | Minsk | [8,1]  | Отель Юбилейный                     |
      | Minsk | [8,2]  | Виктория Отель & Бизнес Центр       |


