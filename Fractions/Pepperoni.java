/**This Pepperoni class is one of the bottommost subclasses in the
 * hierarchy and inherits from the Meat class, as well as from the Ingredient
 * class, which includes the instance variables of a customized final
 * description, cost, and calorie count
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Pepperoni extends Meat {
    public static final String description = "Pepperoni Meat";
    public static final Money cost = new Money(3,59);
    public static final int cal = 138;

    /**this is the default constructor that will automatically plug in the instance variables
     * from the Pepperoni class into the super method constructor that accepts the types of
     * String, Money, and int in that order to initialize the variables based on the customized
     * Pepperoni characteristics
     */
    public Pepperoni() {
        super(description, cost, cal);
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Pepperoni testing = new Pepperoni();
        System.out.println(testing.getDescript());
        System.out.println("Cost: " + testing.getCost());
        System.out.println("Calories: " + testing.getCalories());
    }
}
