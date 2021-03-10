package StacksQueues_zadachi8;

import java.util.*;

public class Brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter an expression: ");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();

		if(checkBrackets(expression)) {
			System.out.println("The brackets are balanced");
		}
		else {
			System.out.println("The brackets aren't balanced");
		}
		sc.close();
	}
	
	public static boolean checkBrackets(String expression) {
		//We will have a stack in which we will add brackets. 
		Stack <Character> brackets = new Stack <Character>();

		//We go through the expression
		//If we have an opening bracket, we'll just add it to the stack
		//If we have a closing bracket, we must see the top of the stack. That SHOULD be
		//the corresponding opening bracket 
		
		//(a {b)}
		//push ( to stack
		//push { to stack
		//closing bracket ) - we check the top of the stack - which is { => unbalanced brackets
		for(int i = 0; i < expression.length(); i++) {
			//opening -> push in stack
			if(isOpening(expression.charAt(i))) {
				brackets.push(expression.charAt(i));
			}
			
			//closing -> check top of the stack for corresponding opening
			else if(isClosing(expression.charAt(i))) {
				//Closing bracket without an opening bracket means false
				if(brackets.isEmpty()) {return false;}
				
				//a variable is used because every time pop() is called , an element is popped 
				//For example, if(brackets.pop() == '{' || brackets.pop() == '[') doesn't work 
				char x = brackets.peek();
				//After memorizing the top element in x, we can remove the top bracket
				brackets.pop();
				switch(expression.charAt(i)) {
					case ')':	if(x == '{' || x == '[') {return false;} break;
					case '}':	if(x == '(' || x == '[') {return false;} break;
					case ']':   if(x == '(' || x == '{') {return false;} break;
				}
				
			}
			
			//If the symbol isnt a bracket of any kind, we don't do anything
				
		}
		//If all brackets have a corresponding bracket and there hasn't been a case of overlapping, the brackets are balanced
		return brackets.isEmpty();
	}

	public static boolean isOpening(char x) {
		return (x == '(' || x == '{' || x == '[' );
	}
	
	public static boolean isClosing(char x) {
		return (x == ')' || x == '}' || x == ']');
	}

}
