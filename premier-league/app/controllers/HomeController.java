/*Nipun Wijetunge | w1761260*/

package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.FootballClub;
import models.Match;
import models.PremierLeagueManager;

import play.mvc.Controller;
import play.mvc.Result;
import utils.ApplicationUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static play.mvc.Results.ok;

public class HomeController extends Controller {

    static File PLFootballClubs = new File("PLFootballClubs.txt");
    static File PLMatches = new File("PLMatches.txt");

    /*the method that get the football club list from the file*/
    public Result sendClubList() throws IOException, ClassNotFoundException {
        PremierLeagueManager leagueManager = PremierLeagueManager.getInstance();
        leagueManager.loadData(PLFootballClubs, PLMatches);

        List<FootballClub> result = leagueManager.getFootballClubList();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    /*the method that get the match list from the file*/
    public Result sendMatchList() throws IOException, ClassNotFoundException {
        PremierLeagueManager leagueManager = PremierLeagueManager.getInstance();
        leagueManager.loadData(PLFootballClubs, PLMatches);

        List<Match> result = leagueManager.getMatchList();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    /*
    the method that get the randomly generated match from the back end
    */
    public Result randomMatchGenerator() throws IOException, ClassNotFoundException {
        PremierLeagueManager leagueManager = PremierLeagueManager.getInstance();

        Match result = leagueManager.randomMatchGenerator();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }
}
