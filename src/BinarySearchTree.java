/**
 * <b>COP 3530: Project 4 – Binary Search Tree </b>
 * <p>
 * This class handles inserting, deleting, and printing the binary search
 * tree.<br>
 * <b>Methods:<br>
 * </b>
 * 
 * <pre>
 * {@linkplain #insert(String, double) insert}               : Inserts country into the binary tree
 * {@linkplain #delete(String) delete}               : deletes a country from the binary tree
 * {@linkplain #find(String) find}                 : finds a country in the binary tree
 * {@linkplain #getSuccessor(Node) getSuccessor}         : finds successor node
 * {@linkplain #printTopCountries(int) printTopCountries}    : Prints top x countries (top countries regarding gdppc)
 * {@linkplain #printBottomCountries(int) printBottomCountries} : Prints bottom x countries (bottom countries regarding gdppc)
 * {@linkplain #printInorder(Node) printInorder}         : Prints countries in binary tree in ascending order A-Z
 * {@linkplain #printPreorder(Node) printPreorder}        : Prints countries in preorder traversal
 * {@linkplain #printPostorder(Node) printPostorder}       : prints countries in postorder traversal
 * </pre>
 * 
 * @author Joshua Leonard
 * @version 11/17/2022
 */
public class BinarySearchTree {
	public Node root;
	public Node current;
	public Node previous;
	public final Node smallest = new Node("DNT", -Double.MAX_VALUE);
	public final Node largest = new Node("DNT", +Double.MAX_VALUE);
	public String[] path;
	public int cnt = 0;

	/**
	 * Constructor for the binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * This method is used to find a specified country, if it is not found it will
	 * return -1 otherwise it will return the GDP per Capita. The method will also
	 * store the nodes it visited in an array to that will be used to print out the
	 * path if the country is found.
	 * 
	 * @param key Country name to be searched
	 * @return GDP per capita
	 */
	public double find(String key) {
		Node current = root;
		while (!(current.cName.equals(key))) {
			path[cnt++] = current.cName;
			if (current.cName.compareTo(key) > 0) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if (current == null) {
				System.out.println(key + " was not found in the binary tree.");
				return -1;
			}
		}
		path[cnt++] = current.cName;

		System.out.println(key + " is found with GDP per capita of " + String.format("%.3f", current.GDPPC));
		System.out.print("Path to " + key + " is ");

		for (int i = 0; i < cnt; i++) {
			System.out.print(path[i]);
			if (cnt - 1 != i) {
				System.out.print("->");
			}
		}

		return current.GDPPC;
	}

	/**
	 * This method inserts countries by name (A-Z) into the binary tree.
	 * 
	 * @param cName Country name
	 * @param GDPPC Country GDP per capita
	 */
	public void insert(String cName, double GDPPC) {
		Node newNode = new Node(cName, GDPPC);

		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (cName.compareTo(current.cName) < 0) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	/**
	 * This method deletes a country from the binary search tree.This method will
	 * call upon 4 different methods depending on the situation encountered.
	 * 
	 * <pre>
	 * {@linkplain #noChildDelete(Node, Node, boolean) noChildDelete}      : If there are no children
	 * {@linkplain #noRightChildDelete(Node, Node, boolean) noRightChildDelete} : if there are no right children
	 * {@linkplain #noLeftChildDelete(Node, Node, boolean) noLeftChildDelete}  : if there are not left children
	 * {@linkplain #twoChildrenDelete(Node, Node, boolean) twoChildrenDelete}  : if there are two children
	 * </pre>
	 * 
	 * @param cName
	 */
	public void delete(String cName) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (!(current.cName.equals(cName))) {
			parent = current;
			if (cName.compareTo(current.cName) < 0) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				System.out.println("Did not find " + cName + ".");
				return;
			}
		}
		if (current.leftChild == null && current.rightChild == null) {
			noChildDelete(current, parent, isLeftChild);
		} else if (current.rightChild == null) {
			noRightChildDelete(current, parent, isLeftChild);
		} else if (current.leftChild == null) {
			noLeftChildDelete(current, parent, isLeftChild);
		} else {
			twoChildrenDelete(current, parent, isLeftChild);
		}
		System.out.println(cName + " was deleted from the binary search tree.");
	}

	/**
	 * This method was split from the delete method to make it more readable(for
	 * me).
	 * 
	 * This method will delete the node if the node has no children.
	 * 
	 * @param current
	 * @param parent
	 * @param isLeftChild true or false
	 */
	public void noChildDelete(Node current, Node parent, boolean isLeftChild) {
		if (current == root) {
			root = null;
		} else if (isLeftChild) {
			parent.leftChild = null;
		} else {
			parent.rightChild = null;
		}
	}

	/**
	 * This method was split from the delete method to make it more readable(for
	 * me).
	 * 
	 * This method will replace the node to be deleted with the left subtree if
	 * there is no right child.
	 * 
	 * @param current
	 * @param parent
	 * @param isLeftChild true or false
	 */
	public void noRightChildDelete(Node current, Node parent, boolean isLeftChild) {
		if (current == root) {
			root = current.leftChild;
		} else if (isLeftChild) {
			parent.leftChild = current.leftChild;
		} else {
			parent.rightChild = current.leftChild;
		}
	}

	/**
	 * This method was split from the delete method to make it more readable(for
	 * me).
	 * 
	 * This method will replace the node to be deleted with the right subtree if
	 * there is no left child.
	 * 
	 * @param current
	 * @param parent
	 * @param isLeftChild true or false
	 */
	public void noLeftChildDelete(Node current, Node parent, boolean isLeftChild) {
		if (current == root) {
			root = current.rightChild;
		} else if (isLeftChild) {
			parent.leftChild = current.rightChild;
		} else {
			parent.rightChild = current.rightChild;
		}
	}

	/**
	 * This method was split from the delete method to make it more readable(for
	 * me).
	 * 
	 * This method will replace the node to be deleted with the inorder successor.
	 * 
	 * @param current
	 * @param parent
	 * @param isLeftChild true or false
	 */
	public void twoChildrenDelete(Node current, Node parent, boolean isLeftChild) {
		Node successor = getSuccessor(current);
		if (current == root) {
			root = successor;
		} else if (isLeftChild) {
			parent.leftChild = successor;
		} else {
			parent.rightChild = successor;
		}
		successor.leftChild = current.leftChild;
	}

	/**
	 * This method will return the next node that is the next highest value in terms
	 * of lexicographically. Go right once, then all the way to the left.
	 * 
	 * @param delNode
	 * @return the successor node
	 */
	public Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	/**
	 * This method will traverse the tree using the Pre-Order traversal method.
	 * 
	 * NLR (Node, Left Child, Right Child)
	 * 
	 * @param root
	 */
	public void printPreorder(Node root) {
		if (root != null) {
			System.out.println(root.printData());// visit/print data
			printPreorder(root.leftChild); // call itself to traverse left child subtree
			printPreorder(root.rightChild); // call itself to traverse right child subtree
		}
	}

	/**
	 * This method will traverse the tree using the In-Order traversal method.
	 * 
	 * LNR (Left Child, Node, Right Child)
	 * 
	 * @param root
	 */
	public void printInorder(Node root) {
		if (root != null) {
			printInorder(root.leftChild); // call itself to traverse left child subtree
			System.out.println(root.printData()); // visit/print data
			printInorder(root.rightChild); // call itself to traverse right child subtree
		}
	}

	/**
	 * This method will traverse the tree using the Post-Order traversal method.
	 * 
	 * LRN (Left Child, Right Child, Node)
	 * 
	 * @param root
	 */
	public void printPostorder(Node root) {
		if (root != null) {
			printPostorder(root.leftChild); // call itself to traverse left child subtree
			printPostorder(root.rightChild); // call itself to traverse right child subtree
			System.out.println(root.printData()); // visit/print data
		}
	}

	/**
	 * This a overloaded method and takes in a user input that is how many countries
	 * they want to print out. It then loops from 0->c and will print out the data,
	 * in this case lowest to highest GDPPC.
	 * 
	 * @param c
	 */
	public void printBottomCountries(int c) {
		for (cnt = 0; cnt < c; cnt++) {
			current = largest;
			printBottomCountries(root);
			System.out.println(current.printData());
			previous = current;
		}
	}

	/**
	 * This method uses the pre-order method to find the NEXT highest GDPPC from the
	 * previous node that was looked at.
	 * 
	 * <pre>
	 * Example: previous was 2, next highest from this would be 3, 
	 * if 3 is previous the next highest would be 4.
	 * </pre>
	 * 
	 * @param root
	 */
	public void printBottomCountries(Node root) {
		if (root != null) {
			if (current.GDPPC > root.GDPPC && cnt == 0) {
				current = root;
			} else if (current.GDPPC > root.GDPPC && previous.GDPPC < root.GDPPC) {
				current = root;
			}
			printBottomCountries(root.leftChild); // call itself to traverse left child subtree
			printBottomCountries(root.rightChild); // call itself to traverse right child subtree
		}
	}

	/**
	 * This a overloaded method and takes in a user input that is how many countries
	 * they want to print out. It then loops from 0->c and will print out the data,
	 * in this case highest to lowest GDPPC.
	 * 
	 * @param c
	 */
	public void printTopCountries(int c) {
		for (cnt = 0; cnt < c; cnt++) {
			current = smallest;
			printTopCountries(root);
			System.out.println(current.printData());
			previous = current;
		}
	}

	/**
	 * This method uses the pre-order method to find the next lowest GDPPC from the
	 * previous node that was looked at.
	 * 
	 * <pre>
	* Example: previous was 4, next lowest from this would be 3, 
	* if 3 is previous the next lowest would be 2.
	 * </pre>
	 * 
	 * @param root
	 */
	public void printTopCountries(Node root) {
		if (root != null) {
			if (current.GDPPC < root.GDPPC && cnt == 0) {
				current = root;
			} else if (current.GDPPC < root.GDPPC && previous.GDPPC > root.GDPPC) {
				current = root;
			}
			printTopCountries(root.leftChild); // call itself to traverse left child subtree
			printTopCountries(root.rightChild); // call itself to traverse right child subtree
		}
	}
}