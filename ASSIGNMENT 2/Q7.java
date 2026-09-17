import java.util.*;

abstract class Team {
    String name;
    int matchesPlayed, wins, draws, points;

        public Team(String name, int matchesPlayed, int wins, int draws) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.wins = wins;
            this.draws = draws;
        }

    int calculatePoints(){
        return 0;
    }
}

class CricketTeam extends Team
{
    public CricketTeam(String name, int matchesPlayed, int wins, int draws)
    {
        super(name, matchesPlayed, wins, draws);
    }

    @Override 
    int calculatePoints()
    {
        return (wins*2)+draws;
    }
}

class FootballTeam extends Team
{
    public FootballTeam(String name, int matchesPlayed, int wins, int draws){
        super(name, matchesPlayed, wins, draws);
    }

    @Override 
    int calculatePoints()
    {
       return (wins*3)+draws;
    }

    @Override 
    public String toString(){
        return "Team: " + name + "(Football) Points: " + points;
    }
}

public class Q7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sport, Team Name, Total Matches Played, Wins, Draws: ");
        String s = sc.nextLine();
        String tn = sc.nextLine();
        int match = Integer.parseInt(sc.nextLine());
        int wins = Integer.parseInt(sc.nextLine());
        int draws = Integer.parseInt(sc.nextLine());
        CricketTeam ct = new CricketTeam(tn, match, wins, draws);

        System.out.print("Enter Sport, Team Name, Total Matches Played, Wins, Draws: ");
        String s1 = sc.nextLine();
        String tn1 = sc.nextLine();
        int match1 = Integer.parseInt(sc.nextLine());
        int wins1 = Integer.parseInt(sc.nextLine());
        int draws1 = Integer.parseInt(sc.nextLine());
        FootballTeam ft = new FootballTeam(tn1, match1, wins1, draws1);
        
        System.out.println("Team: "+ tn + "(Cricket)" + "Points: "
                + ct.calculatePoints());

        System.out.println("Team: " + tn1 + "(Football)" + "Points: "
                + ft.calculatePoints());

        sc.close();
    }
    
}