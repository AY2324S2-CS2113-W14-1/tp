package seedu.fitnus.user;

import seedu.fitnus.Date;
import seedu.fitnus.Drink;
import seedu.fitnus.Exercise;
import seedu.fitnus.ExerciseIntensity;
import seedu.fitnus.Meal;
import seedu.fitnus.exception.IncompleteDeleteException;
import seedu.fitnus.exception.IncompleteEditException;
import seedu.fitnus.exception.NegativeValueException;
import seedu.fitnus.parser.Parser;
import seedu.fitnus.Water;
import seedu.fitnus.storage.Storage;

import seedu.fitnus.exception.IncompleteDrinkException;
import seedu.fitnus.exception.IncompleteExerciseException;
import seedu.fitnus.exception.IncompleteMealException;
import seedu.fitnus.exception.UnregisteredDrinkException;
import seedu.fitnus.exception.UnregisteredExerciseException;
import seedu.fitnus.exception.UnregisteredMealException;
import seedu.fitnus.exception.InvalidListIndexException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    // list for today
    protected static ArrayList<Meal> mealList;
    protected static ArrayList<Drink> drinkList;
    protected static ArrayList<Water> waterList;
    protected static ArrayList<Exercise> exerciseList;
    // list for all dates except today
    protected static ArrayList<Meal> mealListAll;
    protected static ArrayList<Drink> drinkListAll;
    protected static ArrayList<Water> waterListAll;
    protected static ArrayList<Exercise> exerciseListAll;

    public User(Storage mealStorage, Storage drinkStorage, Storage mealNutrientStorage, Storage drinkNutrientStorage,
                Storage exerciseStorage) {
        mealList = new ArrayList<>();
        drinkList = new ArrayList<>();
        exerciseList = new ArrayList<>();
        waterList = new ArrayList<>();
        mealListAll = new ArrayList<>();
        drinkListAll = new ArrayList<>();
        exerciseListAll = new ArrayList<>();
        waterListAll = new ArrayList<>();
        loadMealNutrient(mealNutrientStorage);
        loadDrinkNutrient(drinkNutrientStorage);
        loadMeal(mealStorage);
        loadDrink(drinkStorage);
        loadExercise(exerciseStorage);
    }

    public void loadMeal(Storage mealStorage) {
        try {
            ArrayList<String> mealStorageList = mealStorage.readFile();
            if (!mealStorageList.isEmpty()) {
                for (String s : mealStorageList) {
                    Parser.parseMealStorage(s);
                    String mealDescription = Parser.mealStorageDescription;
                    int mealSize = Parser.mealStorageSize;
                    String currentDate = Parser.mealStorageDate;
                    mealListAll.add(new Meal(mealDescription, mealSize, currentDate));
                }
            }
            Date currentDate = new Date();
            String todayDate = currentDate.getDate();
            for (Meal m : mealListAll) {
                if (m.getDate().equals(todayDate)) {
                    mealList.add(m);
                }
            }
            mealListAll.removeAll(mealList);
        } catch (FileNotFoundException e) {
            mealStorage.createFile();
        }
    }

    public void loadDrink(Storage drinkStorage) {
        try {
            ArrayList<String> drinkStorageList = drinkStorage.readFile();
            if (!drinkStorageList.isEmpty()) {
                for (String s : drinkStorageList) {
                    Parser.parseDrinkStorage(s);
                    String drinkDescription = Parser.drinkStorageDescription;
                    String drinkDate = Parser.drinkStorageDate;
                    int drinkSize = Parser.drinkStorageSize;
                    if (drinkDescription.equals("water")) {
                        waterListAll.add(new Water (drinkSize, drinkDate));
                    } else {
                        drinkListAll.add(new Drink(drinkDescription, drinkSize, drinkDate));
                    }
                }
            }
            Date currentDate = new Date();
            String todayDate = currentDate.getDate();
            for (Drink d : drinkListAll) {
                if (d.getDate().equals(todayDate)) {
                    drinkList.add(d);
                }
            }
            drinkListAll.removeAll(drinkList);
            for (Water w : waterListAll) {
                if (w.getDate().equals(todayDate)) {
                    waterList.add(w);
                }
            }
            waterListAll.removeAll(waterList);
        } catch (FileNotFoundException e) {
            drinkStorage.createFile();
        }
    }

    public void loadExercise(Storage exerciseStorage) {
        try {
            ArrayList<String> exerciseStorageList = exerciseStorage.readFile();
            if (!exerciseStorageList.isEmpty()) {
                for (String s : exerciseStorageList) {
                    Parser.parseExerciseStorage(s);
                    String exerciseDescription = Parser.exerciseStorageDescription;
                    int exerciseDuration = Parser.exerciseStorageDuration;
                    ExerciseIntensity exerciseIntensity = Parser.exerciseStorageIntensity;
                    String currentDate = Parser.exerciseStorageDate;
                    exerciseListAll.add(new Exercise(exerciseDescription, exerciseDuration, exerciseIntensity,
                            currentDate));
                }
            }
            Date currentDate = new Date();
            String todayDate = currentDate.getDate();
            for (Exercise e : exerciseListAll) {
                if (e.getDate().equals(todayDate)) {
                    exerciseList.add(e);
                }
            }
            exerciseListAll.removeAll(exerciseList);
        } catch (FileNotFoundException e) {
            exerciseStorage.createFile();
        } catch (UnregisteredExerciseException e) {
            System.out.println("Sorry that meal is not registered in the database. Please check the spelling and " +
                    "try again");
        }
    }

    public void loadMealNutrient(Storage mealNutrientStorage) {
        try {
            ArrayList<String> mealNutrientList = mealNutrientStorage.readFile();
            if (!mealNutrientList.isEmpty()) {
                for (String s : mealNutrientList) {
                    Parser.parseMealNutrient(s);
                    String description = Parser.mealNutrientDescription;
                    int calories = Parser.mealNutrientCalories;
                    int carbs = Parser.mealNutrientCarbs;
                    int protein = Parser.mealNutrientProtein;
                    int fat = Parser.mealNutrientFat;
                    int fiber = Parser.mealNutrientFiber;
                    int sugar = Parser.mealNutrientSugar;
                    Meal.nutrientDetails.put(description, new int[]{calories, carbs, protein, fat, fiber, sugar});
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Meal nutrient database not found");
        }
    }

    public void loadDrinkNutrient(Storage drinkNutrientStorage) {
        try {
            ArrayList<String> drinkNutrientList = drinkNutrientStorage.readFile();
            if (!drinkNutrientList.isEmpty()) {
                for (String s : drinkNutrientList) {
                    Parser.parseDrinkNutrient(s);
                    String description = Parser.drinkNutrientDescription;
                    int calories = Parser.drinkNutrientCalories;
                    int carbs = Parser.drinkNutrientCarbs;
                    int sugar = Parser.drinkNutrientSugar;
                    int protein = Parser.drinkNutrientProtein;
                    int fat = Parser.drinkNutrientFat;
                    Drink.nutrientDetails.put(description, new int[]{calories, carbs, sugar, protein, fat});
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Drink nutrient database not found");
        }
    }


    public void saveMeal(Storage mealStorage) {
        for (Meal meal : mealListAll) {
            String mealSavedData = meal.getName() + "," + meal.getServingSize() + "," + meal.getDate();
            mealStorage.appendTextContent(mealSavedData);
        }
        for (Meal meal : mealList) {
            String mealSavedData = meal.getName() + "," + meal.getServingSize() + "," + meal.getDate();
            mealStorage.appendTextContent(mealSavedData);
        }
        try {
            mealStorage.writeFile(mealStorage.textContent);
        } catch (IOException e) {
            System.out.println("Failed saving meal: " + e.getMessage());
        }
    }

    public void saveDrink(Storage drinkStorage) {
        for (Water water : waterListAll) {
            String waterSavedData = "water" + "," + water.getWater() + "," + water.getDate();
            drinkStorage.appendTextContent(waterSavedData);
        }
        for (Water water : waterList) {
            String waterSavedData = "water" + "," + water.getWater() + "," + water.getDate();
            drinkStorage.appendTextContent(waterSavedData);
        }
        for (Drink drink : drinkListAll) {
            String drinkSavedData = drink.getName() + "," + drink.getDrinkVolumeSize() + "," + drink.getDate();
            drinkStorage.appendTextContent(drinkSavedData);
        }
        for (Drink drink : drinkList) {
            String drinkSavedData = drink.getName() + "," + drink.getDrinkVolumeSize() + "," + drink.getDate();
            drinkStorage.appendTextContent(drinkSavedData);
        }
        try {
            drinkStorage.writeFile(drinkStorage.textContent);
        } catch (IOException e) {
            System.out.println("Failed saving drink: " + e.getMessage());
        }
    }

    public void saveExercise(Storage exerciseStorage) {
        for (Exercise exercise : exerciseListAll) {
            String exerciseSavedData = exercise.getName() + "," + exercise.getDuration() + ","
                    + exercise.getIntensity() + "," + exercise.getDate();
            exerciseStorage.appendTextContent(exerciseSavedData);
        }
        for (Exercise exercise : exerciseList) {
            String exerciseSavedData = exercise.getName() + "," + exercise.getDuration() + ","
                    + exercise.getIntensity() + "," + exercise.getDate();
            exerciseStorage.appendTextContent(exerciseSavedData);
        }
        try {
            exerciseStorage.writeFile(exerciseStorage.textContent);
        } catch (IOException e) {
            System.out.println("Failed saving drink: " + e.getMessage());
        }
    }


    public static void handleMeal(String command) throws IncompleteMealException, UnregisteredMealException,
            NegativeValueException {
        Parser.parseMeal(command);
        String mealName = Parser.mealDescription;
        int servingSize = Parser.mealSize;

        Date currentDate = new Date();

        mealList.add(new Meal(mealName, servingSize, currentDate.getDate()));
        assert !mealList.isEmpty(): "failed to add meal";

        System.out.println("Added " + servingSize + " serving of " + mealName);
    }

    public void handleDrink(String command) throws IncompleteDrinkException, UnregisteredDrinkException,
            NegativeValueException {
        Parser.parseDrink(command);
        String drinkName = Parser.drinkDescription;
        int servingSize = Parser.drinkSize;

        Date currentDate = new Date();

        boolean waterExist = false; //Water intake for today does not exist flag
        if (drinkName.equals("water")) {
            for (Water water: waterList) {
                if (currentDate.getDate().equals(water.getDate())) {
                    water.addWaterIntake(servingSize);
                    waterExist = true;
                }
            }
            if (!waterExist) {
                waterList.add(new Water(servingSize, currentDate.getDate()));
            }
        } else {
            drinkList.add(new Drink(drinkName, servingSize, currentDate.getDate()));
        }
        System.out.println("Added " + servingSize + " ml of " + drinkName);
    }

    public void handleViewCalories() {
        int caloriesCount = 0;
        for (Meal meal: mealList) {
            caloriesCount += meal.getCalories();
        }
        for (Drink drink: drinkList) {
            caloriesCount += drink.getCalories();
        }
        for (Exercise exercise: exerciseList) {
            caloriesCount -= exercise.getCaloriesBurnt();
        }
        System.out.println("Total Calories: " + caloriesCount);
    }

    public void handleViewCarbohydrates() {
        int carbohydratesCount = 0;
        for (Meal meal: mealList) {
            carbohydratesCount += meal.getCarbs();
        }
        for (Drink drink: drinkList) {
            carbohydratesCount += drink.getCarbs();
        }
        System.out.println("Total Carbohydrates: " + carbohydratesCount);
    }

    public void handleViewProteins() {
        int proteinCount = 0;
        for (Meal meal: mealList) {
            proteinCount += meal.getProtein();
        }
        for (Drink drink: drinkList) {
            proteinCount += drink.getProtein();
        }
        System.out.println("Total Proteins: " + proteinCount);
    }

    public void handleViewWaterIntake() {
        int waterIntake = 0;
        for (Water water: waterList) {
            waterIntake += water.getWater();
        }
        System.out.println("Total water intake today: " + waterIntake + " ml");
    }

    public void handleViewFiber() {
        int fibreCount = 0;
        for (Meal meal: mealList) {
            fibreCount += meal.getFiber();
        }
        System.out.println("Total Fiber: " + fibreCount);
    }

    public void handleViewFat() {
        int fatCount = 0;
        for (Meal meal: mealList) {
            fatCount += meal.getFat();
        }
        for (Drink drink: drinkList) {
            fatCount += drink.getFat();
        }
        System.out.println("Total Fat: " + fatCount);
    }

    public void handleViewSugar() {
        int sugarCount = 0;
        for (Meal meal: mealList) {
            sugarCount += meal.getSugar();
        }
        for (Drink drink: drinkList) {
            sugarCount += drink.getSugar();
        }
        System.out.println("Total Sugar: " + sugarCount);
    }

    public void printMealList(int startIndex, ArrayList<Meal> mealListToPrint) {
        for (int i = 0; i < mealListToPrint.size(); i++) {
            Meal currentMeal = mealListToPrint.get(i);
            System.out.println((startIndex+i) + ". " + currentMeal.getName() + " (serving size: "
                    + currentMeal.getServingSize() + ")" + " | date: " + currentMeal.getDate());
        }
    }

    public void printExerciseList(ArrayList<Exercise> exerciseListToPrint) {
        for (int i = 0; i < exerciseListToPrint.size(); i++) {
            Exercise currentExercise = exerciseListToPrint.get(i);
            System.out.println((i+1) + ". " + currentExercise.getName() + " | duration: " +
                    currentExercise.getDuration() + " | intensity: " + currentExercise.getIntensity()
                    + " | date: " + currentExercise.getDate());
        }
    }
    public void handleListMeals() {
        System.out.println("here's what you have eaten today");
        if (mealList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
        } else {
            printMealList(1, mealList);
        }
    }

    public void handleListMealsAll() {
        System.out.println("here's what you have eaten so far");
        if (mealListAll.isEmpty() && mealList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
        } else {
            printMealList(1, mealListAll);
            printMealList(1 + mealListAll.size(), mealList);
        }
    }

    public void printDrinkList(int startIndex, ArrayList<Drink> drinkListToPrint) {
        for (int i = 0; i < drinkListToPrint.size(); i++) {
            Drink currentDrink = drinkListToPrint.get(i);
            System.out.println((startIndex+i) + ". " + currentDrink.getName() + " (volume: "
                    + currentDrink.getDrinkVolumeSize() + "ml)" + " | date: " + currentDrink.getDate());
        }
    }

    public void handleListDrinks() {
        System.out.println("here's what you have drank today");
        int totalWater = 0;
        for (Water water : waterList) {
            totalWater += water.getWater();
        }
        if (drinkList.isEmpty() && totalWater == 0) {
            System.out.println("  >> nothing so far :o");
        } else if (drinkList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            handleViewWaterIntake();
        } else {
            printDrinkList(1, drinkList);
            System.out.println();
            handleViewWaterIntake();
        }
    }

    public void handleListDrinksAll() {
        System.out.println("here's what you have drank so far");
        int totalWater = 0;
        for (Water water : waterList) {
            totalWater += water.getWater();
        }
        if (drinkListAll.isEmpty() && drinkList.isEmpty() && totalWater == 0) {
            System.out.println("  >> nothing so far :o");
        } else if (drinkListAll.isEmpty() && drinkList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            handleViewWaterIntake();
        } else {
            printDrinkList(1, drinkListAll);
            printDrinkList(1 + drinkListAll.size(), drinkList);
            System.out.println();
            handleViewWaterIntake();
        }
    }

    public void handleListExercises() {
        System.out.println("here's the exercises you've done today");
        if (exerciseList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
        } else {
            printExerciseList(exerciseList);
        }
    }

    public void handleListExercisesAll() {
        System.out.println("here's the exercises you've done so far");
        if (exerciseListAll.isEmpty() && exerciseList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
        } else {
            ArrayList<Exercise> appendedExerciseList = new ArrayList<>();
            appendedExerciseList.addAll(exerciseListAll);
            appendedExerciseList.addAll(exerciseList);
            printExerciseList(appendedExerciseList);
        }
    }

    public void handleListEverything() {
        System.out.println("here's what you have consumed today");
        if (drinkList.isEmpty() && mealList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            System.out.println();
            handleViewWaterIntake();
        } else {
            printMealList(1, mealList);
            printDrinkList(mealList.size()+1, drinkList);
            System.out.println();
            handleViewWaterIntake();
        }

        System.out.println("       ~~~");
        handleListExercises();
    }

    public void handleListEverythingAll() {
        System.out.println("here's what you have consumed so far");
        if (drinkListAll.isEmpty() && mealListAll.isEmpty() && drinkList.isEmpty() && mealList.isEmpty()) {
            System.out.println("  >> nothing so far :o");
            System.out.println();
            handleViewWaterIntake();
        } else {
            printMealList(1, mealListAll);
            printMealList(mealListAll.size() + 1, mealList);
            printDrinkList(mealListAll.size() + mealList.size() + 1, drinkListAll);
            printDrinkList(mealListAll.size() + mealList.size() + drinkListAll.size() + 1, drinkList);
            System.out.println();
            handleViewWaterIntake();
        }

        System.out.println("       ~~~");
        handleListExercisesAll();
    }


    public static void handleEditMealServingSize(String command) throws InvalidListIndexException,
            NegativeValueException, IncompleteEditException {
        Parser.parseEditMeal(command); //Parser handles the index, so index can be = 0
        if (Parser.editMealIndex >= mealList.size() || Parser.editMealIndex < 0) {
            throw new InvalidListIndexException();
        }

        String mealName = mealList.get(Parser.editMealIndex).getName();
        String mealDate = mealList.get(Parser.editMealIndex).getDate();

        Meal updatedMeal = new Meal(mealName, Parser.editMealSize, mealDate);
        mealList.set(Parser.editMealIndex, updatedMeal);
        System.out.println(mealName + " has been edited to " + Parser.editMealSize + " serving(s)");
    }

    public static void handleEditDrinkServingSize(String command) throws InvalidListIndexException,
            NegativeValueException, IncompleteEditException {
        Parser.parseEditDrink(command);

        if (Parser.editDrinkIndex >= drinkList.size() || Parser.editDrinkIndex < 0) {
            throw new InvalidListIndexException();
        }
        String drinkName = drinkList.get(Parser.editDrinkIndex).getName();
        String drinkDate = drinkList.get(Parser.editDrinkIndex).getDate();

        Drink updatedDrink = new Drink(drinkName, Parser.editDrinkSize, drinkDate);
        drinkList.set(Parser.editDrinkIndex, updatedDrink);
        System.out.println(drinkName + " has been edited to " + Parser.editDrinkSize + " ml");
    }

    public static void handleEditWaterIntake(String command) throws InvalidListIndexException,
            NegativeValueException, IncompleteEditException {
        Parser.parseEditWater(command);
        Date currentDate = new Date();
        for (Water water: waterList) {
            if (water.getDate().equals(currentDate.getDate())) {
                water.editWaterIntake(Parser.editWaterSize);
            }
        }
        System.out.println("Total water intake has been edited to " + Parser.editWaterSize + " ml");
    }

    public void handleDeleteMeal(String command) throws InvalidListIndexException, IncompleteDeleteException {
        if (command.length() < 12) {
            throw new IncompleteDeleteException();
        }
        int mealIndex = Integer.parseInt(command.substring(11).trim()) - 1;

        if (mealIndex >= mealList.size() || mealIndex < 0) {
            throw new InvalidListIndexException();
        }

        String mealName = mealList.get(mealIndex).getName();
        mealList.remove(mealIndex);
        System.out.println("Removed " + mealName + " from meals");
    }

    public void handleDeleteDrink(String command) throws InvalidListIndexException, IncompleteDeleteException {
        if (command.length() < 13) {
            throw new IncompleteDeleteException();
        }

        int drinkIndex = Integer.parseInt(command.substring(12).trim()) - 1;
        if (drinkIndex >= drinkList.size() || drinkIndex < 0) {
            throw new InvalidListIndexException();
        }

        String drinkName = drinkList.get(drinkIndex).getName();
        drinkList.remove(drinkIndex);
        System.out.println("Removed " + drinkName + " from drinks");
    }

    public void handleDeleteExercise(String command) throws InvalidListIndexException, IncompleteDeleteException {
        if (command.length() < 16) {
            throw new IncompleteDeleteException();
        }

        int exerciseIndex = Integer.parseInt(command.substring(15).trim()) - 1;
        if (exerciseIndex >= exerciseList.size() || exerciseIndex < 0) {
            throw new InvalidListIndexException();
        }

        String exerciseName = exerciseList.get(exerciseIndex).getName();
        exerciseList.remove(exerciseIndex);
        System.out.println("Removed " + exerciseName + " from exercises done");
    }

    public void handleExercise(String command) throws IncompleteExerciseException, UnregisteredExerciseException,
            NegativeValueException {
        Parser.parseExercise(command);
        String exerciseType = Parser.exerciseDescription;
        int duration = Parser.exerciseDuration;
        ExerciseIntensity intensity = Parser.exerciseIntensity;
        Date currentDate = new Date();
        exerciseList.add(new Exercise(exerciseType, duration, intensity, currentDate.getDate()));
        assert !exerciseList.isEmpty(): "failed to track exercise";

        System.out.println("Tracked " + duration + " minutes of " + exerciseType);
    }

    public void handleClear() {
        mealList.clear();
        drinkList.clear();
        waterList.clear();
        exerciseList.clear();

        assert mealList.isEmpty(): "clearing of meal list failed";
        assert drinkList.isEmpty(): "clearing of drink list failed";
        assert exerciseList.isEmpty(): "clearing of exercise list failed";

        System.out.println("All entries have been deleted");
    }

    public void handleCaloriesBurnt() {
        int caloriesBurnt = 0;
        for (Exercise exercise: exerciseList) {
            caloriesBurnt += exercise.getCaloriesBurnt();
        }
        System.out.println("Total calories burnt: " + caloriesBurnt);
    }
}
