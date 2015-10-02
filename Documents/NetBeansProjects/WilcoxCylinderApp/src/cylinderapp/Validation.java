package cylinderapp;

import java.util.Scanner;

/**
 * The Validation class contains various method for getting and validating user
 * input from the console.
 */
public class Validation {

    /**
     * getInt prompts user to enter an integer returns a valid integer
     *
     * @param prompt
     * @return
     */
    public static int getInt(String prompt) {
        // create new Scanner object and declare and initialize user choice to 0
        Scanner sc = new Scanner(System.in);
        int i = 0;

        // loop until user enters a valid int
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                break;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    /**
     * overloaded getInt to accept minimum and maximum values
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */
    public static int getInt(String prompt, int min, int max) {
        while (true) {
            int i = getInt(prompt);
            if (i < min || i > max) {
                System.out.println("Error! Integer must be from " + min + " to " + max);
            } else {
                return i;
            }
        }
    }

    /**
     * getDouble prompts user to enter a valid double
     *
     * @param prompt
     * @return
     */
    public static double getDouble(String prompt) {
        // create new Scanner object and declare and initialize user choice to 0
        Scanner sc = new Scanner(System.in);
        double d = 0.0;

        // loop until user enters a valid int
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                break;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }

    /**
     * getDouble overloaded getDouble which accepts minimum and maximum values
     *
     * @param prompt
     * @param min
     * @param max
     * @return
     */
    public static double getDouble(String prompt, double min, double max) {
        while (true) {
            double d = getDouble(prompt);
            if (d < min || d > max) {
                System.out.println("Error! Decimal value must be from " + min + " to " + max);
            } else {
                return d;
            }
        }
    }

    /**
     * getContinue prompts the user to continue by entering 'y' or 'n' returns
     * boolean true or false corresponding to yes or no respectively
     *
     * @param prompt
     * @return
     */
    public static boolean getContinue(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        boolean answer;
        String choice = sc.next();

        while (true) {
            if (choice.equalsIgnoreCase("y")) {
                answer = true;
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                answer = false;
                break;
            } else {
                System.out.print("Invalid choice. Please choose 'Y' or 'N': ");
                sc.nextLine();
                choice = sc.next();
            }
        }
        return answer;
    }

    /**
     * getChoice prompts the user to enter one of two choices. Returns an error
     * and re-prompts if neither choice is entered. Returns true if first choice
     * selected, and false if second choice is selected. Choices are not case
     * sensitive.
     *
     * @param prompt
     * @param choice1
     * @param choice2
     * @return boolean
     */
    public static boolean getChoice(String prompt, String choice1, String choice2) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        boolean answer;
        String choice = sc.next();

        while (true) {
            if (choice.equalsIgnoreCase(choice1)) {
                answer = true;
                break;
            } else if (choice.equalsIgnoreCase(choice2)) {
                answer = false;
                break;
            } else {
                System.out.print("Invalid choice. Please choose '" + choice1 + "' or '" + choice2 + "': ");
                sc.nextLine();
                choice = sc.next();
            }
        }
        return answer;
    }

    /**
     * getString displays a prompt to the user, gets the entire line, and
     * returns that line as a string.
     *
     * @param prompt
     * @return String
     */
    public static String getString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String userString = sc.nextLine();
        return userString;
    }
}
