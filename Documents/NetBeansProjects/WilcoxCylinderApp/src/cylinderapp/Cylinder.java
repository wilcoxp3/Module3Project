package cylinderapp;

/**
 *
 * The Cylinder class defines an object which represents a cylinder shape. In
 * addition to the inherited field radius, it also contains the field height.
 * All other properties of the cylinder (area, circumference, volume, surface )
 * area) are derived from these two fields.
 *
 * @author wilcoxp3
 */
public class Cylinder extends Circle {

    protected double height;

    public Cylinder() {
        super();
        this.height = 1.0d;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return this.getArea() * this.height;
    }

    public double getSurfaceArea() {
        return this.getCircumference() * this.height + 2 * this.getArea();
    }
}
