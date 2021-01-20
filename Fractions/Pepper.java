import java.awt.*;
/**This Pepper class is one of the bottommost subclasses in the
 * hierarchy and inherits from the Vegetable class, as well as from the Ingredient
 * class, which includes the instance variables of a customized final
 * description, cost, calorie count, and color of the vegetable
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Pepper extends Vegetable {

    public static final String descript = "Pepper";
    public static final Money cost = new Money(1,20);
    public static final int cal = 60;
    public static Color color = Color.green;

    /**this is the default constructor that will automatically plug in the instance variables
     * from the Pepper class into the super method constructor that accepts the types of
     * String, Money, and int in that order to initialize the variables based on the customized
     * Pepper characteristics
     */
    public Pepper() {
        super(descript, cost, cal, color);
    }

    /**this is a constructor that will keep all the description, cost, and calorie count the same
     * as the initialized instance variables of Pepper, however it will also add in a type of color
     * of that pepper other than green based on the input
     * @param c initializing color of the pepper
     */
    public Pepper(Color c) {
        super(descript, cost, cal, c);
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Olive testing = new Olive();
        System.out.println(testing.getDescript());
        System.out.println("Cost: " + testing.getCost());
        System.out.println("Calories: " + testing.getCalories());
        System.out.println("Color: " + color);
    }
}
