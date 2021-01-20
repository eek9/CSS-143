import java.util.Iterator;
import java.util.List;

/**
 * The ArrayList class will contain methods of how an ArrayList class can behave:
 * random accessing in indexes of different parts of the list, adding in any areas,
 * removing elements in any areas, returning objects that are removed
 *
 * @author Eunhee Kim
 * @version October 17, 2019
 */
public class ArrayList<T> implements Iterable<T>{

    ArrayList<Bill> list = new ArrayList<>();

    private Object[] arrayList = new Object[100];

    //this method will insert an object into an index/random access
    public void insert(Object obj, int index) {
        //creating a new array list that will contain the amount of elements as the original arrayList plus one
        Object[] newList = new Object[arrayList.length+1];
        //the for loop will contain 3 if statements, which sections off before the index, replacing the index with
        //the object, and after the index
        for(int i = 0; i<arrayList.length; i++) {
            if(i<index) {
                //copying elements before reaching the index
                arrayList[i] = newList[i];
                //replacing the object in the designated index
            } else if (i==index) {
                newList[index]= obj;
                //after the index is passed, the rest of the list will be copied over to the newList array
            } else if (i>index) {
                arrayList[i-1] = newList[i];
            }
        }
        arrayList = newList;
    }

    //this method will remove the object coming from any index that is entered in the parameter
    public Object remove(int index) {
        //creating the object and finding it in the arrayList array
        Object removed = arrayList[index];
        //creating a new array that will store the elements without the removed object
        Object[] newList = new Object[arrayList.length - 1];
        //for loop to go over arrayList index and finding the object to remove
        for (int i = 0; i < arrayList.length - 1; i++) {
            //if statement to copy over the elements before reaching index into the newList array
            if (i < index) {
                arrayList[i] = newList[i];
                //if statement to state the object index removed, and skipping it when copying into the newList array
            } else if (i == index) {
                arrayList[i] = removed;
                //if statement for the elements after reaching the index to copy over to the new array
            } else if (i > index) {
                arrayList[i + 1] = newList[i];
            }
        }
        return removed;
    }

    //method that will return the value of size in the list
    public int size() {
        return arrayList.length;
    }

    //method that will print out the string of values from the list
    public String toString() {
        String retVal = "";
        for(int i=0; i<arrayList.length; i++) {
            retVal += arrayList[i] + " ";
        }
        return retVal;
    }

    //return a boolean that will find if there are empty or null areas in the list
    public boolean isEmpty() {
        boolean isEmpty = false;
        for(int i=0; i<arrayList.length; i++) {
            if(arrayList[i] != null) {
                isEmpty = false;
            } else {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    //method that will return the index of what obj is wanted to be located
    public int indexOf(Object obj) {
        for(int i=0; i<arrayList.length; i++) {
            if(arrayList[i] == obj);
            return i;
        }
        return -1;
    }

    //method that returns a boolean of whether two comparing objects are the same
    public boolean equals(Object that) {
        boolean equals = false;
        if(this.size()==((ArrayList)that).size()) {
            for (int i = 0; i < arrayList.length; i++) {
                if (arrayList[i] == that) {
                    equals = true;
                }
            }
        }
        return equals;
    }

    //method that will return the object of what index is wanted to look up
    public Object get(int index) {
        return arrayList[index];
    }

    /**this method will return an iterator in a list of elements in T
     *
     * @return Iterator list of T
     */
    @Override
    public Iterator<T> iterator() {
        return new myIterator<Bill>(list);
    }

//    public void add(T bill) {
//        Object[] newList = new Object[arrayList.length+1];
//        for(int i = 0; i<=arrayList.length; i++) {
//            if(i == arrayList.length) {
//                newList[i] = bill;
//            } else {
//                newList[i] = arrayList[i];
//            }
//        }
//        arrayList=newList;
//    }

    /**this inner class will allow us to have our iterator method
     * to return an iterator from this class
     */
    public class myIterator<E> implements Iterator{

        int index = 0;
        ArrayList<E> list;

        /**this is a copy constructor of an ArrayList
         *
         * @param list an ArrayList
         */
        public myIterator(ArrayList<E> list) {
            this.list = list;
        }

        /**this is a boolean method that checks to see if there is another
         * element in the next index
         *
         * @return a boolean value of true if there is a next element, and false
         * if there is not
         */
        @Override
        public boolean hasNext() {
            if(list.size()>=index+1) {
                return true;
            }
            return false;
        }

        /**this method will return the class or object of the next element of the list
         *
         * @return E of the next object
         */
        @Override
        public E next() {
            E val = (E) list.get(index);
            index++;
            return val;
        }
    }
}
