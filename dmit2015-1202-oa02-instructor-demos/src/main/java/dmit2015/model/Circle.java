package dmit2015.model;

/**
 * This class models a Circle shape.
 *
 * @author Sam Wu
 * @version 2021.01.14
 */
public class Circle {

    /** The radius of the circle */
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            // throw a new unchecked exception
            throw new RuntimeException("The radius must be greater than zero.");
        }
    }

    /** Construct a Circle with a radius of 1 */
    public Circle() {
        radius = 1;
    }

    /** Construct a Circle with the specified radius */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle.
     *
     * @return the area of the circle
     */
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates the circumference of the circle
     *
     * @return the circumference of the circle
     */
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Calculates the diameter of the circle
     *
     * @return the diameter of the circle
     */
    public double diameter() {
        return 2 * radius;
    }

}
