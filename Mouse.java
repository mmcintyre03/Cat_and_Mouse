import java.util.Random;

//This code moves the mouse around the window 
public class Mouse extends Creature{
   
    public Mouse(int x, int y, City city, Random rand){
        super(x, y, city, rand); 
        this.lab = 'b'; //makes the mouse a blue color 
    }
   
   private int age = 0; //sets the age of the mouse to zero to make sure that the mouse dissapears after 22 rounds 

   //This method moves the mouse around the window and makes them change direction 
   public void step(){ 

        age++; //increment the round 

        if(age == 23){ //checks if mouse dies 
            this.dead = true; //if the age is 23 then the mouse should be set to dead 
            return; 
        }

        int i = rand.nextInt(10); //gets a random number from 1-10 
        if(i < 2){ //makes the mouse turn 20% of the time 
            randomTurn(); //turn the mouse 
        }
        super.step(); //calls the step method that makes the mouse move forward 
    }
   //This method checks if a new mouse should be created or not 
    public void takeAction(){

        if(age == 20){ //check if mouse births 
            city.childMouse(this.getX(), this.getY(), rand); //create a new mouse in the same place at the old mouse 
        }
    }
}
