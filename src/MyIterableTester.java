/**
 * This class parses and categorizes data from a text file into strings, integers, and doubles, then displays them.
 * <p>
 * The MyIterableTester class demonstrates the parsing and processing of data from a text file.
 * It reads data from a file, segregates them into different data types (String, Integer, Double),
 * and then displays them using the MyIterable class.
 * <p>
 * author Charles Ray and Alfredo Sandoval-Luis
 * edu.uwp.cs.340.course CSCI 340 - Data Structures/Algotrithm Design
 * edu.uwp.cs.340.section 001
 * edu.uwp.cs.340.assignment 1
 * bugs none
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MyIterableTester {
    /**
     * The main method is the entry point of the application.
     * It reads data from "src/input.txt", separates it into strings, integers, and doubles,
     * and then displays each list using MyIterable.
     *
     * @param args Arguments passed to the program (not used).
     */

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Integer> integerList = new ArrayList<>();
        ArrayList<Double> doubleList = new ArrayList<>();

        try {
            // Reading data from file
            File inputFile = new File("src/input.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                // Sorting data into respective lists based on their type
                while (lineScanner.hasNext()) {
                    if (lineScanner.hasNextInt()) {
                        integerList.add(lineScanner.nextInt());
                    } else if (lineScanner.hasNextDouble()) {
                        doubleList.add(lineScanner.nextDouble());
                    } else {
                        stringList.add(lineScanner.next());
                    }
                }
                lineScanner.close();
            }
            scanner.close();

            // Convert ArrayLists to arrays
            String[] stringArray = stringList.toArray(new String[0]);
            Integer[] integerArray = integerList.toArray(new Integer[0]);
            Double[] doubleArray = doubleList.toArray(new Double[0]);

            // Create MyIterable instances and display elements in reverse sorted order
            System.out.println("My friends:");
            MyIterable<String> stringIterable = new MyIterable<>(stringArray);
            for (String friendNames : stringIterable) {
                System.out.print(friendNames + " ");
            }
            System.out.println("\n----------+---------");

            System.out.println("My numbers:");
            MyIterable<Integer> integerIterable = new MyIterable<>(integerArray);
            for (Integer numbers : integerIterable) {
                System.out.print(numbers + " ");
            }
            System.out.println("\n----------+---------");

            System.out.println("My scores:");
            MyIterable<Double> doubleIterable = new MyIterable<>(doubleArray);
            for (Double scores : doubleIterable) {
                System.out.print(scores + " ");
            }
            System.out.println("\n----------+---------");

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}