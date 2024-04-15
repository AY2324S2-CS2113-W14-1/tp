# User Guide: FitNUS

---
## Project Introduction
FitNUS is a CLI application that aims to help combat diabetes and the overconsumption of calories, sugar, and
carbohydrates. Our vision is to promote healthy lifestyle amongst NUS students.

Users are able to track the meals, drinks, and exercises they have in a day and even view past records.

---

## Table of Contents
<!-- TOC -->
* [1) Setup](#1-setup)
* [2) Features List](#2-features-list)
  * [2.1 Information for users](#21-information-for-users)
  * [2.2 For user to add data](#22-for-user-to-add-data)
  * [2.3 For data retrieval](#23-for-data-retrieval)
  * [2.4 For listing arrays](#24-for-listing-arrays)
  * [2.5 For editing existing data](#25-for-editing-existing-data)
  * [2.6 For deleting data](#26-for-deleting-data)
  * [2.7 For clearing data](#27-for-clearing-data)
  * [2.8 Exit program](#28-exit-program)
* [3) Frequently Asked Questions (FAQ)](#3-faq)
<!-- TOC -->

---
## 1) Setup
To use the app please follow the setup procedures below:
1. Download the JAR file.
2. Place it into an empty folder.
3. Navigate to the folder you just created.
4. Run the JAR file with the following command:
```
-$ java -jar FitNUS.jar
```

**Note**:
1. All files under 'data' and 'db' folders should not be modified by user.
2. Enter `exit` to properly close the program and save the data.
---
## 2) Features List
* For ease of reading this guide, _**sample input**_ is only provided if input command is not the command itself, i.e. the
  input is not one-word.
## 2.1 Information for users
### 2.1.1 Viewing all commands: `help`
Shows a list of all possible command inputs recognised by the application.

**Format**: `help`   
**Expected Output**:
~~~
Here's all the valid commands I recognise: 

Track a meal/drink/exercise: 
- Track a meal eaten: eat m/MEAL s/SERVING_SIZE
- Track a drink: drink d/DRINK s/VOLUME(ML)
- Track an exercise: exercise e/EXERCISE d/DURATION(MINUTES) i/INTENSITY(HIGH, MEDIUM, LOW)

View available meals/drinks/exercises: 
- View all meals that you can input: allMeals
- View all drinks that you can input: allDrinks
- View all exercises that you can input: allExercises

Find information about a meal/drink/exercise: 
- Find the information about a certain meal: infoMeal MEAL
- Find the information about a certain drink: infoDrink DRINK
- Find the information about a certain exercise: infoExercise EXERCISE

View nutrients and calories: 
- View daily calories consumed: calories
- View daily carbohydrates consumed: carbs
- View daily proteins consumed: protein
- View daily fat consumed: fat
- View daily sugar consumed: sugar
- View daily fiber consumed: fiber
- View daily water consumption: water
- View daily calories burnt: caloriesBurnt

List Commands: 
- List today's meal intake: listMeals
- List today's drink intake: listDrinks
- List today's exercises done: listExercises
- List today's entire food intake and exercises: listEverything
- List all meal intake: listMealsAll
- List all drink intake: listDrinksAll
- List all exercises done: listExercisesAll
- List all food intake and exercises: listEverythingAll
- List meal intake for certain date: listMeals d/dd-MM-yyyy
- List drink intake for certain date: listDrinks d/dd-MM-yyyy
- List exercises done for certain date: listExercises d/dd-MM-yyyy
- List entire food intake and exercises for certain date: listEverything d/dd-MM-yyyy

Edit Commands: 
- Edit an existing meal after inserted: editMeal INDEX s/NEW_SERVING_SIZE
- Edit an existing drink after inserted: editDrink INDEX s/NEW_SERVING_SIZE
- Edit total water intake after inserted: editWater s/TOTAL_WATER_INTAKE

Delete Commands: 
- Delete certain meal entry: deleteMeal INDEX
- Delete certain drink entry: deleteDrink INDEX
- Delete certain exercise entry: deleteExercise INDEX

Adding a meal/drink/exercises to available list: 
- Add a new meal to available meals: newMeal MEAL_NAME,CALORIES,CARBS,PROTEIN,FAT,FIBER,SUGAR
- Add a new drink to available drinks: newDrink DRINK_NAME,CALORIES,CARBS,SUGAR,PROTEIN,FAT
- Add a new exercise to available exercises: newExercise EXERCISE_NAME,CALORIES_BURNT_HIGH,CALORIES_BURNT_MEDIUM,
CALORIES_BURNT_LOW

Miscellaneous: 
- View daily calories and water intake recommendation: recommend
- Clear all entries: clear
- Exit the app: exit 
~~~
### 2.1.2 Viewing all pre-defined meals: `allMeals`
Shows a list of all pre-defined meals. These meals will have their nutritional content defined per serving size and can
be inputted immediately.  
Note: If the user has added a self-defined meal previously (using `newMeal`), this self-defined meal will also be
displayed.

**Format**: `allMeals`   
**Expected Output**:
~~~
Available meals: 
- ban mian
- tau huay
- nasi goreng
- babi kecap
- soup kambeng
- nasi lemak
- pepper lunch
- char siew rice
- pork satay with satay sauce
- roti prata
- mee goreng
- chendol
- wanton mee
- oyster omlette
- pizza
- ice kachang
- chicken rice
- fried rice
- kaya toast
- mala
- laksa
- hokkien prawn mee
- durian

You may also input a meal that isn't here with newMeal.
~~~

### 2.1.3 Viewing all pre-defined drinks: `allDrinks`
Shows a list of all pre-defined drinks. These drinks will have their nutritional content defined per 100ml
and can be inputted immediately.
Note: If the user has added a self-defined drink previously (using `newDrink`), this self-defined drink will also be
displayed.

**Format**: allDrinks  
**Expected Output**:
~~~
Available drinks: 
- water
- sprite
- iced lemon tea
- milo
- kopi
- soursop juice
- kopi c
- kalamansi juice
- coke
- kopi o
- plum juice
- teh c bing
- guava juice
- tiger beer
- teh tarik
- sugarcane juice
- teh
- bandung

You may also input a drink that isn't here with newDrink.
~~~

### 2.1.4 Viewing all pre-defined exercises: `allExercises`
Shows a list of all pre-defined exercises. These exercises will have the number of calories burnt for a
high/medium/low intensity workout defined per minute and can be inputted immediately.  
Note: If the user has added a self-defined exercise previously (using `newExercise`), this self-defined exercise will
also be displayed.

**Format**: allExercises  
**Expected Output**:
~~~
Available exercises: 
- running
- swimming
- cycling

You may also input an exercise that isn't here with newExercise.
~~~

## 2.2 For user to add data
Importantly, any user-added data will only be saved to our database when you **safely exit** our application with the
command `exit`.  Any other mode of termination will result in the loss of the inputs from this use.

### 2.2.1 Add a meal eaten: `eat`
Adds a meal to the list of meals consumed today.

**Format**: `eat m/MEAL s/SERVING_SIZE`  
**Sample Input**: `eat m/Chicken Rice s/1`  
**Expected Output**:
~~~
Added 1 serving of chicken rice
~~~

### 2.2.2 Add a drink: `drink`
Adds a drink to the list of drinks consumed today.  
This includes adding a specified volume of water to the amount of water consumed today.

**Format**: `drink d/DRINK s/VOLUME(ML)`  
**Sample Input**: `drink d/Iced Lemon Tea s/200`  
**Expected Output**:
~~~
Added 200 ml of iced lemon tea
~~~

### 2.2.3 Add exercise: `exercise`
Adds an exercise to the list of exercises completed today.

**Format**: `exercise e/EXERCISE d/DURATION(MINUTES) i/INTENSITY(HIGH, MEDIUM, LOW)`  
**Sample Input**: `exercise e/swimming d/30 i/HIGH`  
**Expected Output**:
~~~
Tracked 30 minutes of swimming
~~~

### 2.2.4 Add new meal to pre-defined meals: `newMeal`
Adds a user-defined new meal to the pre-defined meals. You would need to input the **meal name** and its
corresponding **nutritional content** (namely calories, carbohydrates content, protein, fat, fiber, sugar) per
serving of intake.

A reminder that this user-defined meal will only be saved to our database when you **safely exit** our application with
the command `exit`.

Additionally, you may use `newMeal` to override existing nutritional content data, by using the MEAL_NAME in the 
command. In short, `newMeal` will **override any past data** with the specified meal name.

Note: We are not responsible for whether the meal name and its nutrional contents are accurate.
Please verify your information before inputting.

**Format**: `newMeal MEAL_NAME,CALORIES,CARBS,PROTEIN,FAT,FIBER,SUGAR`  
**Sample Input**: `newMeal mie,607,75,25,23,2,10`  
**Expected Output**:
~~~
Added mie to available meals
~~~

### 2.2.5 Add new drink to pre-defined drinks: `newDrink`
Adds a user-defined new drink to the pre-defined drinks. You would need to input the **drink name** and its
corresponding **nutritional content** (namely calories, carbohydrates content, sugar, protein, fat) per **100ml** of
intake.

A reminder that this user-defined drink will only be saved to our database when you **safely exit** our application
with the command `exit`.

Additionally, you may use `newDrink` to override existing nutritional content data, by using the DRINK_NAME in the
command. In short, `newDrink` will **override any past data** with the specified drink name.

Note: We are not responsible for whether the drink name and its nutrional contents are accurate.
Please verify your information before inputting.

**Format**: `newDrink DRINK_NAME,CALORIES,CARBS,SUGAR,PROTEIN,FAT`   
**Sample Input**: `newDrink coke,153,32,1,2,1`   
**Expected Output**:
~~~
Added coke to available drinks
~~~

### 2.2.6 Add new exercise to pre-defined exercises: `newExercise`
Adds a user-defined new exercise to the pre-defined exercises. You would need to input the **exercise name** and its
corresponding **calories burnt** for a **1 minute** HIGH, MEDIUM and LOW intensity workout.

A reminder that this user-defined exercise will only be saved to our database when you **safely exit** our application
with the command `exit`.

Additionally, you may use `newExercise` to override existing calories burnt data, by using the EXERCISE_NAME in the
command. In short, `newExercise` will **override any past data** with the specified exercise name.

**Note**: We are not responsible for whether the exercise name and its calories burnt are accurate.
Please verify your information before inputting.

**Format**: `newExercise EXERCISE_NAME, CALORIES_BURNT_HIGH, CALORIES_BURNT_MEDIUM, CALORIES_BURNT_LOW`   
**Sample Input**: `newExercise badminton,20,10,5`  
**Expected Output**:
~~~
Added badminton to available exercises
~~~

## 2.3 For data retrieval
### 2.3.1 Find the information about a certain meal: `infoMeal`
For the specified meal, display its nutritional content **per serving** to the user.

**Format**: `infoMeal MEAL`  
**Sample Input**: `infoMeal chicken rice`  
**Expected Output**:
~~~
Meal: chicken rice (per serving)
Calories: 400 kcal
Carbs: 50 g
Protein: 30 g
Fat: 20 g
Fiber: 10 g
Sugar: 5 g
~~~

### 2.3.2 Find the information about a certain drink: `infoDrink`
For the specified drink, display its nutritional content **per 100ml** to the user.

**Format**: `infoDrink DRINK`  
**Sample input**: `infoDrink milo`  
**Expected output**:
~~~
Drink: milo (per 100 ml)
Calories: 124 kcal
Carbs: 20 g
Sugar: 3 g
Protein: 3 g
Fat: 1 g
~~~

### 2.3.3 Find the information about a certain exercise: `infoExercise`
For the specified exercise, display its **calories burnt per minute** for different intensities (HIGH, MEDIUM, LOW) to
the user.

**Format**: `infoExercise EXERCISE`   
**Sample input**: `infoExercise swimming`   
**Expected output**:
~~~
Exercise: swimming
~ Calories burnt for a 1 minute workout of ~
HIGH intensity: 12 kcal
MEDIUM intensity: 8 kcal
LOW intensity: 5 kcal
~~~

### 2.3.4 View daily net calorie count: `calories`
Display current net calorie count **in kcal**  for the day. This takes into account the calories consumed from meals
and drinks,
and the calories burnt from exercise.

**Format**: `calories`    
**Expected output**:
~~~
Total Calories: 230 kcal
~~~

### 2.3.5 View daily carbohydrates consumed: `carbs`
Display current total carbohydrates intake **in grams**  for the day.

**Format**: `carbs`  
**Expected output**:
~~~
Total Carbohydrates: 150 grams
~~~

### 2.3.6 View daily proteins consumed: `protein`
Display current total protein intake **in grams**  for the day.

**Format**: `protein`  
**Expected output**:
~~~
Total Proteins: 100 grams
~~~

### 2.3.7 View daily fat consumed: `fat`
Display current total fat intake **in grams**  for the day.

**Format**: `fat`  
**Expected output**:
~~~
Total Fat: 50 grams
~~~

### 2.3.8 View daily sugar consumed: `sugar`
Display current total sugar intake **in grams**  for the day.

**Format**: `sugar`  
**Expected output**:
~~~
Total Sugar: 20 grams
~~~

### 2.3.9 View daily fiber consumed: `fiber`
Display current total fiber intake **in grams** for the day.

**Format**: `fiber`  
**Expected output**:
~~~
Total Fiber: 20 grams
~~~

### 2.3.10 View daily water consumption: `water`
Display current total water intake  **in ml**  for the day.

**Format**: `water`  
**Expected output**:
~~~
Total water intake today: 0 ml
~~~

### 2.3.11 View daily calories burnt: `caloriesBurnt`
Display current total calorie burnt  **in kcal** for the day.

**Format**: `caloriesBurnt`    
**Expected output**:
~~~
Total calories burnt: 360 kcal
~~~

### 2.3.12 View daily calories and water intake recommendations: `recommend`
Display a recommendation based on the current water and calories intake.   
Note: This is a very simplified recommendation system that takes into account that an average human being should drink
approximately 2600ml of water and 2200kcal per day.

**Format**: `recommend`    
**Expected output**:
~~~
We recommend drinking more water. Please drink 2600 ml more water by the end of the day to hit the daily water 
intake goal :)
    ~~
We recommend eating more food. Please eat 1610 more calories by today :)
~~~

## 2.4 For listing arrays
### 2.4.1 List today's meal intake: `listMeals`
Display all the meals the user has inputted today.

**Format**: `listMeals`   
**Expected output**:
~~~
here's what you have eaten today
1. chicken rice (serving size: 1) | date: 01-04-2024
~~~

### 2.4.2 List today's drink intake: `listDrinks`
Display all the drinks user has inputted today.

**Format**: `listDrinks`  
**Expected output**:
~~~
here's what you have drank today
1. sprite (volume: 100ml) | date: 01-04-2024

Total water intake today: 0 ml
~~~

### 2.4.3 List today's exercises done: `listExercises`
Display all the exercises user tracked today.

**Format**: `listExercises`  
**Expected output**:
~~~
here's the exercises you've done today
1. boxing | duration: 10 | intensity: LOW | date: 01-04-2024
~~~

### 2.4.4 List everything inputted today: `listEverything`
Display all the meals, drinks and exercises user tracked today.

**Format**: `listEverything`  
**Expected output**:
~~~
here's what you have consumed today
1. chicken rice (serving size: 1) | date: 01-04-2024
2. sprite (volume: 100ml) | date: 01-04-2024

Total water intake today: 100 ml
       ~~~
here's the exercises you've done today
1. boxing | duration: 10 | intensity: LOW | date: 01-04-2024
~~~

### 2.4.5 List all meals intake from the entire app's lifecycle : `listMealsAll`
Display all the meals inputted during the entire app lifecycle.  
Note: As mentioned, meals are only saved to our database when you **safely exit** our application with the
command `exit`.  Any other mode of termination will result in the loss of the inputs from that use.


**Format**: `listMealsAll`   
**Expected output**:
~~~
here's what you have eaten so far
1. mala (serving size: 2) | date: 30-03-2024
2. chicken rice (serving size: 1) | date: 01-04-2024
~~~

### 2.4.6 List all drinks intake from the entire app's lifecycle: `listDrinksAll`
Display all the drinks inputted during the entire app lifecycle.  
Note: As mentioned, drinks are only saved to our database when you **safely exit** our application with the
command `exit`.  Any other mode of termination will result in the loss of the inputs from that use.

**Format**: `listDrinksAll`  
**Expected output**:
~~~
here's what you have drank so far
1. milo dinosaur (volume: 200ml) | date: 30-03-2024
2. sprite (volume: 100ml) | date: 01-04-2024

Total water intake today: 100 ml
~~~

### 2.4.7 List all exercises done from the entire app's lifecycle: `listExercisesAll`
Display all the exercises inputted during the entire app lifecycle.  
Note: As mentioned, exercises are only saved to our database when you **safely exit** our application with the
command `exit`.  Any other mode of termination will result in the loss of the inputs from that use.

**Format**: `listExercisesAll`  
**Expected output**:
~~~
here's the exercises you've done so far
1. cycling | duration: 100 | intensity: LOW | date: 29-02-2024
2. swimming | duration: 100 | intensity: HIGH | date: 30-03-2024
3. boxing | duration: 10 | intensity: LOW | date: 01-04-2024
~~~

### 2.4.8 List everything inputted for the entire app's lifecycle: `listEverythingAll`
Display all the drinks, meals, and exercises inputted for the entire app lifecycle.

**Format**: `listEverythingAll`  
**Expected output**:
~~~
here's what you have consumed so far
1. mala (serving size: 2) | date: 30-03-2024
2. chicken rice (serving size: 1) | date: 01-04-2024
3. milo dinosaur (volume: 200ml) | date: 30-03-2024
4. sprite (volume: 100ml) | date: 01-04-2024

Total water intake today: 100 ml
       ~~~
here's the exercises you've done so far
1. cycling | duration: 100 | intensity: LOW | date: 29-02-2024
2. swimming | duration: 100 | intensity: HIGH | date: 30-03-2024
3. boxing | duration: 10 | intensity: LOW | date: 01-04-2024
~~~

### 2.4.9 List meal intake for a certain date: `listMeals d/[DATE]`
Display all the meals user inputted for the specified date, in the format **dd-MM-yyyy**. You may not view a
future date, i.e. dates from tomorrow onwards.

**Format**: `listMeals d/dd-MM-yyyy`  
**Sample input**: `listMeals d/01-04-2024`  
**Expected output**:
~~~
here's what you have eaten on 01-04-2024
1. soup kambeng (serving size: 2) | date: 01-04-2024
2. nasi lemak (serving size: 2) | date: 01-04-2024
3. tau huay (serving size: 1) | date: 01-04-2024
4. roti prata (serving size: 2) | date: 01-04-2024
~~~

### 2.4.10 List drink intake for a certain date: `listDrinks d/[DATE]`
Display all the drinks user inputted for the specified date (excluding water), in the format **dd-MM-yyyy**. You may not view a
future date, i.e. dates from tomorrow onwards.

**Format**: `listDrinks d/dd-MM-yyyy`  
**Sample input**: `listDrinks d/01-04-2024`  
**Expected output**:
~~~
here's what you have drank on 01-04-2024
1. honey lemon tea (volume: 200ml) | date: 01-04-2024
2. kopi c (volume: 500ml) | date: 01-04-2024
3. milo (volume: 200ml) | date: 01-04-2024
~~~

### 2.4.11 List exercise done for a certain date: `listExercises d/[DATE]`
Display all the exercises user inputted for the specified date, in the format **dd-MM-yyyy**. You may not view a
future date, i.e. dates from tomorrow onwards.

**Format**: `listExercises d/dd-MM-yyyy`  
**Sample input**: `listExercises d/01-04-2024`  
**Expected output**:
~~~
here's the exercises you've done on 01-04-2024
1. boxing | duration: 10 | intensity: LOW | date: 01-04-2024
~~~

### 2.4.12 List everything inputted for a certain date: `listEverything d/[DATE]`
Display all the meals, drinks, and exercises user inputted for the specified date, in the format **dd-MM-yyyy**. You may not view a
future date, i.e. dates from tomorrow onwards.

**Format**: `listEverything d/dd-MM-yyyy`  
**Sample input**: `listEverything d/01-04-2024`  
**Expected output**:
~~~
here's what you have consumed on 01-04-2024
1. soup kambeng (serving size: 2) | date: 01-04-2024
2. nasi lemak (serving size: 2) | date: 01-04-2024
3. tau huay (serving size: 1) | date: 01-04-2024
4. roti prata (serving size: 2) | date: 01-04-2024
5. honey lemon tea (volume: 200ml) | date: 01-04-2024
6. kopi c (volume: 500ml) | date: 01-04-2024
7. milo (volume: 200ml) | date: 01-04-2024

       ~~~
here's the exercises you've done on 01-04-2024
1. boxing | duration: 10 | intensity: LOW | date: 01-04-2024
~~~

## 2.5 For editing existing data
Note: There is no method to edit an inputted exercise of the day. If you would like to change a value in your 
exerciseList, please use `deleteExercise` and add it again as a new exercise (`exercise`).
### 2.5.1 Edit an existing meal after inserted: `editMeal`
For a meal that was inputted in the day, edit its serving size. You may identify the meal by its index in listMeals.

**Format**: `editMeal INDEX s/NEW_SERVING_SIZE`  
**Sample input**: `editMeal 2 s/10`  
**Expected output**:
~~~
chicken rice has been edited to 10 serving(s)
~~~

### 2.5.2 Edit an existing drink after inserted: `editDrink`
For a drink that was inputted in the day, edit its intake volume. You may identify the drink by its index in
listDrinks.

**Format**: `editDrink INDEX s/NEW_VOLUME`  
**Sample input**: `editDrink 1 s/200`  
**Expected output**:
~~~
iced lemon tea has been edited to 200 ml
~~~

### 2.5.3 Edit water intake after inserted: `editWater`
Edit the total volume of water intake of the day, in ml.

**Format**: `editWater s/TOTAL_WATER_INTAKE`  
**Sample input**: `editWater s/200`  
**Expected output**:
~~~
Total water intake has been edited to 200 ml
~~~

## 2.6 For deleting data
### 2.6.1 Delete a certain meal entry: `deleteMeal`
Delete a meal that was inputted today. You may identify the meal by its index in listMeals.

**Format**: `deleteMeal INDEX`  
**Sample Input**: `deleteMeal 1`  
**Expected output**:
~~~
Removed chicken rice from meals
~~~

### 2.6.2 Delete a certain drink entry: `deleteDrink`
Delete a drink that was inputted today. You may identify the drink by its index in listDrinks.

**Format**: `deleteDrink INDEX`  
**Sample input**: `deleteDrink 1`  
**Expected output:**
~~~
Removed iced lemon tea from drinks
~~~

### 2.6.3 Delete a certain exercise entry: `deleteExercise`
Delete an exercise that was inputted today. You may identify the exercise by its index in listExercises.

**Format**: `deleteExercise INDEX`  
**Sample input**: `deleteExercise 1`  
**Expected output:**
~~~
Removed swimming from exercises done
~~~

## 2.7 For clearing data
### 2.7.1 Clear all entries: `clear`
Clear all entries that was added to mealList, drinkList and exerciseList **today**.  
Note: These are meals/drinks you consumed today or exercises you have done today.

**Format**: `clear`  
**Expected output**:
~~~
All meals, drinks and exercise entries that you added to your lists today have been deleted
~~~

## 2.8 Exit program
### 2.8.1 Exit the app: `exit`
Safely close the application. Don't worry, all your inputs will be saved while you're gone :)

**Format**: `exit`  
**Expected output**:
~~~
Bye. Hope to see you again soon!
~~~
---

## 3) FAQ
**Q**: How do I save changes made in the app? 

**A**: All changes will be saved once typing `exit` and terminating the program correctly. Any abrupt termination will 
cause all changes within the session to be lost.

**Q**: What is the difference between `listMeals` and `listMealsAll`?

**A**: `listMeals` will list out all the meals you have eaten today 
(with respect to the device current date). Let's say you type `listMeals` on Monday 23:59, 
and then type it again on Tuesday 00:01, the list displayed will be different (empty if you have not made any changes). 
`listMealsAll` will list out all the meals you have eaten throughout the lifetime of the app, it could be days ago,
weeks ago, months, or even years, as long ss you have inputted and saved it correctly and did not delete the data. 
The same applies for others (e.g. `listDrinks` and `listDrinksAll`)

**Q**: Will `clear` erase all the entries from days ago?

**A**: No. `clear` will only delete all insertions (including post edit) you have made today.

**Q**: Am I able to delete or edit the entries I have inserted from days ago?

**A**: No. All drinks, meals, and exercises, you have inserted from days ago will no longer be able to change. 
Only changes made today can be edited/deleted, so make sure that everything is correct before the date changes!

**Q**: My `listDrinks` have 3 indexes, but my `listDrinksAll` have 10 indexes, why can't I perform `deleteDrink 10`?

**A**: Referring to the previous question, you can only delete/edit items made today. `listDrinks` and `listDrinksAll` 
have different list indexes, please follow `listDrinks` index only. This applies to both meal and exercises.