package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 * @editor christian.tavares@snhu.edu||1/22/2023
 */
public class GameService implements Container{

	//First you create a private object of our class
	private static GameService instance = new GameService();
	
	//Next we make a private constructor so it cannot be instantiated elsewhere
	private GameService() {}
	
	//Finally we create a getInstance() function to allow access to the only available object
	public static GameService getInstance() {
		return instance;
	}
	
	/**
	 * A list of the active games, and the next Id of our entity objects
	 */
	private static List<Entity> games = new ArrayList<>();
	private static long nextGameId = 1;
	
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
		public boolean hasNext() {  //a function that checks if there is a next game in our list of games
			if(index < getGameCount()){
				return true;
			}
			return false;
		}
	 
		@Override
		public Object next() { //a function that will return the next game in our list as an Object
			if(this.hasNext()){
				return games.get(index++);
			}
			return null;
		}	
	}

	/*
	 * Holds the next game identifier
	 */

	/**
	 * Construct a new game instance. This function will use the iterator to compare strings.
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Entity addGame (String name) {

		// a local game instance
		Entity game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		GameService gameService = new GameService();
		for (Iterator iter = gameService.getIterator(); iter.hasNext();) {
			if (iter.next() == gameService.getGame(name)) {
				game = gameService.getGame(name);
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Entity(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}
	/**
	 * Returns the game instance at the specified index. 
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Entity getGame(int index){
		if (index < getGameCount()) {
			return games.get(index);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Returns the game instance with the specified id. This function will use the iterator to compare IDs.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Entity getGame(long id) {

		// a local game instance
		Entity game = null;
		Entity nextGame = null;
		int i = 0;

		// FIXME: Use iterator to look for existing game with same index
		// if found, simply assign that instance to the local variable
		GameService gameService = new GameService();
		for (Iterator iter = gameService.getIterator(); iter.hasNext();) {
			nextGame = (Entity)iter.next();
			if (nextGame.getId() == id) {
				game = games.get(i);
			}
			else {
			}
			i++;
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name. This function will use the iterator to compare strings.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Entity getGame(String name) {

		// a local game instance
		Entity game = null;
		Entity nextGame = null;
		int i = 0;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		GameService gameService = new GameService();
		for (Iterator iter = gameService.getIterator(); iter.hasNext();) {
			nextGame = (Entity)iter.next();
			if (nextGame.getName() == name) {
				game = games.get(i);
			}
			else {
			}
			i++;
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
