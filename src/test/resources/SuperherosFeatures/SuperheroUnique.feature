@tag
Feature: US02 Superhero Unique pour lennemi 

  en tant que utilisateur
  je veux que tout au long la vie de lennemi, un seul superhero lui soit affecte
  afin qu il ne puisse se battre que avec un seul superhero


  Scenario Outline: un seul superhero par ennemi
    Given un ennemi de force <strength>
    And premier Superhero  de force <power1> et deuxieme Superhero de force <power2>
    When lennemi et le premier superhero sappretent au combat
    Then impossible daffecter le deuxieme superhero a lennemi

    Examples: 
      | strength |  power1 | power2|
      | 100      |  80     |  75   |
      
     
  Scenario Outline: changer de superhero
    Given un ennemi de force <strength>
    And premier Superhero  de force <power1> et deuxieme Superhero de force <power2>
    When lennemi et le premier superhero sappretent au combat mais lennemi change de superhero
    Then le premier superhero est remplace par le deuxieme
    And lennemi nest plus dans la liste du premier superhero
    
    Examples: 
      | strength |  power1 | power2|
      | 100      |  80     |  75   |
      
  