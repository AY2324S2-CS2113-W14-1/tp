# Bryan Castorius' Project Portfolio Page

FitNUS is a CLI application that aims to help combat diabetes and the overconsumption of calories, sugar, and
carbohydrates. Our vision is to promote healthy lifestyle amongst NUS students.

---
Given below are my contributions to the project.

### Code Contributed: 
Click on the following link: [Individual Reposense](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=w14&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23)
### Features Implemented:
#### Drink and Water Class
  * Methods to handle inserting water and drink volume
  * Methods to edit the water volume intake
  * Methods to obtain the nutritional value for each drink object
  * Reorganize Drink and Water Class into part of DrinkList class
#### Recommendations
  * Method to provide the recommended amount of water and calories intake.

### Enhancements Implemented

#### Drink and Water Class
  * Create various exceptions for handling invalid insertion to the drink command (e.g. UnregisteredDrinkException, InvalidEditWaterException)
  * Making sure that only one object of water can be created per day will only add volume to the existing water object if it is still the same day
  * Added javadoc documentation inside the Drink and Water class and also other class methods that relates to Drink and Water class

#### Parser Class
  * Update the help command output message
  * Catch exceptions relating to Water and Drink Class
  * Methods to parse the load and store Exercise command made from current session into ExerciseList.txt

### Contributions to Developer Guide
  * Added User Stories
  * Added Table of Content
  * Added Instructions for Manual Testing including basic features
  * Added class diagrams for Meal, Drink, Exercise components and their explanation
  * Added architecture diagram and its explanation
  * Added InfoMeal sequence diagram and its explanation

### Contributions to User Guide
  * Added FAQs
  * Update Table of Content
  * Added explanations, sample inputs and outputs for features relating to adding data and data retrieval

### Project Management
  * Added issues for milestone `v1.0`, `v2.0`, and `v2.1`
  * Solve and debug issues relating to Drink and Water feature from PE dry run
  * Merge and resolve conflicts from other peers' pull requests