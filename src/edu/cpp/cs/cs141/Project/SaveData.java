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

/**
 * @author ginar
 *
 */
import java.io.*;

public class SaveData {

	/**
	 * 
	 */
        private Board board;
        private int lives;
        private boolean foundBriefcase;
        private boolean debug;
        
	public SaveData() {
		// TODO Auto-generated constructor stub
                // default values for fields
                board = null;
                lives = 0;
                foundBriefcase = false;
	}
        
        public void save(Board board, int lives, boolean found, boolean debug, String fname) throws IOException
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(System.getProperty("user.dir") + "/memorycard/" + fname + ".dat")
            );
            this.board = board;
            this.lives = lives;
            foundBriefcase = found;
            this.debug = debug;
            oos.writeObject(this.board);
            oos.writeInt(this.lives);
            oos.writeBoolean(this.foundBriefcase);
            oos.writeBoolean(this.debug);
            oos.close();
        }
        
        public void load(String fname) throws IOException, ClassNotFoundException
        {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "/memorycard/" + fname + ".dat")
            );
            this.board = (Board)ois.readObject();
            this.lives = ois.readInt();
            this.foundBriefcase = ois.readBoolean();
            this.debug = ois.readBoolean();
            ois.close();
        }
        
        public Board getBoard()
        {
            return board;
        }
        
        public int getLives()
        {
            return lives;
        }
        
        public boolean getFoundBriefcase()
        {
            return foundBriefcase;
        }
        
        public boolean getDebugMode()
        {
            return debug;
        }
}
