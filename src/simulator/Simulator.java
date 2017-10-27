package simulator;

import java.util.*;


public class Simulator extends Thread {

    private static int scoreFirstTeam;
    private static int scoreSecondTeam;
    private static int minutesPlayed;
    private static int strengthTeam1;
    private static int strengthTeam2;
    private static String Team1;
    private static String Team2;
    Scanner scanner = new Scanner(System.in);

    public Simulator(int scoreFirstTeam, int scoreSecondTeam, int minutesPlayed, int strengthTeam1, int strengthTeam2, String team1, String team2) {
        this.scoreFirstTeam = scoreFirstTeam;
        this.scoreSecondTeam = scoreSecondTeam;
        this.minutesPlayed = minutesPlayed;
        this.strengthTeam1 = strengthTeam1;
        this.strengthTeam2 = strengthTeam2;
        Team1 = team1;
        Team2 = team2;
    }

    public int getScoreFirstTeam() {
        return scoreFirstTeam;
    }

    public int getScoreSecondTeam() {
        return scoreSecondTeam;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public int getStrengthTeam1() {
        return strengthTeam1;
    }

    public int getStrengthTeam2() {
        return strengthTeam2;
    }

    public String getTeam1() {
        return Team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public Simulator generateMatch(){
        System.out.println("Team1 eingeben:");
        String Team1 = scanner.nextLine();
        System.out.println("Team2 eingeben:");
        String Team2 = scanner.nextLine();
        System.out.println("Stärke eingeben:");
        int strengthTeam1 = scanner.nextInt();
        System.out.println("Stärke eingeben:");
        int strengthTeam2 = scanner.nextInt();
        Simulator simulator = new Simulator(0,0,0, strengthTeam1, strengthTeam2, Team1, Team2);
        return simulator;
    }



    public void run(){
        try {

            boolean anotherGame = true;
            while (anotherGame == true) {
                Simulator sim = generateMatch();
                RandomGenerator randomGenerator = new RandomGenerator();
                for (int minutes=sim.getMinutesPlayed(); minutes <= 90; minutes++) {

                    int formTeam1 = sim.getStrengthTeam1() + randomGenerator.createRandomNumber(100);
                    int formTeam2 = sim.getStrengthTeam2() + randomGenerator.createRandomNumber(100);

                    if (formTeam1 - formTeam2 > 75) {
                        scoreFirstTeam++;
                        System.out.println("GOOOAAAALLL!!!!!");
                        Thread.sleep(1000);
                    }
                    if (formTeam2 - formTeam1 > 75) {
                        scoreSecondTeam++;
                        System.out.println("GOOOAAAALLL!!!!!");
                        Thread.sleep(1000);
                    }
                    if (minutes == 45){
                        System.out.println("Halftime Score: "+scoreFirstTeam+" : "+scoreSecondTeam);
                        Thread.sleep(1000);
                    }
                    System.out.println("Minutes played: "+minutes+" Score: "+scoreFirstTeam+" : "+scoreSecondTeam);
                    Thread.sleep(300);
                }
                System.out.println("Score: " + scoreFirstTeam + " : " + scoreSecondTeam);
                System.out.println("Another Game?y/n");
                anotherGame = scanner.next().matches("y");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
