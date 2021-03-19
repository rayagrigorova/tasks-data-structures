package Lists_zadachi7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class zadachi7_2ArrayList {
//I chose to use ArrayList, because there isn't any deletion done (in which LinkedList performs better),
//the memory consumption is high in LinkedList comparatively (ArrayList maintains indexes and element data while LinkedList
//maintains element data and two pointers for neighbor nodes) and sorting is slightly faster with ArrayList
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		ArrayList <String> list = new  ArrayList<>();
		loadFromFile(list, "words.txt");
		Collections.sort(list);
		System.out.println(list);
		
		long end = System.currentTimeMillis();
		System.out.println("Took "+(end - start) + " ms"); 
	}

	public static void loadFromFile(ArrayList <String> list, String fileName) {
		//zadachi7_2ArrayList is the class name 
		Scanner sc = new Scanner(zadachi7_2ArrayList.class.getResourceAsStream(fileName));
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
		    String lineWords[] = line.split("[\\s.,]+");
		    Collections.addAll(list, lineWords);
		}
		sc.close();
	   
	}
}
