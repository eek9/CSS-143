import java.awt.*;
import java.awt.geom.Arc2D;
/**
 * The PieSlice class is inherited from the Shape class and will draw a shape that is in the shape of a pie slice.
 * It includes its own data member of a radius that is not included in the shape class.
 * The methods in this class consists of accessors/mutators, a constructor that also initializes some values from
 * the Shape class, overridden getArea() and draw method
 *
 * @author Eunhee Kim
 * @version October 28, 2019
 */
public class PieSlice extends Shape{
    //data member of the radius of a pie slice in a double value
    private double radius;

    /**This is the constructor for our child class where we also plug in the x and y coordinates that
     * were inherited from the parent class, Shape
     * @param r integer radius of the size of how long the side of the pie slice will be
     * @param x integer x coordinate of where the PieSlice will be located
     * @param y integer y coordinate of where the PieSlice will be located
     */
    public PieSlice(int x, int y, double r) {
        super(x,y);
        this.radius = r;
    }

    /**This is the accessor of the radius
     * @return the size of the radius in a double value
     */
    public double getRadius() {
        return this.radius;
    }

    /**This is the mutator of the radius
     * @param r double radius of setting a different value to the radius
     */
    public void setRadius(double r) {
        this.radius=r;
    }

    /**This method calculates the area of the PieSlice
     * @return a double of the area of the pie slice which is calculated from first finding the area of a full
     * circle and then multiplying by a 45 degree angle that represents the portion of the slice
     */
    public double getArea() {
        return Math.PI*this.radius*this.radius*(45/360);
    }

    /**This method draws the final shape of the PieSlice
     * @param g Graphics is the class we have for our g object to output the drawing of the PieSlice shape
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //the code below helps me draw a simple pie slice by first giving the coordinates, how long the sides of the
        //slices should be(the radius), the starting angle and the measurement angle of how big the slice is, and the
        //Arc2D.PIE will simply close the arc with a point, like a pie slice
        Arc2D.Double drawSlice = new Arc2D.Double(super.getX(), super.getY(), this.radius, this.radius, 45, 45, Arc2D.PIE);
        g2d.draw(drawSlice);
    }
}
