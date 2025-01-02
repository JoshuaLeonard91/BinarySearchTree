/**
 * <b>COP 3530: Project 4 – Binary Search Tree</b>
 * <p>
 * This class file extends the Exception class, and helps correctly throw errors
 * in the project 4 file.
 * 
 * @author Joshua Leonard
 * @version 11/12/2022
 */
@SuppressWarnings("serial")
public class positiveOnly extends Exception {
	public positiveOnly(String e) {
		super(e);
	}

	public positiveOnly() {

	}
}