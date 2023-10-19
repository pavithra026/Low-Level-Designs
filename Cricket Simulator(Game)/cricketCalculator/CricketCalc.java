package cricketCalculator;
import java.util.*;
public class CricketCalc {
	
	Scanner sc = new Scanner(System.in);
	
	public void updateTeam1(String[] teamOnePlayers, Team1 teamOne) {
		teamOne.batsman.add(teamOnePlayers[0]);
		teamOne.batsman.add(teamOnePlayers[1]);
		teamOne.batsman.add(teamOnePlayers[2]);
		teamOne.bowler.add(teamOnePlayers[3]);
		teamOne.bowler.add(teamOnePlayers[4]);
	}
	
	public void updateTeam2(String[] teamTwoPlayers, Team2 teamTwo) {
		teamTwo.batsman.add(teamTwoPlayers[0]);
		teamTwo.batsman.add(teamTwoPlayers[1]);
		teamTwo.batsman.add(teamTwoPlayers[2]);
		teamTwo.bowler.add(teamTwoPlayers[3]);
		teamTwo.bowler.add(teamTwoPlayers[4]);
	}
	
	//--------------------------innings 1 begins--------------------------------->
	public int InningsOne(ArrayList<Integer> batsmanScore, ArrayList<Integer> bowlerWickets, Team1 t1, Team2 t2){
		int wickets = 0;
		int striker = 0, nonStriker = 1, nextBatsman = 2;
		int bowler = 0;
		int totalScore = 0;
		boolean flag = false;
		for(int over=1; over<=5; over++) {
			bowler = (over%2==0)? 1 : 0;
			System.out.println("Now Playing Over" + " " + over);
			for(int ball=0; ball<6;) {
				String run = sc.nextLine();
				if(run.equals("WI")) {
					bowlerWickets.set(bowler, bowlerWickets.get(bowler)+1);
					wickets++;
					if(wickets > 1) {
						System.out.println("\nWicket Out.Team Score : " + totalScore + "\n");
						flag = true;
						break;
					}
					striker = nonStriker;
					nonStriker = nextBatsman;
					nextBatsman = (nextBatsman + 1)%batsmanScore.size();
					
				}else if(run.equals("W") || run.equals("NB")){
					t1.inningsExtra++;
					totalScore++;
					continue;
				}else {
					batsmanScore.set(striker, batsmanScore.get(striker)+Integer.parseInt(run));
					totalScore += Integer.parseInt(run);
					
					if(Integer.parseInt(run)%2 == 1) {
						int temp = striker;
						striker = nonStriker;
						nonStriker = temp;
					}
				}
				ball++;	
			}
			if(flag) {
				break;
			}
			int temp = striker;
			striker = nonStriker;
			nonStriker = temp;
		}
		t1.totalScore = totalScore;
		t2.totalWickets = wickets;
		
		return totalScore;
	}
	//--------------------------innings 1 over--------------------------------->
	
	
	//--------------------------innings 2 begins--------------------------------->
	public int InningsTwo(ArrayList<Integer> batsmanScore, ArrayList<Integer> bowlerWickets, Team1 t1, Team2 t2, int TargetScore) {
		int wickets = 0;
		int striker = 0, nonStriker = 1, nextBatsman = 2;
		int bowler = 0;
		int totalScore = 0;
		boolean flag = false;
		for(int over=1; over<=5; over++) {
			bowler = (over%2==0)? 1 : 0;
			System.out.println("Now Playing Over" + " " + over);
			for(int ball=0; ball<6;) {
				if(totalScore >= TargetScore) {
					System.out.println("\nReached the target Score. Team Score : " + totalScore + "\n");
					flag = true;
					break;
				}
				String run = sc.nextLine();
				if(run.equals("WI")) {
					bowlerWickets.set(bowler, bowlerWickets.get(bowler)+1);
					wickets++;
					if(wickets > 1) {
						System.out.println("\nWicket Out. Team Score : " + totalScore + "\n");
						flag = true;
						break;
					}
					striker = nonStriker;
					nonStriker = nextBatsman;
					nextBatsman = (nextBatsman + 1)%batsmanScore.size();
					
				}else if(run.equals("W") || run.equals("NB")){
					t2.inningsExtra++;
					totalScore++;
					continue;
				}else {
					batsmanScore.set(striker, batsmanScore.get(striker)+Integer.parseInt(run));
					totalScore += Integer.parseInt(run);
					
					if(Integer.parseInt(run)%2 == 1) {
						int temp = striker;
						striker = nonStriker;
						nonStriker = temp;
					}
				}
				ball++;	
			}
			if(flag) {
				break;
			}
			int temp = striker;
			striker = nonStriker;
			nonStriker = temp;			
		}	
		t2.totalScore = totalScore;
		t1.totalWickets = wickets;
		
		return totalScore;
	}
	//--------------------------innings 2 play over--------------------------------->
	
} 
