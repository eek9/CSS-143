import java.awt.*;
/**This Circle class inherits from the shape class and will have all the
 * variables from its parent class, as well as a radius of the Circle
 * to help measure the area specified for circles, as well as a color variable
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Circle extends Shape {
    private double radius;
    private Color color;

    /**this is the default constructor of Circle where it will initialize values of
     * x, y, and radius as 0, as well as the color to be black.
     *
     */
    public Circle() {
        super(0,0,Color.black);
        this.radius=0;
    }

    /**this is the constructor that will set the set the points of the circle
     * and its radius
     * @param x the x-value point of where the shape will be located
     * @param y the y-value point of where the shape will be located
     * @param r the size of radius of the circle
     */
    public Circle(int x, int y, int r) {
        super(x, y);
        if (r > 0) {
            this.radius = r;
        }
    }

    /**this is the constructor that will set the points of the circle
     * and its radius as well as the color
     * @param x the x-value point of where the shape will be located
     * @param y the y-value point of where the shape will be located
     * @param r the size of radius of the circle
     * @param c the color of the circle
     */
    public Circle(int x, int y, int r, Color c) {
        super(x, y, c);
        if (r > 0) {
            this.radius = r;
        }
    }

    /**this method will calculate the area of the circle
     * @return double value of the area of the circle
     */
    //Override the getArea() method
    public double getArea() {
        //This method should return a double corresponding to the area of your shape.
        return Math.PI * radius * radius;
    }

    /**this method overrides the toString() method to print out the statement
     * of the shape, which will be Circle
     * @return String output of shape name
     */
    public String toString() {
        return "Circle";
    }

    /**this is the getter for the radius value of the Circle object
     * @return double value of radius
     */
    //Next, define members that are custom to Circles
    public double getRadius() {
        return this.radius;
    }

    /**this is the setter for the radius value
     * @param r double value of new radius that will be set
     */
    public void setRadius(double r) {
        this.radius = r;
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Circle testing = new Circle();

        System.out.println(testing);
        testing.setRadius(4);
        System.out.println("Radius of circle: " + testing.getRadius());
        System.out.println("Area of circle with radius 4: " + testing.getArea());
    }
}
