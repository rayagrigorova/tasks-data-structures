package StacksQueues_zadachi8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class PrefixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		toPrefix(s);
	}
	
	public static void toPrefix (String s) {
		s = insertBlanks(s);
		String[] tokens = s.split(" ");
		Stack <Character> operators = new Stack <>();
		
		System.out.println("\ntokens: ");
		for(int i = 0; i < tokens.length; i++) {
			System.out.print(tokens[i] + "|");
		}
		System.out.println("\n");
		
		for(String token : tokens) {
			if(token.equals("") || token.contains(" ")) {continue;}
			
			//If the token is a number, we directly print it
	        else if(isNumber(token)) {
	        	System.out.print(token + " ");
	        }
	        else if (isOperator(token)) {
	        	//If there aren't any operators or the importance of the operator is bigger than the previous one's or if we are in brackets
	        	if(operators.isEmpty() || importance(token.charAt(0)) >= importance (operators.peek()) || operators.contains('(')) {
	        		operators.push(token.charAt(0));
	        	}
	        	else {
	        		//Pop all operators that are more important or as important as the scanned operator
	        		//Then, push the scanned 
	        		// If a ( or ) is found, we stop popping

	        		//In the end, we push the scanned operator in the stack
	        		while(!operators.isEmpty() && !operators.peek().equals('(') && !operators.peek().equals(')') && importance(token.charAt(0)) <= importance(operators.peek())) {
	        			System.out.print(operators.pop() + " ");
	        		}
	        		
	        		operators.push(token.charAt(0));
	        	}
	        }
	        
	        
	        else if(token.equals("(")) {operators.push('(');}
	        else if (token.equals(")")){
	        	while(!operators.isEmpty() && operators.peek() != '(') {
	        		System.out.print(operators.pop() + " ");
	        	}
	        	//pop opening bracket
	        	operators.pop();
	        }
		}
		while(!operators.isEmpty()) {
			System.out.print(operators.pop() + " ");
		}
		
	}
	
	public static boolean isNumber(String s) {
		try {
			int x = Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static int importance(char x) {
		// Importance of ^ = 3, */ = 2, +- = 1
		switch (x) {
		case '(':
		case ')':
			return 4;
		case '^': 
			return 3;
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		default: return -1;
		}
	}
	
	public static boolean isOperator(String s) {
		return (s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-") || s.equals("^"));
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
