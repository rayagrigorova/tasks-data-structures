package StacksQueues_zadachi8;

import java.util.Comparator;

public class BallComparator implements Comparator <Ball> {

	@Override
	public int compare(Ball o1, Ball o2) {
		if(o1.radius < o2.radius) {
			return 1;
		}
		else if (o1.radius > o2.radius) {
			return -1;
		}
		return 0;
	}

}
