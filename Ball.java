package StacksQueues_zadachi8;

import java.awt.Color;
import java.util.Random;

class Ball {
	int x = 0;
	int y = 0; // Current ball position
	int dx = 2; // Increment on ball's x-coordinate
	int dy = 2; // Increment on ball's y-coordinate
	int radius = 5; // Ball radius
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	
	Ball(){
		Random r = new Random();
		//r.nextInt(19) generates random int in range [0;18]. We add 2 so it's >= 2
		radius = (r.nextInt(19)) + 2;
		
	    x = r.nextInt(101);
		y = r.nextInt(101);
		dx = (r.nextInt(5)) + 1; 
		dy = (r.nextInt(5)) + 1;
	}

}