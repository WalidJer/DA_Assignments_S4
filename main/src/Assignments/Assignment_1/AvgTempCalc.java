import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 ****************************Assignment#1**************************
 * This class allows the user to:
 * - Enter a list of daily temperatures
 * - Calculate the average temperature
 * - Identify and display all temperatures above the average
 */
public class AvgTempCalc {

    double[] temperatures;

    public AvgTempCalc(int numberOfTemperatures) {
        temperatures = new double[numberOfTemperatures];
    }

    /**
     * Method to prompts the user to enter temperature values.
     */
    public void insertTemperatures() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Enter temperature for day " + (i + 1) + ": ");
            temperatures[i] = sc.nextDouble();
        }
        sc.close(); 
    }

    /**
     * Calculates the average temperature and identifies
     * all temperatures that are above that average.
     * Prints the summary results.
     */
    public void averageTemperature() {
        double sum = 0;

        // Calculate the sum of all temperatures
        for (int i = 0; i < temperatures.length; i++) {
            sum += temperatures[i];
        }

        // Compute the average
        double averageTemperature = sum / temperatures.length;

        // Collect temperatures above the average
        ArrayList<Double> aboveAverageTemperatures = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > averageTemperature) {
                aboveAverageTemperatures.add(temperatures[i]);
            }
        }

        // Display the results
        System.out.println("\nYou entered the following temperatures: " + Arrays.toString(temperatures));
        System.out.println("The calculated average temperature is: " + averageTemperature);
        System.out.println("Number of days above the average: "+aboveAverageTemperatures.size() + " day(s) ");
        System.out.println("Those above-average temperatures are: " + aboveAverageTemperatures);
    }

    /**
     * Main method: gets number of temperatures/days from the user,
     * then runs the analysis.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of temperatures/days: ");
            int numberOfTemperatures = scanner.nextInt();

            if (numberOfTemperatures <= 0) {
                System.out.println("Number of days must be greater than 0.");
                return;
            }

            
            AvgTempCalc avgCalc = new AvgTempCalc(numberOfTemperatures);
            avgCalc.insertTemperatures();
            avgCalc.averageTemperature();

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid numbers.");
        } finally {
            scanner.close(); 
        }
    }
}