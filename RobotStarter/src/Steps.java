import java.util.*;
import kareltherobot.*;
public class Steps implements Directions{

	public static void main(String[] args) {
	    new Steps().start();
	  }


	  public void start(){
		  Scanner s = new Scanner(System.in);
		  System.out.println("Steps Height Width");
		  final int steps = s.nextInt();
		  final int height = s.nextInt();
		  final int width = s.nextInt();
		  
		  //System.out.println(width);
		  World.setSize(height*steps+1,width*steps+1);
		  World.setDelay(1);
		  World.setVisible(true);
		  Robot r = new Robot(1,1,North, steps*(height+width));
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
