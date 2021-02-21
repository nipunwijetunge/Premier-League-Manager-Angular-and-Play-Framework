/*Nipun Wijetunge | w1761260*/

package models;

import java.util.Objects;

public class UniversityFootballClub extends FootballClub {
    private String UniversityName;

    public UniversityFootballClub(String clubName, String clubLocation, int wins, int draws, int defeats, int goalsReceived, int goalsScored, int points, int numberOfMatchesPlayed, String universityName) {
        super(clubName, clubLocation, wins, draws, defeats, goalsReceived, goalsScored, points, numberOfMatchesPlayed);
        UniversityName = universityName;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "UniversityName='" + UniversityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(UniversityName, that.UniversityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), UniversityName);
    }
}
