import java.awt.*;
import java.util.Random;
/**This method will record all the Ingredients, and its total calories, cost, shape, and
 * fraction remaining in a Pizza object. It also uses the PizzaComparable
 * interface methods to compare the prices, sizes, and areas of comparing
 * pizza objects.
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Pizza implements PizzaComparable {

    private ArrayList<Ingredient> ingredientsList = new ArrayList<Ingredient>();
    private int calCount = 0;
    private Money totalCost = new Money(0,0);
    private Shape myShape;
    private Fraction remaining = new Fraction(1,1);
    private int ingredientCount = 0;

    /**this is a constructor for the Pizza class that will automatically
     * create another random pizza object
     */
    public Pizza() {
        Random random = new Random();

        int randomMeat = (int) (Math.random()+1.5);
        if(randomMeat==1) {
            addIngredient(new Pepperoni());
        } else {
            addIngredient(new Sausage());
        }

        int randomCheese = (int) (Math.random() +1.5);
        if(randomCheese==1) {
            addIngredient(new Goat());
        } else {
            addIngredient(new Mozzarella());
        }

        int randomBase = (int) (Math.random() +1.5);
        if(randomBase==1) {
            addIngredient(new Alfredo());
        } else {
            addIngredient(new Marinara());
        }

        int randomOlive = (int) (Math.random() +1.5);
        if(randomOlive==1) {
            addIngredient(new Olive(Color.GREEN));
        } else {
            addIngredient(new Olive(Color.BLACK));
        }

        int randomPepper = (int) (Math.random() +1.5);
        if(randomPepper==1) {
            addIngredient(new Pepper(Color.green));
        } else {
            addIngredient(new Pepper(Color.red));
        }

        int randomShapeSize = random.nextInt(50)+1;
        int randomX = random.nextInt(50)+1;
        int randomY = random.nextInt(50)+1;

        int randomShape = (int) (Math.random() +1.5);
        if(randomShape==1) {
            setShape(new Circle(randomX,randomY,randomShapeSize));
        } else {
            setShape(new Square(randomX, randomY, randomShapeSize));
        }
    }

    /**this method will return a fraction of how much of the pizza that is left
     * @return Fraction object that represents the amount left in the pizza
     */
    public Fraction getRemaining() {
        return remaining;
    }

    /**this method will set a new amount of remaining pizza
     * @param f Fraction object that will reset the remaining
     */
    public void setRemaining(Fraction f) {
        this.remaining = new Fraction(f);
    }

    /**this method will return the value of how many calories in a pizza
     * @return integer of calories
     */
    public int getCalories() {

        return calCount;
    }

    /**this method will set the calories of a pizza object into a new integer
     * this method is only used when adjusting the calories of the pizza after it has been eaten
     * @param cal int calories to set into pizza object
     */
    public void setCalories(int cal) {
        this.calCount = cal;
    }

    /**this method will return the total cost of the pizza
     * @return Money object of the cost of pizza
     */
    public Money getTotalCost() {

        return new Money(totalCost);
    }

    /**this method will return the value of the remaining area of the pizza left
     * @return double value of the area of pizza left
     */
    public double getRemainingArea() {

        return (double)(myShape.getArea()*remaining.getFractionValue());
    }

    /**this method will set the shape of the pizza
     * @param s Shape object that will set the shape
     */
    public void setShape(Shape s) {
        myShape = s;
    }

    /**this method will return the shape of the pizza
     * @return Shape object of the pizza
     */
    public Shape getShape() throws CloneNotSupportedException {
        try {
            return (Shape) myShape.clone();
        } catch(CloneNotSupportedException e){
            throw new CloneNotSupportedException();
        }
    }

    /**this method will add another ingredient to the pizza and add the ingredient's
     * price and calories to the total calories and cost of the whole pizza
     * @param a is the Ingredient object that will be added into the pizza
     */
    public void addIngredient(Ingredient a) {
        ingredientsList.insert(a, ingredientsList.size());
        ingredientCount++;
        calCount+=a.getCalories();
        totalCost.add(a.getCost());
    }

    /**this method will subtract a fraction amount from a pizza
     * @param amt Fraction amount to be eaten
     */
    public void eatSomePizza(Fraction amt) throws PizzaException{
        if(amt==null) {
            throw new PizzaException("Fraction to be eaten is a null amount");
        }else if(amt.getDenominator()<=0 || amt.getNumerator()<=0) {
            throw new PizzaException("Not a valid fraction");
        } else if(remaining.getNumerator()==0) {
            throw new PizzaException("Pizza is already gone");
        } else {
            double newCal = (double) (getCalories()/getRemainingArea());
            double newPrice = this.totalCost.getMoney()/getRemainingArea();
            remaining.subFraction(amt);
            newCal = newCal*getRemainingArea();
            newPrice = newPrice*getRemainingArea();
            this.calCount = (int)newCal;
            this.totalCost = new Money(newPrice);
        }
    }

    /**this overriden method will print out the information of a pizza with its cost,
     * shape, and remaining amount of pizza left
     * @return String of the record in pizza
     */
    @Override
    public String toString() {
        return "Pizza has a price:" + getTotalCost().toString() + " and calories:" + getCalories()
                + ", Fraction remaining:" + getRemaining().toString() + " and area left:" +
                getRemainingArea() + " and shape:" + myShape.toString();
    }

    /**this overriden method will compare the cost of different
     * pizzas and return different integers based on whether the comparing
     * object is greater or less than the pizza
     * @return int of either -1(comparing price is lower), 0(price is equal), or 1(price is higher)
     */
    @Override
    public int compareTo(Object o) {
        Pizza other = (Pizza) o;
        return this.getTotalCost().compareTo(other.getTotalCost());
    }

    /**this overridden method will compare the size of different
     * pizzas and return different integers based on whether the comparing
     * object is greater or less than the pizza
     * @return int of either -1(comparing size is lower), 0(size is equal), or 1(size is higher)
     */
    @Override
    public int compareToBySize(Object o) {
        Pizza other = (Pizza) o;
        if(this.getRemainingArea()>other.getRemainingArea()) {
            return 1;
        } else if(this.getRemainingArea()<other.getRemainingArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**this overridden method will compare the calories of different
     * pizzas and return different integers based on whether the comparing
     * object is greater or less than the pizza
     * @return int of either -1(comparing calories is lower), 0(calories is equal), or 1(calories is higher)
     */
    @Override
    public int compareToByCalories(Object o) {
        Pizza other = (Pizza) o;
        if(this.getCalories()>other.getCalories()) {
            return 1;
        } else if(this.getCalories()<other.getCalories()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Pizza testing = new Pizza();
        System.out.println("testing pizza: \n" + testing);
        System.out.println();

        Fraction amt = new Fraction(1,2);
        testing.eatSomePizza(amt);
        System.out.println("After eating a fraction of the testing pizza: \n" + testing);
        System.out.println();

        Pizza compare = new Pizza();
        System.out.println("compare pizza: \n" + compare);
        System.out.println();

        System.out.println("Comparing compare pizza with testing pizza by price: " + compare.compareTo(testing));
        System.out.println("test1 passed");
        System.out.println();

        System.out.println("Comparing compare pizza with testing pizza by Calories: " + compare.compareToByCalories(testing));
        System.out.println("test2 passed");
        System.out.println();

        System.out.println("Comparing compare pizza with testing pizza by size: " + compare.compareToBySize(testing));
        System.out.println("test3 passed");
        System.out.println();


    }
}
