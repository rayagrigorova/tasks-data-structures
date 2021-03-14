package StacksQueues_zadachi8;

import java.util.*;

public class EvaluateExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an expression: ");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();

		System.out.println("Answer: " + evaluateExpression(expression));
		sc.close();
	}

	public static int evaluateExpression(String expression) {
		Stack <Integer> operandStack = new Stack <Integer>();
		Stack <Character> operatorStack = new Stack <Character>();

		expression = insertBlanks(expression);
		
		String[] tokens = expression.split(" ");
		
		System.out.println("tokens: ");
		for(int i = 0; i < tokens.length; i++) {
			System.out.print(tokens[i] + "|");
		}
		System.out.println();
		
		for(String token : tokens) {
			if(token.length() == 0 || token.contains(" ")) {continue;}
			
			else if(token.charAt(0) == '+' || token.charAt(0) == '-') {
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' ||
					operatorStack.peek() == '/' || operatorStack.peek() == '*' ||operatorStack.peek() == '^')) {
					processAnOperator(operatorStack, operandStack);
				}
				operatorStack.push(token.charAt(0));
			}
			
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '^')) {
					processAnOperator(operatorStack, operandStack);
				}
				operatorStack.push(token.charAt(0));
			}
			//PEMDAS - Exponents (Powers, Roots) before Multiply, Divide, Add or Subtract
			else if(token.charAt(0) == '^') {
				//push and process
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '^')){
				processAnOperator(operatorStack, operandStack);
				}
				operatorStack.push(token.charAt(0));
			}
			
			else if (token.trim().charAt(0) == '(') {operatorStack.push('(');}
			else if (token.trim().charAt(0) == ')') {
				while(operatorStack.peek() != '(') {
					processAnOperator(operatorStack, operandStack);
				}
				operatorStack.pop();
			}
			else {
				operandStack.push(Integer.parseInt(token));
			}
		}
		
		while(!operatorStack.isEmpty()) {
			processAnOperator(operatorStack, operandStack);
		}
		return operandStack.pop();		
	}
	
	public static double evaluateExpressionDouble(String expression) {
		Stack <Double> operandStack = new Stack <Double>();
		Stack <Character> operatorStack = new Stack <Character>();

		expression = insertBlanks(expression);
		
		String[] tokens = expression.split(" ");		
		
		for(String token : tokens) {
			if(token.length() == 0 || token.contains(" ")) {continue;}
			
			else if(token.charAt(0) == '+' || token.charAt(0) == '-') {
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' ||
					operatorStack.peek() == '/' || operatorStack.peek() == '*' ||operatorStack.peek() == '^')) {
					processAnOperatorDouble(operatorStack, operandStack);
				}
				operatorStack.push(token.charAt(0));
			}
			
			else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '^')) {
					processAnOperatorDouble(operatorStack, operandStack);
				}
				operatorStack.push(token.charAt(0));
			}
			//PEMDAS - Exponents (Powers, Roots) before Multiply, Divide, Add or Subtract
			else if(token.charAt(0) == '^') {
				//push and process
				while(!operatorStack.isEmpty() && (operatorStack.peek() == '^')){
				processAnOperatorDouble(operatorStack, operandStack);
				}
				operatorStack.push(token.charAt(0));
			}
			
			else if (token.trim().charAt(0) == '(') {operatorStack.push('(');}
			else if (token.trim().charAt(0) == ')') {
				while(operatorStack.peek() != '(') {
					processAnOperatorDouble(operatorStack, operandStack);
				}
				operatorStack.pop();
			}
			else {
				operandStack.push(Double.parseDouble(token));
			}
		}
		
		while(!operatorStack.isEmpty()) {
			processAnOperatorDouble(operatorStack, operandStack);
		}
		return operandStack.pop();		
	}
	
	
	public static void processAnOperatorDouble(Stack <Character> operatorStack, Stack <Double> operandStack) {
		char op = operatorStack.pop();
		double op1 = operandStack.pop();
		double op2 = operandStack.pop();
		
		if(op == '+') {
			operandStack.push(op2 + op1);
		}
		else if(op == '-') {
			operandStack.push(op2 - op1);
		}
		else if (op == '*') {
			operandStack.push(op2 * op1);
		}
		else if(op == '/') {
			operandStack.push(op2 / op1);
		}
		else if(op == '^') {
			operandStack.push(Math.pow(op2, op1));
		}
		
	}
	
	public static void processAnOperator(Stack <Character> operatorStack, Stack <Integer> operandStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		
		if(op == '+') {
			operandStack.push(op2 + op1);
		}
		else if(op == '-') {
			operandStack.push(op2 - op1);
		}
		else if (op == '*') {
			operandStack.push(op2 * op1);
		}
		else if(op == '/') {
			operandStack.push(op2 / op1);
		}
		else if(op == '^') {
			operandStack.push((int) Math.pow(op2, op1));
		}
		
	}

	public static String insertBlanks(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++ ) {
			if(s.charAt(i) == '(' ||s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^') {
				result += " " + s.charAt(i) + " ";
			}
			else {
				result += s.charAt(i);
			}
		}
		return result;
	}

}
