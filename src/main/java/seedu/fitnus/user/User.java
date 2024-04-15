package seedu.fitnus.user;

import seedu.fitnus.drink.Drink;
import seedu.fitnus.drink.DrinkList;
import seedu.fitnus.drink.Water;
import seedu.fitnus.exception.ExceedTypeLongException;
import seedu.fitnus.exception.FutureDateException;
import seedu.fitnus.meal.Meal;
import seedu.fitnus.meal.MealList;
import seedu.fitnus.exercise.Exercise;
import seedu.fitnus.exercise.ExerciseList;
import seedu.fitnus.parser.Parser;
import seedu.fitnus.validator.IntegerValidation;

import seedu.fitnus.exception.InvalidDateException;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Handles all methods related to the user's meals, drinks and exercise.
 */
public class User {
    private static final int MAX_WATER_INTAKE = 10000;
    private static final int RECOMMEND_WATER_INTAKE = 2600;
    private static final long RECOMMEND_CALORIE_INTAKE = 2200;

    public static MealList myMealList;
    public static ExerciseList myExerciseList;
    public static DrinkList myDrinkList;

    public User() {
        myMealList = new MealList();
        myDrinkList = new DrinkList();
        myExerciseList = new ExerciseList();
    }

    /**
     * Prints the user's net calorie intake of the day.
     * The method sums up the calories from meals and drinks, and subtracts calories burnt from exercise.
     */
    public void handleViewCalories() throws ExceedTypeLongException {
        long caloriesIntakeCount = 0;
        for (Meal meal: myMealList.mealList) {
            caloriesIntakeCount += meal.getCalories();
        }
        for (Drink drink: myDrinkList.drinkList) {
            caloriesIntakeCount += drink.getCalories();
        }
        IntegerValidation.checkNoOverflowForSum(caloriesIntakeCount);
        assert caloriesIntakeCount >= 0: "total calories intake has to be a non-negative value";

        try {
            long caloriesBurntCount = 0;
            for (Exercise exercise : myExerciseList.exerciseList) {
                caloriesBurntCount += exercise.getCaloriesBurnt();
            }
            IntegerValidation.checkNoOverflowForSum(caloriesBurntCount);
            assert caloriesBurntCount >= 0: "total calories burnt has to be a non-negative value";

            long caloriesCount = caloriesIntakeCount - caloriesBurntCount;
            System.out.println("Total Calories: " + caloriesCount + " kcal");
        } catch (ExceedTypeLongException e) {
            System.out.println("the amount of calories you burnt has exceeded our data limits. please do a quick " +
                    "check to make sure your exerciseList is accurate!");
        }
    }

    /**
     * Prints the user's total carbohydrate intake of the day.
     * The method sums up the carbohydrates from meals and drinks.
     */
    public void handleViewCarbohydrates() throws ExceedTypeLongException {
        long carbohydratesCount = 0;
        for (Meal meal: myMealList.mealList) {
            carbohydratesCount += meal.getCarbs();
        }
        for (Drink drink: myDrinkList.drinkList) {
            carbohydratesCount += drink.getCarbs();
        }
        IntegerValidation.checkNoOverflowForSum(carbohydratesCount);
        System.out.println("Total Carbohydrates: " + carbohydratesCount + " grams");
    }

    /**
     * Prints the user's total protein intake of the day.
     * The method sums up the protein from meals and drinks.
     */
    public void handleViewProteins() throws ExceedTypeLongException {
        long proteinCount = 0;
        for (Meal meal: myMealList.mealList) {
            proteinCount += meal.getProtein();
        }
        for (Drink drink: myDrinkList.drinkList) {
            proteinCount += drink.getProtein();
        }
        IntegerValidation.checkNoOverflowForSum(proteinCount);
        System.out.println("Total Proteins: " + proteinCount + " grams");
    }

    /**
     * Prints the user's total fiber intake of the day.
     * The method sums up the fiber from meals.
     */
    public void handleViewFiber() throws ExceedTypeLongException {
        long fibreCount = 0;
        for (Meal meal: myMealList.mealList) {
            fibreCount += meal.getFiber();
        }
        IntegerValidation.checkNoOverflowForSum(fibreCount);
        System.out.println("Total Fiber: " + fibreCount + " grams");
    }

    /**
     * Prints the user's total fat intake of the day.
     * The method sums up the fat from meals and drinks.
     */
    public void handleViewFat() throws ExceedTypeLongException {
        long fatCount = 0;
        for (Meal meal: myMealList.mealList) {
            fatCount += meal.getFat();
        }
        for (Drink drink: myDrinkList.drinkList) {
            fatCount += drink.getFat();
        }
        IntegerValidation.checkNoOverflowForSum(fatCount);
        System.out.println("Total Fat: " + fatCount + " grams");
    }

    /**
     * Prints the user's total sugar intake of the day.
     * The method sums up the sugar from meals and drinks.
     */
    public void handleViewSugar() throws ExceedTypeLongException {
        long sugarCount = 0;
        for (Meal meal: myMealList.mealList) {
            sugarCount += meal.getSugar();
        }
        for (Drink drink: myDrinkList.drinkList) {
            sugarCount += drink.getSugar();
        }
        IntegerValidation.checkNoOverflowForSum(sugarCount);
        System.out.println("Total Sugar: " + sugarCount + " grams");
    }

    /**
     * Handles when the user is listing all meals and drinks they have inputted today.
     * Method first checks if the lists is empty.
     */
    public void handleListEverything() {
        System.out.println("here's what you have consumed today");
        if (myDrinkList.drinkList.isEmpty() && myMealList.mealList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            System.out.println();
            myDrinkList.handleViewWaterIntake();
        } else {
            MealList.printMealList(1, myMealList.mealList);
            myDrinkList.printDrinkList(myMealList.mealList.size()+1, myDrinkList.drinkList);
            System.out.println();
            myDrinkList.handleViewWaterIntake();
        }

        System.out.println("       ~~~");
        myExerciseList.handleListExercises();
    }

    /**
     * Handles when the user is listing all meals and drinks they have inputted,
     * inclusive of previously saved meals and drinks.
     * Method first checks if the lists is empty.
     */
    public void handleListEverythingAll() {
        System.out.println("here's what you have consumed so far");
        if (myDrinkList.drinkListAll.isEmpty() && myMealList.mealListAll.isEmpty() && myDrinkList.drinkList.isEmpty()
                && myMealList.mealList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            System.out.println();
            myDrinkList.handleViewWaterIntake();
        } else {
            MealList.printMealList(1, myMealList.mealListAll);
            MealList.printMealList(myMealList.mealListAll.size() + 1, myMealList.mealList);
            myDrinkList.printDrinkList(myMealList.mealListAll.size()
                    + myMealList.mealList.size() + 1, myDrinkList.drinkListAll);
            myDrinkList.printDrinkList(myMealList.mealListAll.size() + myMealList.mealList.size()
                    + myDrinkList.drinkListAll.size() + 1, myDrinkList.drinkList);
            System.out.println();
            myDrinkList.handleViewWaterIntake();
        }

        System.out.println("       ~~~");
        myExerciseList.handleListExercisesAll();
    }

    /**
     * Handles when the user is listing all meals and drinks they have consumed on a certain date.
     * Method will first extract all meals and drinks that have this corresponding date,
     * before printing.
     *
     * @param command string inputted by the user, containing the date of which they would like to list
     * @throws InvalidDateException if the date inputted by user is invalid
     */
    public void handleListEverythingDate(String command) throws InvalidDateException, FutureDateException,
            ParseException {
        String date = Parser.parseListDate(command);
        ArrayList<Meal> mealListDate = new ArrayList<>();
        for (Meal m : myMealList.mealListAll) {
            if (m.getDate().equals(date)) {
                mealListDate.add(m);
            }
        }
        for (Meal m : myMealList.mealList) {
            if (m.getDate().equals(date)) {
                mealListDate.add(m);
            }
        }

        ArrayList<Drink> drinkListDate = new ArrayList<>();
        for (Drink d : myDrinkList.drinkListAll) {
            if (d.getDate().equals(date)) {
                drinkListDate.add(d);
            }
        }
        for (Drink d : myDrinkList.drinkList) {
            if (d.getDate().equals(date)) {
                drinkListDate.add(d);
            }
        }

        System.out.println("here's what you have consumed on " + date);
        if (mealListDate.isEmpty() && drinkListDate.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            System.out.println();
        } else {
            MealList.printMealList(1, mealListDate);
            myDrinkList.printDrinkList(1 + mealListDate.size(), drinkListDate);
            System.out.println();
        }

        System.out.println("       ~~~");
        myExerciseList.handleListExercisesDate(command);
    }

    /**
     * Handle when user would like to clear all entries from today.
     * This includes all meals, drinks and exercise.
     */
    public void handleClear() {
        myMealList.mealList.clear();
        myDrinkList.drinkList.clear();
        myDrinkList.waterList.clear();
        myExerciseList.exerciseList.clear();

        assert myMealList.mealList.isEmpty(): "clearing of meal list failed";
        assert myDrinkList.drinkList.isEmpty(): "clearing of drink list failed";
        assert myExerciseList.exerciseList.isEmpty(): "clearing of exercise list failed";

        System.out.println("All meals, drinks and exercise entries that you added to your lists today have been " +
                "deleted");
    }


    /**
     * Handles when user would like to see what is recommended to them,
     * only regarding the calorie and water intake.
     */
    public void handleRecommendations() {
        int waterIntake = 0;
        for (Water water: myDrinkList.waterList) {
            waterIntake += water.getWater();
        }
        int waterDifference = RECOMMEND_WATER_INTAKE - waterIntake;
        if (waterIntake < RECOMMEND_WATER_INTAKE) {
            System.out.println("We recommend drinking more water.\n Please drink " +
                    waterDifference + " ml more water by the end of the day to hit the daily water intake goal :)");
        } else if (waterIntake > MAX_WATER_INTAKE) {
            System.out.println("You drank more than 10,000ml of water today! Did you really drink so much?\nPlease " +
                    "editWater if necessary, else be mindful to drink less water tomorrow :)\n" +
                    "Scientifically, you should drink less than 800ml an hour !");
        } else {
            System.out.println("Great! You are on track with the water intake today!");
        }
        System.out.println("    ~~");

        long caloriesIntakeCount = 0;
        for (Meal meal: myMealList.mealList) {
            caloriesIntakeCount += meal.getCalories();
        }
        for (Drink drink: myDrinkList.drinkList) {
            caloriesIntakeCount += drink.getCalories();
        }
        long caloriesDifference = RECOMMEND_CALORIE_INTAKE - caloriesIntakeCount;
        if (caloriesIntakeCount < RECOMMEND_CALORIE_INTAKE) {
            System.out.println("We recommend eating more food. Please eat " + caloriesDifference + " more calories by" +
                    " today :)");
        } else if (caloriesIntakeCount > RECOMMEND_CALORIE_INTAKE 
                   && caloriesIntakeCount < RECOMMEND_CALORIE_INTAKE + 200) {
            System.out.println("Great! You are on track with the calorie intake for the day!");
        } else {
            System.out.println("You ate " + -caloriesDifference
                    + " calories above the recommended calorie intake amount, consider exercising!");
        }
    }
}
