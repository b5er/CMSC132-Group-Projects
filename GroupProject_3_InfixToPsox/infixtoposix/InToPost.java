package infixtoposix;

import java.util.StringTokenizer;


//AUTHORS - TUMASANG CHE, RAMASAI TADEPALLI, SHUBHANKAR VIRAGI, NISCHAL REDDY, BRIAN SERVIA

/*This code will push the operators in the stack and pop them based on precedence i.e. until the top of the stack has an element of lower precedence
 * When you encounter a bracket ")" then you keep popping until you reach "("
 * When you reach the end of a String input, then you keep popping the elements until you reach the end of the stack.
 * e.g. if the input is --> 1+2*3/4 then the output should be --> 123*4/+ 
 */

public class InToPost<T> {
	private LinkedStack<Character> opStack;
	private String input;
	private String output = "";

	/*
	 * Defines an empty stack and initializes input
	 */
	public InToPost(String given) {
		input = given;
		opStack = new LinkedStack<Character>();
	}


	public String convertToPost() {
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch (ch) {
			case '+': 
			case '-':
				gotOper(ch, 1); 
				break; 
			case '*': 
			case '/':
				gotOper(ch, 2); 
				break; 
			case '(': 
				opStack.push(ch);
				break;
			case ')': 
				gotParen(ch); 
				break;
			default: 
				output = output + ch; 
				break;
			}
		}
		while (!opStack.isEmpty()) {
			output = output + opStack.pop();
		}
		return output; 
	}
	public void gotOper(char opThis, int prec1) {
		while (!opStack.isEmpty()) {
			char opTop = opStack.pop();
			if (opTop == '(') {
				opStack.push(opTop);
				break;
			}
			else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) { 
					opStack.push(opTop);
					break;
				}
				else
					output = output + opTop;
			}
		}
		opStack.push(opThis);
	}
	public void gotParen(char ch){ 
		while (!opStack.isEmpty()) {
			char chx = opStack.pop();
			if (chx == '(') 
				break; 
			else
				output = output + chx; 
		}
	}
}