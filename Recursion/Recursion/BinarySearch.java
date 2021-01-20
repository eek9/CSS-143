/**
 * The BinarySearch class extends from the SearchAlgorithm class.
 * It will search for the target in a String array by splitting the section
 * into half, and determining if the target will appear in the first half
 * or second half of the array. From there, it will work its way up or down the
 * list to search for the target.
 *
 * @author Eunhee Kim
 * @version October 7, 2019
 */
public class BinarySearch extends SearchAlgorithm {

    /**this method will iteratively search for the target by only using loops
     * and if statements while splitting the index into 2 and finding its way
     * for a match from either going up or down the array
     *
     * @return integer of how which index the target will appear
     */
    public int search(String[] list, String target) throws ItemNotFoundException{
        //resetting count before searching for next target
        resetCount();
        int lowIndex = 0;
        int highIndex = list.length-1;
        //as long as the lowIndex is less than the highIndex value
        while (lowIndex<=highIndex) {
            //the midIndex is found by splitting the list into half from adding
            //the lowIndex and highIndex, then dividing by 2
            int midIndex = (lowIndex+highIndex)/2;
            //if the array of midIndex element is equal to the target, then it will return the
            //value of the midIndex
            if (list[midIndex].equals(target)) {
                incrementCount();
                return midIndex;
                //if the target is greater than the array of the midIndex,
                //then the highIndex will shift down one
            } else if(list[midIndex].compareTo(target)>0) {
                incrementCount();
                highIndex=midIndex-1;
                //if the target is less than the array of the midIndex,
                //then the lowIndex will shift up one
            } else if(list[midIndex].compareTo(target)<0) {
                incrementCount();
                lowIndex=midIndex+1;
            }
        }
        throw new ItemNotFoundException();
    }

    /**this method will recursively search for the index of the target through
     * the help of another method, recSearchHelper which receives 2 more passing
     * parameters of a lowIndex and highIndex to direct which direction to go
     *
     * @return an integer of which index the target will be found
     */
    public int recSearch(String[] list, String target) throws ItemNotFoundException{
        resetCount();
        int lowIndex = 0;
        int highIndex = list.length-1;
        //calling the helper method
        return recSearchHelper(list, target, lowIndex, highIndex);

    }

    /**this method will help the resursive search by determining which direction to
     * continue searching for the target based on if it will occur before the
     * middle index or after the middle index
     *
     * @return an integer of which index the target will be found
     */
    public int recSearchHelper(String[] list, String target, int lowIndex, int highIndex) throws ItemNotFoundException {
        int midIndex = (lowIndex+highIndex)/2;
        if(lowIndex>highIndex) {
            throw new ItemNotFoundException();
        }
        //if the midIndex of the array equals to the target, then it will return
        //the midIndex
        if(list[midIndex].equals(target)) {
            incrementCount();
            return midIndex;
        } else if(list[midIndex].compareTo(target)>0) {
            incrementCount();
            //this is the recursive method that will go back up to the list to
            //compare the target string to the before index
            return recSearchHelper(list, target, lowIndex, midIndex-1);
        } else if(list[midIndex].compareTo(target)<0) {
            incrementCount();
            //this is the recursive method that will continue going down the list to
            //compare the target string to the next index
            return recSearchHelper(list, target, midIndex+1, highIndex);
        }
        throw new ItemNotFoundException();
    }
}
