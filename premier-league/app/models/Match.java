/*Nipun Wijetunge | w1761260*/

package models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*this class holds all information about each played match of Premier League entered to the system*/

public class Match implements Serializable , Comparable<Match>{
    private String team1;
    private String team2;
    private int team1Score;
    private int team2Score;
    private Date date;

    public Match(String team1, String team2, int team1Score, int team2Score, Date date) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.date = date;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "models.Match{" +
                "team1=" + team1 +
                ", team2=" + team2 +
                ", team1Score=" + team1Score +
                ", team2Score=" + team2Score +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return team1Score == match.team1Score &&
                team2Score == match.team2Score &&
                Objects.equals(team1, match.team1) &&
                Objects.equals(team2, match.team2) &&
                Objects.equals(date, match.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team1, team2, team1Score, team2Score, date);
    }

    @Override
    public int compareTo(Match o) {
        return date.compareTo(o.date);
    }
}
