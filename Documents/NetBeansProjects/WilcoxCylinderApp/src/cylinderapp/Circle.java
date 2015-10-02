package cylinderapp;

/**
 *
 * The Circle class defines an object which represents a circle shape. It has a
 * single field, radius, from which all other values (diameter, circumference,
 * area) are derived.
 *
 * @author wilcoxp3
 */
public class Circle {

    protected double radius;

    public Circle() {
        this.radius = 1.0d;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getDiameter() {
        return 2 * this.radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
