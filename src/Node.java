/**
 * <b>COP 3530: Project 4 – Binary Search Tree</b>
 * <p>
 * The Node class is used to store data for the binary search tree, as well as
 * the leftChild reference and rightChild reference.
 * 
 * <pre>
 * <b>cName</b> = country name
 * <b>GDPPC</b> = GDP per capita
 * <b>leftChild</b> = left childs reference/pointer
 * <b>rightChild</b> = right childs reference pointer
 * </pre>
 * 
 * <pre>
 * <b>Methods:</b>
 * {@linkplain #Node(String, double) Node}: creates a node with this data
 * {@linkplain #printData() printData}: prints the nodes name and gdp per capita that is formatted
 * </pre>
 * 
 * @author Joshua Leonard
 * @version 11/12/2022
 *
 */
public class Node {
	String cName;
	double GDPPC;
	Node leftChild; // this node’s left child
	Node rightChild; // this node’s right child

	/**
	 * Constructor to create a Node with the data for the country name and countries
	 * gdp per capita.
	 * 
	 * @param cName
	 * @param GDPPC
	 */
	public Node(String cName, double GDPPC) {
		this.GDPPC = GDPPC;
		this.cName = cName;
	}

	/**
	 * This method is used to print out each nodes data that is formatted to work
	 * with the print data method in the project4 class file.
	 */
	public String printData() {
		return String.format("%-33s", cName) + String.format("%13.13s", String.format("%.3f", GDPPC));
	}
}
