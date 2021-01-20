/**
 * The Queue class will demonstrate how the lists of Queue classes behave:
 * the FIFO(First In First Out) of removing objects from the front(dequeueing), adding objects
 * to the back(enqueueing)
 *
 * @author Eunhee Kim
 * @version October 17, 2019
 */
public class Queue {

    private Object[] queue;

    //this method will add an object into the back of the queue list
    public void enqueue(Object obj) {
        //creating a new object array with the length of one more element than the original queue because we are
        //adding
        Object[] newList = new Object[queue.length+1];
        //for loop to copy the elements from the queue array to the newList
        for(int i=0; i<queue.length; i++) {
            queue[i] = newList[i];
        }
        //after the for loop, we will be filling in the last empty spot with the object
        newList[queue.length+1] = obj;
        queue = newList;
    }

    //this method will take out the front element of the queue array list and return the object value of what was
    //removed
    public Object dequeue() {
        //we are finding the dequeued object from the first element of the queue array
        Object dequeued = queue[0];
        //making a new array to add in the elements of the array in order after dequeueing the first element out
        Object[] newList = new Object[queue.length-1];
        //the for loop will copy over the elements from the queue array over into the newList array
        for(int i=0; i<queue.length-1; i++) {
                queue[i] = newList[i];
            }
        queue = newList;
        return dequeued;
    }

    //method to return the size of list
    public int size() {
        return queue.length;
    }

    //string method to return the values of the list
    public String toString() {
        String retVal = "";
        for(int i=0; i<queue.length; i++) {
            retVal += queue[i] + " ";
        }
        return retVal;
    }

    //method to determine if the list is empty
    boolean isEmpty() {
        boolean isEmpty = false;
        for(int i=0; i<queue.length; i++) {
            if(queue[i] != null) {
                isEmpty = false;
            } else {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    //boolean method to find if the comparing object is the same as another
    public boolean equals(Object that) {
        boolean equals = false;
        if(this.size() == ((Queue)that).size()) {
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] == that) {
                    equals = true;
                }
            }
        }
        return equals;
    }
}
