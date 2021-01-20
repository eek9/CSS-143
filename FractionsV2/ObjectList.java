/**
 * The ObjectList class is what we are reusing from our last lab. It will
 * be used to store a list of the unique FractionCounters
 *
 * @author Eunhee Kim
 * @version October 10, 2019
 */
public class ObjectList
{
    //Declare an integer called numElements
    //Make this private, and set it to zero
    private int numElements = 0;
    //Declare an integer array called "data"
    //Make this private and able to store up to 100 integers
    private FractionCounter[] fList= new FractionCounter[100];

    public void add(FractionCounter nx) {
        //this should add the value n to our array and add one to
        //numElements
        fList[numElements++] = nx;
    }

    @Override
    public String toString() {
        String retVal = "";
        //in a loop, append all the elements in our data array to
        //this string, separated by a line
        for(int i = 0; i < numElements; i++) {
            retVal += fList[i] + "\n";
        }
        return retVal;
    }
}