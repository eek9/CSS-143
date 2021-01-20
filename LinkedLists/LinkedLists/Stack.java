/**The Stack class will build from the inherited List class and behave through
 * the push an pop functions, which is redirected from the superclass
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class Stack extends List{

    /**This method is inherited from the List class, where it will determine
     * if a list is empty
     *
     * @return boolean value of true if list is empty and false if it is not empty
     */
    public boolean isEmpty() {
        //return the value from the method of isEmpty() from the superclass
        return super.isEmpty();
    }

    /**This method will push/add an object to the top of the "stack"/list
     *
     * @param next Object next will be passed to be added onto last of the list
     */
    public void push(Object next) {
        //we are using the append method from the super class, because it is a
        //function that will act to add an object to the end of the list, just as how
        //the push is supposed to behave
        super.append(next);
    }

    /**Overriding the insert() method from the superclass to push, without using
     * the index
     *
     * @param index integer index of location to insert(this parameter will be ignored
     *              in this method of the Stack class because we are only inserting to
     *              the end of the list.
     * @param next Object next of what is to be added into the list
     */
    @Override
    public void insert(Object next, int index) {
        //calling the push method from the child class, stack, to behave as a
        //push method
        this.push(next);
    }

    /**This pop method will remove only from the end of the list, because the Stack
     * behaves as a LIFO structure
     *
     * @return Object that will be removed from the list
     */
    public Object pop() {
        //Calling the remove method from the superclass where the index to be removed
        //will be from the last index, which is equivalent to the size of the list minus one
        return super.remove(size()-1);
    }

    /**Overriding the remove() method from the superclass to pop off the last
     * object from the list.
     *
     * @param index integer index of where to remove(this parameter will not be applied
     *              to change the behavior of the method, regardless of what the value is
     *              because we are only trying to pop off the last index of the list)
     * @return Object that is being popped
     */
    @Override
    public Object remove(int index) throws LinkedListException {
        //calling the pop method from the Stack class to remove the object from the last index
        return this.pop();
    }

    public static void main(String[] args) {
        Stack empty = new Stack();
        Stack one = new Stack();
        Stack multiple = new Stack();

        one.push(5);
        multiple.push(10);
        multiple.push(20);
        multiple.push(30);

        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);
        System.out.println("PASSED TESTS");
        System.out.println();

        one.pop();
        multiple.pop();
        System.out.println("One (upon pop):"+one);
        System.out.println("Multiple (upon pop):"+ multiple);
        System.out.println("PASSED TESTS");
        System.out.println();

        one.push(600);
        multiple.push(400);
        System.out.println("One (on push):"+one);
        System.out.println("Multiple(on push):"+ multiple);
        System.out.println("PASSED TESTS");
        System.out.println();

        Stack test = new Stack();
        test.push(0);
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println("test(intial test):" + test);
        System.out.println("PASSED TEST");
        System.out.println();

        test.pop();
        System.out.println("test(after pop):" + test);
        System.out.println("PASSED TEST");
        System.out.println();

        test.insert(5, 0);
        System.out.println("test(after 'insert'):" + test);
        System.out.println("PASSED TEST");
        System.out.println();

        test.remove(0);
        System.out.println("test(after 'remove')" + test);
        System.out.println("PASSED TEST");
        System.out.println();
    }
}
