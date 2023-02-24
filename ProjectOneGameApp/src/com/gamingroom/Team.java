package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 * @editor christian.tavares@snhu.edu||1/22/2023
 */
public class Team implements Container{
	
	/**
	 * A list of the active players
	 */
	private static List<Entity> players = new ArrayList<Entity>();
	private static long nextPlayerId = 1;
	
	//First you create a private object of our class
	private static Team instance = new Team();
	
	//Next we make a private constructor so it cannot be instantiated elsewhere
	private Team() {}
	
	//Finally we create a getInstance() function to allow access to the only available object
	public static Team getInstance() {
		return instance;
	}

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
			if(index < getPlayerCount()){
				return true;
			}
			return false;
		}
	 
		@Override
		public Object next() { //a function that will return the next game in our list as an Object
			if(this.hasNext()){
				return players.get(index++);
			}
			return null;
		}	
	}
	
	public Entity addPlayer (String name) {

		// a local game instance
		Entity player = null;

		// FIXME: Use iterator to look for existing team with same name
		// if found, simply return the existing instance
		Team team = new Team();
		for (Iterator iter = team.getIterator(); iter.hasNext();) {
			if (iter.next() == team.getPlayer(name)) {
				player = team.getPlayer(name);
			}
		}

		// if not found, make a new game instance and add to list of games
		if (player == null) {
			player = new Entity(nextPlayerId++, name);
			players.add(player);
		}

		// return the new/existing game instance to the caller
		return player;
	}
	
	Entity getPlayer(int index){
		if (index < getPlayerCount()) {
			return players.get(index);
		}
		else {
			return null;
		}
	}
	
	public Entity getPlayer(long id) {

		// a local game instance
		Entity player = null;
		Entity nextPlayer = null;
		int i = 0;

		// FIXME: Use iterator to look for existing game with same index
		// if found, simply assign that instance to the local variable
		Team team = new Team();
		for (Iterator iter = team.getIterator(); iter.hasNext();) {
			nextPlayer = (Entity)iter.next();
			if (nextPlayer.getId() == id) {
				player = players.get(i);
			}
			else {
			}
			i++;
		}

		return player;
	}
	
	public Entity getPlayer(String name) {

		// a local game instance
		Entity player = null;
		Entity nextPlayer = null;
		int i = 0;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Team team = new Team();
		for (Iterator iter = team.getIterator(); iter.hasNext();) {
			nextPlayer = (Entity)iter.next();
			if (nextPlayer.getName() == name) {
				player = players.get(i);
			}
			else {
			}
			i++;
		}

		return player;
	}
	
	/**
	 * Constructor with an identifier and name
	 */

	/**
	 * @return the id
	 */

	/**
	 * @return the name
	 */
	
	public long getNextPlayerId() {
		return nextPlayerId;
	}

	@Override
	public String toString() {
		return "Team [id=" + 1 + ", name=" + "insert name" + "]";
	}
	
	public int getPlayerCount() {
		return players.size();
	}
}
