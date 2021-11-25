@tag
Feature: US00 Creation de Personnage

  En tant que Utilisateur
  je veux creer des personnages (superhero et ennemi)
  afin de pouvoir les utiliser 
  
  
  Scenario Outline: Ajout dun Superhero  
  Given un Superheros de <power> positifs
  When le superhero est cree
  Then  le superhero est bien instancie
  
  Examples:
	| power |
	| 100   |
  
  Scenario Outline: Ajout dun Ennemi  
  Given un Ennemi de <strength> positifs
  When le Ennemi est cree
  Then  le Ennemi est bien instancie

	Examples:
	| strength |
	| 100      |
	



    