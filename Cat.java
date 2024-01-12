import java.util.Random;

//This class holds the methods that makes the cat chase the mouse, remove dead cats and moves the cat around the window. 
public class Cat extends Creature{
    
	private int catAge = 50; //counter for how many moves are made
	
	public Cat(int x, int y, City city, Random rand){
	super(x, y, city, rand);
	this.lab = 'y'; //makes the cat dot the color yellow 
	stepLen = 2 ; // make the cat jump 
	}

	//This method moves the cat around the window 
	public void step(){ //moves cat 
		if(catAge == 0){ //if the cats age reaches 0 then the cat has lived 50 rounds 
			this.dead = true;  //removes the cat from the window 
			return;
		}
	
		catAge--; //decrease the age of the cat each round  
	
		if(rand.nextInt(100) < 5){ //makes the cat turn 5% of time 
		    randomTurn(); //turn the cat 
		}
	
	super.step();
	}
	
	//This method will make the cat chase a mouse if there is a mouse near the cat or it will catch a mouse if it is on the mouse 
	public void takeAction(){ 
	// check the min distance of the nearest cat is less then 20 
	if(this instanceof Cat){ //gets an instance of a cat 
		for(Creature creature : city.creatures){ //searches through the creatures 
			if(creature instanceof Mouse){ //checks if the creature is a mouse 
				if(this.dist(creature) == 0){ //if the cat is on the mouse then it kills the mouse 
					catAge = 50; //sets the age of the cat to 50 because it caught the mouse 
					creature.dead = true; //removes the mouse from the window beucase it was caught 
					return;
				}
			}	
		}
	}
	chaseMouse(); //call the method for the cat to chase a mouse 
	}
	
	//This method searches the window to look for the closes mouse to a cat 
	public Creature findMouse(Creature c){
	int minDist = 10000; 
	Creature closeMouse = null; 
	
		for(Creature creature : city.creatures){ //searches through the creatures 
			if(creature instanceof Mouse){ //checks if it is a mouse 
				int cDist = c.dist(creature);
				if(cDist < minDist && cDist < 20){ 
					minDist = cDist; //updating the min dist 
					closeMouse = creature;  //updating the closest creature/mouse 
				}
			}
		}
		return closeMouse; 
	}

	//This method to make the cat chase the mouse
	public void chaseMouse(){  
	Creature closeMouse = findMouse(this); //find the closest mouse  
	
		if(closeMouse != null){ //makes sure that the closest mouse actully exists 
			lab = 'c';//turn cat cyan 
	
			int x = closeMouse.getX() - this.getX(); //finds the x distance between the mouse and cat 
			int y = closeMouse.getY() - this.getY(); //finds the y distance between the mouse and cat 
	
			int dir; 
	
			if(Math.abs(x) >= Math.abs(y)){ //if the x distance is greater then the y then move in the east west direction 
				if( x > 0){ //if the distance is postitive then is moves east 
					dir = Creature.EAST;
				}
				else{ //then the distance is negative it moves west 
					dir = Creature.WEST; 
				}
			}
			else{ //moves the cat in the south north direction 
				if(y > 0){ //if the distance is positive then it moves south 
					dir = Creature.SOUTH;
				}
				else{ //if the distance is negative then it moves north 
					dir = Creature.NORTH; 
				}
			}
			setDir(dir); //sets the direction value to the one that is found
		}
		else{ //makes the color of the cat yellow if it cannot find a mouse to chase 
			lab = 'y'; 
		}
	}  
}

