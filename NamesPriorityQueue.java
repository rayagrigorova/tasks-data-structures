package StacksQueues_zadachi8;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NamesPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue <String> q1 = new PriorityQueue<>();
		PriorityQueue <String> q2 = new PriorityQueue<>();
		
		String[] s1 = new String[]{"George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael"};
		String[] s2 = new String []{ "George" , "Katie" , "Kevin" , "Michelle" , "Ryan" };		
		
		for(String q : s1) {
			q1.offer(q);
		}
		for(String q : s2) {
			q2.offer(q);
		}
		System.out.println("q1: " + q1 + "\nq2: " + q2 + "\n");
		
		System.out.println("Union: " + findUnion(q1, q2));
		System.out.println("Difference: " + findDifference(q1, q2));
		System.out.println("Intersection: " + findIntersection(q1, q2));

	}
	
	public static PriorityQueue <String> findUnion(PriorityQueue <String> x, PriorityQueue <String> y){
		//Creates a PriorityQueue containing the elements in x and y
		PriorityQueue <String> ans = new PriorityQueue <String> (x);
		PriorityQueue <String> copyY = new PriorityQueue <String> (y);
		
		//Remove the common elements once because they will be added twice otherwise
		copyY.removeAll(findIntersection(x, y));
		//Now we have x + y - intersection
		ans.addAll(copyY);
		return ans;
		
	}
	
	public static  PriorityQueue <String> findDifference(PriorityQueue <String> x, PriorityQueue <String> y){
		PriorityQueue <String> ans = new PriorityQueue <String> ();
		//All elements 
		ans = findUnion(x, y);
		//Remove common elements so we are left with the difference
		ans.removeAll(findIntersection(x, y));
		return ans;
	}
	
	public static PriorityQueue <String> findIntersection(PriorityQueue <String> x, PriorityQueue <String> y){
		//Contains elements from x
		PriorityQueue <String> ans = new PriorityQueue <String> (x);
		//keep all elements contained in both x and y
		ans.retainAll(y);
		return ans;
	}

}
