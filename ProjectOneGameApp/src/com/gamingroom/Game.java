package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 * @editor christian.tavares@snhu.edu||1/22/2023
 */
public class Game implements Container{
	/**
	 * A list of the active teams
	 */
	private static List<Entity> teams = new ArrayList<Entity>();
	private static long nextTeamId = 1;
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	
	//First you create a private object of our class
	private static Game instance = new Game();
	
	//Next we make a private constructor so it cannot be instantiated elsewhere
	private Game() {}
	
	//Finally we create a getInstance() function to allow access to the only available object
	public static Game getInstance() {
		return instance;
	}
	
	public Game(long Id, String name) {}

	/**
	 * The iterator functions and overrides for the class to utilize
	 */
	@Override
	public Iterator getIterator() { //our constructor for the iterator, which is the only public object
		return new GameIterator();
	}
	 
	private class GameIterator implements Iterator { //our iterator class that uses private functions
		int index;
	 
		@Override
		public boolean hasNext() {  //a function that checks if there is a next game in our list of teams
			if(index < getTeamCount()){
				return true;
			}
			return false;
		}
	 
		@Override
		public Object next() { //a function that will return the next game in our list as an Object
			if(this.hasNext()){
				return teams.get(index++);
			}
			return null;
		}	
	}
	
	public Entity addTeam (String name) {

		// a local game instance
		Entity team = null;

		// FIXME: Use iterator to look for existing team with same name
		// if found, simply return the existing instance
		Game game = new Game();
		for (Iterator iter = game.getIterator(); iter.hasNext();) {
			if (iter.next() == game.getTeam(name)) {
				team = game.getTeam(name);
			}
		}

		// if not found, make a new game instance and add to list of games
		if (team == null) {
			team = new Entity(nextTeamId++, name);
			teams.add(team);
		}

		// return the new/existing game instance to the caller
		return team;
	}
	
	Entity getTeam(int index){
		if (index < getTeamCount()) {
			return teams.get(index);
		}
		else {
			return null;
		}
	}
	
	public Entity getTeam(long id) {

		// a local game instance
		Entity team = null;
		Entity nextTeam = null;
		int i = 0;

		// FIXME: Use iterator to look for existing game with same index
		// if found, simply assign that instance to the local variable
		Game game = new Game();
		for (Iterator iter = game.getIterator(); iter.hasNext();) {
			nextTeam = (Entity)iter.next();
			if (nextTeam.getId() == id) {
				team = teams.get(i);
			}
			else {
			}
			i++;
		}

		return team;
	}
	
	public Entity getTeam(String name) {

		// a local game instance
		Entity team = null;
		Entity nextTeam = null;
		int i = 0;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Game game = new Game();
		for (Iterator iter = game.getIterator(); iter.hasNext();) {
			nextTeam = (Entity)iter.next();
			if (nextTeam.getName() == name) {
				team = teams.get(i);
			}
			else {
			}
			i++;
		}

		return team;
	}
	
	public long getNextTeamId() {
		return nextTeamId;
	}

	@Override
	public String toString() {
		
		return "Team [id=" + 1 + ", name=" + "insert name" + "]";
	}
	
	public int getTeamCount() {
		return teams.size();
	}

}
