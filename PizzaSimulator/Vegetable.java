import java.awt.*;
/**This Vegetable class inherits from the Ingredient class, which will include
 * the instance variables of a customized final description, cost, and
 * calorie count
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Vegetable extends Ingredient{
    private Color myColor;
    private String descript;
    private Money cost;
    private int cal;

    /**this constructor will initialize the variables of the base class and
     * call the method from the extended Ingredient class to plug in the
     * inputted values in order to set them
     * @param c int calorie count
     * @param m Money object of cost
     * @param d String description of Ingredient
     */
    public Vegetable(String d, Money m, int c) {
        super(d, m, c);
        myColor = Color.black;
    }

    /**this constructor will initialize the variables of the base class and
     * call the method from the extended Ingredient class to plug in the
     * inputted values in order to set them
     * @param c int calorie count
     * @param m Money object of cost
     * @param d String description of Ingredient
     * @param color color of vegetable
     */
    public Vegetable(String d, Money m, int c, Color color) {
        super(d, m, c);
        this.myColor = color;
    }

    /**this method will return the color of the vegetable
     * @return Color
     */
    public Color getColor() {
        return myColor;
    }

    /**this method will set the color of the vegetable to a different color
     * @param c Color to be changed to
     */
    public void Color(Color c) {
        this.myColor = c;
    }

    /**this is a overridden equals method that will compare two objects and its instance variables if
     * they are equal or not
     * @param obj comparing Object
     * @return boolean value if two objects are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Vegetable) {
            Vegetable other = (Vegetable) obj;
            return super.equals(obj) && this.myColor.equals(other.getColor());
        }
        else {
            return false;
        }
    }

    /**this is a overridden toString() method where it will print out the description, cost,
     * calories, and color of the Ingredient
     * @return String output of information
     */
    @Override
    public String toString() {
        return super.toString() + "\nColor: " + getColor();
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Vegetable testing = new Vegetable("tomato", new Money(4,99), 250);
        System.out.println(testing);

        Vegetable compare = new Vegetable("onion", new Money(2,35), 100);
        compare.Color(Color.white);
    }
}
