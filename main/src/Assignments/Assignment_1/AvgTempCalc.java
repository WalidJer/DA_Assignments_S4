import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AvgTempCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input number of temperatures
            System.out.println("How many temperatures do you want to enter?");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Number of temperatures must be greater than 0.");
                return;
            }

            double[] temps = new double[n];
            double sum = 0;

            // Enter temperatures
            for (int i = 0; i < n; i++) {
                System.out.print("Enter temperature " + (i + 1) + ": ");
                temps[i] = sc.nextDouble();
                sum += temps[i];
            }

            // Calculate average
            double avg = sum / n;

            // Collect above-average temps in a List
            ArrayList<Double> aboveAvgTemps = new ArrayList<>();
            for (int i = 0; i < temps.length; i++) {
                if (temps[i] > avg) {
                    aboveAvgTemps.add(temps[i]);
                }
            }

            // Print results
            System.out.println();
            System.out.println("Temperatures entered: " + Arrays.toString(temps));
            System.out.println("Average temperature: " + avg);
            System.out.println(aboveAvgTemps.size() + " day(s) were above average temperature.");
            System.out.println("Temperatures above average: " + aboveAvgTemps);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
        } finally {
            sc.close();
        }
    }
}