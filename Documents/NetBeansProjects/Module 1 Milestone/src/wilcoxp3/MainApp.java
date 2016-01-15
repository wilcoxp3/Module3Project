/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.util.Scanner;

/**
 *
 * @author wilcoxp3
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean keepGoing = true;
        while (keepGoing) {

            printMenu();
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    runHelloWorld();
                    break;
                case 2:
                    runIntDivider();
                    break;
                case 3:
                    runWordSorter();
                    break;
                case 4:
                    keepGoing = false;
                    break;
            }
        }

    }

    private static void printMenu() {

        System.out.print("1 - Hello, World!\n2 - Integer Divider\n"
                + "3 - Word Sorter\n4 - Exit\n");
    }

    private static void runHelloWorld() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");

    }

    private static void runIntDivider() {

        Scanner sc = new Scanner(System.in);
        int int1;
        int int2;
        int quotient;
        int remainder;

        System.out.println("Let's divide some integers.");

        System.out.print("Enter first integer: ");
        int1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        int2 = sc.nextInt();

        quotient = int1 / int2;
        remainder = int1 % int2;

        System.out.println(int1 + " / " + int2 + " = " + quotient
                + " remainder " + remainder + "\n");
    }

    private static void runWordSorter() {

        System.out.println("Let's sort some words.");

        Scanner sc = new Scanner(System.in);
        int numOfWords = 0;
        String[] words = new String[1];
        boolean keepGoing = true;

        while (keepGoing) {

            System.out.print("Enter a word: ");
            String word = sc.nextLine();
            words[numOfWords] = word;
            numOfWords++;
            if (words.length == numOfWords) {
                String[] tempArray = new String[numOfWords * 2];
                for (int i = 0; i < words.length; i++) {
                    words[i] = tempArray[i];
                }
                words = tempArray;
            }
            System.out.print("Add another word (y/n)? ");
            //TODO
        }
    }

}
