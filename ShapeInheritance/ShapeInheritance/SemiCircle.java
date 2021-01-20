import java.awt.*;
import java.awt.geom.Arc2D;
/**
 * The SemiCircle class is inherited from the Shape class.
 * It contains a data member of a radius, and methods of the accessor/mutator, calculation of the area, and
 * a drawing method of the SemiCircle.
 * @author Eunhee Kim
 * @version October 28, 2019
 */
public class SemiCircle extends Shape {
    //data member of the radius of a semicircle in a double value
    private double radius;
    /**This is the constructor for our child class where we also plug in the x and y coordinates that
     * were inherited from the parent class, Shape
     * @param r integer radius of the SemiCircle
     * @param x integer x coordinate of where the SemiCircle will be located
     * @param y integer y coordinate of where the SemiCircle will be located
     */
    public SemiCircle(int x, int y, double r) {
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

    /**This method calculates the area of the SemiCircle
     * @return a double value of subtracting half of what the full circle area would be according to the given radius
     */
    public double getArea() {

        return (Math.PI*this.radius*this.radius)/2;
    }

    /**This method will draw the SemiCircle
     * @param g Graphics is the class we have for our g object to output the drawing of the SemiCircle shape
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //the code below allows me to create a semicircle by passing the parameters of the x and y from the super class,
        //and also providing how long/wide, to what degree, and the Arc2D.CHORD, closes the arc
        Arc2D drawArc2D = new Arc2D.Double((double)super.getX(), (double)super.getY(), radius, radius, 0, 180, Arc2D.CHORD);
        g2d.draw(drawArc2D);
    }
}
