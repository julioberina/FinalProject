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
 * This class represents the entity that the user plays as. 
 */
public class Agent {
	private int Xpos;
	private int Ypos;
	
	/**
	 * 
	 */
	public Agent() {
		Xpos = 0;
		Ypos = 0;
	}

	public int getX() {
		return Xpos;
	}
	public int getY(){
		return Ypos;
	}

}
