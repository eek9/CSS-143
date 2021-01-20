import java.awt.geom.Point2D;
/**
 * The LineSegment class will use the Point2D class to create objects of a
 * point with a starting coordinate point and an ending coordinate point
 *
 * @author Eunhee Kim
 * @version October 14, 2019
 */
public class LineSegment {
    //The start and end points of a line segment should never be null
    //Initialize these to the origin instead

    //A LineSegment has a start point
    //This is a Point2D object
    //All data will be private
    private Point2D sp;
    //A LineSegment also has an end point.
    //Also a Point2D object
    private Point2D ep;

    public LineSegment() {
        sp.setLocation(0,0);
        ep.setLocation(0,0);

    }

    //Create getters and setters for your start and end points
    public Point2D getStartPoint() {
        return sp;
    }

    public void setStartPoint(Point2D start) {
        this.sp = start;
    }

    public Point2D getEndpoint() {
        return ep;
    }

    public void setEndpoint(Point2D end) {
        this.ep = end;
    }

    //Create a toString() function to build a string composed of the startPoint’s
    //toString() and endPoint’s toString()
    //Should look like “Line start(0,0) and end(1,1)”
    public String toString() {
        return "Line start (" + sp.getX() + "," + sp.getY() + ") and end ("
                + ep.getX() + "," + ep.getY() + ")";
    }

    //Create an equals method that determines if two LineSegments are equal
    public boolean equals(LineSegment other) {
        if(other==null || !(other instanceof LineSegment)) {
            return false; //use this as the first line
            //return start and end points are equal, requires an equals in the Point2D class
        } else if (this.sp == other.sp && this.ep == other.ep) {
            return true;
        }
        return false;
    }
}
