/**This Cheese class inherits from the Ingredient class, which will include
 * the instance variables of a customized final description, cost, and
 * calorie count
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Cheese extends Ingredient {

    /**this default constructor for base will direct to extended Ingredient
     * class' no argument constructor
     */
    public Cheese() {
        super();
    }

    /**this constructor will initialize the variables of the base class and
     * call the method from the extended Ingredient class to plug in the
     * inputted values in order to set them
     * @param c int calorie count
     * @param m Money object of cost
     * @param descript String description of Ingredient
     */
    public Cheese(String descript, Money m, int c) {
        super(descript, m, c);
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Cheese testing = new Cheese("cheddar", new Money(3,50), 180);
        System.out.println(testing);
    }
}
