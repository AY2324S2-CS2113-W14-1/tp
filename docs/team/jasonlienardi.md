# Jason Lienardi's Project Portfolio Page

## Project: FitNUS

### Overview
FitNUS is a CLI application that aims to help combat diabetes and the overconsumption of calories, sugar, and
carbohydrates. Our vision is to promote healthy lifestyle amongst NUS students.

### Summary of Contributions

#### Code contributed: [RepoSense Link](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2024-02-23)

#### Features implemented
- Created FitNUS which is the entry point of the app
- Created Meal class and MealList class 
- Created Exercise class, ExerciseIntensity enumeration and ExerciseList class
- Added a newMeal command which allows users to store the nutrient details of their favorite meals in the app. The new meal will be added to the available meals csv to allow users to track the meal in the future
- Added a newDrink command which allows users to store the nutrient details of their favorite drinks in the app. The new drink will be added to the available drinks csv to allow users to track the drink in the future
- Added a newExercise command which allows users to store the details regarding the calories burnt for a certian exercise. The new exercise will be added to the available exercises csv to allow users to track the exercise in the future

#### Enhancements implemented
- Updated exception handling to give more specific edge cases (ie. negative value exception for meal/drink nutrient and exercise calories and non-positive value exception for meal/drink serving size and exercise duration) [#139](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/139)

#### Project Management
- Wrapped up milestones `v1.0`, `v2.0` and `v2.1`

#### Contributions to User Guide
- Added documentation for features `eat`, `drink`, `water`, `exercise`, `infoMeal`, `infoDrink`, `infoExercise`, `calories`, `carbs`, `protein`, `fat`, `sugar`, `fiber`, `viewWater`, `caloriesBurnt`, `listMeals`, `listDrinks`, `listExercises`, `listEverything`, `listMealsAll`, `listDrinksAll`, `listExercisesAll`, `listEverythingAll`. Complete with command description, format, sample input and expected output. [#63](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/63/files#diff-1a95edf069a4136e9cb71bee758b0dc86996f6051f0d438ec2c424557de7160b)

#### Contributions to Developer Guide
- Added implementation details for `eat`, `editMeal`, `newMeal`, and `deleteMeal` feature. As well sequence diagrams for `eat`, `editMeal` and `newMeal` commands. [#151](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/151/files)

#### Contributions to team-based tasks
- Managed GitHub issues
- Assigned issues to team members
- Linked PR and Issues to Milestones
- Clean-up formatting of DG and UG

#### Review or Mentoring Contributions
- PR Reviews: [#44](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/44), [#61](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/61), [#84](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/84), [#155](https://github.com/AY2324S2-CS2113-W14-1/tp/pull/155)