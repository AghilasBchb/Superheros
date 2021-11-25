@tag
Feature: US01 Combat ennemi superhero
  en tant que utilisateur
  je veux mettre en combat un ennemie et un superhero
  afin que le plus fort gagne 

  
  Scenario Outline: ennemi versus superhero
    Given un ennemi de <strength> positif
    And un Superheros de <power> positif 
    When lennemi et superhero sappretent au combat
    Then le plus fort gagnera
    And lennemi nest plus relie au superhero
    And le superhero nest plus relie a lennemi
 
    Examples: 
  | strength | power |
	| 80       | 100   |
	| 100      | 80    |
	
	
	