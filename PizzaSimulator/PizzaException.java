/**This PizzaException class is inherited from the RuntimeException class
 * so that it would be caught during runtime, whenever there are invalid inputs
 * that occur during the Pizza drivers.
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class PizzaException extends RuntimeException{

    /**when this method is called as the PizzaException is caught, it will call the default constructor
     * of its extended RuntimeException class
     *
     */
    public PizzaException() {
        super();
    }

    /**when this method is called with an input of the message, it will call connect it to the
     * constructor of the RunTimeException class to print out the message from the input
     * @param msg String message to output
     */
    public PizzaException(String msg) {
        super(msg);
    }
}
