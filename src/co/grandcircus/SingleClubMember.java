package co.grandcircus;

/**
 * @author Benjamin Feintein
 * @author Christopher Ciric
 */

public class SingleClubMember extends Member {

	private String club;

	public SingleClubMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SingleClubMember(String name, String phoneNum, double fee, int memID) {
		super(name, phoneNum, fee, memID);
		// TODO Auto-generated constructor stub
	}

	public SingleClubMember(String name, String phoneNum, double fee, int memID, String club) {
		super(name, phoneNum, fee, memID);
		this.club = club;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "SingleClubMember [club=" + club + ", " + super.toString() + "]";
	}

}
