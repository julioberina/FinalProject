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
 *
 */
public abstract class Item implements Serializable {
    protected int xPos;
	protected int yPos;
    
	/**
	 * 
	 */
	public Item(int x, int y) {
		// TODO Auto-generated constructor stub
                xPos = x;
                yPos = y;
	}
	
	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}
	
	

}
