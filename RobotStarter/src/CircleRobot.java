import javax.swing.*;
import kareltherobot.*;

public class CircleRobot implements Directions{
	public static void main(String[] args) {
		final int radius = Integer.parseInt(JOptionPane.showInputDialog("Enter radius of circle:"));
		World.setSize((radius << 1)+1, (radius << 1)+1);
		World.setDelay(1);
		World.setVisible(true);
		Robot ribbot = new Robot(1,radius+1, North, Integer.MAX_VALUE);
		circle(ribbot,radius);
		for (int i = 0; i < radius; i++) {
			ribbot.move();
		}
	}
	static void circle(Robot rob, int rad) {
		int initx = 0;
		int inity = -rad;
		int x = 0;
		int y = -rad;
		do {
			//finds the best move to do by choosing the one that
			//is closest to the border of the circle
			//and is also counterclockwise around the circle
			int xmove = -2;
			int ymove = -2;
			int distance = Integer.MAX_VALUE;
			for (int xinc = -1; xinc < 2; xinc++) {
				for (int yinc = -1; yinc < 2; yinc++) {
					if (xinc!=0||yinc!=0) {//checks if not empty
						if (y*(x+xinc)-x*(y+yinc)<0) { //checks if counterclockwise
							if (Math.abs(distsq(x+xinc,y+yinc) - rad*rad) < distance) {
								xmove = xinc;
								ymove = yinc;
								distance = Math.abs(distsq(x+xinc,y+yinc) - rad*rad);
							}
						}
					}
				}
			}
			x += xmove;
			y += ymove;
			move(rob,xmove,ymove);
			rob.putBeeper();
		} while (initx != x || inity != y);
	}
	static int distsq(int x1, int y1) { //distance to origin squared
		return x1*x1+y1*y1;
	}
	static void move(Robot roomba, int x, int y) { //assume Robot is pointed north
		if (y > 0) {
			for (int i = 0; i < y; i++) {
				roomba.move();
			}
		}else {
			roomba.turnLeft();
			roomba.turnLeft();
			for (int i = 0; i < -y; i++) {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
		}
		if (x > 0) {
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
			for (int i = 0; i < x; i++) {
				roomba.move();
			}
			roomba.turnLeft();
		}else {
			roomba.turnLeft();
			for (int i = 0; i < -x; i++) {
				roomba.move();
			}
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
		}
	}
	static boolean within(int x, int y, int rad) {
		return x*x+y*y<=rad*rad;
	}
}