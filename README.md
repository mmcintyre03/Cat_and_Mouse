Project Introduction: 
This code was completed for Software Engineering CSCI 2113 at Geroge Washington University for Professor Kinga Dobolyi. This project created a point simulation of cats and mice. The cats will change the mice and eat them, but if a cat does not catch enough mice then they will pass away. The mice after a certain amount of rounds will also pass away. To complete this project object orientied programing was used to created multiple cats and mice.  

Given Files and Code: 
To start the project files Creature.java, City.java, Simulator.java and GridPoint.java were provided by Professor Dobolyi to help complete the project. The Creature.java file provided the code to create a basic creature and was used to create the cat and mice. The City.java file created the environment were the creatures lived in. Simulator.java and GridPoint.java are created to help maipulate the creature objects movements and create a grid using row/column to be used as a key. 

Cat
The Cat.java file is used to move the cat and allow them to chase mice. Within this class the age of the cat is counted, the closest mouse is found, and the cat chasing the mouse is also found. The age of the cat is recorded by how many rounds of the program have occured. The closest mouse is found by looping through all of the instances of mice and comparing the distance to a specific instance of a cat. If the mouse is close to the cat the cat will turn cyan and start chasing the mouse. If the cat is at the same spot as the mouse then the cat catches the mouse and the mouse is removed from the city. 

Mouse
The Mouse.java file is used to move the mice around and remove them from the city. Within this class there is a variable that counts the amount of rounds that has occured and it is used to track the age of the mouse. After a certain amount of rounds if the mouse has not been eaten then it will pass away/removed from the city. 

Executing the code
To execute the code open all of the files and paste the following into the terminal to compile the files. 
javac -classpath ".;./Plotter.jar;./junit-platform-console-standalone-1.7.0-M1.jar" *.java for Windows

javac -classpath ".:./Plotter.jar:./junit-platform-console-standalone-1.7.0-M1.jar" *.java for Mac

After the files are complied then run the following lines to run the program. 

java Simulator 8 2 0 1000 | java -jar Plotter.jar

The first number(8) is the number of cats that will be created, the second number is the number of mice, the third is the number of Zombie cats(This was not a requirement of our project), the last is the number of rounds the simulation will last.
