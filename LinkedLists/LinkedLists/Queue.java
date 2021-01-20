/**The queue class will build from the inherited list class, but will modify its
 * structure of adding and removing objects by a FIFO structure
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class Queue extends List{

    /**This method is inherited from the List class, where it will determine
     * if a list is empty
     *
     * @return boolean value of true if list is empty and false if it is not empty
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**This method will enqueue an object to the end of the list
     *
     * @param next Object next of what will be added to the list
     */
    public void enqueue(Object next) {
        //borrowing the append method from the superclass because it behaves
        //to add objects to the end of the list
        super.append(next);
    }

    /**Overriding the insert() method from the superclass to enqueue, without using
     * the index
     *
     * @param index integer index of location to insert(this parameter will be ignored
     *              in this method of the Queue class because we are only inserting to
     *              the end of the list)
     * @param next Object next of what is to be queued into the list
     */
    @Override
    public void insert(Object next, int index) {
        //calling the enqueue method from the Queue class to behave as it should
        //to only add objects to the end of the list
        this.enqueue(next);
    }

    /**This method will dequeue objects only from the beginning of the list
     * to follow the FIFO structure
     *
     * @return Object that is to be dequeued
     */
    public Object dequeue() {
        //calling the remove() method from the superclass to remove only remove
        //the object from index 0(start/head of the list)
        return super.remove(0);
    }

    /**Overriding the remove() method from the superclass to dequeue the first
     * object in the beginning of the list
     *
     * @param index integer index of where to remove(this parameter will not be applied
     *              to change the behavior of the method regardless of what the value is
     *              because we are only trying to dequeue the object from the head of the
     *              index)
     * @return Object that is being dequeued
     */
    @Override
    public Object remove(int index) {
        //returning the value from when the dequeue method is called, so that
        //it will only remove the head of the list
        return this.dequeue();
    }

    public static void main(String[] args) {
        Queue empty = new Queue();
        Queue one = new Queue();
        Queue multiple = new Queue();

        one.enqueue(5);
        multiple.enqueue(10);
        multiple.enqueue(20);
        multiple.enqueue(30);

        System.out.println("Empty:"+empty);
        System.out.println("One:"+one);
        System.out.println("Multiple:"+ multiple);
        System.out.println("PASSED TEST");
        System.out.println();

        one.dequeue();
        multiple.dequeue();
        System.out.println("One (upon dequeue):"+one);
        System.out.println("Multiple (upon dequeue):"+ multiple);
        System.out.println("PASSED TEST");
        System.out.println();

        one.enqueue(600);
        multiple.enqueue(400);
        System.out.println("One (on enqueue):"+one);
        System.out.println("Multiple(on enqueue):"+ multiple);
        System.out.println("PASSED TEST");

        Queue test = new Queue();
        test.enqueue(0);
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        System.out.println("test(initial test):" + test);
        System.out.println("PASSED TEST");
        System.out.println();

        test.dequeue();
        System.out.println("test(after dequeue):" + test);
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
