import java.io.*;
import java.util.Stack;

public class Postfix {
	
	public static void main(String[] args) {
		String pfx = "12*3+";
		System.out.println(evaluate(pfx));
		String inx = "1*2+3";
		System.out.println(infixToPostfix(inx));
	}
	
   /*
    * Determines the value presented by the postfix expression.
    * param pfx Represent a postfix expression.
    */
	public static int evaluate(String pfx) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
	
		//save each char in the array
		for(int i = 0; i < pfx.length(); i++) {
			char ch = pfx.charAt(i);
		
		//check if the ch is a digit 
		
			if(Character.isDigit(ch)) {
				//push the item onto the top of stack
				stack.push(ch - '0');
			}
			//if operator is +, -, /, *, then use cases
			else {
				
				//removes 2 objects at the top of stack
				
				int a = stack.pop();
				int b = stack.pop();
				
				switch (ch) {
				case  '+':
					result = a + b;
					break;
				case '-':
					result = b - a;
					break;
				case '/':
				//mistake was: case 3: ch = '/';
					result = b / a;
					break;
				case '*':
					result =  a * b;
					break;
				case '^':
					result = (int) Math.pow(b, a);
					break;
				}
				stack.push(result);
			}
		}
		
		//return the value of the left element
			return stack.pop();
	}
	
	/*
	 * Generate the String expression into postfix.
	 * @param ifx The ifx represents the infix.
	 */
	public static String infixToPostfix (String ifx){
		String result = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < ifx.length(); i++) {
			char ch = ifx.charAt(i);
			// check whether the element is a digit, if yes - output it.
			if(Character.isDigit(ch)) {
				result += ch - '0'; 
			}
			// if it is a "(", then it can be pushed, precedence 
			//of operators in the stack is not important
			else if(ch == '(') {
					stack.push(ch);
				}
			// if it is a ")", then pop() all the elements till "("
			else if(ch == ')') {
				if(!stack.empty() && stack.peek() != '(') {
					result += stack.pop();
					}
				}
				//if it is an operator
			else {
				while(!stack.isEmpty() && getOperatorPriority(ch) <= getOperatorPriority(stack.peek())) {
					result += stack.pop();
					}
				stack.push(ch);
				}
			}
		result += stack.pop();
		return result;
		}
		
	public static int getOperatorPriority(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		}else if ((ch == '*' || ch == '/')){
			return 2;
		}else if (ch == '^'){
			return 3;
		}
		return -1;
		
	}
	
	/*
	 * Reads the expression from the console, convert it 
	 * to postfix and evaluate it.
	 * @param input The input from the console.
	 */
	
	public static String readFromConsole(String input) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String result = "";
		try {
			String infix = reader.readLine();
			String postfix = infixToPostfix(infix);
			result = Integer.toString(evaluate(postfix));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
			
	
		
}

