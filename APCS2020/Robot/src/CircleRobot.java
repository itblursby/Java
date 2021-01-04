import javax.swing.*;
import kareltherobot.*;

public class CircleRobot implements Directions{
	public static void main(String[] args) {
		//final int radius = Integer.parseInt(JOptionPane.showInputDialog("Enter radius of circle:"));
		World.setSize(80,80);
		World.setDelay(0);
		World.setVisible(true);
		Robot ribbot = new Robot(21,35, North, Integer.MAX_VALUE);
		ellipse(ribbot,20,20);
		move(ribbot,20,26);
		ellipse(ribbot,12,12);
		move(ribbot,-40,0);
		ellipse(ribbot,12,12);
		move(ribbot,20,-26);
		
		move(ribbot,4,4);
		ellipse(ribbot,3,7);
		move(ribbot,0,-3);
		ellipse(ribbot,2,4);
		move(ribbot,-8,3);
		ellipse(ribbot,3,7);
		move(ribbot,0,-3);
		ellipse(ribbot,2,4);
		move(ribbot,4,-9);
		ellipse(ribbot,5,2);

//		ellipse(ribbot,3,7);


	}
	static void ellipse(Robot rob, int xrad, int yrad) {
		int initx = 0;
		int inity = -yrad;
		int x = 0;
		int y = -yrad;
		rob.turnLeft();
		rob.turnLeft();
		for (int i = 0; i < yrad; i++) {
			rob.move();
		}
		rob.turnLeft();
		rob.turnLeft();
		do {
			int xmove = -2;
			int ymove = -2;
			float distance = Float.MAX_VALUE;
			for (int xinc = -1; xinc < 2; xinc++) {
				for (int yinc = -1; yinc < 2; yinc++) {
					if (xinc!=0||yinc!=0) {//checks if not empty
						if (y*(x+xinc)-x*(y+yinc)<0) { //checks if counterclockwise
							if (Math.abs(distsq((x+xinc)/(float)xrad,(y+yinc)/(float)yrad) - 1) < distance) {
								xmove = xinc;
								ymove = yinc;
								distance = Math.abs(distsq((x+xinc)/(float)xrad,(y+yinc)/(float)yrad) - 1);
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
		for (int i = 0; i < yrad; i++) {
			rob.move();
		}
	}
	static float distsq(float x1, float y1) { //distance to origin squared
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