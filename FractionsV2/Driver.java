import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * The driver class is where all the calculations and outputs will
 * be made from connecting all the functions from the other classes.
 *
 * @author Eunhee Kim
 * @version October 10, 2019
 */

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        //locating the file and using the scanner to read through it
        File f = new File("fractions.txt");
        Scanner reader = new Scanner(f);
        //creating an object from the ObjectList class
        ObjectList fractions = new ObjectList();

        //do-while loop to make sure that the fractions are distinguished from the
        //numerator and denominator first before doing anything else
        do {
            String fractionsLine = reader.nextLine();
            String[]splitF = fractionsLine.split("/");
            int numerator;
            numerator = Integer.parseInt(splitF[0]);
            int denominator;
            denominator = Integer.parseInt(splitF[1]);

            Fraction fractionA = new Fraction(numerator, denominator);


        } while (reader.hasNextLine());
        System.out.println(fractions.toString());
    }
}