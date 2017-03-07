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

import java.io.IOException;
/**
 * @author AlternativeFAQs
 * The class from which our game will launch. 
 */
public class Main {
	/**
	 * The main method that will launch our game using the user interface.
	 * @param args
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		UserInterface ui = new UserInterface();
		ui.runGame();
	}

}
