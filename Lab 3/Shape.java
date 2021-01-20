import java.awt.*;
/**
 * The Shape class will contain the data items of x, y, or color, for what
 * all shapes contain.
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class Shape {
    //Declare 4 class invariants for the Shape class as comments and submit them.
    //What might be a good invariant? Think about how we might use this Shape...
    //Perhaps x and y must be nonnegative integers?
    //TODO: declare invariants for this Shape class here and in comments.
    //The area must not be negative
    //The x and y values must not be a String or char
    //The color must not be a number value
    //The coordinates should not be negative

    //Declare an x and a y. (all data here is private)
    private int x;
    private int y;
    //Declare a Color object.
    private Color color;

    //instance methods
    public Shape() {
    }

    //remember imports for class Color
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    //copy c’tor
    public Shape(Shape other) {
        this.x = other.x;
        this.y = other.y;
        this.color = other.color;
    }

    //describe your shape’s x,y, color, etc.
    public String toString() {
        return "Shape (" + x + "," + y + ")" + "and" + "color: " + color + "and area: " + getArea();
    }

    //to be replaced by subclasses, return -1 here
    public double getArea() {
        return -1;
    }

    //to be used by the paint program, empty for now
    public void draw(Graphics g) {
    }
}
