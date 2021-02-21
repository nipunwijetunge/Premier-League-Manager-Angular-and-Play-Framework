/*Nipun Wijetunge | w1761260*/

package models;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    private static PremierLeagueManager instance = null;

    static File PLFootballClubs = new File("PLFootballClubs.txt");
    static File PLMatches = new File("PLMatches.txt");

    //this list holds all the registered clubs and their information in the Premier League
    private final List<FootballClub> footballClubList = new ArrayList<>(20);

    //this list holds the information of all entered played matches in the League
    private final List<Match> matchList = new ArrayList<>();

    private PremierLeagueManager() {
    }

    public static PremierLeagueManager getInstance() {
        if (instance == null) {
            synchronized (PremierLeagueManager.class) {
                if (instance == null) {
                    instance = new PremierLeagueManager();
                }
            }
        }
        return instance;
    }

    /*the following method allows to create a football club and add it to th Premier League.
     * maximum number of teams that are allowed to play in PL is 20.
     * In this method, after validating input data to create a club and add to the PL it automatically generates a
     * registration number and the club will be registered under that registration number. This registration number will be needed
     * in case of deletion of a club from the PL.*/
    @Override
    public void createFootballClubAndAddToPL(FootballClub f) {
        if (footballClubList.contains(f)) {
            System.out.println("This club is already in the Premier League.");
        } else if (footballClubList.size() == 20) {
            System.out.println("Sorry! Premier League is full right now.");
        } else {
            if (!footballClubList.isEmpty()) {
                f.setRegNo(footballClubList.get(footballClubList.size() - 1).getRegNo() + 1);
            } else {
                f.setRegNo(2019001);
            }
            footballClubList.add(f);
            System.out.println("The team was successfully added.");
            System.out.println("Club " + f.getClubName() + "'s registration code is " + f.getRegNo());
        }
    }

    /*This method allows user to remove a club from the Premier League. User has to remember the registration code that the system
     * gave to the particular club in the process of adding the club to Premier League in order to remove that particular club from PL.
     * After the validation of club name and registration number the club will be removed.*/
    @Override
    public void removeFootballClubFromPL(String name, int regNo) {
        boolean exist = false;
        for (FootballClub f : footballClubList) {
            if (f.getClubName().equals(name) || f.getRegNo() == regNo) {
                exist = true;
                break;
            } else {
                exist = false;
            }
        }

        if (exist) {
            for (FootballClub f : footballClubList) {
                if (f.getClubName().equals(name) && f.getRegNo() == regNo) {
                    footballClubList.remove(f);
                    System.out.println("The club was successfully removed.");
                    break;
                } else if (f.getClubName().equals(name)) {
                    System.out.println("The registered No. you entered is wrong!");
                    break;
                }
            }
        } else {
            System.out.println("This club has not registered in the League.");
        }
    }

    /*This method shows stats on a chosen club. User will have to input club name and registration number in order to
     *view stats on the that club. In CLI, details in the table might be misplaced according to the length of the
     * name of the club.*/
    @Override
    public void displayStatsOnATeam(String name, int regNo) {
        boolean exist = false;
        for (FootballClub f : footballClubList) {
            if (f.getClubName().equals(name) || f.getRegNo() == regNo) {
                exist = true;
                break;
            } else {
                exist = false;
            }
        }

        if (exist) {
            for (FootballClub f : footballClubList) {
                if (f.getClubName().equals(name) && f.getRegNo() == regNo) {
                    System.out.println();
                    System.out.println("Club        Points   Wins   Defeats   Draws   Goals-Scored   Goals-Received");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println(f.getClubName() + "            " + f.getPoints() + "       " + f.getWins() + "       " + f.getDefeats() +
                            "        " + f.getDraws() + "          " + f.getGoalsScored() + "               " + f.getGoalsReceived());
                    break;
                } else if (f.getClubName().equals(name) && f.getRegNo() != regNo) {
                    System.out.println("The registered No. you entered is wrong!");
                    break;
                }
            }

        } else {
            System.out.println("This club has not registered in the League.");
        }
    }

    /* This method generates the Premier League table. it will sorted by the points.(club with the highest number of points in the
    tournament will appear first and the least will appear last). in case of equal point counts, goal difference(goals scored - goals received) will be considered
    (the club with highest goal difference will appear first and least will appear last.).*/
    @Override
    public void displayPLTable() {
        System.out.println("Club        Points   Wins   Defeats   Draws   Goals-Scored   Goals-Received");
        System.out.println("---------------------------------------------------------------------------");
        footballClubList.sort(Collections.reverseOrder());
        for (FootballClub f : footballClubList) {
            System.out.println(f.getClubName() + "            " + f.getPoints() + "       " + f.getWins() + "       " + f.getDefeats() +
                    "        " + f.getDraws() + "          " + f.getGoalsScored() + "               " + f.getGoalsReceived());
        }
    }

    /*this method allows user to add a played match to the system. the data gathered from inputs will be used to
     * update stats on each club accordingly. according to the Premier League Wikipedia page winning team get 3 points,
     * in the matter of drawing a match, each team will awarded 1 point. and i have used that point awarding method in this system.*/
    @Override
    public void addAPlayedMatch(Match match) {
        boolean team1Check = false;
        boolean team2Check = false;

        for (FootballClub f : footballClubList) {
            if (match.getTeam1().equals(f.getClubName())) {
                team1Check = true;
            } else if (match.getTeam2().equals(f.getClubName())) {
                team2Check = true;
            }
        }

        if (matchList.contains(match)) {
            System.out.println("This match has been already added.");
        } else {
            if (team1Check && team2Check) {
                for (FootballClub f : footballClubList) {

                    if (match.getTeam1().equals(f.getClubName()) && !match.getTeam1().equals(match.getTeam2())) {
                        f.setNumberOfMatchesPlayed(f.getNumberOfMatchesPlayed() + 1);
                        f.setGoalsScored(f.getGoalsScored() + match.getTeam1Score());
                        f.setGoalsReceived(f.getGoalsReceived() + match.getTeam2Score());
                        if (match.getTeam1Score() > match.getTeam2Score()) {
                            f.setWins(f.getWins() + 1);
                            f.setPoints(f.getPoints() + 3);
                        } else if (match.getTeam1Score() == match.getTeam2Score()) {
                            f.setDraws(f.getDraws() + 1);
                            f.setPoints(f.getPoints() + 1);
                        } else {
                            f.setDefeats(f.getDefeats() + 1);
                        }

                    } else if (match.getTeam2().equals(f.getClubName()) && !match.getTeam1().equals(match.getTeam2())) {
                        f.setNumberOfMatchesPlayed(f.getNumberOfMatchesPlayed() + 1);
                        f.setGoalsScored(f.getGoalsScored() + match.getTeam2Score());
                        f.setGoalsReceived(f.getGoalsReceived() + match.getTeam1Score());
                        if (match.getTeam2Score() > match.getTeam1Score()) {
                            f.setWins(f.getWins() + 1);
                            f.setPoints(f.getPoints() + 3);
                        } else if (match.getTeam2Score() == match.getTeam1Score()) {
                            f.setDraws(f.getDraws() + 1);
                            f.setPoints(f.getPoints() + 1);
                        } else {
                            f.setDefeats(f.getDefeats() + 1);
                        }
                    }
                }

                matchList.add(match);
                System.out.println("models.Match has been added successfully.");

            } else if (!team1Check && !team2Check) {
                System.out.println("Sorry! " + match.getTeam1() + " and " + match.getTeam2() + " do not play in the Premier League.");
            } else if (!team1Check) {
                System.out.println("Sorry!" + match.getTeam1() + " football club you entered as team 1 does not play in the Premier League.");
            } else {
                System.out.println("Sorry!" + match.getTeam2() + " football club you entered as team 2 does not play in the Premier League.");
            }
        }
    }

    /*this method allows user to save data to a file in order to load saved data in future compilations of the system.
     *the file will be written in object stream. this method throws IOException*/
    @Override
    public void saveData(File footballClubs, File matches) throws IOException {
        FileOutputStream footballOutputStream = new FileOutputStream(footballClubs);
        ObjectOutputStream footballOOS = new ObjectOutputStream(footballOutputStream);

        for (FootballClub f : footballClubList) {
            footballOOS.writeObject(f);
        }

        footballOOS.flush();
        footballOutputStream.close();
        footballOOS.close();

        FileOutputStream matchOutputStream = new FileOutputStream(matches);
        ObjectOutputStream matchOOS = new ObjectOutputStream(matchOutputStream);

        for (Match m : matchList) {
            matchOOS.writeObject(m);
        }

        matchOOS.flush();
        matchOutputStream.close();
        matchOOS.close();

        System.out.println("Data has been successfully saved!");
    }

    /*tis method is commanded to trigger at beginning of each compilation. it will automatically store data
     * that stored in the files to the system. so user can continue where stopped. this method throws IOException
     * and ClassNotFoundException.*/
    @Override
    public void loadData(File footballClubs, File matches) throws IOException, ClassNotFoundException {
        FileInputStream footballInputStream = new FileInputStream(footballClubs);
        ObjectInputStream footballOIS = new ObjectInputStream(footballInputStream);
        footballClubList.clear();
        matchList.clear();

        for (; ; ) {
            try {
                FootballClub f = (FootballClub) footballOIS.readObject();
                footballClubList.add(f);
            } catch (EOFException e) {
                break;
            }
        }

        footballInputStream.close();
        footballOIS.close();

        FileInputStream matchInputStream = new FileInputStream(matches);
        ObjectInputStream matchOIS = new ObjectInputStream(matchInputStream);

        for (; ; ) {
            try {
                Match m = (Match) matchOIS.readObject();
                matchList.add(m);
            } catch (EOFException e) {
                break;
            }
        }

        matchInputStream.close();
        matchOIS.close();
    }

    /*this method generates a random match by getting two teams from the football club list,
    * only if there are enough clubs to create a match. after creating the random match it will automatically be
    * saved to the match file as a played match*/
    public Match randomMatchGenerator() throws IOException {
        if (footballClubList.size() >= 2) {
            Random random = new Random();
            FootballClub team1 = footballClubList.get(random.nextInt(footballClubList.size()));
            FootballClub team2 = footballClubList.get(random.nextInt(footballClubList.size()));

            while (team1.equals(team2)) {
                team2 = footballClubList.get(random.nextInt(footballClubList.size()));
            }

            int team1Score = random.nextInt(10);
            int team2Score = random.nextInt(10);

            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate today = LocalDate.now();
            Date date1 = Date.from(today.atStartOfDay(defaultZoneId).toInstant());

            Match match = new Match(team1.getClubName(), team2.getClubName(), team1Score, team2Score, date1);
            addAPlayedMatch(match);
            saveData(PLFootballClubs, PLMatches);

            return match;
        }
        return null;
    }

    public List<FootballClub> getFootballClubList() {
        return new ArrayList<>(footballClubList);
    }

    public List<Match> getMatchList() {
        return new ArrayList<>(matchList);
    }
}
