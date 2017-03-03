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

import java.util.ArrayList;

/**
 * @author AlternativeFAQs A class that represents the game engine. This holds
 *         all of the statistics for the game at an instant.
 */
public class GameEngine {


	/**
	 * A field that represents the board that the user will be playing on
	 */
	private static Board bldg;

	/**
	 * A field that represents the number of lives (or tries) that a player has.
	 * The game ends when the user has no more lives.
	 */
	private int lives;
	
	private boolean foundBriefcase;

	/**
	 * The default constructor for the class GameEngine. Initially, the game
	 * starts off with a new board that contains 6 ninjas in randomly placed
	 * locations every time it is created, and the player starts with 3 lives.
	 */
	public GameEngine() {
		bldg = new Board();
		lives = 3;
	}

	/**
	 * An overloaded constructor that will create a game engine based off of old
	 * statistics from a game that the user previously saved.
	 * 
	 * @param oldGame
	 *            - The previous board from the saved game that the user wants
	 *            to load
	 * @param prevLives
	 *            - The previous amount of lives that the user had in the saved
	 *            game
	 */
	public GameEngine(Board oldGame, int prevLives) {

	}

	/**
	 * A method that decreases the players amount of lies every time they are
	 * shot by an assassin
	 */
	public void loseLife() {
		lives--;
	}

	/**
	 * A method that returns the number of lives left. At 0 the game ends.
	 * 
	 * @return - Amount of lives remaining
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * A method that checks whether the agent has landed on the radar
	 * @return
	 */
	public boolean foundRadar(){
		boolean found = false;
		if (getAgentX()==bldg.getRadarX() && getAgent().getY()==bldg.getRadarY())
			found = true;
		return found;
	}
	
	/**
	 * A method that checks whether the agent has landed on invincibility
	 * @return
	 */
	public boolean foundInvincibility(){
		boolean found = false;
		if (getAgentX()==bldg.getInvc().getX() && getAgentY()==bldg.getInvc().getY())
			found = true;
		return found;
	}
	
	/**
	 * A method that checks whether the agent has landed on an additional bullet.
	 * @return
	 */
	public boolean foundBullet(){
		boolean found = false;
		if (getAgentX()==bldg.getBulletX() && getAgentY()==bldg.getBulletY())
			found=true;
		bldg.getGun().reload();
		return found;
	}

	public void useGun(){
		if (foundBullet() && bldg.getGun().seeAmmo()>0)
			bldg.getGun().use();
	}
	
	/**
	 * A method that checks if the agent was able to move up
	 * @return
	 */
	public boolean movedUp(){
		boolean moved = false;
		if (getAgent().move('w')){ 
			getAgent().setY(getAgentY()+1);
			moved = true;
		}
		return true;
	}
	
	/**
	 * A method that checks if the agent was able to move down
	 * @return
	 */
	public boolean movedDown(){
		boolean moved = false;
		if (getAgent().move('s')){ 
			getAgent().setY(getAgentY()-1);
			moved = true;
		}
		return true;
	}
	
	/**
	 * A method that checks if the agent was able to move left
	 * @return
	 */
	public boolean movedLeft(){
		boolean moved = false;
		if (getAgent().move('a')){ 
			getAgent().setX(getAgentX()-1);
			moved = true;
		}
		return true;
	}
	
	/**
	 * A method that checks if the agent was able to move right
	 * @return
	 */
	public boolean movedRight(){
		boolean moved = false;
		if (getAgent().move('d')){ 
			getAgent().setX(getAgentX()+1);
			moved = true;
		}
		return true;
	}
	
	
	/**
	 * A method that will check all surrounding units of a ninja assassin. If
	 * the player is in one of the surrounding squares, the player is shot and
	 * dies.
	 */
	public boolean checkForKill() {
		ArrayList<Assassin> hitList = bldg.getNinjas();
		boolean nextToAgent = false;
		for (int i = 0 ; i<6 ; i++){
			if (getAgentX()==hitList.get(i).getX() && (getAgentY()==hitList.get(i).getY()+1 || getAgentY()==hitList.get(i).getY()-1))
				nextToAgent=true;
			if (getAgentY()==hitList.get(i).getY() && (getAgentX()==hitList.get(i).getX()+1 || getAgentX()==hitList.get(i).getX()-1))
				nextToAgent=true;
		}
		return nextToAgent;
	}

	public void startOver(){
		getAgent().setX(0);
		getAgent().setY(0);
	}
	

	/**
	 * A method that relays whether the user found the briefcase or not
	 * 
	 * @return - A boolean that is true if the player reached the correct room,
	 *         or false if not.
	 */
	public boolean checkRoom() {
		if (validBriefcaseCoords(getAgentX(),getAgentY()-1))
			foundBriefcase=true;
		return foundBriefcase;
	}
	
	public boolean briefcaseFound(){
		return foundBriefcase;
	}
	
	public Board getBoard(){
		return bldg;
	}
        
    public Agent getAgent() {
        return bldg.getAgent();
    }
	
	public int getAgentX() {
		return bldg.getAgent().getX();
	}

	public int getAgentY() {
		return bldg.getAgent().getY();
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
        
        public void loadBoard(Board board) {
            bldg = board;
        }
        
        public void loadLives(int lives) {
            this.lives = lives;
        }
        
        public void loadFoundBriefcase(boolean found) {
            foundBriefcase = found;
        }
}
