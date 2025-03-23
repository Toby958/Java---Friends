package org.example;

//Importing packages
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class FileReader {



    /**
     * Reads a file containing colleague data and creates a binary search tree called BST of Colleague objects.
     *
     * @param filename the name of the file to be read
     * @return a binary search tree  called BST of Colleague objects
     */
    public static BST readColleagues(String filename) {
        BST bst = new BST();
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(";");
                String tag = lineScanner.next();
                String dateString = lineScanner.next();
                String[] interests = lineScanner.next().split(",");
                ArrayList<String> interestList = new ArrayList<>(Arrays.asList(interests));
                int day = Integer.parseInt(dateString.substring(8, 10));
                int month = Integer.parseInt(dateString.substring(5, 7));
                int year = Integer.parseInt(dateString.substring(0, 4));
                Colleague colleague = new Colleague(tag, year, month, day, interestList);
                bst.insertColleague(colleague);
                lineScanner.close();
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File was not found: " + filename);
        } catch (Exception e) {
            System.err.println("Error locating data in the file: " + filename);
            e.printStackTrace();
        }
        return bst;
    }


}