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
 */
public abstract class ActiveAgent {
    
    private int xPos;
    private int yPos;
    private boolean alive;
    private int lives;
    
    public ActiveAgent(int x, int y, int lives) {
	// TODO Auto-generated constructor stub
        xPos = x;
        yPos = y;
        alive = true;
        this.lives = lives;
    }
    
    public void setX(int x) {
        xPos = x;
    }
    
    public void setY(int y) {
        yPos = y;
    }
    
    public int getX() {
        return xPos;
    }
    
    public int getY() {
        return yPos;
    }
    
    public void kill(ActiveAgent other)
    {
        --other.lives;
        
        if (other.lives == 0)
            alive = false;
    }
}
