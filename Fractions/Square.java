import java.awt.*;
/**This Square class inherits from the shape class and will have all the
 * variables from its parent class, as well as a sidelength of the Square
 * to help measure the area specified for squares, as well as a color variable
 *
 * @author Eunhee Kim
 * @version December 5, 2019
 */
public class Square extends Shape {
    private int side;
    private Color color;

    /**this is the default constructor of Square where it will initialize values of
     * x, y, and side length as 0, as well as the color to be black.
     *
     */
    public Square() {
        super(0,0,Color.black);
        this.side=0;
    }

    /**this is the constructor method that will initialize the values of x, y, and the side length
     * of the square
     * @param x the x-value point of where the shape will be located
     * @param y the y-value point of where the shape will be located
     * @param s the side length of the square
     */
    public Square(int x, int y, int s) {
        super(x,y);
        if(s>0) {
            this.side = s;
        }
    }

    /**this is the constructor that will set the points of the square
     * and its sidelengths as well as the color
     * @param x the x-value point of where the shape will be located
     * @param y the y-value point of where the shape will be located
     * @param s the side length of the square
     * @param c the color of the circle
     */
    public Square(int x, int y, int s, Color c) {
        super(x,y,c);
        if(s>0) {
            this.side = s;
        }
    }

    /**this method will calculate the area of the square
     * @return double value of the area of the square
     */
    //Override the getArea() method
    public double getArea() {
        //This method should return a double corresponding to the area of your shape
        return this.side*this.side;
    }

    /**this method overrides the toString() method to print out the statement
     * of the shape, which will be Square
     * @return String output of shape name
     */
    public String toString() {
        return "Square";
    }

    /**this is the getter for the sidelength value of the Square object
     * @return double value of sidelength
     */
    //Next, define members that are custom to your shape
    public int getSide() {
        return this.side;
    }

    /**this is the setter for the sidelength value
     * @param s double value of new sidelength that will be set
     */
    public void setSide(int s) {
        this.side = s;
    }

    /**this will contain a driver method of where the methods in this class
     *will be tested
     */
    public static void main(String[] args) {
        Square testing = new Square();

        System.out.println(testing);
        testing.setSide(4);
        System.out.println("Radius of circle: " + testing.getSide());
        System.out.println("Area of circle with radius 4: " + testing.getArea());
    }

}