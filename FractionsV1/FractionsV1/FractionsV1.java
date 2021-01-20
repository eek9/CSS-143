import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Fractions V1 Assignment:
 * Create a class that will read a file with a set of fractions and build a main method that identifies
 * the amount of occurrences of each fraction. The output should print out the list of unique fractions
 * and the corresponding counts.
 *
 * @author Eunhee Kim
 * @version October 5, 2019
 */
public class FractionsV1 {

    /**
     * There is only one method for this class and it is the main, which will calculate all the occurrences of the
     * same value fractions coming from the list of fractions in a file. There is a FileNotFoundException
     * to make sure that the file is able to read in order for the rest of the code to process.
     * Steps in this method include - assigning arrays for the list of values to compare and calculating the fraction
     * values to count the occurrences.
     */

    public static void main(String[] args) throws FileNotFoundException {

            //scanner running through File(fractions.txt) to read from

            File f = new File("fractions.txt");
            Scanner reader = new Scanner(f);

            //assigning list of numbers as a String array with a quantity of how many lines/rows there are based on
            //amount of line counts from the while loop condition of reader.hasNextLine())
            //*I understand that I should not have hard coded the size of the array, but I was not
            //sure where to find the solution to resize it according to whatever the number of rows in the file*
            String[] fraction = new String[100000];
            int lines = 0;
            while (reader.hasNextLine()) {
                fraction[lines] = reader.next();
                lines++;
            }

            //arrays to split the string of fractions into 2 new different arrays (numerators and denominators)
            String[] split;
            //array for the list of numerators
            Double[] numerator = new Double[lines];
            //array for the list of denominators
            Double[] denominator = new Double[lines];


            //for loop to assign values into the numerator and denominator arrays through the separation of "/" sign
            //while also parsing the values into double[] arrays
            for (int i = 0; i < lines; i++) {
                split = fraction[i].split("/");
                numerator[i] = Double.parseDouble(split[0]);
                denominator[i] = Double.parseDouble(split[1]);
            }
            
            //for loop to compare the first fractions to the next
            for (int i = 0; i < lines; i++) {

                //initial variable to find the number of occurrences of fraction
                int count = 0;

                //simplifying/finding the decimal values of the fraction through a variable to make it easier to compare
                //with the upcoming fractions
                double math1 = numerator[i]/denominator[i];
                int j;

                //initializing decimal value of the upcoming fraction to compare with
                double math2 =0;

                //for loop for locating the array of the second fraction and finding the
                //decimal value to compare with the first
                for (j = 0; j < lines; j++) {

                    //value of the comparing next fraction
                    math2 = numerator[j]/denominator[j];

                    //adding on counts whenever the two decimal values from each fraction is the same
                    if (math1 == math2) {
                        count++;
                    }
                }

                //*I tried to figure out how to keep the code from repeating the same fractions with the same values and
                //was not able to find the solution. The if statement below was what I thought would make sense, but as you can
                //see from the output, it did not work.
                //I used this if statement thinking that if the second comparing value was not equal to the first comparing value,
                //then it would make the second comparing value as a unique Fraction and letting that fraction to print. This will
                //then avoid reprinting the fractions with the same values as the previous ones.*
                if(math2 != math1) {
                    System.out.println(fraction[i]  + " has a count of " + count);
                }
            }
    }

}
/*
 *QUESTIONS:
 *
 *Q1:
 * Can you complete this without using arrays?
 * We can use a char index to identify each part of the String from the list of fractions and then parsing it into integer values
 * to compare and evaluate their actual values, however our code would be much longer and complicated.
 *
 * What is the least number of variables you can use to solve this problem?
 * 4 variables - int variable to count amount of occurrences, variable for numerator, variable for denominator, int variable
 * to find amount of lines
 *
 *Q2:
 * Can you use just one array to solve this?
 * Yes
 *
 * What would the data type be of that array?
 * String
 *
 *Q3:
 * What does it mean to make a class so another class is inside (or part of) the first class, so that it is composed of other data types?
 * What does "composition" mean in that case?  How is it done?
 * The first class will be referencing other objects from the other classes as its own instance variable.
 * The name of the class being called into the other class can be seen as a data type, when addressing it as "Class_Name Variable".
 * You can also access the other methods from class1 in another class, class2, through an object from class1.
 *
 *Q4:
 * What are some solutions to the reduction problem other than Euclid's GCD (greatest common divisor) algorithm? (You may want to look up GCD online.)
 * Assigning variables that equal a decimal of the values when the fractions are divided.
 *
 */



