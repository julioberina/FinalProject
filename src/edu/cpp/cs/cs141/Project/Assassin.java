/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Final Project
 * * <description-of-assignment>
 *
 * Team Alternative FAQs 
 *   Julio Berina
 *   Isaac Kim
 *   Sean Ritchie
 *   Gina Rodil
 */
package edu.cpp.cs.cs141.Project;

import java.util.Random;

/**
 * @author AlternativeFAQs
 *
 */
public class Assassin extends ActiveAgent {

    Random random;
    
    public Assassin(int x, int y){
	super(x, y, 1);
        random = new Random();
    }
	
	/**
	 * Random number generator selects 0 through 3 to move.
	 * 0 for up, 1 for right, 2 for down, 3 for left.
	 */
        
	public void move() {
	int direction = random.nextInt(4);
        int xPos = super.getX();
        int yPos = super.getY();
                
	if (direction == 0) {
            if (yPos < 8 || (xPos == 1 && (yPos + 1 != 1 || yPos + 1 != 4 || yPos + 1 != 7))
			 || (xPos == 4 && (yPos + 1 != 1 || yPos + 1 != 4 || yPos + 1 != 7))
                         || (xPos == 7 && (yPos + 1 != 1 || yPos + 1 != 4 || yPos + 1 != 7))) {
				++yPos;
			}
		} else if (direction == 1) {
			if (xPos < 8 || (yPos == 1 && (xPos + 1 != 1 || xPos + 1 != 4 || xPos + 1 != 7))
					|| (yPos == 4 && (xPos + 1 != 1 || xPos + 1 != 4 || xPos + 1 != 7))
					|| (yPos == 7 && (xPos + 1 != 1 || xPos + 1 != 4 || xPos + 1 != 7))) {
				++xPos;
			}
		} else if (direction == 2) {
			if (yPos > 0 || (xPos == 1 && (yPos - 1 != 1 || yPos - 1 != 4 || yPos - 1 != 7))
					|| (xPos == 4 && (yPos - 1 != 1 || yPos - 1 != 4 || yPos - 1 != 7))
					|| (xPos == 7 && (yPos - 1 != 1 || yPos - 1 != 4 || yPos - 1 != 7))) {
				--yPos;
			}
		} else if (direction == 3) {
			if (xPos > 0 || (yPos == 1 && (xPos - 1 != 1 || xPos - 1 != 4 || xPos - 1 != 7))
					|| (yPos == 4 && (xPos - 1 != 1 || xPos - 1 != 4 || xPos - 1 != 7))
					|| (yPos == 7 && (xPos - 1 != 1 || xPos - 1 != 4 || xPos + 1 != 7))) {
				--xPos;
			}
		}
	super.setX(xPos);
	super.setY(yPos);

    }
}
