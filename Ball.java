package Lists_zadachi7;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

class Ball {
	int x;
	int y; // Current ball position
	int dx; // Increment on ball's x-coordinate
	int dy; // Increment on ball's y-coordinate
	int radius; // Ball radius
	Color color;
	
	Ball(){
		this.x = (int)(Math.random() * 50);
		this.y = (int)(Math.random() * 50);
		this.dx = (int)(Math.random() * 5) + 1; 
		this.dy = (int)(Math.random() * 5) + 1;
		this.radius = 5;
		this.color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));		
	}
	
	Ball(Dimension d){
		this();
		Random r = new Random();
		this.x = r.nextInt(d.width);
		this.y = r.nextInt(d.height);
	}
}