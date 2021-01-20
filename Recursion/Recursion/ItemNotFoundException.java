/**
 *
 * @author Eunhee Kim
 * @version October 7, 2019
 */
public class ItemNotFoundException extends Exception{

    public ItemNotFoundException() {
        super("Target is not found");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

}
