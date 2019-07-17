/*
 * Postfix Class
 * 
 * Converts a line from infix to postfix
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

public class Postfix {

	private static final char[] RECOGNIZED_OPERATIONS = { '-', '–', '+', '/', '*', '^' };
	private static final int[] OPERATION_PRIORITIES = { 0, 0, 0, 1, 1, 2 };

	private String line;
	private Stack<Character> stack = new Stack<Character>();
	char[] inputCharacters;

	public Postfix() {
		line = "";
	}

	// ****************************************

	/**
	 * 
	 * @param input
	 * @return
	 */
	public String convertToPostfix(String input) {

		line = "";

		if (input == null || input.trim().equals("")) {
			line = "Error: No input found on this line from the input file.";
			return line;
		}

		inputCharacters = input.replaceAll(" ", "").toCharArray();

		if (isOperator(inputCharacters[0]) == true) {
			line = "Invalid infix syntax. A variable is required before the first operator.";
			return line;
		} // End If
		for (int i = 0; i < inputCharacters.length; i++) {

			if(i < 0) {
			if (isOperator(inputCharacters[i]) && isOperator(inputCharacters[i - 1])) {
				line = "Invalid infix syntax between " + (i - 1) + " and " + i
						+ ". Add a variable between the operators.";
				return line;
			} // End If
			else if (isVariable(inputCharacters[i]) && isVariable(inputCharacters[i - 1])) {
				line = "Invalid infix syntax between " + (i - 1) + " and " + i
						+ ". Add an operator between the variables.";
				return line;
			} // End If
			else if (inputCharacters[i] == ')' && inputCharacters[i - 1] == '(') {
				line = "Invalid infix syntax between " + (i - 1) + " and " + i + ". Remove the empty parenthesis.";
				return line;
			} // End If
			}

			if (isOperator(inputCharacters[i])) {
				if (stack.isEmpty()) {
					stack.push(inputCharacters[i]);
				} // End If
				else {
					while (!stack.isEmpty()
							&& (operationPriority(stack.peek()) >= operationPriority(inputCharacters[i]))) {
						line += stack.pop() + " ";
					} // End While
					stack.push(inputCharacters[i]);
				} // End Else
			} // End If
			else if (inputCharacters[i] == '(') {
				stack.push(inputCharacters[i]);
			} // End If Else
			else if (inputCharacters[i] == ')') {
				while (stack.peek() != '(') {
					line += stack.pop() + " ";
				}
				stack.pop();
			} // End If Else
			else {

				line += inputCharacters[i] + " ";
			} // End Else
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid syntax. Unclosed parenthesis at the end of the infix line.";
			} // End If
			line += stack.pop() + " ";
		} // End while
		return line;
	}

	// ****************************************

	/**
	 * 
	 * @param input
	 * @return
	 */
	private int operationPriority(char input) {
		for (int i = 0; i < RECOGNIZED_OPERATIONS.length; i++) {
			if (RECOGNIZED_OPERATIONS[i] == input) {
				return OPERATION_PRIORITIES[i];
			} // End If
		} // End If
		return -1;
	}

	// ****************************************

	/**
	 * 
	 * @param input
	 * @return
	 */
	private boolean isOperator(char input) {
		for (int i = 0; i < RECOGNIZED_OPERATIONS.length; i++) {
			if (RECOGNIZED_OPERATIONS[i] == input) {
				return true;
			}
		}
		return false;
	}

	// ****************************************

	/**
	 * 
	 * @param input
	 * @return
	 */
	private boolean isVariable(char input) {
		if (!isOperator(input) && input != '(' && input != ')') {
			return true;
		} else {
			return false;
		}
	}
}
