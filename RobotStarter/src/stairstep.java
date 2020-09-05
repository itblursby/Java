//package steps;

import kareltherobot.*;
import java.util.*;

public class stairstep implements Directions{
  
  // Leave this alone!!
  public static void main(String[] args) {
    new stairstep().start();
  }


  public void start(){
	  Scanner s = new Scanner(System.in);
	  System.out.println("Steps,Height,Width");
	  int steps = s.nextInt();
	  int height = s.nextInt();
	  int width = s.nextInt();
	  
	  //System.out.println(width);
	  World.setSize(height*steps+1,width*steps+1);
	  World.setDelay(1);
	  World.setVisible(true);
	  Robot r = new Robot(1,1,North, 10000);
	  for (int i = 0; i < steps; i++) {
		  makeStep(r,height,width);
	  }
  }
  // Robot rob is facing North, height beepers placed for the step
	public void moveForward(Robot bot, int spaces)
	{
		for (int i = 0; i < spaces; i++) {
			bot.putBeeper();
			bot.move();
			
		}
	}
	public void turnRight(Robot bot) {
		bot.turnLeft();
		bot.turnLeft();
		bot.turnLeft();
	}
	public void makeStep(Robot bot, int height, int width) {
		//assume robot is pointed north
		moveForward(bot,height);
		turnRight(bot);
		moveForward(bot,width);
		bot.turnLeft();
	}
}