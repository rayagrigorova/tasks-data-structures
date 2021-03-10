package Lists_zadachi7;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 5;
	private ArrayList<Ball> list = new ArrayList<Ball>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			collision();
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
	public void collision() {
		for(int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(i != j && haveCollided(i, j)) {
					//if i > j then the ball at i was added AFTER the ball at j. So the ball at i must be removed
					//and the radius of the ball at j must increase
					if(i > j) {
						list.get(j).radius += list.get(i).radius;
						list.remove(i);
					}
					else {
						list.get(i).radius += list.get(j).radius;
						list.remove(j);
					}
				}
			}
		}
	}
	
	public boolean haveCollided(int i, int j) {
		//If the distance between the centers is less than or equal the sum of the radiuses, they have collided 
		//Distance between the centers is sqrt(i.x - j.x) ^ 2 + (i.y - j.y) ^ 2)
		//hypot returns sqrt(x^2 +y^2)
		//It must be <= i.radius + j.radius
		return (Math.hypot(list.get(i).x - list.get(j).x, list.get(i).y - list.get(j).y) <= (list.get(i).radius + list.get(j).radius));
	}
	public void remove(Point p) {
		System.out.println("Mouse pos: " + p.x + " " + p.y);
		int dRad = 0;
		for(int i = 0; i < list.size(); i++) {
			System.out.println(" pos: " + list.get(i).x + " " + list.get(i).y);
			//If radius is too small, we should make clicking easier
			dRad =  (list.get(i).radius <= 10) ? 10 : 0;

			System.out.println("distance between center and point: " +( Math.hypot(list.get(i).x - p.x, list.get(i).y - p.y))
					+ " radius + dRad: " + (list.get(i).radius + dRad) + " radius: " + list.get(i).radius);
			
			//(x-center_x)^2 + (y - center_y)^2 < radius^2 for the point to be in the circle 
			if(Math.hypot(list.get(i).x - p.x, list.get(i).y - p.y) < (list.get(i).radius + dRad)) {
				list.remove(list.get(i));
			}
			
		}
	}
	
}