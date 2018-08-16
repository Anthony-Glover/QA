Feature: Shopping on a website
  As a person
  I want to browse items on a website
  So that I can purhcase the items I want

Scenario: Browse the items available on the website
  Given the correct web address
  When I navigate to the 'Menu' page
  Then I can browse a list of the available products

Scenario Outline: Browse the items available on the website
  Given the correct "<website>" web address
  When I navigate to the 'Menu' page  "<value>"
  Then I can browse a list of the available products

Examples: 
	| website   | value |
	| http://www.practiceselenium.com/welcome.html | 1 |
	| http://www.practiceselenium.com/welcome.html | 2 | 
	| http://www.practiceselenium.com/welcome.html | 1 | 
	| http://www.practiceselenium.com/welcome.html | 20 | 


