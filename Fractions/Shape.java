import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by Johnny Lin)
 *
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)

class Shape implements Cloneable  {
    private int x = 0;
    private int y = 0;
    private Color color;

    /**this constructor will initialize the values of x and y
     * @param a the initializing x-value
     * @param b the initializing y-value
     */
    public Shape(int a, int b) {
        x = a;
        y = b;
    }

    /**this constructor will initialize the values of x and y, as well as the color of the shape
     * @param a the initializing x-value
     * @param b the initializing y-value
     * @param c the initializing color
     */
    public Shape(int a, int b, Color c) {
        x = a;
        y = b;
        color = c;
    }

    /**this constructor should return the value of the circle area
     * @return double value of area
     */
    public double getArea() {

        return -1;
    }

    /**this is the getter method for the x-value
     * @return int of x=value
     */
    public int getX() {
        return x;
    }

    /**this is the getter method for the y-value
     * @return int of y=value
     */
    public int getY() {
        return y;
    }

    /**this is the setter method to assign a new value to the
     * x-value
     * @param value int value of new x
     */
    public void setX(int value) {
        x = value;
    }

    /**this is the setter method to assign a new value to the
     * y-value
     * @param value int value of new y
     */
    public void setY(int value) {
        y = value;
    }

    /**this is an overridden method from the cloneable interface, and will make another copy
     * of a Shape object
     * @return Shape object of another copy
     * @throws CloneNotSupportedException
     */
    @Override
    public Shape clone() throws CloneNotSupportedException{
        try {
            Shape newShape = (Shape) super.clone();
            return newShape;
        } catch(CloneNotSupportedException e) {
            throw new CloneNotSupportedException();
        }
    }
}
