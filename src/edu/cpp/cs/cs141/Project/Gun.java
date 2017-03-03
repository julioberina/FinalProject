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
 * An entity that represents the players gun (and if applicable, ammunition). This is an extension of the superclass Item. 
 * The Gun is just one of the few items that the player can carry with him. If the player has not yet used the first 
 * equipped bullet and tries to gain another, the powerup will have no effect.
 */
public class Gun implements Serializable {

	/**
	 * A field that represents the amount of bullets contained in the players gun.
	 */
	private int ammo;
	
	/**
	 * The default constructor for the class Gun. When a new game starts, the player is equipped with a gun that contains
	 * 1 bullet.
	 */
	public Gun() {
		ammo = 1;
	}

	/**
	 * A method that decreases the ammo in the gun by 1 whenever it is used
	 */
	public void use(){
		ammo--;
	}
	
	/**
	 * A method that will return the number of bullets left in the gun.
	 */
	public int seeAmmo(){
		return ammo;
	}
	
	public void reload(){
		ammo = 1;
	}
	
}