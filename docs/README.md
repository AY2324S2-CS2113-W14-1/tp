# FitNUS
## Project Introduction
FitNUS is a CLI application that aims to help combat diabetes and the overconsumption of calories, sugar, and
carbohydrates. Our vision is to promote healthy lifestyle amongst NUS students.

Users are able to track the meals, drinks, and exercises they have in a day and even past records. 

Useful links:
* [User Guide](UserGuide.md)
* [Developer Guide](DeveloperGuide.md)
* [About Us](AboutUs.md)

---

## Setup 
To use the app please follow the setup procedures below:
1. Download the JAR file. 
2. Place it into an empty folder. 
3. Navigate to the folder you just created.
4. Run the JAR file with the following command:
```
-$ java -jar FitNUS.jar
```

---

## Features List
### 1 Information for users
1. View all possible commands: `help`
2. View all pre-defined meals. These meals will have their nutritional content defined per serving size and can
be inputted immediately: `allMeals`
3. View all pre-defined drinks. These drinks will have their nutritional content defined per 100ml
and can be inputted immediately: `allDrinks`
4. Viewing all pre-defined exercises. These exercises will have the number of calories burnt for a
high/medium/low intensity workout defined per minute and can be inputted immediately: `allExercises`

### 2 For user to add data
1. Adds a meal to the list of meals consumed today: `eat`
2. Add a drink to the list of drinks consumed today: `drink`
3. Add an exercise to the list of exercises done: `exercise`
4. Add a custom new meal on top of pre-defined meals: `newMeal`
5. Add a custom new drink on top of pre-defined drink: `newDrink`
6. Add a custom new exercise on top of pre-defined exercises: `newExercise`

### 3 For user to retrieve data
1. Find nutritional content about a certain meal: `infoMeal`
2. Find nutritional content about a certain drink: `infoDrink`
3. Find the calories burnt per minute from a certain exercise: `infoExercise`
4. View daily net calorie count: `calories`
5. View daily carbohydrates consumed: `carbs`
6. View daily proteins consumed: `protein`
7. View daily fat consumed: `fat`
8. View daily sugar consumed: `sugar`
9. View daily fiber consumed: `fiber`
10. View daily water consumption: `water`
11. View daily calories burnt: `caloriesBurnt`
12. View daily calories and water intake recommendation, based on current intake: `recommend`
    
### 4 For users to view their lists and data
1. List today's meal intakes: `listMeals`
2. List today's drink intake: `listDrinks`
3. List today's exercises done: `listExercises`
4. List everything inputted today, inclusive of all meals, drinks and exercises: `listEverything`
5. List entire app's lifecycle meals intake, inclusive of previously inputted meals and their dates: `listMealsAll`
6. List entire app's lifecycle drinks intake, inclusive of previously inputted drinks and their dates: `listDrinksAll`
7. List entire app's lifecycle exercises done, inclusive of previously inputted exercises and their dates: `listExercisesAll`
8. List everything inputted for the entire app's lifecycle: `listEverythingAll`
9. List meal intake for a certain date: `listMeals d/[DATE]`
10. List drink intake for a certain date: `listDrinks d/[DATE]`
11. List exercise done for a certain date: `listExercises d/[DATE]`
12. List entire food intake and exercise done for a certain date: `listEverything d/[DATE]`

### 5 For users to edit existing data
1. Edit the serving size of a meal that was inputted in the day: `editMeal`
2. Edit the volume of a drink that was inputted in the day: `editDrink`
3. Edit total water intake of the day: `editWater`

### 6 For users to delete existing data
1. Delete a meal entry: `deleteMeal`
2. Delete a drink entry: `deleteDrink`
3. Delete an exercise entry: `deleteExercise`

### 7 For users to clear all data
1. Clear all entries of meals, drinks and exercise: `clear`

---

## Exit the program
Close the application and save all the changes made: `exit`
