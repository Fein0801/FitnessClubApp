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
		// TODO Auto-generated constructor stub
	}

	public MultiClubMember(String name, String phoneNum, double fee, int memID) {
		super(name, phoneNum, fee, memID);
		// TODO Auto-generated constructor stub
	}

	public MultiClubMember(String name, String phoneNum, double fee, int memID, int points) {
		super(name, phoneNum, fee, memID);
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
		return "MultiClubMember [points=" + points + ", " + super.toString() + "]";
	}

}
