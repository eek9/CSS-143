/**This Ingredient class include instance variables that include a description,
 * cost, and calorie count of an Ingredient. The methods contained in this
 * class will include accessors and mutators for the instances. This class
 * also implements from the Comparable class to override the compareTo method
 * into this class for comparing the prices of two different Ingredient objects
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Ingredient implements Comparable {

    private String descript;
    private Money cost;
    private int calories;

    /**default constructor initializes the values of cost and calories to zero,
     * as well as the description to nothing
     */
    public Ingredient() {
        this.descript = "";
        this.cost = new Money(0,0);
        this.calories = 0;
    }

    /**constructor method that will initialize the values of the description,
     * cost, and calorie count of an ingredient object
     * @param c this is the string description of the name of the ingredient
     * @param d Money object of the cost of the ingredient
     * @param m int calorie count of the ingredient
     */
    public Ingredient(String d, Money m, int c) {
        this.descript = d;
        this.cost = new Money(m);
        this.calories = c;
    }

    public Ingredient(Ingredient a) {
        this.descript = a.descript;
        this.cost = new Money(a.getCost());
        this.calories = a.calories;
    }

    /**this method will return the name/description of the ingredient
     * @return String description of ingredient
     */
    public String getDescript() {
        return descript;
    }

    /**this method will set a new name/description into an ingredient
     * @param d the String of new name
     */
    public void setDescript(String d) {
        this.descript = d;
    }

    /**the method that will return the Money object
     * @return Money object
     */
    public Money getCost() {
        return new Money(cost);
    }

    /**this method will set new values from a money object
     * @param m the new Money object to set the new values
     */
    public void setCost(Money m) {
        this.cost = new Money(m);
    }

    /**this method will get the value of calories of an Ingredient
     * @return int value of calories in Ingredient
     */
    public int getCalories() {
        return calories;
    }

    /**this method will set new calorie count into an Ingredient
     * @param c int of new calories to set
     */
    public void setCalories(int c) {
        this.calories = c;
    }

    /**this method will return the Ingredient object
     * @return Ingredient object
     */
    public Ingredient getIngredient() {
        return this;
    }

    /**this is a overridden toString() method where it will print out the description, cost,
     * and calories of the Ingredient
     * @return String output of information
     */
    @Override
    public String toString() {
        return "Ingredients: " + getDescript() + "\nCost: " + getCost() + "\nCalories: "
                + getCalories();
    }

    /**this is a overridden equals method that will compare two objects and its instance variables if
     * they are equal or not
     * @param o comparing Object
     * @return boolean value if two objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if(o==null) {
            return false;
        } else if(o instanceof Ingredient) {
            Ingredient other = (Ingredient) o;
            return this.getDescript().equalsIgnoreCase(other.getDescript()) &&
                    this.getCost().equals(other.getCost()) &&
                    this.getCalories() == other.getCalories();
        } else {
            return false;
        }
    }

    /**this method will give an integer value based on the price of two comparing Ingredient objects
     * @param o comparing Ingredient object
     * @return int of either -1(comparing price is lower), 0(price is equal), or 1(price is higher)
     */
    @Override
    public int compareTo(Object o) {
        if(o instanceof Ingredient) {
            Ingredient other = (Ingredient) o;
            if (this.getCost().getMoney() > other.getCost().getMoney()) {
                return 1;
            } else if (this.getCost().getMoney() < other.getCost().getMoney()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -2;
        }
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Ingredient testing = new Ingredient();
        testing.setDescript("Chocolate");
        testing.setCalories(300);
        testing.setCost(new Money(3,99));

        System.out.println(testing);

        Ingredient compare = new Ingredient();
        compare = new Ingredient(testing);
        System.out.println("Is compare and testing equal? " + compare.equals(testing));
        System.out.println("test1 passed");
        System.out.println();

        compare.setCalories(500);
        System.out.println("after change, compare is now: " + "\n" + compare);
        System.out.println("Is compare and testing equal now? " + compare.equals(testing));
        System.out.println("test2 passed");

    }

}
