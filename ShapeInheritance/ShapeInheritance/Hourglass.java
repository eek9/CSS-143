import java.awt.*;
/**
 * The Hourglass class is inherited from the Shape class.
 * It also includes its own data members of a height and length, as well as methods of its accessors/mutators,
 * area of the Hourglass, and the draw method.
 *
 * @author Eunhee Kim
 * @version October 31, 2019
 */
public class Hourglass extends Shape{
    //data members of width and height of the hourglass in an integer value
    private int width;
    private int height;

    /**This is the constructor for our child class where we also plug in the x and y coordinates that
     * were inherited from the parent class, Shape
     * @param h integer height of how tall the hourglass will be
     * @param w integer width of how wide the hourglass will be
     * @param x integer x coordinate of where the hourglass will be located
     * @param y integer y coordinate of where the hourglass will be located
     */
    public Hourglass(int x, int y, int w, int h) {
        super(x,y);
        this.width = w;
        this.height = h;
    }

    /**This is the accessor of the integer width
     * @return the value of the width of the hourglass
     */
    public int getWidth() {
        return this.width;
    }

    /**This is the accessor of the integer height
     * @return the value of the height of the hourglass
     */
    public int getHeight() {
        return this.height;
    }

    /**This is the mutator that can change the width of the hourglass
     * @param w integer width is what will set the width size of the hourglass
     */
    public void setWidth(int w) {
        this.width = w;
    }

    /**This is the mutator that can change the height of the hourglass
     * @param h integer height is what will set the height of the hourglass
     */
    public void setHeight(int h) {
        this.height = h;
    }

    /**This method finds the area of the hourglass by first finding the area of a rectangle based on the
     * width and height, as well as the area of the triangles that will be subtracted from not being part of the
     * hourglass
     * @return a double value of the area after subtracting the area of the unneeded triangles of the side of
     * the hourglass from the area of a full rectangle
     */
    @Override
    public double getArea() {
        double recA = (double) this.width*this.height;
        double triA = (double) (this.height*(this.width/2))*2;
        return recA - triA;
    }

    /**This method draws the final shape of the PieSlice
     * @param g Graphics is the class we have for our g object to output the drawing of the hourglass shape
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //the drawing of the lines will connect together to give a final image of an hourglass
        g2d.drawLine(super.getX(), super.getY(), super.getX()+width, super.getY());
        g2d.drawLine(super.getX()+width, super.getY(), super.getX(), super.getY()-height);
        g2d.drawLine(super.getX(), super.getY()-height, super.getX()+width, super.getY()-height);
        g2d.drawLine(super.getX()+width, super.getY()-height, super.getX(), super.getY());
    }
}
