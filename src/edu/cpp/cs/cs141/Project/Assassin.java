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
import java.io.Serializable;


/**
 * @author AlternativeFAQs
 *
 */
public class Assassin extends ActiveAgent implements Serializable{

    Random random;
    
    public Assassin(int x, int y){
	super(x, y, 1);
        random = new Random();
    }
	
    
	public boolean canMove(char direction) {
        int xPos = super.getX();
        int yPos = super.getY();
        boolean canMove = true;
        
        if (direction == 'w') {
            if (yPos >= 8)
            	canMove = false;
            else if ((xPos == 1 && (yPos + 1 == 1 || yPos + 1 == 4 || yPos + 1 == 7))
            		|| (xPos == 4 && (yPos + 1 == 1 || yPos + 1 == 4 || yPos + 1 == 7))
                    || (xPos == 7 && (yPos + 1 == 1 || yPos + 1 == 4 || yPos + 1 == 7)) ) {
				canMove = false;
			}
		} else if (direction == 'd') {
			if (xPos >= 8)
				canMove = false;
			else if ((yPos == 1 && (xPos + 1 == 1 || xPos + 1 == 4 || xPos + 1 == 7))
					|| (yPos == 4 && (xPos + 1 == 1 || xPos + 1 == 4 || xPos + 1 == 7))
					|| (yPos == 7 && (xPos + 1 == 1 || xPos + 1 == 4 || xPos + 1 == 7)) ) {
				canMove = false;
			}
		} else if (direction == 's') {
			if (yPos <= 0)
				canMove = false;
			else if ((xPos == 1 && (yPos - 1 == 1 || yPos - 1 == 4 || yPos - 1 == 7))
					|| (xPos == 4 && (yPos - 1 == 1 || yPos - 1 == 4 || yPos - 1 == 7))
					|| (xPos == 7 && (yPos - 1 == 1 || yPos - 1 == 4 || yPos - 1 == 7)) ) {
				canMove = false;
			}
		} else if (direction == 'a') {
			if (xPos <= 0)
				canMove = false;
			else if ((yPos == 1 && (xPos - 1 == 1 || xPos - 1 == 4 || xPos - 1 == 7))
					|| (yPos == 4 && (xPos - 1 == 1 || xPos - 1 == 4 || xPos - 1 == 7))
					|| (yPos == 7 && (xPos - 1 == 1 || xPos - 1 == 4 || xPos - 1 == 7)) ) {
				canMove = false;
			}
		}
	return canMove;
    }
    
	/**
	 * Random number generator selects 0 through 3 to move.
	 * 0 for up, 1 for right, 2 for down, 3 for left.
	 */
	public void move() {
		int direction = random.nextInt(4);
        int xPos = super.getX();
        int yPos = super.getY();

        switch(direction){
        case 0: 
        	if (canMove('w'))
        		yPos=yPos+1;
        	break;
        case 1:
        	if (canMove('a'))
        		xPos=xPos-1;
        	break;
        case 2:
        	if (canMove('s'))
        		yPos=yPos-1;
        	break;
        case 3:
        	if (canMove('d'))
        		xPos=xPos+1;
        	break;
		}
		super.setX(xPos);
		super.setY(yPos);
    }
}
