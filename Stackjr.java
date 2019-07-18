/*
 * Stack Class
 * 
 * Creates a stack using a Node Class
 * 
 * Windows Eclipse IDE
 * 
 * @version 1.0
 * 
 * @author Jarred Hawkins, Kane Egan
 * 
 * Girasol - A fire opal that glows like fire in a certain light
 * 
 * "We all make choices, but in the end our choices make us."
 * 		- Andrew Ryan(1902 - 1960)
 */
public class Stackjr<T> {

	public Node<T> topOfStack;

	public Stackjr() {
		clear();
	}

	// ****************************************

	/**
	 * 
	 * @param anEntry
	 * @return
	 */
	public boolean push(T anEntry) {
		if (anEntry == null) {
			return false;
		} // End If
		topOfStack = new Node<T>(anEntry, topOfStack);
		return true;
	}

	// ****************************************

	/**
	 * 
	 * @return
	 */
	public T peek() {
		return topOfStack.getData();
	}

	// ****************************************

	/**
	 * 
	 * @return
	 */
	public T pop() {
		if (topOfStack == null) {
			return null;
		} // End If
		T returnData = topOfStack.getData();
		topOfStack = topOfStack.getNextNode();
		return returnData;
	}

	// ****************************************

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (topOfStack == null) {
			return true;
		} else {
			return false;
		}
	}

	// ****************************************

	/**
	 * 
	 */
	public void clear() {
		topOfStack = null;
	}
}
