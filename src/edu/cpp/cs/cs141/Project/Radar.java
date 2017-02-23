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
 * An entity that represents a power-up which allows the user to see the number of the room where the briefcase is stored. 
 * This is an extension of the superclass Item because it is one of the few power-ups that the player can obtain from a 
 * random spot in the building.
 */
public class Radar extends Item {

	/**
	 * 
	 */
	public Radar(int x, int y) {
		xPos = x;
		yPos = y;
	}

}
