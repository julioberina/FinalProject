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

/**
 * @author AlternativeFAQs
 *
 */
public class Room {
	private int xPos;
	private int yPos;
	private boolean briefcase;
	
	Room(int x,int y){
		xPos = x;
		yPos = y;
		briefcase = false;
	}

	public void setBriefcase() {
		briefcase = true;
	}
	
	int getX(){
		return xPos;
	}
	
	
	int getY(){
		return yPos;
	}
}
