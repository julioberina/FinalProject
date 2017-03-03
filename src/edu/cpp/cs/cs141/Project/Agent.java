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

import java.io.Serializable;
/**
 * @author AlternativeFAQs
 * This class represents the entity that the user plays as. 
 */
public class Agent extends ActiveAgent implements Serializable {
    
    public Agent() {
	super(0, 0, 3);
    }
    
    
    /**
	 * 0 for up, 1 for right, 2 for down, 3 for left.
	 */
    public boolean move(char direction) {
        int xPos = super.getX();
        int yPos = super.getY();
        boolean canMove = true;
        
        if (direction == 'w') {
            if (yPos < 8)
            	if ((xPos == 1 && (yPos + 1 == 1 || yPos + 1 == 4 || yPos + 1 == 7))
            		|| (xPos == 4 && (yPos + 1 == 1 || yPos + 1 == 4 || yPos + 1 == 7))
                    || (xPos == 7 && (yPos + 1 == 1 || yPos + 1 == 4 || yPos + 1 == 7)) ) {
				canMove = false;
			}
		} else if (direction == 'd') {
			if (xPos < 8)  
				if ((yPos == 1 && (xPos + 1 == 1 || xPos + 1 == 4 || xPos + 1 == 7))
					|| (yPos == 4 && (xPos + 1 == 1 || xPos + 1 == 4 || xPos + 1 == 7))
					|| (yPos == 7 && (xPos + 1 == 1 || xPos + 1 == 4 || xPos + 1 == 7)) ) {
				canMove = false;
			}
		} else if (direction == 's') {
			if (yPos > 0)
				if ((xPos == 1 && (yPos - 1 == 1 || yPos - 1 == 4 || yPos - 1 == 7))
					|| (xPos == 4 && (yPos - 1 == 1 || yPos - 1 == 4 || yPos - 1 == 7))
					|| (xPos == 7 && (yPos - 1 == 1 || yPos - 1 == 4 || yPos - 1 == 7)) ) {
				canMove = false;
			}
		} else if (direction == 'a') {
			if (xPos > 0)
				if ((yPos == 1 && (xPos - 1 == 1 || xPos - 1 == 4 || xPos - 1 == 7))
					|| (yPos == 4 && (xPos - 1 == 1 || xPos - 1 == 4 || xPos - 1 == 7))
					|| (yPos == 7 && (xPos - 1 == 1 || xPos - 1 == 4 || xPos + 1 == 7)) ) {
				canMove = false;
			}
		}
	return canMove;
    }
    
}
