package lk.ac.jfn.eng.ec4070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program will determine whether given parentheses in a text stream are
 * properly balanced or not using stack.
 * 
 * @author Nadeesha Maduranga (nadeesham332@gmail.com)
 *
 */

public class Parentheses {
	private char items[];
	private int top;

	/**
	 * Implements the stack
	 * 
	 * @param n : number of characters in text stream
	 */
	Parentheses(int n) {
		items = new char[n];
		top = -1;
	}

	/**
	 * Add items to the stack
	 * 
	 * @param c : Item to add
	 */
	void push(char c) {
		if (top == items.length - 1) {
			System.out.println("Stack full.");
			return;
		}
		top++;
		items[top] = c;
	}

	/**
	 * Remove an item (Finally added item) from the stack
	 * 
	 * @return Romoved item
	 */
	char pop() {
		if (isEmpty()) {
			System.out.println("Stack empty");
			return (char) 0;
		}
		char p;
		p = items[top];
		top--;
		return p;
	}

	/**
	 * Check whether stack is empty or not
	 * 
	 * @return Stack is empty (True) or not (False)
	 */
	boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	/**
	 * Checks whether parantheses are balanced or not
	 * 
	 * @param str : Input text stream
	 * @return Paranthesis balanced (True) or not (False)
	 */
	public static Boolean checkValid(String str) {
		char sym, prev; // sym:symbol, prev: previous
		Parentheses s = new Parentheses(str.length());
		for (int i = 0; i < str.length(); i++) {
			sym = str.charAt(i);
			if (sym == '(' || sym == '{' || sym == '[') {
				s.push(sym);
			}
			if (sym == ')' || sym == '}' || sym == ']') {
				if (s.isEmpty()) {
					return false;
				} else {
					prev = s.pop();
					if (!isPairMatch(prev, sym))
						return false;
				}
			}

		}
		if (!s.isEmpty())
			return false;
		return true;
	}

	/**
	 * Check paranthesis are match or not
	 * 
	 * @param character1: Removed (POP) paranthesis in the stack
	 * @param character2: Closing parantheses which have to check
	 * @return paranthesis are match (true) or not (false)
	 */
	public static boolean isPairMatch(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	/**
	 * Driver code
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		System.out.println("This program will determine whether given parentheses in a text stream"
				+ " are properly balanced (True) or not (False) using stack.");
		System.out.print("\nEnter a text stream : ");

		// Getting inputs from user
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		if (checkValid(input)) {
			System.out.println("\tTrue");
		} else {
			System.out.println("\tFalse");
		}

	}

}
