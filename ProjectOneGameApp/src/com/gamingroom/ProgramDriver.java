package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 * @editor christian.tavares@snhu.edu||1/22/2023
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getInstance(); // replace null with ???
		Game team = Game.getInstance();
		Team player = Team.getInstance();
		
		//This constructor cannot work because of line 17 in GameService.java, which is private
		//GameService newService = new GameService();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Entity game1 = service.addGame("Game #1");
		Entity team1 = team.addTeam("Team #1");
		Entity team2 = team.addTeam("Team #2");
		Entity player1 = player.addPlayer("John");
		Entity player2 = player.addPlayer("Rachel");
		Entity player3 = player.addPlayer("Aaron");
		Entity player4 = player.addPlayer("Lidia");
		System.out.println(game1);
		System.out.println(team1);
		System.out.println(team2);
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		
		Entity game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		//test code to see what happens if you create a game with an existing name
		Entity game3 = service.addGame("Game #1");
		System.out.println(game3);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
