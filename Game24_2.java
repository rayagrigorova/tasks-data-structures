package StacksQueues_zadachi8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Game24_2 {
	
	static int [] numbers = new int[4];
	static char [] operations = {'+', '-', '/', '*'};
	//4! ways to order the numbers = 24
	//4 numbers to order
	static int [][] orderedNumbers = new int[24][4];
	//For the operations +-/* there are 4 * 4 * 4 = 64 possibilities
	//3 operations to order
	static String [] orderedOperations = new String[64];
	
	//Pairs of operations 
	public static String pairs[] = new String[16];
	
	public static int ind = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//Get the 4 numbers
		for(int i = 0 ; i < 4; i++) {
			numbers[i] = sc.nextInt();
		}
		sc.close();
		
		ind = 0;
		orderNumbers(numbers.clone(), 4);
		
		System.out.println("Ordered numbers:");
		for(int i = 0; i < 24; i++) {
			for(int j = 0; j < 4; j++)System.out.print(orderedNumbers[i][j]+ " ");
			System.out.println();
		}

		orderOperationPairs();
		orderOperations();
		
		orderExpressions();
}
		
		//For the brackets, there are a few possibilities:
//		((2 - 1) + 5) * 4
//		(2 - (1 - 5)) * 4
//		(2 + 4) * (5 - 1)
//		4 / ((1 * 2) / 12)
//		4 / ( 12 + (1 * 2))
		
		//We will have arrays with the ordered numbers and operations 
		//For each combination of numbers we will combine it with each combination of signs 
		//Then, we will put the combination between brackets (for every one of the types)
	public static void orderNumbers(int[] elements, int size) {
		
				//Heap’s Algorithm for generating permutations
			    if(size == 1) {
			    	for(int i = 0; i < 4; i++) {
				    	orderedNumbers[ind][i] = elements[i];
			    	}
			    	ind++;
			    	return;
			    } else {
			        for(int i = 0; i < size - 1; i++) {
			        	orderNumbers(elements, size - 1);
			            if(size % 2 == 0) {
			                swap(elements, 0, size - 1);
			            } else {
			                swap(elements, i, size - 1);
			            }
			        }
		        	orderNumbers(elements, size - 1);
			    }
	}
	
	private static void swap(int [] arr, int i, int j) {
	    int tmp = arr[i];
	    arr[i] =arr[j];
	    arr[j] = tmp;
	}
	public static void orderOperationPairs() {
		ind = 0;
		//creates all possible pairs of two operations 
		for(int i = 0; i < 4; i++) {
			for(int j = 0 ; j < 4; j++) {
				pairs[ind] = String.valueOf(operations[i])  + operations[j];	
				ind++;
			}
		}
	}
	
	public static void orderOperations() {
		ind = 0;
		//There are a total of 16 pairs of operations 
		for(int i = 0; i < 16; i++ ) {
			//4 possibilities for the 3rd sign 
			for(int j = 0; j < 4; j++) {
				//the ith pair + the sign at j 
				orderedOperations[ind] = pairs[i] + operations[j];
				ind++;
			}
		}
		System.out.println("\nOrdered operations: ");
		for(int i = 0 ; i < 64; i++) {
			System.out.print(orderedOperations[i] + " ");
		}
		
	}
	public static void orderExpressions() {
		//For all ordered numbers 
		for(int orderedNum = 0; orderedNum < 24; orderedNum++) {
			//With all possible operations between them 
			for(int orderedOp = 0; orderedOp < 64; orderedOp++) {
				//the five possible positions of the brackets 
				for(int i = 0; i < 5; i++) {
					switch(i) {
						case 0: evaluate(first( orderedNum, orderedOp)); break;
						case 1: evaluate(second( orderedNum, orderedOp)); break;
						case 2: evaluate(third( orderedNum, orderedOp)); break;
						case 3: evaluate(fourth( orderedNum, orderedOp)); break;
						case 4: evaluate(fifth( orderedNum, orderedOp)); break;
					}
				}
			}
			
		}
	}
	
//	((2 - 1) + 5) * 4 
public static String first( int orderedNum, int  orderedOp) {
	//for each number
	return " ( ( " + orderedNumbers[orderedNum][0] + " " + orderedOperations[orderedOp].charAt(0) + " " + orderedNumbers[orderedNum][1] + " ) "
			+  " " + orderedOperations[orderedOp].charAt(1) + " " + orderedNumbers[orderedNum][2] + " ) " + orderedOperations[orderedOp].charAt(2) + " " + orderedNumbers[orderedNum][3];
}
//(2 - (1 - 5)) * 4 
public static String second( int orderedNum, int  orderedOp) {
	return " ( " + orderedNumbers[orderedNum][0] + " " + orderedOperations[orderedOp].charAt(0) + " ( " + orderedNumbers[orderedNum][1] + " " + 
			 orderedOperations[orderedOp].charAt(1) + " " +  orderedNumbers[orderedNum][2] + " ) ) " + orderedOperations[orderedOp].charAt(2) + " " + orderedNumbers[orderedNum][3];
}

//(2 + 4) * (5 - 1)
public static String third( int orderedNum, int  orderedOp) {
	return " ( " + orderedNumbers[orderedNum][0] + " " + orderedOperations[orderedOp].charAt(0) + " " + orderedNumbers[orderedNum][1] + " ) " +
			orderedOperations[orderedOp].charAt(1)  + " ( " +  orderedNumbers[orderedNum][2] + " " + orderedOperations[orderedOp].charAt(2) + " " + orderedNumbers[orderedNum][3] + " ) ";
}

//4 / ((1 * 2) / 12) 
 
public static String fourth( int orderedNum, int  orderedOp) {
	return "" + orderedNumbers[orderedNum][0] + " " + orderedOperations[orderedOp].charAt(0) +  " ( ( " + orderedNumbers[orderedNum][1] + " " + orderedOperations[orderedOp].charAt(1) +
			 " " + orderedNumbers[orderedNum][2] + " ) " + orderedOperations[orderedOp].charAt(2) + " " + orderedNumbers[orderedNum][3] + " )";
}
//4 / ( 12 + (1 * 2))
public static String fifth( int orderedNum, int  orderedOp) {
	return "" + orderedNumbers[orderedNum][0] + " " +  orderedOperations[orderedOp].charAt(0) + " ( " + orderedNumbers[orderedNum][1] + " " + orderedOperations[orderedOp].charAt(1) +
			" ( " + orderedNumbers[orderedNum][2] + " " + orderedOperations[orderedOp].charAt(2) + " " + orderedNumbers[orderedNum][3] + " ) ) ";
}

public static void evaluate(String s) {
	 double result = EvaluateExpression.evaluateExpressionDouble(s);
	if(result == 24) {
		System.out.println("Answer: " + s) ;
	}
	
}
}


