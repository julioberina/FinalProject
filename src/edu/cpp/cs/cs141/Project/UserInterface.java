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

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

/**
 * @author AlternativeFAQs
 *
 */
public class UserInterface {

	/**
	 * A field that is used to run the game engine
	 */
	private GameEngine eng;
	
	/**
	 * A field that is used to grab user input.
	 */
	private Scanner keyboard;
	
	public static enum DIRECTION {UP,DOWN,LEFT,RIGHT};
	
	/**
	 * The default constructor for the class UserInterface. A new user interface begins with a new default game engine where
	 * all the statistics and data are set to default (0 lives, a new random board, 6 randomly located ninjas).
	 */
	public UserInterface() {
		keyboard = new Scanner(System.in);
		eng = new GameEngine();
	}
	
	/**
	 * A method that displays the games overall menu. It will give the user the option to start, save, or load a game, and
	 * give them the option to see the help screen.
	 */
	public void displayMenu() throws IOException, ClassNotFoundException {
		String choice, filename;
		
		System.out.println("Welcome, Agent Smith. We have a new assignment for you.\n "
				+ "Retrieve the briefcase with classified documents hidden in one of the 9 rooms.\n "
				+ "You may only see two squares ahead of you, and watch out for ninja assassins.");
		System.out.print("\nStart New Game - N"
				+ "\nDebug Mode - D \t\t\tHelp - H"
				+ "\nLoad Prevous Game - L \t\tQuit - Q (Press at any time)\t");
		choice = keyboard.nextLine();
		
		if (choice.equalsIgnoreCase("H")){
			displayHelp();
		}
		else if (choice.equalsIgnoreCase("D")){
			while (eng.getLives()>0 && !eng.briefcaseFound()){
				gameLoopDebug();
			}
			if (eng.getLives()==0)
				System.out.println("\n\nMission Failed");
			else if (eng.briefcaseFound())
				System.out.println("\n\nMission Accomplished.");
		}
		else if (choice.equalsIgnoreCase("L")){
			loadGame();
		}
		else if (choice.equalsIgnoreCase("N")){
			gameLoop();
		}
		else if (choice.equalsIgnoreCase("Q")){
			System.out.println("\nGood Bye.");
			System.exit(0);
		}
		else System.out.println("\nInvalid Choice Entered. Mission Aborted.");
		
	}
	
	/**
	 * A method that displays what the grid of the building with the lights off
	 */
	public void displayBoard(){
		String[] legend = new String[]{"","I - Invincibility","R - Radar","B - Bullet",
				"D - Look/Move Right", "A - Look/Move Left","S - Look/Move Down","W - Look/Move Up",""};
		System.out.println();
		for (int j = 8; j >= 0; --j) {
			for (int i = 0; i < 9; ++i) {
				if (i == eng.getAgentX() && j == eng.getAgentY()) 
					System.out.print("[A]");
				else if (eng.validRoomCoords(i, j) || eng.validBriefcaseCoords(i, j)) 
					System.out.print("[R]");
				else 
					System.out.print("[*]");
			}
			System.out.println("\t\t" + legend[j]);
		}
	}
	
	
	
	public void displayBoardDebug() {
		String[] legend = new String[]{"","I - Invincibility","G - Goggles/Radar","R - Room","D - Documents","B - Bullet",
				"N - Ninja Assassin","A - Agent/Player",""};
		System.out.println();
		for (int j = 8; j >= 0; --j) {
			for (int i = 0; i < 9; ++i) {
				if (i == eng.getAgentX() && j == eng.getAgentY()) {
					System.out.print("[A]");
				} else if (eng.AssassinCoord(i, j)) {
					System.out.print("[N]");
				} else if (i == eng.getInvcX() && j == eng.getInvcY()) {
					System.out.print("[I]");
				} else if (i == eng.getBulletX() && j == eng.getBulletY()) {
					System.out.print("[B]");
				} else if (i == eng.getRadarX() && j == eng.getRadarY()) {
					System.out.print("[G]");//G for goggles
				} else if (eng.validBriefcaseCoords(i, j)) {
					System.out.print("[D]");//D for documents, to prevent conflicts with bullet
				} else if (eng.validRoomCoords(i, j)) {
					System.out.print("[R]");
				} else {
					System.out.print("[ ]");
				}
			}
			System.out.println("\t\t" + legend[j]);
		}
	}
	
	/**
	 * A method that will display the building with the next two units lit up in the direction that the user requested
	 */
	public void displayNextTwo(DIRECTION dir){
		String[] legend = new String[]{"","I - Invincibility","R - Radar","B - Bullet",
				"D - Look/Move Right", "A - Look/Move Left","S - Look/Move Down","W - Look/Move Up",""};
		
		System.out.println();
		for (int j = 8; j >= 0; --j) {
			for (int i = 0; i < 9; ++i) {
				if (i == eng.getAgentX() && j == eng.getAgentY()) 
					System.out.print("[A]");
				else if (eng.validRoomCoords(i, j) || eng.validBriefcaseCoords(i, j)) 
					System.out.print("[R]");
				else if (dir == DIRECTION.UP && i == eng.getAgentX() && (j == eng.getAgentY()+2 || j == eng.getAgentY()+1))
					System.out.print("[" + eng.getBoard().viewSpace(i, j) + "]");				
				else if (dir == DIRECTION.DOWN && i == eng.getAgentX() && (j == eng.getAgentY()-2 || j == eng.getAgentY()-1))
					System.out.print("[" + eng.getBoard().viewSpace(i, j) + "]");	
				else if (dir == DIRECTION.LEFT && j == eng.getAgentY() && (i == eng.getAgentX()-2 || i == eng.getAgentX()-1))
					System.out.print("[" + eng.getBoard().viewSpace(i, j) + "]");	
				else if (dir == DIRECTION.RIGHT && j == eng.getAgentY() && (i == eng.getAgentX()+2 || i == eng.getAgentX()+1))
					System.out.print("[" + eng.getBoard().viewSpace(i, j) + "]");	
				else 
					System.out.print("[*]");
			}
			System.out.println("\t\t" + legend[j]);
		}
	}
	
	/**
	 * A method that will continually ask the user to take their turn until they run out of lives or choose to quit the game
	 */
	public void gameLoop(){
        eng.setDebugMode(false);
        while (eng.getAgent().isAlive()) {
        	displayBoard();
            displayNextTwo(lookDirection());
            switch (getDirection()){
            case UP:{
            	if (eng.movedUp())
            		eng.useItem();
            	else System.out.println("Unable to move.");
            	break;}
            case DOWN:{
            	if (eng.checkRoom())
            		break;
            	if (eng.movedDown())
            		eng.useItem();
            	else System.out.println("Unable to move.");
            	break;}
            case LEFT:{
            	if (eng.movedLeft())
            		eng.useItem();
            	else System.out.println("Unable to move.");           	
            	break;}
            case RIGHT:{
            	if (eng.movedRight())
            		eng.useItem();
            	else System.out.println("Unable to move.");
            	break;}
            }
            if (eng.briefcaseFound())
            	break;
            eng.getBoard().ninjaMove();
            if (eng.checkForKill()){
            	eng.loseLife();
            	System.out.println("\n\nA ninja killed you!\n\n");
            	eng.startOver();
            	break;
            }
        }
	}
	
	/**
	 * A method that will continually ask the user to take their turn until they run out of lives or choose to quit the game
	 */
	public void gameLoopDebug(){
            eng.setDebugMode(true);
        while (eng.getAgent().isAlive()) {
        	displayBoardDebug();
            switch (getDirection()){
            case UP:{
            	if (eng.getAgent().move('w')) 
            		eng.getAgent().setY(eng.getAgentY()+1);
            	else System.out.println("Unable to move.");
            	break;}
            case DOWN:{
            	if (eng.checkRoom())
            		break;
            	if (eng.getAgent().move('s')) 
            		eng.getAgent().setY(eng.getAgentY()-1);
            	else System.out.println("Unable to move.");
            	break;}
            case LEFT:{
            	if (eng.getAgent().move('a')) 
            		eng.getAgent().setX(eng.getAgentX()-1);
            	else System.out.println("Unable to move.");           	
            	break;}
            case RIGHT:{
            	if (eng.getAgent().move('d')) 
            		eng.getAgent().setX(eng.getAgentX()+1);
            	else System.out.println("Unable to move.");
            	break;}
            }
            if (eng.briefcaseFound())
            	break;
            eng.getBoard().ninjaMove();
            if (eng.checkForKill()){
            	eng.loseLife();
            	System.out.println("\n\nA ninja killed you!\n\n");
            	eng.startOver();
            	break;
            }
        }
	}
	
	/**
	 * @return
	 */
	public DIRECTION getDirection(){
		String choice="";
		DIRECTION dir = null;
        boolean choiceMade = false;
		while (choiceMade == false) {
    		System.out.print("\nChoose direction to move (W-Up, A-Left, S-Down, D-Right): \t");
    		choice = keyboard.nextLine();
    		if (choice.equalsIgnoreCase("w") && eng.getAgentY() < 8) {
    			dir = DIRECTION.UP;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("a") && eng.getAgentX() > 0) {
    			dir = DIRECTION.LEFT;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("s") && eng.getAgentY() > 0) {
    			dir = DIRECTION.DOWN;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("d") && eng.getAgentX() < 8) {
    			dir = DIRECTION.RIGHT;
               	choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("q"))
    			System.exit(0);
    		else System.out.println("Not a valid move. Try again.");
		}
		return dir;
	}

	
	public DIRECTION lookDirection(){
		String choice="";
        boolean choiceMade = false;
		DIRECTION dir = null;
		while (choiceMade == false) {
    		System.out.print("\nChoose direction to look (W-Up, A-Left, S-Down, D-Right): \t");
    		choice = keyboard.nextLine();
    		if (choice.equalsIgnoreCase("w") && eng.getAgentY() < 8) {
    			dir = DIRECTION.UP;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("a") && eng.getAgentX() > 0) {
    			dir = DIRECTION.LEFT;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("s") && eng.getAgentY() > 0) {
    			dir = DIRECTION.DOWN;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("d") && eng.getAgentX() < 8) {
    			dir = DIRECTION.RIGHT;
                choiceMade = true;
                }
    		else if (choice.equalsIgnoreCase("q"))
    			System.exit(0);
    		else System.out.println("Not a valid move. Try again.");
		}
		return dir;
	}
	
	
	public void displayHelp(){
		String info, displaytext = "";
		info = "\n\n   Inside this building is a briefcase full of classified documents. "
			+ "You are to retrieve these documents from one of the 9 rooms without getting caught. "
			+ "There are 6 ninja assassins throughout the building that will kill you if they are immediately next to you. "
			+ "You may kill them but you can only carry one bullet at all times. "
			+ "The building is pitch black, but you will be equipped with "
			+ "night vision goggles that allow you to see two units ahead of you in the direction of your choice. "
			+ "Rooms may only be entered from the north side."
			+ "You have 3 tries to get the briefcase, and may be able to find other items lying around the building "
			+ "to help you with your mission. A Radar will give you the exact location of the briefcase, a Bullet "
			+ "will equip you with another bullet if you do not already have one, and invincibility will make you "
			+ "invulnerable from the ninjas for 5 turns. For each turn, you will first choose the direction you "
			+ "want to look in, then choose which of the adjacent units you would like to move to. Each ninja assassin will"
			+ "also move one adjacent unit after your turn. Good luck.";
		int counter = 0;
		for (int i = 0 ; i < info.length(); i++ ){
			counter++;	
			displaytext = displaytext + info.charAt(i);
			if (counter==120){
				System.out.println(displaytext);
				displaytext = "";
				counter=0;
			}
		}
		System.out.println(displaytext);
		displayBoardDebug();
	}

	/**
	 * A method that will allow the user to quit their current game and save their progress to a specified file location.
	 * This will ask the user for the location to save the game and copy all the data of the current state of the game from
	 * the game engine.  
	 */
	public void saveGame() throws IOException {
		String save, filename = "";
                SaveData sd = new SaveData();
		
		System.out.println("Are you sure you would like to quit this game and save? (Y/N)");
		save = keyboard.nextLine();
		if (save.equalsIgnoreCase("Y") || save.equalsIgnoreCase("YES")){
			
                        while (filename.length() == 0) {
                            System.out.println("Enter the save file name (no file extension):  ");
                            filename = keyboard.nextLine();
                        }
                        
                        sd.save(eng.getBoard(), eng.getLives(), eng.briefcaseFound(), eng.getDebugMode(), filename);
		}
	}
	
	/**
	 * A method that will allow the user to load a previous game that was saved to a file. This method will ask for the 
	 * user to input the file location, and check to make sure it is a valid file. From the file it will load all the data
	 * from the previous game engine. 
	 * @return - The class GameEngine with previous data and statistics from an older game.
	 */
	public void loadGame() throws IOException, ClassNotFoundException {
                File saveFolder = new File("memorycard/");
                File[] saveFiles = saveFolder.listFiles();
		String filename = "";
                SaveData sd = new SaveData();                
                
                
                System.out.println("Here is a list of save files: ");
                for (int i = 0; i < saveFiles.length; ++i)
                    System.out.println(saveFiles[i]);
                
                System.out.print("\n");
                
                while (filename.length() == 0) {
                    System.out.print("Enter file to load (no file extension):  ");
                    filename = keyboard.nextLine();
                }
                
		//Call method from SaveData
                sd.load(filename);
		eng.loadBoard(sd.getBoard());
                eng.loadLives(sd.getLives());
                eng.loadFoundBriefcase(sd.getFoundBriefcase());
                eng.setDebugMode(sd.getDebugMode());
	}
	
}
