/**This Goat class is one of the bottommost subclasses in the
 * hierarchy and inherits from the Cheese class, as well as from the Ingredient
 * class, which includes the instance variables of a customized final
 * description, cost, and calorie count
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Goat extends Cheese {
    public static final String description = "Goat cheese";
    public static final Money cost = new Money(4, 99);
    public static final int cal = 103;

    /**this is the default constructor that will automatically plug in the instance variables
     * from the Goat class into the super method constructor that accepts the types of
     * String, Money, and int in that order to initialize the variables based on the customized
     * Goat cheese characteristics
     */
    public Goat () {
        super(description, cost, cal);
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Goat testing = new Goat();
        System.out.println(testing.getDescript());
        System.out.println("Cost: " + testing.getCost());
        System.out.println("Calories: " + testing.getCalories());
    }
}
