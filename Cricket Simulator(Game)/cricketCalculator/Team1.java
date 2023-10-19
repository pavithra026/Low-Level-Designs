package cricketCalculator;

import java.util.ArrayList;

public class Team1 {

	String teamName;
	int inningsExtra;
	int totalWickets;
	int totalScore;
	
	ArrayList<String> batsman = new ArrayList<String>();
	ArrayList<String> bowler = new ArrayList<String>();
	
	ArrayList<Integer> batsmanScore = new ArrayList<Integer>();
	ArrayList<Integer> bowlerWickets = new ArrayList<Integer>();
	
	public void initializePlayerScore(){
		for(int v = 1; v <= batsman.size(); v++) {
			batsmanScore.add(0);
		}
		for(int w = 1; w <= bowler.size(); w++) {
			bowlerWickets.add(0);
		}
	}
	public void displayTeamStatistics() {
	    System.out.println(String.format("%-15s : %s", "Team Name", teamName));
	    System.out.println(String.format("%-15s : %s", "Total Score", totalScore));
	    System.out.println(String.format("%-15s : %s", "Total Wickets", totalWickets));
	    System.out.println(String.format("%-15s : %s", "Innings Extra", inningsExtra));
	    
	    System.out.println("\nBatsman Score Board :");
	    for (int i = 0; i < batsman.size(); i++) {
	        String batsmanInfo = String.format("%-10s : %d runs", batsman.get(i), batsmanScore.get(i));
	        System.out.println(batsmanInfo);
	    }
	    
	    System.out.println("\nBowlers Wicket Board :");
	    for (int j = 0; j < bowler.size(); j++) {
	        String bowlerInfo = String.format("%-10s : %d wickets", bowler.get(j), bowlerWickets.get(j));
	        System.out.println(bowlerInfo);
	    }
	    
	    System.out.println("\n--------------------------\n");
	}


}
