package StacksQueues_zadachi8;

import java.util.*;

public class Postfix {
	static Stack <Integer> operands = new Stack <>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		evaluate(s);
		
		sc.close();
		
	}
	
	public static void evaluate(String s) {
		String[] tokens = s.split(" ");
		
		System.out.println("\ntokens: ");
		for(int i = 0; i < tokens.length; i++) {
			System.out.print(tokens[i] + "|");
		}
		System.out.println("\n");
		
		for(String token : tokens) {
			System.out.println("token:" + token);
			//If the char is empty or a blank space
			if(token.equals("") || token.contains(" ")) {continue;}
			
			//The valid operations are +-/*^
			if (isOperation(token.charAt(0))) {
				doOperation(token.charAt(0));
			}
			
			else if(isNumber(token)){
				operands.push(Integer.parseInt(token));
			}
			//If it isn't a valid operand or number
			else {
				System.out.println("\nInvalid input");
				return;
			}
			
		}
		//There shouldn't be anything in the stack except for the result
		if(operands.size() >= 2 || operands.size() <= 0) {
			System.out.println("\nInvalid input");
			return;
		}
		else {
			System.out.println("\nAnswer: " + operands.pop());
		}
		
	}
	
	public static boolean isOperation(char c) {
		return (c == '/' || c == '*' || c == '+' || c == '-' || c == '^');
	}
	
	public static boolean isNumber(String s) {
		try {
			int x = Integer.parseInt(s);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static void doOperation(char c) {
		try {
			int i1 = operands.pop();
			int i2 = operands.pop();
			
			switch(c) {
			case '+' : operands.push(i2 + i1); break;
			case '-' : operands.push(i2 - i1); break;
			case '/' : operands.push(i2 / i1); break;
			case '*' : operands.push(i2 * i1); break;
			case '^' : operands.push((int) Math.pow(i2 , i1)); break;
			}
		}
		catch(Exception e) {

		}
	}
	
	
}
