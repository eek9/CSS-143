/**
 * The ArrayList class will contain methods of how an ArrayList class can behave:
 * random accessing in indexes of different parts of the list, adding in any areas,
 * removing elements in any areas, returning objects that are removed
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class ArrayList<TBA> {

    private TBA[] arrayList;

    /**the default constructor that will initialize the size of the array as
     * an empty array
     */
    public ArrayList() {
        arrayList = (TBA[]) new Object[0];
    }

    /**this method will return the size of how many elements are in the array
     * @return int value of how many elements
     */
    public int size() {
        return arrayList.length;
    }

    /**this method will find the element that is found in the wanted index
     * @param index int index of where to find value at
     * @return TBA the element found
     */
    public TBA get(int index) {
        if (this.isEmpty())
        {
            throw new NullPointerException();
        }
        else
        {
            return (TBA) arrayList[index];
        }
    }

    /**this method will set an element into a specified index
     * @param idx the int index of where you want to set a value
     * @param obj the object you want to set the index as
     * @return nothing
     */
    public void set(int idx, TBA obj) {
        this.arrayList[idx] = obj;
    }

    /**this method will insert an object to any index through random access
     * @param obj the object that will be inserted
     * @param index the index of where to add the new obj
     * @return nothing
     */
    public void insert(Object obj, int index) {
        if(this.arrayList.length==0) {
            this.arrayList = (TBA[]) new Object[1];
            this.arrayList[0] = (TBA) obj;
        } else {
            TBA[] newList = (TBA[]) new Object[arrayList.length+1];
            for(int i=0; i<index; i++) {
                newList[i] = this.arrayList[i];
            }
            newList[index] = (TBA) obj;
            for(int i=index+1; i<newList.length; i++) {
                newList[i] = this.arrayList[i-1];
            }
            this.arrayList = newList;
        }
    }

    /**this method will remove an object from a specified index
     * @param index the index of where to remove the object from
     * @return the object that is now removed from the arraylist based on the index
     */
    public TBA remove(int index) {
        TBA removed = this.arrayList[index];
        if(this.arrayList.length==1) {
            this.arrayList = (TBA[]) new Object[0];
        } else {
            Object[] newList = new Object[this.arrayList.length-1];
            if(index==0) {
                for(int i=0; i<arrayList.length-1; i++) {
                    newList[i] = arrayList[i+1];
                }
                this.arrayList = (TBA[]) newList;
            } else {
                for (int i = 0; i < index; i++) {
                    newList[i] = this.arrayList[i];
                }
                for (int i = index; i < arrayList.length; i++) {
                    newList[i] = this.arrayList[i + 1];
                }
                this.arrayList = (TBA[]) newList;
            }
        }
        return removed;
    }

    /**method that will return the index of what obj is wanted to be located
     * @param obj the obj that is being searched
     * @return int value of the index where the obj is found
     */
    public int indexOf(TBA obj) {
        for(int i=0; i<this.arrayList.length; i++) {
            if(arrayList[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    /**method that returns a boolean of whether two comparing objects are the same
     *
     * @param that the arraylist that is being compared to
     * @return boolean statement if whether the two arraylists are the same of not
     */
    public boolean equals(ArrayList that) {
        boolean equals = false;
        if(this.size()==that.size()) {
            for (int i = 0; i < arrayList.length; i++) {
                if (!(arrayList[i].equals(that.get(i)))) {
                    break;
                } else {
                    equals = true;
                }
            }
        }
        return equals;
    }
    /**this method will swap the objects from two indexes
     * @param idx1 integer of index in where to swap from
     * @param idx2 integer of index in where to swap
     */
    public void swap(int idx1, int idx2) {
        TBA temp = arrayList[idx1];
        arrayList[idx1] = arrayList[idx2];
        arrayList[idx2] = temp;

    }

    /**return a boolean that will find if there are empty or null areas in the list
     *
     * @return boolean value of whether the arraylist is empty or not
     */
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    /**method that will print out the string of values from the list
     * @return String of the ArrayList values in the output
     */
    public String toString() {
        String retVal = "";
        for(int i=0; i<arrayList.length; i++) {
            retVal += arrayList[i] + " ";
        }
        return retVal;
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {

        ArrayList<Money> testing = new ArrayList<>();
        Money a = new Money(10,99);
        Money b = new Money(1,85);
        Money c = new Money(3,45);
        Money d = new Money(7,99);
        testing.insert(a,0);
        testing.insert(b,1);
        testing.insert(c,2);


        System.out.println(testing);
        System.out.println("test1 passed");
        System.out.println();

        testing.remove(0);
        System.out.println(testing);
        System.out.println("test2 passed");
        System.out.println();

        testing.insert(d, 2);
        System.out.println(testing);
        System.out.println("test3 passed");
        System.out.println();

        testing.swap(0,1);
        System.out.println(testing);
        System.out.println("test4 passed");
        System.out.println();

        System.out.println("Index of d($7.99) is at: " + testing.indexOf(d));
        System.out.println("test5 passed");
        System.out.println();

        ArrayList<Money> compare = new ArrayList<>();
        System.out.println("Compare isEmpty()? " + compare.isEmpty());
        System.out.println("test6 passed");
        System.out.println();

        System.out.println("Is compare and testing equal? "+ compare.equals(testing));
        System.out.println("test7 passed");
        System.out.println();

        compare.insert(new Money(3,45), 0);
        compare.insert(new Money(1,85), 1);
        compare.insert(new Money(7,99),2);
        System.out.println("is compare and testing equal now? " + compare.equals(testing));
        System.out.println("test8 passed");
        System.out.println();

        System.out.println("At Index 0 of compare there is: " + compare.get(0));
        compare.remove(0);
        System.out.println("After removing from Index 0 of compare: " + compare);
        System.out.println("test9 passed");
        System.out.println();

    }

}
