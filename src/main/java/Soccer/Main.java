package Soccer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\keora\\Desktop\\SoccerApp\\src\\main\\java\\data.txt");
        Scanner sc = null;
        String match, team1, team2, score1, score2;
        int leagueTotal = 0;
        int position = 0;
        TreeMap<String, Integer> scoreboard = new TreeMap<>();
        String[] sides, l1, l2;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {

//            Map<String, Integer> map = new HashMap<>();
            leagueTotal = 0;
            match = sc.nextLine();
            sides = match.split(",");
            l1 = sides[0].split(" ");
            team1 = l1[0];
            score1 = l1[1];
            l2 = sides[1].split(" ");
            team2 = l2[0];
            score2 = l2[1];
            int teamScore1 = Integer.parseInt(score1);
            int teamScore2 = Integer.parseInt(score2);
            if (teamScore1 > teamScore2) {

                scoreboard.put(team1, scoreboard.getOrDefault(team1, leagueTotal) + 3);

            } else if (teamScore1 < teamScore2) {


                scoreboard.put(team2, scoreboard.getOrDefault(team2, leagueTotal) + 3);
            } else {

                scoreboard.put(team1, scoreboard.getOrDefault(team1, leagueTotal) + 1);
                scoreboard.put(team2, scoreboard.getOrDefault(team2, leagueTotal) + 1);
            }
        }


        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        scoreboard.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Rankings: " + reverseSortedMap);



    }
}
