package com.gamingroom;

/**
 * A simple class to hold information about a game.
 * This class is inherited by Game.java, Player.java and Team.java
 * 
 * @author christian.tavares@snhu.edu||1/21/2023
 */
public class Entity {
	
	private long id;
	private String name;
	
	//Next we make a private constructor so it cannot be instantiated elsewhere
	private Entity() {}
	
	/**
	 * Constructor with an identifier and name
	 */
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}
}
