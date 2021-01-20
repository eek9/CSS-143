/**The LinkedListException class inherits from the RuntimeException class
 * as we use this to throw an exception when a situation occurs in the code
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class LinkedListException extends RuntimeException{

    /**Default constructor of the class that also calls the default constructor
     * of the superclass
     */
    public LinkedListException() {
        super();
    }

    /**A constructor of the class that will print out a customized message
     * when the exception is caught
     *
     * @param msg String message of what to display when the exception is caught
     *            in a certain area
     */
    public LinkedListException(String msg) {
        super(msg);
    }

}
