package co.grandcircus;

/**
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 * 
 */

public class MultiClubMember extends Member {

    private int points;

    public MultiClubMember() {
	super();
    }

    public MultiClubMember(String firstName, String lastName, String phoneNum, double fee, int memID, int points) {
	super(firstName, lastName, phoneNum, fee, memID);
	this.points = points;
    }

    public int getPoints() {
	return points;
    }

    public void setPoints(int points) {
	this.points = points;
    }

    @Override
    public String toString() {
	return super.toString() + "\nPoints: " + points;
    }

}
