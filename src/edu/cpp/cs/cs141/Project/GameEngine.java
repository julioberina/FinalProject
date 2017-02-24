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

import java.util.ArrayList;

/**
 * @author AlternativeFAQs A class that represents the game engine. This holds
 *         all of the statistics for the game at an instant.
 */
public class GameEngine {

	/**
	 * A field that represents the agent that the user will play as.
	 */
	private static Agent spy;

	/**
	 * A field that represents the board that the user will be playing on
	 */
	private Board bldg;

	/**
	 * The default constructor for the class GameEngine. Initially, the game
	 * starts off with a new board that contains 6 ninjas in randomly placed
	 * locations every time it is created, and the player starts with 3 lives.
	 */
	public GameEngine() {
            spy = new Agent();
            bldg = new Board();
	}

	/**
	 * A method that will check all surrounding units of a ninja assassin. If
	 * the player is in one of the surrounding squares, the player is shot and
	 * dies.
	 */

	public int getAgentX() {
		return spy.getX();
	}

	public int getAgentY() {
		return spy.getY();
	}

	public boolean AssassinCoord(int i, int j) {
		return bldg.AssassinCoord(i, j);
	}

	public boolean validBriefcaseCoords(int i, int j) {

		return bldg.validBriefcaseCoords(i, j);
	}

	public boolean validRoomCoords(int i, int j) {
		return bldg.validRoomCoords(i, j);
	}

	public int getInvcX() {
		return bldg.getInvcX();
	}

	public int getInvcY() {
		return bldg.getInvcY();
	}

	public int getBulletX() {
		return bldg.getBulletX();
	}

	public int getBulletY() {
		return bldg.getBulletY();
	}

	public int getRadarX() {
		return bldg.getRadarX();
	}

	public int getRadarY() {
		return bldg.getRadarY();
	}
        
        public Board getBoard() {
            return bldg;
        }
        
        public static Agent getAgent() {
            return spy;
        }
}
