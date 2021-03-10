package Lists_zadachi7;

import java.awt.Color;

class Ball {
	int x = (int)(Math.random() * 100);
	int y = (int)(Math.random() * 100); // Current ball position
	int dx = (int)(Math.random() * 5) + 1; // Increment on ball's x-coordinate
	int dy = (int)(Math.random() * 5) + 1; // Increment on ball's y-coordinate
	int radius = 5; // Ball radius
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
}