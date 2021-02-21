/*Nipun Wijetunge | w1761260*/

package models;

import java.io.Serializable;
import java.util.Objects;

/*this class is the super class of all football club classes.*/

public class SportsClub implements Serializable {
    private int regNo;
    private String clubName;
    private String clubLocation;

    public SportsClub(String clubName, String clubLocation) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    @Override
    public String toString() {
        return "models.SportsClub{" +
                "regNo=" + regNo +
                ", clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(clubName, that.clubName) &&
                Objects.equals(clubLocation, that.clubLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo, clubName, clubLocation);
    }
}
