package seedu.fitnus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVReader {
    public static final String DELIMITER = ",";
    private static HashMap<String, String[]> foodItems = new HashMap<>();

    public static void main(String[] args){
        String mealCsvFile = "./tp/db/Meal_db.csv";
        String drinkCSVFile = "./db/Drink_db.csv";
        CSVReader.read(mealCsvFile);
    }
    public static void read(String filename) {
        try{
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(DELIMITER);
                String itemFullName = tempArr[0];
                String[] itemDetails = new String[tempArr.length-1];
                for(int i = 1; i < tempArr.length; i++) {
                    itemDetails[i-1] = tempArr[i];
                }
                foodItems.put(itemFullName, itemDetails);

            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readInputInfo(String filename, String foodName) {
        read(filename);
        String foodNameTrimmed = foodName.toLowerCase().trim();
        StringBuilder result = new StringBuilder();
        boolean found = false;
        String[] nutrientInfo = null;
        if (foodItems.containsKey(foodNameTrimmed)) {
            nutrientInfo = foodItems.get(foodName);
            found = true;
        } else {
            System.out.println("Error! Food not found. Please input a valid item.");
        }
        if (found && nutrientInfo != null) {
            result.append(foodName);
            for(int i = 0; i < nutrientInfo.length; i++) {
                result.append(DELIMITER).append(nutrientInfo[i]);
            }
        }
        return result.toString();
    }
}

