package cricketCalculator;
import java.util.*;
public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the team names seperated by comma :");
		String[] teams = sc.nextLine().split(",");
		System.out.println("Enter the team 1 Player names [3 batsman 2 bowlers] seperated by comma :");
		String[] teamOnePlayers = sc.nextLine().split(",");
		System.out.println("Enter the team 2 Player names [3 batsman 2 bowlers] seperated by comma :");
		String[] teamTwoPlayers = sc.nextLine().split(",");
		

		Team1 t1 = new Team1();
		t1.teamName = teams[0];

		Team2 t2 = new Team2();
		t2.teamName = teams[1];
		
		CricketCalc calc = new CricketCalc();
		calc.updateTeam1(teamOnePlayers,t1);
		calc.updateTeam2(teamTwoPlayers,t2);

		
		t1.initializePlayerScore();
		t2.initializePlayerScore();
		
		System.out.println("Enter 6 runs (W-wide | NB-No ball | WI-wicket)");
		System.out.println("\nYour Innings 1 has Started!\n");
		
		//Innings 1------------------->
		int target = calc.InningsOne(t1.batsmanScore, t2.bowlerWickets, t1, t2);
		
		//Innings 2------------------->
		System.out.println("Your Innings 2 has Started!");
		int Score = calc.InningsTwo(t2.batsmanScore, t1.bowlerWickets, t1, t2, target);
		
		System.out.println("------------------MATCH RESULT DISPLAY-----------------------");
		if(Score >= target) {
			System.out.println(t2.teamName + " has won the Match.\n");
		}else if(Score < target){
			System.out.println(t1.teamName + " has won the Match.\n" );
		}
		sc.close();
		//Score Board---------------->
		System.out.println("DISPLAYING TEAM STATISTICS :\n");
		t1.displayTeamStatistics();
		t2.displayTeamStatistics();
	
		
		
		
	}
	
	
	
}
