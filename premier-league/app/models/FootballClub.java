/*Nipun Wijetunge | w1761260*/

package models;

import java.io.Serializable;
import java.util.Objects;

/*this class holds all the information on each team that plays in premier League*/

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
    private int wins = 0;
    private int draws = 0;
    private int defeats = 0;
    private int goalsReceived = 0;
    private int goalsScored = 0;
    private int points = 0;
    private int numberOfMatchesPlayed = 0;

    public FootballClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }

    public FootballClub(String clubName, String clubLocation, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int points, int numberOfMatchesPlayed) {
        super(clubName, clubLocation);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.points = points;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    @Override
    public String toString() {
        return "models.FootballClub{" +
                "wins=" + wins +
                ", draws=" + draws +
                ", looses=" + defeats +
                ", goalsReceived=" + goalsReceived +
                ", goalsScored=" + goalsScored +
                ", points=" + points +
                ", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                goalsReceived == that.goalsReceived &&
                goalsScored == that.goalsScored &&
                points == that.points &&
                numberOfMatchesPlayed == that.numberOfMatchesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, draws, defeats, goalsReceived, goalsScored, points, numberOfMatchesPlayed);
    }

    /*in this overridden compareTo method allows to sort models.FootballClub objects in descending order comparing points.
     * in the case where points are equal, goal difference will be considered. if goal difference is also equal, the name
     * of the club will be considered and will be sorted alphabetically.*/
    @Override
    public int compareTo(FootballClub f) {
        if (this.points == f.points){
            if ((this.getGoalsScored() - this.getGoalsReceived()) > (f.getGoalsScored() - f.getGoalsReceived())){
                return 1;
            } else {
                return f.getClubName().compareTo(this.getClubName());
            }
        } else if (this.points > f.points){
            return 1;
        } else {
            return -1;
        }
    }
}
