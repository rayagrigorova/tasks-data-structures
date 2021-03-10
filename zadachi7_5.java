package Lists_zadachi7;

import java.util.LinkedList;
import java.util.ListIterator;

public class zadachi7_5 {
	public static void main(String[]args) {
		LinkedList <Integer> list = new LinkedList <>();
		//Adding 5 000 000 elements to linked list 
		for(int i = 0;  i < 5_000_000; i++) {
			list.add(i);
		}
		
		ListIterator <Integer> it = list.listIterator();
		long start1 = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		long end1 = System.currentTimeMillis();
		System.out.println("Took "+ (end1 - start1) + " ms"); 
		
		
		long start2 = System.currentTimeMillis();	
		for(int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		long end2 = System.currentTimeMillis();
		System.out.println("Took "+ (end2 - start2) + " ms"); 
	}

	
}
