package models;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueManagerTest {
    static File PLFootballClubs = new File("PLFootballClubs.txt");
    static File PLMatches = new File("PLMatches.txt");

    @Test
    void createFootballClubAndAddToPL() {
        FootballClub footballClub = new FootballClub("test-club-name","test-club-location");
        PremierLeagueManager manager = PremierLeagueManager.getInstance();
        manager.createFootballClubAndAddToPL(footballClub);
    }

    @Test
    void removeFootballClubFromPL() {
        PremierLeagueManager manager = PremierLeagueManager.getInstance();
        manager.removeFootballClubFromPL("test-club-name",2019001);
    }

    @Test
    void displayStatsOnATeam() {
        PremierLeagueManager manager = PremierLeagueManager.getInstance();
        manager.displayStatsOnATeam("test-club-name",2019001);
    }

    @Test
    void displayPLTable() {
        PremierLeagueManager manager = PremierLeagueManager.getInstance();
        manager.displayPLTable();
    }

    @Test
    void addAPlayedMatch() throws ParseException {
        String date = "12-12-2020";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = dateFormat.parse(date);

        Match match = new Match("test-team-1","test-team-2",2,3,date1);
        PremierLeagueManager manager = PremierLeagueManager.getInstance();

    }

    @Test
    void saveData() throws IOException {
        PremierLeagueManager manager = PremierLeagueManager.getInstance();
        manager.saveData(PLFootballClubs,PLMatches);
    }

    @Test
    void loadData() throws IOException, ClassNotFoundException {
        PremierLeagueManager manager = PremierLeagueManager.getInstance();
        manager.loadData(PLFootballClubs,PLMatches);
    }
}