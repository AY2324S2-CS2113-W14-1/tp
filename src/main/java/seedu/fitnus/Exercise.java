package seedu.fitnus;

import seedu.fitnus.exception.IncompleteInfoException;
import seedu.fitnus.exception.UnregisteredExerciseException;
import seedu.fitnus.parser.Parser;

import java.util.HashMap;

public class Exercise {
    public static HashMap<String, int[]> exerciseDetails = new HashMap<>();
    private String name;
    private int duration; // Duration in minutes
    private ExerciseIntensity intensity;
    private int caloriesBurnt;
    private String dateAdded;

    public Exercise(String name, int duration, ExerciseIntensity intensity, String currentDate)
            throws UnregisteredExerciseException {
        assert name != null : "Name must not be null";
        this.name = name;
        assert duration > 0 : "Duration must be greater than 0";
        this.duration = duration;
        assert isValidIntensity(intensity) : "Intensity must be HIGH, MEDIUM, or LOW";
        this.intensity = intensity;
        setCaloriesBurnt(); // Assign exercise details based on the name and intensity
        this.dateAdded = currentDate;
    }

    static {
        exerciseDetails.put("running", new int[]{8, 5, 3});
        exerciseDetails.put("cycling", new int[]{6, 4, 2});
        exerciseDetails.put("swimming", new int[]{10, 7, 4});
    }

    private void setCaloriesBurnt() throws UnregisteredExerciseException {
        int[] details = exerciseDetails.get(name);
        if (details == null) {
            throw new UnregisteredExerciseException();
        }
        this.caloriesBurnt = duration * details[intensity.ordinal()];
    }

    private boolean isValidIntensity(ExerciseIntensity intensity) {
        return intensity == ExerciseIntensity.HIGH || intensity == ExerciseIntensity.MEDIUM ||
                intensity == ExerciseIntensity.LOW;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public ExerciseIntensity getIntensity() {
        return intensity;
    }

    public String getDate() {
        return dateAdded;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIntensity(ExerciseIntensity intensity) {
        this.intensity = intensity;
    }

    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public static void handleInfoExercise(String command) throws UnregisteredExerciseException,
            IncompleteInfoException {
        String name = Parser.parseInfoExercise(command);
        int[] details = exerciseDetails.get(name);
        if (details == null) {
            throw new UnregisteredExerciseException();
        }
        System.out.println("Exercise: " + name);
        System.out.println("~ Calories burnt for a 1 minute workout of ~");
        System.out.println("HIGH intensity: " + details[0]);
        System.out.println("MEDIUM intensity: " + details[1]);
        System.out.println("LOW intensity: " + details[2]);
    }

    public static void printAvailableExercises() {
        System.out.print("Available exercises: ");
        for (String exercise : exerciseDetails.keySet()) {
            System.out.print(exercise);
            System.out.print(", ");
        }
        System.out.print("etc.");
        System.out.println();
    }

    public static void listAvailableExercises() {
        System.out.println("Available exercises: ");
        for (String exercise : exerciseDetails.keySet()) {
            System.out.println("- " + exercise);
        }
        System.out.println();
        System.out.println("You may also input an exercise that isn't here.");
    }
    
    public static HashMap<String, int[]> getExerciseDetails() {
        return exerciseDetails;
    }
}
