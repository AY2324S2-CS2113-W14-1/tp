package seedu.fitnus.parser;

import seedu.fitnus.date.DateValidation;
import seedu.fitnus.drink.Drink;
import seedu.fitnus.exception.ExceedTypeIntException;
import seedu.fitnus.exception.StorageErrorException;
import seedu.fitnus.meal.Meal;
import seedu.fitnus.exercise.Exercise;
import seedu.fitnus.exercise.ExerciseIntensity;
import seedu.fitnus.user.User;
import seedu.fitnus.validator.IntegerValidation;

import seedu.fitnus.exception.ExceedTypeLongException;
import seedu.fitnus.exception.FutureDateException;
import seedu.fitnus.exception.IncompleteDeleteException;
import seedu.fitnus.exception.IncompleteDrinkException;
import seedu.fitnus.exception.IncompleteEditException;
import seedu.fitnus.exception.IncompleteEditWaterException;
import seedu.fitnus.exception.IncompleteExerciseException;
import seedu.fitnus.exception.IncompleteInfoException;
import seedu.fitnus.exception.IncompleteMealException;
import seedu.fitnus.exception.InvalidCommandException;
import seedu.fitnus.exception.InvalidDateException;
import seedu.fitnus.exception.InvalidEditWaterException;
import seedu.fitnus.exception.InvalidListIndexException;
import seedu.fitnus.exception.NegativeValueException;
import seedu.fitnus.exception.NonPositiveValueException;
import seedu.fitnus.exception.UnregisteredDrinkException;
import seedu.fitnus.exception.UnregisteredExerciseException;
import seedu.fitnus.exception.UnregisteredMealException;

import java.text.ParseException;

/**
 * The Parser class is responsible for parsing user commands and delegating
 * them to the appropriate classes for execution.
 */
public class Parser {
    public static final int MIN_INTEGER_VALUE = -2147483648;
    public static final int MAX_INTEGER_VALUE = 2147483647;

    public static String mealDescription;
    public static int mealSize;
    public static String drinkDescription;
    public static int drinkSize;

    public static int editMealIndex;
    public static int editMealSize;
    public static int editDrinkIndex;
    public static int editDrinkSize;
    public static int editWaterSize;

    public static String mealStorageDescription;
    public static int mealStorageSize;
    public static String mealStorageDate;

    public static String drinkStorageDescription;
    public static int drinkStorageSize;
    public static String drinkStorageDate;

    public static String exerciseStorageDescription;
    public static int exerciseStorageDuration;
    public static ExerciseIntensity exerciseStorageIntensity;
    public static String exerciseStorageDate;

    public static String exerciseDescription;
    public static int exerciseDuration;

    public static String mealNutrientDescription;
    public static int mealNutrientCalories;
    public static int mealNutrientCarbs;
    public static int mealNutrientProtein;
    public static int mealNutrientFat;
    public static int mealNutrientFiber;
    public static int mealNutrientSugar;

    public static String drinkNutrientDescription;
    public static int drinkNutrientCalories;
    public static int drinkNutrientCarbs;
    public static int drinkNutrientSugar;
    public static int drinkNutrientProtein;
    public static int drinkNutrientFat;

    public static String exerciseCaloriesDescription;
    public static int exerciseCaloriesHigh;
    public static int exerciseCaloriesMedium;
    public static int exerciseCaloriesLow;

    public static ExerciseIntensity exerciseIntensity;
    private User user;

    /**
     * Constructs a Parser object with the given User.
     *
     * @param user The User object to interact with.
     */
    public Parser(User user) {
        this.user = user;
    }

    /**
     * Parses the user command and executes the corresponding action.
     *
     * @param command The command entered by the user.
     */
    public void parseCommand(String command) {
        String trimmedCommand = command.trim();
        try {
            if (trimmedCommand.equals("help")) {
                handleHelp();
            } else if (trimmedCommand.startsWith("eat")) {
                user.myMealList.handleMeal(trimmedCommand);
            } else if (trimmedCommand.startsWith("drink")) {
                user.myDrinkList.handleDrink(trimmedCommand);
            } else if (trimmedCommand.startsWith("exercise")) {
                user.myExerciseList.handleExercise(trimmedCommand);
            } else if (trimmedCommand.startsWith("newMeal")) {
                user.myMealList.handleAddNewMealNutrient(trimmedCommand);
            } else if (trimmedCommand.startsWith("newDrink")) {
                user.myDrinkList.handleAddNewDrinkNutrient(trimmedCommand);
            } else if (trimmedCommand.startsWith("newExercise")) {
                user.myExerciseList.handleAddNewExerciseCalories(trimmedCommand);
            }else if (trimmedCommand.equals("allMeals")) {
                Meal.listAvailableMeals();
            } else if (trimmedCommand.equals("allDrinks")) {
                Drink.listAvailableDrinks();
            } else if (trimmedCommand.equals("allExercises")) {
                Exercise.listAvailableExercises();
            } else if (trimmedCommand.startsWith("infoMeal")) {
                Meal.handleInfoMeal(trimmedCommand);
            } else if (trimmedCommand.startsWith("infoDrink")) {
                Drink.handleInfoDrink(trimmedCommand);
            } else if (trimmedCommand.startsWith("infoExercise")) {
                Exercise.handleInfoExercise(trimmedCommand);
            } else if (trimmedCommand.equals("calories")) {
                user.handleViewCalories();
            } else if (trimmedCommand.equals("caloriesBurnt")) {
                user.myExerciseList.handleCaloriesBurnt();
            } else if (trimmedCommand.equals("carbs")) {
                user.handleViewCarbohydrates();
            } else if (trimmedCommand.equals("protein")) {
                user.handleViewProteins();
            } else if (trimmedCommand.equals("sugar")) {
                user.handleViewSugar();
            } else if (trimmedCommand.equals("fat")) {
                user.handleViewFat();
            } else if (trimmedCommand.equals("water")) {
                user.myDrinkList.handleViewWaterIntake();
            } else if (trimmedCommand.equals("fiber")) {
                user.handleViewFiber();
            } else if (trimmedCommand.equals("listMeals")) {
                user.myMealList.handleListMeals();
            } else if (trimmedCommand.equals("listMealsAll")) {
                user.myMealList.handleListMealsAll();
            } else if (trimmedCommand.startsWith("listMeals") && trimmedCommand.contains("d/")) {
                user.myMealList.handleListMealsDate(trimmedCommand);
            } else if (trimmedCommand.equals("listDrinks")) {
                user.myDrinkList.handleListDrinks();
            } else if (trimmedCommand.equals("listDrinksAll")) {
                user.myDrinkList.handleListDrinksAll();
            } else if (trimmedCommand.startsWith("listDrinks") && trimmedCommand.contains("d/")) {
                user.myDrinkList.handleListDrinksDate(trimmedCommand);
            } else if (trimmedCommand.equals("listExercises")) {
                user.myExerciseList.handleListExercises();
            } else if (trimmedCommand.equals("listExercisesAll")) {
                user.myExerciseList.handleListExercisesAll();
            } else if (trimmedCommand.startsWith("listExercises") && trimmedCommand.contains("d/")) {
                user.myExerciseList.handleListExercisesDate(command);
            } else if (trimmedCommand.equals("listEverything")) {
                user.handleListEverything();
            } else if (trimmedCommand.equals("listEverythingAll")) {
                user.handleListEverythingAll();
            } else if (trimmedCommand.startsWith("listEverything") && trimmedCommand.contains("d/")) {
                user.handleListEverythingDate(trimmedCommand);
            } else if (trimmedCommand.startsWith("editMeal")) {
                user.myMealList.handleEditMealServingSize(trimmedCommand);
            } else if (trimmedCommand.startsWith("editDrink")) {
                user.myDrinkList.handleEditDrinkServingSize(trimmedCommand);
            } else if (trimmedCommand.startsWith("editWater")) {
                user.myDrinkList.handleEditWaterIntake(trimmedCommand);
            } else if (trimmedCommand.startsWith("deleteMeal")) {
                user.myMealList.handleDeleteMeal(trimmedCommand);
            } else if (trimmedCommand.startsWith("deleteDrink")) {
                user.myDrinkList.handleDeleteDrink(trimmedCommand);
            } else if (trimmedCommand.startsWith("deleteExercise")) {
                user.myExerciseList.handleDeleteExercise(trimmedCommand);
            } else if (trimmedCommand.equals("clear")) {
                user.handleClear();
            } else if (trimmedCommand.equals("recommend")) {
                user.handleRecommendations();
            } else {
                throw new InvalidCommandException();
            }
        } catch (InvalidCommandException e) {
            System.out.println("Invalid command, type [help] to view all commands.");
        } catch (IncompleteDrinkException e) {
            System.out.println("Incomplete/Incorrect command, the format MUST be [drink d/DRINK s/VOLUME(ML)].");
        } catch (IncompleteMealException e) {
            System.out.println("Incomplete/Incorrect command, the format MUST be [eat m/MEAL s/SERVING_SIZE].");
        } catch (IncompleteExerciseException e) {
            System.out.println("Incomplete/Incorrect command, " +
                    "the format MUST be [exercise e/EXERCISE d/DURATION i/INTENSITY].\n"
                    + " > DURATION should be in minutes and INTENSITY can only be HIGH/MEDIUM/LOW.");
        } catch (UnregisteredDrinkException e) {
            System.out.println("Sorry that drink is not registered in the database. Please check the spelling and " +
                    "try again");
        } catch (UnregisteredMealException e) {
            System.out.println("Sorry that meal is not registered in the database. Please check the spelling and " +
                    "try again");
        } catch (InvalidListIndexException e) {
            System.out.println("Sorry the index you provided is invalid, check [listMeals/listDrinks/listExercises] " +
                    "to view valid indexes.");
        } catch (UnregisteredExerciseException e) {
            System.out.println("Sorry that exercise is not registered in the database. Please check the spelling and" +
                    " try again");
        } catch (NumberFormatException e) {
            System.out.println("An integer value is expected, try again please :)\n" +
                    "  > Friendly reminder that integer values cannot exceed the range of " + MIN_INTEGER_VALUE + " to "
                    + MAX_INTEGER_VALUE + ".\n    Although, we highly doubt you will ever exceed this range");
        } catch (IncompleteDeleteException e) {
            System.out.println("Please specify an index that you would like to delete. The format should be " +
                    "[deleteMeal/deleteDrink/deleteExercise INDEX]");
        } catch (IncompleteEditException e) {
            System.out.println("Please specify an index that you would like to edit AND/OR the new serving size. "+
                    "Type [help] to view the commands format.");
        } catch (IncompleteInfoException e) {
            System.out.println("Please specify a meal/drink/exercise that you would like to view the info of. " +
                    "Type [help] to view the commands format.");
        } catch (NonPositiveValueException e) {
            System.out.println("Your serving size/exercise duration must be greater than 0!");
        } catch (NegativeValueException e) {
            System.out.println("Value cannot be negative!");
        } catch (InvalidDateException e) {
            System.out.println("Invalid date provided. Your date must be in the format of dd-MM-yyyy.");
        } catch (FutureDateException e) {
            System.out.println("Specified date has not passed. Please try another date.");
        } catch (ParseException e) {
            System.out.println("Specified date is invalid. Please try another date.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ExceedTypeLongException e) {
            System.out.println("the count you would like to view has exceeded our data limits, are you sure you have " +
                    "consumed so much? Please do a quick check to update your listMeals and/or listDrinks before " +
                    "viewing again :')");
        } catch (InvalidEditWaterException e) {
            System.out.println("Make sure to add water for the day before editing it.");
        } catch (IncompleteEditWaterException e) {
            System.out.println("Please specify the new volume of water.\n" +
                    "The format should be [editWater s/NEW_VOLUME(ML)].");
        } catch (ExceedTypeIntException e) {
            System.out.println("Adding this amount of water will exceed a total of 2147483647ml water today. Are " +
                    "you sure you can drink so much water in a day? \nI shall remove this amount for now. EditWater " +
                    "if you deem fit :/");
        }

    }

    /**
     * Displays a list of valid commands and their formats.
     */
    public static void handleHelp() {
        System.out.println("Here's all the valid commands I recognise: ");
        System.out.println();
        System.out.println("Track a meal/drink/exercise: ");
        System.out.println("- Track a meal eaten: eat m/MEAL s/SERVING_SIZE");
        System.out.println("- Track a drink: drink d/DRINK s/VOLUME(ML)");
        System.out.println("- Track an exercise: exercise e/EXERCISE d/DURATION(MINUTES) " +
                "i/INTENSITY(HIGH, MEDIUM, LOW)");
        System.out.println();
        System.out.println("View available meals/drinks/exercises: ");
        System.out.println("- View all meals that you can input: allMeals");
        System.out.println("- View all drinks that you can input: allDrinks");
        System.out.println("- View all exercises that you can input: allExercises");
        System.out.println();
        System.out.println("Find information about a meal/drink/exercise: ");
        System.out.println("- Find the information about a certain meal: infoMeal MEAL");
        System.out.println("- Find the information about a certain drink: infoDrink DRINK");
        System.out.println("- Find the information about a certain exercise: infoExercise EXERCISE");
        System.out.println();
        System.out.println("View nutrients and calories: ");
        System.out.println("- View daily calories consumed: calories");
        System.out.println("- View daily carbohydrates consumed: carbs");
        System.out.println("- View daily proteins consumed: protein");
        System.out.println("- View daily fat consumed: fat");
        System.out.println("- View daily sugar consumed: sugar");
        System.out.println("- View daily fiber consumed: fiber");
        System.out.println("- View daily water consumption: water");
        System.out.println("- View daily calories burnt: caloriesBurnt");
        System.out.println();
        System.out.println("List Commands: ");
        System.out.println("- List today's meal intake: listMeals");
        System.out.println("- List today's drink intake: listDrinks");
        System.out.println("- List today's exercises done: listExercises");
        System.out.println("- List today's entire food intake and exercises: listEverything");
        System.out.println("- List all meal intake: listMealsAll");
        System.out.println("- List all drink intake: listDrinksAll");
        System.out.println("- List all exercises done: listExercisesAll");
        System.out.println("- List all food intake and exercises: listEverythingAll");
        System.out.println("- List meal intake for certain date: listMeals d/dd-MM-yyyy");
        System.out.println("- List drink intake for certain date: listDrinks d/dd-MM-yyyy");
        System.out.println("- List exercises done for certain date: listExercises d/dd-MM-yyyy");
        System.out.println("- List entire food intake and exercises for certain date: listEverything d/dd-MM-yyyy");
        System.out.println();
        System.out.println("Edit Commands: ");
        System.out.println("- Edit an existing meal after inserted: editMeal INDEX s/NEW_SERVING_SIZE");
        System.out.println("- Edit an existing drink after inserted: editDrink INDEX s/NEW_SERVING_SIZE");
        System.out.println("- Edit total water intake after inserted: editWater s/TOTAL_WATER_INTAKE");
        System.out.println();
        System.out.println("Delete Commands: ");
        System.out.println("- Delete certain meal entry: deleteMeal INDEX");
        System.out.println("- Delete certain drink entry: deleteDrink INDEX");
        System.out.println("- Delete certain exercise entry: deleteExercise INDEX");
        System.out.println();
        System.out.println("Adding a meal/drink/exercises to available list: ");
        System.out.println("- Add a new meal to available meals: newMeal MEAL_NAME,CALORIES," +
                "CARBS,PROTEIN,FAT,FIBER,SUGAR");
        System.out.println("- Add a new drink to available drinks: newDrink DRINK_NAME,CALORIES," +
                "CARBS,SUGAR,PROTEIN,FAT");
        System.out.println("- Add a new exercise to available exercises: newExercise EXERCISE_NAME," +
                "CALORIES_BURNT_HIGH,CALORIES_BURNT_MEDIUM,CALORIES_BURNT_LOW");
        System.out.println();
        System.out.println("Miscellaneous: ");
        System.out.println("- View daily calories and water intake recommendation: recommend");
        System.out.println("- Clear all entries: clear");
        System.out.println("- Exit the app: exit ");
    }

    /**
     * Parses a meal command string and extracts the meal description and size.
     *
     * @param command The command entered by the user.
     * @throws IncompleteMealException If the meal command is incomplete.
     * @throws UnregisteredMealException If the meal is not registered in the database.
     * @throws NonPositiveValueException If a negative value is encountered.
     */
    public static void parseMeal(String command) throws IncompleteMealException, UnregisteredMealException,
            NonPositiveValueException {
        if (!command.contains("m/") || !command.contains("s/")) {
            throw new IncompleteMealException();
        }
        int descriptionIndex = command.indexOf("m/") + 2;
        int sizeIndex = command.indexOf("s/") + 2;

        if (sizeIndex >= command.length() || sizeIndex < descriptionIndex) {
            throw new IncompleteMealException();
        }

        mealDescription = command.substring(descriptionIndex, sizeIndex - 2).trim().toLowerCase();
        if (mealDescription.isEmpty()) {
            throw new IncompleteMealException();
        }
        if (!Meal.getNutrientDetails().containsKey(mealDescription)) {
            throw new UnregisteredMealException();
        }
        mealSize = Integer.parseInt(command.substring(sizeIndex).trim());
        IntegerValidation.checkIntegerGreaterThanZero(mealSize);
    }

    /**
     * Parses the command for adding a drink.
     *
     * @param command The command entered by the user.
     * @throws IncompleteDrinkException If the drink command is incomplete.
     * @throws UnregisteredDrinkException If the drink is not registered in the database.
     * @throws NonPositiveValueException If a negative value is encountered.
     */
    public static void parseDrink(String command) throws IncompleteDrinkException, UnregisteredDrinkException,
            NonPositiveValueException {
        if (!command.contains("d/") || !command.contains("s/")) {
            throw new IncompleteDrinkException();
        }
        int descriptionIndex = command.indexOf("d/") + 2;
        int sizeIndex = command.indexOf("s/") + 2;
        if (sizeIndex >= command.length() || sizeIndex < descriptionIndex) {
            throw new IncompleteDrinkException();
        }
        drinkDescription = command.substring(descriptionIndex, sizeIndex - 2).trim().toLowerCase();
        if (drinkDescription.isEmpty()) {
            throw new IncompleteDrinkException();
        }
        if (!Drink.getNutrientDetails().containsKey(drinkDescription) && !drinkDescription.equals("water")) {
            throw new UnregisteredDrinkException();
        }

        drinkSize = Integer.parseInt(command.substring(sizeIndex).trim());
        IntegerValidation.checkIntegerGreaterThanZero(drinkSize);
    }

    /**
     * Parses the command for obtaining information about a meal.
     *
     * @param command The command entered by the user.
     * @return The description of the meal.
     * @throws UnregisteredMealException If the meal is not registered in the database.
     * @throws IncompleteInfoException If the command is incomplete.
     */
    public static String parseInfoMeal(String command) throws UnregisteredMealException, IncompleteInfoException {
        int mealIndex = 9;
        if (command.length() < mealIndex + 1) {
            throw new IncompleteInfoException();
        }
        String infoMealDescription = command.substring(mealIndex).trim().toLowerCase();

        if (!Meal.getNutrientDetails().containsKey(infoMealDescription)) {
            throw new UnregisteredMealException();
        }
        return infoMealDescription;
    }

    /**
     * Parses the command for obtaining information about an exercise.
     *
     * @param command The command entered by the user.
     * @return The description of the exercise.
     * @throws UnregisteredExerciseException If the exercise is not registered in the database.
     * @throws IncompleteInfoException If the command is incomplete.
     */
    public static String parseInfoExercise(String command) throws UnregisteredExerciseException,
            IncompleteInfoException {
        int exerciseIndex = 13;
        if (command.length() < exerciseIndex + 1) {
            throw new IncompleteInfoException();
        }
        String infoExerciseDescription = command.substring(exerciseIndex).trim().toLowerCase();
        if (!Exercise.getExerciseDetails().containsKey(infoExerciseDescription)) {
            throw new UnregisteredExerciseException();
        }
        return infoExerciseDescription;
    }

    /**
     * Parses the command for obtaining information about a drink.
     *
     * @param command The command entered by the user.
     * @return The description of the drink.
     * @throws UnregisteredDrinkException If the drink is not registered in the database.
     * @throws IncompleteInfoException If the command is incomplete.
     */
    public static String parseInfoDrink(String command) throws UnregisteredDrinkException, IncompleteInfoException {
        int drinkIndex = 10;
        if (command.length() < drinkIndex + 1) {
            throw new IncompleteInfoException();
        }
        String infoDrinkDescription = command.substring(drinkIndex).trim().toLowerCase();
        if (!Drink.getNutrientDetails().containsKey(infoDrinkDescription)) {
            throw new UnregisteredDrinkException();
        }
        return infoDrinkDescription;
    }

    /**
     * Parses the command for editing a meal.
     *
     * @param command The command entered by the user.
     * @throws NonPositiveValueException If a negative value is encountered.
     * @throws IncompleteEditException If the command is incomplete.
     */
    public static void parseEditMeal(String command) throws NonPositiveValueException, IncompleteEditException {
        int mealSizePosition = command.indexOf("s/");
        if (mealSizePosition <= 9) {
            throw new IncompleteEditException();
        }

        editMealIndex = Integer.parseInt(command.substring(9, mealSizePosition).trim()) - 1;
        editMealSize = Integer.parseInt(command.substring(mealSizePosition + 2).trim());
        IntegerValidation.checkIntegerGreaterThanZero(editMealSize);
    }

    /**
     * Parses the command for editing a drink.
     *
     * @param command The command entered by the user.
     * @throws NonPositiveValueException If a negative value is encountered.
     * @throws IncompleteEditException If the command is incomplete.
     */
    public static void parseEditDrink(String command) throws NonPositiveValueException, IncompleteEditException {
        int drinkSizePosition = command.indexOf("s/");
        if (drinkSizePosition <= 10) {
            throw new IncompleteEditException();
        }

        editDrinkIndex = Integer.parseInt(command.substring(10, drinkSizePosition).trim()) - 1;
        editDrinkSize = Integer.parseInt(command.substring(drinkSizePosition + 2).trim());
        IntegerValidation.checkIntegerGreaterThanZero(editDrinkSize);
    }

    /**
     * Parses the command for editing water intake.
     *
     * @param command The command entered by the user.
     * @throws NonPositiveValueException If a negative value is encountered.
     * @throws IncompleteEditException If the command is incomplete.
     */
    public static void parseEditWater(String command) throws NonPositiveValueException, IncompleteEditWaterException {
        int waterSizePosition = command.indexOf("s/") + 2;
        if (waterSizePosition <= 1) { //-1 + 2
            throw new IncompleteEditWaterException();
        }
        editWaterSize = Integer.parseInt(command.substring(waterSizePosition).trim());
        IntegerValidation.checkIntegerGreaterThanZero(editWaterSize);
    }

    /**
     * Parses the data for storing meal information.
     *
     * @param data The data string to be parsed.
     */
    public static void parseMealStorage(String data) throws StorageErrorException, NonPositiveValueException,
            NumberFormatException {
        String delimiter = ",";
        String[] arrayOfMealData = data.split(delimiter);
        if (arrayOfMealData.length != 3) {
            throw new StorageErrorException();
        }
        mealStorageDescription = arrayOfMealData[0];
        mealStorageSize = Integer.parseInt(arrayOfMealData[1]);
        IntegerValidation.checkIntegerGreaterThanZero(mealStorageSize);

        mealStorageDate = arrayOfMealData[2];
    }

    /**
     * Parses the data for storing drink information.
     *
     * @param data The data string to be parsed.
     */
    public static void parseDrinkStorage(String data) throws StorageErrorException, NonPositiveValueException,
            NumberFormatException {
        String delimiter = ",";
        String[] arrayOfDrinkData = data.split(delimiter);
        if (arrayOfDrinkData.length != 3) {
            throw new StorageErrorException();
        }
        drinkStorageDescription = arrayOfDrinkData[0];
        drinkStorageSize = Integer.parseInt(arrayOfDrinkData[1]);
        IntegerValidation.checkIntegerGreaterThanZero(drinkStorageSize);
        drinkStorageDate = arrayOfDrinkData[2];
    }

    /**
     * Parses the data for storing exercise information.
     *
     * @param data The data string to be parsed.
     */
    public static void parseExerciseStorage(String data) throws NonPositiveValueException, StorageErrorException,
            NumberFormatException {
        String delimiter = ",";
        String[] arrayOfExerciseData = data.split(delimiter);
        if (arrayOfExerciseData.length != 4) {
            throw new StorageErrorException();
        }
        exerciseStorageDescription = arrayOfExerciseData[0];
        exerciseStorageDuration = Integer.parseInt(arrayOfExerciseData[1]);
        IntegerValidation.checkIntegerGreaterThanZero(exerciseStorageDuration);
        exerciseStorageIntensity = ExerciseIntensity.valueOf(arrayOfExerciseData[2]);
        exerciseStorageDate = arrayOfExerciseData[3];
    }

    /**
     * Parses the command for adding an exercise.
     *
     * @param command The command entered by the user.
     * @throws IncompleteExerciseException If the exercise command is incomplete.
     * @throws UnregisteredExerciseException If the exercise is not registered in the database.
     * @throws NonPositiveValueException If a negative value is encountered.
     */
    public static void parseExercise(String command) throws IncompleteExerciseException, UnregisteredExerciseException,
            NonPositiveValueException {
        if (!command.contains("e/") || !command.contains("d/") || !command.contains("i/")) {
            throw new IncompleteExerciseException();
        }
        int descriptionIndex = command.indexOf("e/") + 2;
        int durationIndex = command.indexOf("d/") + 2;
        int intensityIndex = command.indexOf("i/") + 2;
        if (intensityIndex >= command.length() || durationIndex < descriptionIndex || intensityIndex < descriptionIndex
                || intensityIndex < durationIndex) {
            throw new IncompleteExerciseException();
        }
        exerciseDescription = command.substring(descriptionIndex, durationIndex - 2).trim().toLowerCase();
        if (exerciseDescription.isEmpty()) {
            throw new IncompleteExerciseException();
        }
        if (!Exercise.getExerciseDetails().containsKey(exerciseDescription)) {
            throw new UnregisteredExerciseException();
        }

        exerciseDuration = Integer.parseInt(command.substring(durationIndex, intensityIndex - 2).trim());
        IntegerValidation.checkIntegerGreaterThanZero(exerciseDuration);

        String intensityString = command.substring(intensityIndex).trim().toUpperCase();
        try {
            exerciseIntensity = ExerciseIntensity.valueOf(intensityString);
        } catch (IllegalArgumentException e) {
            throw new IncompleteExerciseException(); // Invalid intensity
        }
    }

    /**
     * Parses the nutrient information for a meal.
     *
     * @param data The nutrient data string to be parsed.
     */
    public static void parseMealNutrient(String data) throws  IllegalArgumentException, NegativeValueException {
        String delimiter = ",";
        String[] arrayOfMealNutrient = data.split(delimiter);

        for (int i = 0; i < arrayOfMealNutrient.length; i++) {
            arrayOfMealNutrient[i] = arrayOfMealNutrient[i].trim();
        }

        if (arrayOfMealNutrient.length != 7) {
            throw new IllegalArgumentException("Invalid number of arguments provided. Expected 7, got "
                    + arrayOfMealNutrient.length);
        }

        try {
            mealNutrientDescription = arrayOfMealNutrient[0].trim().toLowerCase();
            mealNutrientCalories = Integer.parseInt(arrayOfMealNutrient[1]);
            mealNutrientCarbs = Integer.parseInt(arrayOfMealNutrient[2]);
            mealNutrientProtein = Integer.parseInt(arrayOfMealNutrient[3]);
            mealNutrientFat = Integer.parseInt(arrayOfMealNutrient[4]);
            mealNutrientFiber = Integer.parseInt(arrayOfMealNutrient[5]);
            mealNutrientSugar = Integer.parseInt(arrayOfMealNutrient[6]);

            IntegerValidation.checkIntegerGreaterOrEqualThanZero(mealNutrientCalories);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(mealNutrientCarbs);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(mealNutrientProtein);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(mealNutrientFat);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(mealNutrientFiber);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(mealNutrientSugar);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format, please input an integer");
        }
    }

    /**
     * Parses the nutrient information for a drink.
     *
     * @param data The nutrient data string to be parsed.
     */
    public static void parseDrinkNutrient(String data) throws  IllegalArgumentException, NegativeValueException {
        String delimiter = ",";
        String[] arrayOfDrinkNutrient = data.split(delimiter);

        for (int i = 0; i < arrayOfDrinkNutrient.length; i++) {
            arrayOfDrinkNutrient[i] = arrayOfDrinkNutrient[i].trim();
        }

        if (arrayOfDrinkNutrient.length != 6) {
            throw new IllegalArgumentException("Invalid number of arguments provided. Expected 6, got "
                    + arrayOfDrinkNutrient.length);
        }

        try {
            drinkNutrientDescription = arrayOfDrinkNutrient[0].trim().toLowerCase();
            drinkNutrientCalories = Integer.parseInt(arrayOfDrinkNutrient[1]);
            drinkNutrientCarbs = Integer.parseInt(arrayOfDrinkNutrient[2]);
            drinkNutrientSugar = Integer.parseInt(arrayOfDrinkNutrient[3]);
            drinkNutrientProtein = Integer.parseInt(arrayOfDrinkNutrient[4]);
            drinkNutrientFat = Integer.parseInt(arrayOfDrinkNutrient[5]);

            IntegerValidation.checkIntegerGreaterOrEqualThanZero(drinkNutrientCalories);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(drinkNutrientCarbs);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(drinkNutrientSugar);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(drinkNutrientProtein);
            IntegerValidation.checkIntegerGreaterOrEqualThanZero(drinkNutrientFat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format, please input an integer");
        }
    }

    /**
     * Parses the calorie information for an exercise.
     *
     * @param data The calorie data string to be parsed.
     */
    public static void parseExerciseCalories(String data) throws IllegalArgumentException, NonPositiveValueException {
        String delimiter = ",";
        String[] arrayOfExerciseCalories = data.split(delimiter);

        for (int i = 0; i < arrayOfExerciseCalories.length; i++) {
            arrayOfExerciseCalories[i] = arrayOfExerciseCalories[i].trim();
        }

        if (arrayOfExerciseCalories.length != 4) {
            throw new IllegalArgumentException("Invalid number of arguments provided. Expected 4, got "
                    + arrayOfExerciseCalories.length);
        }

        try {
            exerciseCaloriesDescription = arrayOfExerciseCalories[0].trim().toLowerCase();
            exerciseCaloriesHigh = Integer.parseInt(arrayOfExerciseCalories[1]);
            exerciseCaloriesMedium = Integer.parseInt(arrayOfExerciseCalories[2]);
            exerciseCaloriesLow = Integer.parseInt(arrayOfExerciseCalories[3]);

            if (exerciseCaloriesHigh <= exerciseCaloriesMedium || exerciseCaloriesMedium <= exerciseCaloriesLow) {
                throw new IllegalArgumentException("HIGH intensity must be greater than MEDIUM intensity and MEDIUM " +
                        "intensity must be larger than LOW intensity.");
            }

            IntegerValidation.checkIntegerGreaterThanZero(exerciseCaloriesHigh);
            IntegerValidation.checkIntegerGreaterThanZero(exerciseCaloriesMedium);
            IntegerValidation.checkIntegerGreaterThanZero(exerciseCaloriesLow);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format, please input an integer");
        }
    }

    /**
     * Parses the date from a command string.
     *
     * @param command The command entered by the user.
     * @return The parsed date string.
     * @throws FutureDateException If the date format is invalid.
     */
    public static String parseListDate(String command) throws FutureDateException, ParseException {
        int indexOfDate = command.indexOf("d/") + 2;
        String date = command.substring(indexOfDate);
        return DateValidation.formatDateIfValid(date);
    }

    /**
     * Parses the newMeal command from a command string.
     *
     * @param command The command entered by the user containing the new meal they want to add and its nutrient details
     * @throws NegativeValueException If a negative value is encountered.
     */
    public static void parseNewMeal(String command) throws NegativeValueException {
        String mealNutrients = command.substring(8).trim();
        parseMealNutrient(mealNutrients);
    }


    /**
     * Parses the newDrink command from a command string.
     *
     * @param command The command entered by the user containing the new drink they want to add and its nutrient details
     * @throws NegativeValueException If a negative value is encountered.
     */
    public static void parseNewDrink(String command) throws NegativeValueException {
        String drinkNutrients = command.substring(9).trim();
        parseDrinkNutrient(drinkNutrients);
    }

    /**
     * Parses the newMeal command from a command string.
     *
     * @param command The command entered by the user containing the new exercise they want to add and its calories
     *                burnt details
     * @throws NonPositiveValueException If a negative value is encountered.
     */
    public static void parseNewExercise(String command) throws NonPositiveValueException {
        String exerciseDetails = command.substring(12).trim();
        parseExerciseCalories(exerciseDetails);
    }
}
