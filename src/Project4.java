
/*
 * Author: Joshua Leonard
 * Course: COP3530
 * Project #: 4
 * Title: Binary Search Tree
 * Due Date: 11/18/2022
 *
 * This program demonstrates the use of:
 * 1: Binary Search Tree
 * 		a)Inserting a Country Node into the tree
 * 		b)Deleting a Country Node in the tree
 * 		c)Finding a Country Node in the tree
 * 		d)Printing In-Order
 * 		e)Printing Pre-Order
 * 		f)Printing Post Order
 * 		g)Printing x Countries in descending or ascending order
 * 
 */
import java.io.IOException;
import java.util.Scanner;

/**
 * <b>COP 3530: Project 4 – Binary Search Tree</b>
 * <p>
 * This is the main class file that handles the display menu, reading in the
 * user input for the file creating the Binary search tree, and printing
 * formatted strings with country data.
 * 
 * @author Joshua Leonard
 * @version 11/17/2022
 */
public class Project4 {
	public static Country[] country;
	public static BinarySearchTree nTree = new BinarySearchTree();
	public static int nbrCountries;
	private static FileHandler fileHandler = new FileHandler();
	private static Scanner scnr = new Scanner(System.in);
	private static String fileName;

	/**
	 * <b>!Entry Point!</b>
	 * <p>
	 * This is the main function.
	 * <p>
	 * It prints out the the Project #, Who the instructor is, who the student is,
	 * students N#:, and the name of the project.
	 * <p>
	 * The program will loop until a correct file name is given, it will create a
	 * new Binary Search tree of country objects.
	 * <p>
	 * If the file was successfully read it will insert the country objects into the
	 * binary search tree and print out how many countries were added into the tree
	 * and display the menu for the project as indicated in the directions.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		System.out.println(
				"COP3530 Project 4\nInstructor: Professor Liu\nStudent: Joshua Leonard\nN#: N01476308\nBinary Search Tree\n");
		boolean flag = false;
		while (!flag) {
			try {
				System.out.print("Enter the file name: ");
				fileName = file.nextLine();
				System.out.println();
				fileHandler.readCountry(fileName);
				nbrCountries = fileHandler.setSize(fileName);
				nTree.path = new String[nbrCountries];
				System.out.println("There were " + nbrCountries + " countries inserted into the binary search tree.");
				System.out.println("\n");
				displayMenu();
				flag = true;
			} catch (IOException e) {
				System.out.println("File not found: " + e.getMessage());
			}
		} // end while loop
		file.close();
	}// end main

	/**
	 * This method is the display menu, it will loop until the user selects 9 to
	 * quit the program. Each input will call on another method or methods to get
	 * the correct data.
	 * 
	 */
	public static void displayMenu() {
		boolean flag = true;
		boolean inputFlag = false;

		do {
			String input = selection(inputFlag);
			inputFlag = false;
			switch (input) {

			case "1":
				printData("inOrder");
				break;
			case "2":
				printData("preOrder");
				break;
			case "3":
				printData("postOrder");
				break;
			case "4":
				nCountry();
				nTree.cnt = 0;
				break;
			case "5":
				System.out.print("Enter a country you would like to delete: ");
				String delete = scnr.nextLine();
				nTree.delete(delete);
				System.out.println("\n");
				nTree.cnt = 0;
				nbrCountries--;
				break;
			case "6":
				System.out.print("Enter a country you would like to search: ");
				String find = scnr.nextLine();
				System.out.println();
				nTree.find(find);
				nTree.cnt = 0;
				System.out.println("\n");
				break;
			case "7":
				printGDPPC("bottom");
				System.out.println("\n");
				nTree.cnt = 0;
				break;
			case "8":
				printGDPPC("top");
				System.out.println("\n");
				nTree.cnt = 0;
				break;
			case "9":
				System.out.println("Programing Exiting");
				flag = false;
			}
		} while (flag);// end do-while
		scnr.close();
	}// end displayMenu

	/**
	 * This method is for the user selection, if the input does not match the
	 * required input it will let the user know it was an invalid input and ask
	 * again. If conditions are passed it will return the the users input back to
	 * the display menu.
	 * 
	 * <pre>
	 * 1: Print in-order data for the binary tree
	 * 2: Print pre-order data for the binary tree
	 * 3: Print post-order data for the binary tree
	 * 4: Insert new country
	 * 5: Delete a country with a given name
	 * 6: Search for a country and print its path from root to country and print the GDPPC
	 * 7: Print bottom x countries based on GDPPC
	 * 8: Print top x countries based on GDPPC
	 * 9: Quit Program
	 * </pre>
	 * 
	 * @param inputFlag
	 * @return input
	 */
	public static String selection(boolean inputFlag) {
		System.out.println("Please make a selection: ");
		System.out.println("1) In-Order.");
		System.out.println("2) Pre-Order.");
		System.out.println("3) Post-Order.");
		System.out.println("4) Insert a country with name and GDP per capita.");
		System.out.println("5) Delete a country for a given name.");
		System.out.println("6) Search and print a country and its path for a given name.");
		System.out.println("7) Print bottom countries regarding GDPPC ");
		System.out.println("8) Print top countries regarding GDPPC");
		System.out.println("9) Quit Program");

		String input = "";
		while (!inputFlag) {
			input = scnr.nextLine();
			if (input.matches("1|2|3|4|5|6|7|8|9")) {
				inputFlag = true;
			} else {
				System.out.println("Invalid Choice! Please enter 1-9:");
			} // end if/else
		} // end while
		return input;
	}

	/**
	 * This methods prints out the header followed by dash line to indicate
	 * separation.
	 * <p>
	 * The second half of this method will print out each country in the binary tree
	 * depending on the type that is passed through and print out either top x
	 * countries or bottom x countries. Will print out all countries if user input
	 * is more than amount of countries.
	 * <p>
	 * <b>NAME CAPTIAL GDPPC CASERATE DEATHRATE POPDENS</b>
	 * <p>
	 * 
	 * @param type String either "top" or "bottom"
	 */
	public static void printGDPPC(String type) {
		System.out.print("Enter the number of countries: ");
		try {
			int nbr = scnr.nextInt();
			System.out.println("\n");
			if (nbr < 0) {
				throw new positiveOnly();
			}
			if (nbr > nbrCountries) {
				if (type.equals("top")) {
					System.out
							.println("User input " + nbr + " is greater than amount of countries in the binary tree.");
					System.out.println("Printing all countries in the binary tree regarding the top GDPPC.\n");
				} else {
					System.out
							.println("User input " + nbr + " is greater than amount of countries in the binary tree.");
					System.out.println("Printing all countries in the binary tree regarding the bottom GDPPC.\n");
				}
				nbr = nbrCountries;
			} else {
				if (type.equals("top")) {
					System.out.println("Top " + nbr + " countries regarding GDPPC:\n");
				} else {
					System.out.println("Bottom " + nbr + " countries regarding GDPPC:\n");
				}
			}

			String name = "Name";
			String gdppc = "GDP Per Capita";
			System.out.printf("%-32s %s\n", name, gdppc);
			System.out.println("------------------------------------------------");

			if (type.equals("top")) {
				nTree.printTopCountries(nbr);
			} else {
				nTree.printBottomCountries(nbr);
			}
		} catch (positiveOnly e) {
			System.out.println("Positive numbers only!");
		} catch (Exception e) {
			System.out.println("Invalid Input!");
		}
		scnr = new Scanner(System.in);
	}

	/**
	 * This methods prints out the header followed by dash line to indicate
	 * separation.
	 * <p>
	 * The second half of this method will call on the different sets of traversal
	 * depending on what type of string is given. The traversal is in the
	 * BinarySearchTree class file and is a recursive method that prints out the
	 * nodes in the specified order.
	 * <p>
	 * <b>NAME CAPTIAL GDPPC CASERATE DEATHRATE POPDENS</b>
	 * <p>
	 * 
	 * @param type String either "inOrder" or "prePrder" or "postOrder"
	 */
	public static void printData(String type) {
		System.out.println("\n");
		String name = "Name";
		String gdppc = "GDP Per Capita";
		System.out.printf("%-32s %s\n", name, gdppc);
		System.out.println("------------------------------------------------");
		if (type.equals("preOrder")) {
			nTree.printPreorder(nTree.root);
		} else if (type.equals("inOrder")) {
			nTree.printInorder(nTree.root);
		} else {
			nTree.printPostorder(nTree.root);
		}
		System.out.println("\n");
	}// end printData

	/**
	 * This method is used to create a new country object and insert it into the
	 * binary search tree.
	 * <p>
	 * If the user inputs a invalid choice, the variable ic(invalid choice) will be
	 * set to true and will inform the user that the choice is invalid and tell the
	 * user to try again.
	 * <p>
	 * If the data the user inputs is valid it will insert the country object into
	 * the binary search tree
	 * <p>
	 * Lastly the nbrCountries gets incremented to keep track of the amount of
	 * countries that are within a tree.
	 * 
	 */
	public static void nCountry() {
		boolean ic = false;
		String name = "";
		double gdppc = 0;

		System.out.print("Enter Country Name: ");
		name = scnr.nextLine();

		try {
			System.out.print("Enter GDP per capita: ");
			gdppc = scnr.nextDouble();
			if (gdppc < 0) {
				throw new positiveOnly();
			}
		} catch (positiveOnly e) {
			System.out.println("Country gdppc must be positive!");
		} catch (Exception e) {
			System.out.println("\nInvalid attempt, please enter valid correct data for each choice.");
			ic = true;
		}
		if (ic == true) {
			System.out.println("Please try again.\n");
		} else {
			nTree.insert(name, gdppc);
		}
		nbrCountries++;
		scnr = new Scanner(System.in);
		System.out.println();
	}// end nCountry
}
