package cylinderapp;

/**
 * <p>
 * Assignment 4: Cylinder App</p>
 * <ul>
 * <li>Professor: Tedd Sperling</li>
 * <li>Course: Introduction to Mobile App Development - 42189</li>
 * <li>Student: Paul Wilcox</li></ul>
 * <p>
 * This program computes and displays the details of either a circle or a
 * cylinder. It gets a choice of shape from the user, and then prompts the user
 * to enter the radius for a circle, or both the radius and height for a
 * cylinder.</p>
 *
 * @author wilcoxp3
 */
public class CylinderApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Cirlce/Cylinder Application!");

        while (true) {

            int userChoice = Validation.getInt("Enter 1 to compute a circle, "
                    + "2 to compute a cylinder, and 3 to quit: ");

            if (userChoice == 3) {

                break;

            } else if (userChoice == 1) {

                Circle myCircle = new Circle();

                double radius = Validation.getDouble("\nEnter circle radius: ");
                myCircle.setRadius(radius);

                System.out.println("\nCircle radius: " + myCircle.getRadius());
                System.out.println("Circle diameter: " + myCircle.getDiameter());
                System.out.println("Circle circumference: " + myCircle.getCircumference());
                System.out.println("Circle area: " + myCircle.getArea());

            } else if (userChoice == 2) {

                Cylinder myCylinder = new Cylinder();

                double radius = Validation.getDouble("\nEnter cylinder radius: ");
                myCylinder.setRadius(radius);

                double height = Validation.getDouble("Enter cylinder height: ");
                myCylinder.setHeight(height);

                System.out.println("\nCylinder radius: " + myCylinder.getRadius());
                System.out.println("Cylinder height: " + myCylinder.getHeight());
                System.out.println("Cylinder diameter: " + myCylinder.getDiameter());
                System.out.println("Cylinder circumference: " + myCylinder.getCircumference());
                System.out.println("Cylinder area: " + myCylinder.getSurfaceArea());
                System.out.println("Cylinder volume: " + myCylinder.getVolume());

            } else {
                System.out.println("Invalid choice.");
            }
            System.out.println("\nWould you like to compute a shape again?");
        }
        System.out.println("DONE");
    }

}
