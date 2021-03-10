package Lists_zadachi7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class zadachi7_2LinkedList {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		LinkedList <String> list = new  LinkedList<>();
		loadFromFile(list, "words.txt");
		Collections.sort(list);
		System.out.println(list);
		
		long end = System.currentTimeMillis();
		System.out.println("Took "+(end - start) + " ms"); 
	}

	public static void loadFromFile(LinkedList <String> list, String fileName) {
		Scanner sc = new Scanner(zadachi7_2LinkedList.class.getResourceAsStream(fileName));
		while (sc.hasNextLine()) {
				String data = sc.next();
				list.add(data);
		}
		sc.close();
	   
	}

}
