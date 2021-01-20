/**
 * The LinearSearch class is inherited from the SearchAlgorithm class.
 * Its purpose is to find a String target through a linear search down an array
 * of strings. The method of search will be created incursively and recursively
 * in this class
 *
 * @author Eunhee Kim
 * @version October 7, 2019
 */
public class LinearSearch extends SearchAlgorithm {

    /**this method iteratively searches for a target string from a String list through loops
     * and if statement.
     *
     * @return an integer of the index where the target is found
     * @throws ItemNotFoundException when the target is not found in the given list
     */
    public int search(String[] list, String target) throws ItemNotFoundException{
        //always resetting the count before searching for another target
        resetCount();
        //when the list is not empty, it will go through a for loop where it searches
        //through the list array until it matches with the target, which will then return
        //the index of where it occurred
        if(list!=null) {
            for(int i=0; i<list.length; i++) {
                incrementCount();
                if(list[i].equalsIgnoreCase(target)) {
                    return i;
                }
            }
        }
        throw new ItemNotFoundException();
    }

    /**this method recursively searches through the list with the help of another
     * method, recSearchHelper
     *
     * @return an integer of the index where the target appears
     * @throws ItemNotFoundException when the target is not found in the given list
     */
    public int recSearch(String[] list, String target) throws ItemNotFoundException{
        //resetting count before searching for the next target
        resetCount();
        //returns the value found from the helper method
        return recSearchHelper(list, target, 0);
    }

    /**this method is a helper for the recursive method search. Its purpose is to
     * keep track of the count of index as it goes down the list until it reaches
     * the target file, through recursively calling the same method but changing the
     * parameter of the index as it goes down the list by 1
     *
     * @return an integer of where the target appears in the index
     * @throws ItemNotFoundException when the target is not found in the given list
     */
    public int recSearchHelper(String[] list, String target, int index) throws ItemNotFoundException{
        //this is the base case, where it will throw the exception when the index
        //grows larger than the length of the list
        if(index>list.length) {
            throw new ItemNotFoundException();
            //when the match is found in the list, it will add a count and also return
            //the index of where the target was found
        } else if (list[index].equals(target)) {
            incrementCount();
            return index;
            } else {
            incrementCount();
            //this is the recursive method that will continue on to the next index
            //of the list to compare if the target is found or not
            return recSearchHelper(list, target, index + 1);
        }
    }
}
