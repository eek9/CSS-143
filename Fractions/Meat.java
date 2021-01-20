/**This Meat class inherits from the Ingredient class, which will include
 * the instance variables of a customized final description, cost, and
 * calorie count
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Meat extends Base {

    /**this default constructor for base will direct to extended Ingredient
     * class' no argument constructor
     */
    public Meat() {
        super();
    }

    /**this constructor will initialize the variables of the base class and
     * call the method from the extended Ingredient class to plug in the
     * inputted values in order to set them
     * @param c int calorie count
     * @param m Money object of cost
     * @param descript String description of Ingredient
     */
    public Meat(String descript, Money m, int c) {
        super(descript, m, c);
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Meat testing = new Meat("bacon", new Money(4,99), 250);
        System.out.println(testing);
    }

}
