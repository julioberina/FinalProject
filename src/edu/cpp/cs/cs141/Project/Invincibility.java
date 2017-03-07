/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin RodrÃ­guez
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
 * An entity that represents a power-up in the game which makes the player invulnerable to the assassins for 5 turns. This 
 * class extends the superclass Item because it is one of the items that the player can pick up at a random location in the 
 * building.
 */
public class Invincibility extends Item implements Serializable {

	/**
	 * A field that represents whether the invincibility power-up is in use or not.
	 */
	private boolean safe;
	
	
	/**
	 * A field that represents the number of turns that the current invincibility power-up has been in use.
	 */
	private int turns ;
	
	/**
	 * The default constructor for the class Invincibility. When the power-up is picked up it is in use for 5 turns.
	 */
	public Invincibility(int x,int y) {
		super(x,y);
		safe = true;
		turns = 5;
	}
	
	/**
	 * A method that will decrease the number of turns remaining that the player can continue to use invincibility.
	 */
	public void use(){
		turns--;
	}
	
	public int getTurns(){
		return turns;
	}

}
