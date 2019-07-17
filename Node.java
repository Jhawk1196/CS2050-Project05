/*

Node Class

Node class to be used by linked lists, holding generic data.

Project 4

Windows Eclipse IDE

@version 1.0

@author Jarred Hawkins

Nummiform - Shaped like a coin

"We all make choices, but in the end our choices make us."
		- Andrew Ryan(1902 - 1960)

*/
public class Node<T> {
	
	private T data;
	private Node <T> next;
	
	//****************************************
	
	public Node() {
		this(null, null);
	}
	
	//****************************************
	
	public Node(T entry){
		this(entry, null);
	}

	//****************************************
	
	public Node(T dataPortion, Node <T> nextNode) {
		data = dataPortion;
		next = nextNode;
	}
	
	//****************************************
	
	/**
	 * 
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	//****************************************
	
	/**
	 * 
	 * @param newData
	 */
	public void setData(T newData) {
		data = newData;
	}
	
	//****************************************
	
	/**
	 * 
	 * @return
	 */
	public Node <T> getNextNode() {
		return next;
	}
	
	//****************************************
	
	/**
	 * 
	 * @param nextNode
	 */
	public void setNextNode(Node <T> nextNode) {
		next = nextNode;
	}
	
}
