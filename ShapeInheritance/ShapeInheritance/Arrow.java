import java.awt.*;
/**
 * This Arrow class is inherited from the Shape class but also contains the data members of a height and width of an
 * arrow. The methods of the class includes accessors/mutators, a constructor that also inherits an x and y from
 * the parent class(Shape), an area of the arrow being created, and also the calculations that draw
 * the graphic arrow
 *
 * @author Eunhee Kim
 * @version October 31, 2019
 */
public class Arrow extends Shape{
    //data members of height and width in an integer value for the size
    //of an arrow
    private int height;
    private int width;

    /**This is the constructor for our child class where we also plug in the x and y coordinates that
     * were inherited from the parent class, Shape
     * @param h integer height of how tall the arrow will be
     * @param w integer width of how wide the arrow will be
     * @param x integer x coordinate of where the arrow will be located
     * @param y integer y coordinate of where the arrow will be located
     */
    public Arrow(int x, int y, int w, int h) {
        super(x,y);
        this.width = w;
        this.height = h;
    }


    /**This is the accessor of the integer width
     * @return the value of the width of the arrow
     */
    public int getWidth() {
        return this.width;
    }

    /**This is the accessor of the integer height
     * @return the value of the height of the arrow
     */
    public int getHeight() {
        return this.height;
    }

    /**This is the mutator that can change the width of the arrow
     * @param w integer width is what will set the width size of the arrow
     */
    public void setWidth(int w) {
        this.width = w;
    }

    /**This is the mutator that can change the height of the arrow
     * @param h integer height is what will set the height of the arrow
     */
    public void setHeight(int h) {
        this.height = h;
    }

    /**This method measures the area of the arrow through the calculations of first finding the area
     * of a rectangle with the same width*height, and then subtracting the areas around the arrow that fits in
     * rectangle
     * @return a double value of the area of the arrow
     */
    @Override
    public double getArea() {
        double recA = (height/3)*(width/2);
        double sqA = (height/2)*(width/2);
        return (height*width)-((2*recA)+sqA);
    }

    /**This method draws the arrow through drawing lines of the x-coordinates and y-coordinates that
     * have a relationship with each other to make the arrow shape
     * @param g Graphics is the class we have for our g object to output the drawing of the arrow shape
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        //the code below are the lines and connections between each point of the arrow, where the first set of x and y
        //point is the start, and the last 2 set of x and y are the ending point of the lines.
        //there should be 7 lines of code for this because there are 7 lines in an arrow
        g2d.drawLine(super.getX(), super.getY(), super.getX()+(width/2), super.getY());
        g2d.drawLine(super.getX()+(width/2), super.getY(), super.getX()+(width/2), super.getY()+(height/3));
        g2d.drawLine(super.getX()+(width/2), super.getY()+(height/3),super.getX()+width, super.getY()-(height/6));
        g2d.drawLine(super.getX()+width, super.getY()-(height/6), super.getX()+(width/2), super.getY()-((2*height)/3));
        g2d.drawLine(super.getX()+(width/2), super.getY()-((2*height)/3), super.getX()+(width/2), super.getY()-(height/3));
        g2d.drawLine(super.getX()+(width/2), super.getY()-(height/3), super.getX(), super.getY()-(height/3));
        g2d.drawLine(super.getX(), super.getY()-(height/3), super.getX(), super.getY());

    }
}
