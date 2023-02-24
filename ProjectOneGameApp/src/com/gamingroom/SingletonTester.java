package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 * @editor christian.tavares@snhu.edu||1/22/2023
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// FIXME: obtain local reference to the singleton instance
		GameService service = GameService.getInstance(); // replace null with ???
		Game team = Game.getInstance();
		Team player = Team.getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}
		
		// a simple loop to print out the teams
		for (int i = 0; i < team.getTeamCount(); i++) {
			System.out.println(team.getTeam(i));
		}
		
		// a simple loop to print out the players
		for (int i = 0; i < player.getPlayerCount(); i++) {
			System.out.println(player.getPlayer(i));
		}
		
		//Some test code to test the iterator in getGame() functions
		System.out.println("\nAbout to test the iterator for getGame(String)...");
		System.out.println(service.getGame("Game #1"));
		System.out.println(service.getGame("Game #2"));
		System.out.println(service.getGame("TestFail"));
		
		//Some more test code to test the getGame() function for calling by index
		System.out.println("\nAbout to test the iterator for getGame(long)...");
		System.out.println(service.getGame(0));
		System.out.println(service.getGame(1));
		System.out.println(service.getGame(15));
		
		//Some test code to test the iterator in getTeam() functions
		System.out.println("\nAbout to test the iterator for getTeam(String)...");
		System.out.println(team.getTeam("Team #1"));
		System.out.println(team.getTeam("Team #2"));
		System.out.println(team.getTeam("TestFail"));
		
		//Some more test code to test the getTeam() function for calling by index
		System.out.println("\nAbout to test the iterator for getTeam(long)...");
		System.out.println(team.getTeam(0));
		System.out.println(team.getTeam(1));
		System.out.println(team.getTeam(15));
		
		//Some test code to test the iterator in getPlayer() functions
		System.out.println("\nAbout to test the iterator for getPlayer(String)...");
		System.out.println(player.getPlayer("John"));
		System.out.println(player.getPlayer("Rachel"));
		System.out.println(player.getPlayer("Aaron"));
		System.out.println(player.getPlayer("Lidia"));
		System.out.println(player.getPlayer("TestFail"));
		
		//Some more test code to test the getPlayer() function for calling by index
		System.out.println("\nAbout to test the iterator for getPlayer(long)...");
		System.out.println(player.getPlayer(0));
		System.out.println(player.getPlayer(1));
		System.out.println(player.getPlayer(2));
		System.out.println(player.getPlayer(3));
		System.out.println(player.getPlayer(15));
	}
}
