/**
 * The Stack class will contain methods of how a Stack list behaves:
 * the LIFO(Last In First Out) of adding objects to the top/front of the list(push),
 * removing objects from the list at the top/front as well.
 *
 * @author Eunhee Kim
 * @version October 17, 2019
 */
public class Stack {

    private Object[] stack;
    private int top;

    //this push method will add an object into a Stack, where it will be listed on the top of the list
    //the top of the Stack will be the highest number of the array
    public void push(Object obj) {
            //creating a new object array, which will carry the shifted and a newly added object to the
            //end of the list
            //the length of the new array will be one more than the stack array because we are adding one object
            //at a time in the array
            //when I tried to run my code, it highlights the code below, and
            //I was not able to figure out what could be the issue to it.
            Object[] newList = new Object[stack.length + 1];
            //the for loop will take the values from the class stack array and copy it over to the newList array
            //until it hits the end of the whole array
            for(int i = 0; i<stack.length; i++) {
                    stack[i] = newList[i];
            }
            //after the for loop finishes running, the newList array will add/push the new object into the last spot
            newList[stack.length - 1] = obj;
            //
            stack = newList;
    }
    //this method is supposed to return the object from the stack list that will be removed from the top, which is
    //the last element in the list because it was the last one in
    public Object pop() {

        Object popped = stack[stack.length-1];
        //turning the last element in the stack array list into a null, because that will be what we are removing
        stack[stack.length-1] = null;
        Object[] newList = new Object[stack.length-1];
        //this for loop will have the stack array copy its elements over to the newList array, except for the last
        //element in the list, because that is what will be popped/removed
        for(int i=0; i<newList.length; i++) {
            stack[i] = newList[i];
        }
        stack = newList;
        //
        return popped;
    }

    //method to return the size of the list
    public int size() {
        return stack.length;
    }

    //method that will return the string of elements from the stack list
    public String toString() {
        String retVal = "";
        for(int i=0; i<stack.length; i++) {
            retVal += stack[i] + " ";
        }
        return retVal;
    }

    //method that will return the boolean if the list contains empty areas
    public boolean isEmpty() {
        boolean isEmpty = false;
        for(int i=0; i<stack.length; i++) {
            if(stack[i] != null) {
                isEmpty = false;
            } else {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    //method that returns a boolean stating if the comparing the objects are the same or not
    public boolean equals(Object that) {
        boolean equals = false;
        if(this.size() == ((Stack)that).size()) {
            for (int i = 0; i < stack.length; i++) {
                if (stack[i] == that) {
                    equals = true;
                }
            }
        }
        return equals;
    }
}
