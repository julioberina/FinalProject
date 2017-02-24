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
import java.util.Random;

/**
 * @author AlternativeFAQs
 *
 */
public class Board {

	/**
	 * A field that represents the length and width of the building. It is a set
	 * number.
	 */
	private final int size = 9;

	/**
	 * Local variable that stores which room has the briefcase in it
	 */
	private int briefcaseRoomNum;

	/**
	 * A field that represents an ArrayList containing all the ninjas that are
	 * on the board. If an assassin dies, the ArrayList decreases by one
	 * element.
	 */
	private ArrayList<Assassin> ninjas = new ArrayList<Assassin>();

	/**
	 * Creates a list of rooms. Later converts to an array to get individual
	 * rooms
	 */
	private ArrayList<Room> room = new ArrayList<Room>();

        private Agent agent;
	private Item invc;
	private Item radar;
	private Item extraBull;

	/**
	 * A field that represents a 2-dimensional array of the building. It holds
	 * characters that represent what is located at each element of the array (A
	 * room, ninja, power-up, spy, etc.)
	 */
	private char[][] bldg = new char[size][size];

	/**
	 * The default constructor for the class Board. Initially the building
	 * contains the user starting at the bottom left corner and 6 ninjas placed
	 * randomly throughout the building, but at least 3 units away from the spy.
	 * The initial position of the spy starts at the origin on the bottom left
	 * hand side of the board.
	 */
	public Board() {


		initializeRooms();
		
		initializeNinjas();

		createInvincibility();
		
		createRadar();
		
		createBullet();
		
		agent = new Agent();
		for (int row=8; row >= 0 ; row-- ){
			for (int column = 0; column < size; column++){					
				if (row == agent.getX() && column == agent.getY())
					bldg[row][column] = 'A';
				else if (AssassinCoord(row,column))
					bldg[row][column] = 'N';
				else if (row == getInvcX() && column == getInvcY())
					bldg[row][column] = 'I';
				else if (row == getBulletX() && column == getBulletY())
					bldg[row][column] = 'B';
				else if (row == getRadarX() && column == getRadarY())
					bldg[row][column] = 'G';
				else if (validBriefcaseCoords(row,column))
					bldg[row][column] = 'D';
				else if (validRoomCoords(row,column))
					bldg[row][column] = 'R';
				else 
					bldg[row][column] = ' ';	
			}
		}
		
	}
	
	private void initializeNinjas(){
		Assassin[] spyArray = (Assassin[]) ninjas.toArray(new Assassin[6]);
		Room[] roomArray = (Room[]) room.toArray(new Room[6]);
		int ninjaX = 0;
		int ninjaY = 0;
		
		for (int i = 0; i < 6; ++i) {
			boolean validSpyCheck = false;
			boolean validRoomCheck = false;

			while (validRoomCheck == false || validSpyCheck == false) {
				validRoomCheck = false;
				validSpyCheck = false;
				int x = 0;
				int y = 0;
				while (x + y <= 3) {
					x = randomGen(0, 9);
					y = randomGen(0, 9);
				}
				ninjaX = x;
				ninjaY = y;
				for (int j = 0; j < 9; ++j) {
					if ((x == roomArray[j].getX()) && (y == roomArray[j].getY())) {
						break;
					} else if (j == 8) {
						validRoomCheck = true;
					}
				}
				for (int j = 0; j <= i; ++j) {
					if (j == i) {
						validSpyCheck = true;
					} else if (x == spyArray[j].getX() && y == spyArray[j].getY()) {
						validSpyCheck = false;
						break;
					}
				}
			}

			spyArray[i] = new Assassin(ninjaX, ninjaY);
		}
		for (int i = 0; i < 6; i++) {
			ninjas.add(spyArray[i]);
		}
	}
	
	private void initializeRooms(){
		briefcaseRoomNum = randomGen(9);
		room.add(new Room(1, 1));
		room.add(new Room(4, 1));
		room.add(new Room(7, 1));
		room.add(new Room(1, 4));
		room.add(new Room(4, 4));
		room.add(new Room(7, 4));
		room.add(new Room(1, 7));
		room.add(new Room(4, 7));
		room.add(new Room(7, 7));
		room.get(briefcaseRoomNum).setBriefcase();
	}
	
	private void createInvincibility(){
		boolean validRoomCheck = false;
		int itemX = 0;
		int itemY = 0;
		Room[] roomArray = (Room[]) room.toArray(new Room[6]);
		while (validRoomCheck == false) {
			validRoomCheck = false;
			int x = randomGen(1, 9);
			int y = randomGen(1, 9);
			itemX = x;
			itemY = y;
			for (int j = 0; j < 9; ++j) {
				if ((x == roomArray[j].getX()) && (y == roomArray[j].getY())) {
					break;
				} else if (j == 8) {
					validRoomCheck = true;
				}
			}
		}
		invc = new Invincibility(itemX, itemY);
	}

	private void createRadar() {
		boolean validRoomCheck = false;
		int itemX = 0;
		int itemY = 0;
		Room[] roomArray = (Room[]) room.toArray(new Room[6]);
		while (validRoomCheck == false) {
			validRoomCheck = false;
			int x = randomGen(1, 9);
			int y = randomGen(1, 9);
			itemX = x;
			itemY = y;
			for (int j = 0; j < 9; ++j) {
				if ((x == roomArray[j].getX()) && (y == roomArray[j].getY())) {
					break;
				} else if (j == 8) {
					validRoomCheck = true;
				}
			}
		}
		radar = new Radar(itemX, itemY);
	}

	private void createBullet() {
		Room[] roomArray = (Room[]) room.toArray(new Room[6]);
		boolean validRoomCheck = false;
		int itemX = 0;
		int itemY = 0;
		while (validRoomCheck == false) {
			validRoomCheck = false;
			int x = randomGen(1, 9);
			int y = randomGen(1, 9);
			itemX = x;
			itemY = y;
			for (int j = 0; j < 9; ++j) {
				if ((x == roomArray[j].getX()) && (y == roomArray[j].getY())) {
					break;
				} else if (j == 8) {
					validRoomCheck = true;
				}
			}
		}
		extraBull = new ExtraBullet(itemX, itemY);
	}

	/**
	 * A method that will pick up whatever item the user has landed on at a
	 * given location.
	 * 
	 * @param i
	 *            - The row number of the location
	 * @param j
	 *            - The column number of the location
	 * @return - The Item in that location
	 */
	public Item getItem(int i, int j) {
		return null;
	}

	/**
	 * A method that relays whether the user found the briefcase or not
	 * 
	 * @return - A boolean that is true if the player reached the correct room,
	 *         or false if not.
	 */
	public boolean briefcaseFound() {
		return false;
	}

	/**
	 * @param max
	 *            The maximum bound of the return value The max value you want
	 *            selected. For example, if you want to pick from numbers 1
	 *            through 9, you enter 9. The output ends up being 0 through 8,
	 *            but the odds are still the same.
	 * @return the random selected number within the bounds.
	 */
	private int randomGen(int max) {
		Random rand = new Random();
		return rand.nextInt(max);
	}

	/**
	 * @param min
	 *            minimum bound to be returned
	 * @param max
	 *            max bound to be returned
	 * @return The randomly generated value between the bounds Overrides
	 *         randomGen(int)
	 */
	private int randomGen(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}

	/**
	 * @param x
	 *            x Coord
	 * @param y
	 *            y Coord
	 * @return A check to see if the input coords match with the assasin coords
	 *         to out put them
	 */
	public boolean AssassinCoord(int x, int y) {
		Assassin[] spyArray = (Assassin[]) ninjas.toArray(new Assassin[6]);
		boolean valid = false;
		for (int i = 0; i < 6; ++i) {
			if (x == spyArray[i].getX() && y == spyArray[i].getY()) {
				valid = true;
				break;
			}
		}
		return valid;
	}

	/**
	 * @param x
	 *            x coord
	 * @param y
	 *            y coord
	 * @return whether or not a room has a briefcase called from the user
	 *         interface to check whether a room has a briefcase.
	 */
	public boolean validBriefcaseCoords(int x, int y) {
		int counter = 0;
		for (int i = 1 ; i < 8 ; i += 3){
			for (int j = 1 ; j < 8 ; j+=3 ){
				if ( x==i && y==j && briefcaseRoomNum == counter)
					return true;
				counter++;
			}
		}
		return false;
	}

	/**
	 * @param x
	 *            x coord
	 * @param y
	 *            y coord
	 * @return whether or not a coord is a room or not call traces back to the
	 *         print board call.
	 */
	public boolean validRoomCoords(int x, int y) {
				int counter = 0;
		for (int i = 1 ; i < 8 ; i += 3){
			for (int j = 1 ; j < 8 ; j+=3 ){
				if ( x==i && y==j && briefcaseRoomNum != counter)
					return true;
				counter++;
			}
		}
		return false;
	}

	public int getInvcX() {
		return invc.getX();
	}

	public int getInvcY() {
		return invc.getY();
	}

	public int getBulletX() {
		return extraBull.getX();
	}

	public int getBulletY() {
		return extraBull.getY();
	}

	public int getRadarX() {
		return radar.getX();
	}

	public int getRadarY() {
		return radar.getY();
	}
	
	public String toString(){
		String type = "";
		for (int j=8 ; j>=0 ; j--){
			for (int i=0 ; i<size ; i++){	
				type = type + "[" + bldg[i][j] + "]";				
			}
			type += "\n";
		}
		return type;
	}
	
	public void ninjaMove() {
		Assassin[] spyArray = (Assassin[]) ninjas.toArray(new Assassin[6]);
		for(int i = 0; i < 6; i++){
			spyArray[i].move();
		}
	}

}
