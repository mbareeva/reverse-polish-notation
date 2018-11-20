import java.util.Stack;

public class Postfix {
	
	public static void main(String[] args) {
		String pfx = "12*3+";
		System.out.println(evaluate(pfx));
	}
   /*
    * Determines the value presented by the postfix expression.
    * param pfx Respresent a postfix expression.
    */
	public static int evaluate(String pfx) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		//create the array to keep the chars of String in it
		//char[] array = new char[pfx.length()];
		
		//save each char in the array
		for(int i = 0; i < pfx.length(); i++) {
			char ch = pfx.charAt(i);
		
		//check whether the array element is digit or operator
		
		//if(isDigit(array[i]))
			if(Character.isDigit(ch)) {
				//push the item onto the top of stack
				stack.push(ch - '0'); // before just array[i]
				//stack.push(Character.getNumericValue(ch));
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
			//return result;
		
		//return the value of the left element
			return stack.pop();
	}
		
}

