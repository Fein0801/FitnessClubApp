package co.grandcircus;

/**
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 */

public class SingleClubMember extends Member {

    private String club;

    public SingleClubMember() {
    	super();
	this.club = "Sunrise Cafe";
    }

    public SingleClubMember(String firstName, String lastName, String phoneNum, double fee, int memID, String club) {
	super(firstName, lastName, phoneNum, fee, memID);
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
	return super.toString() + "\nClub: " + club;
    }

    @Override
    public String generateSaveDataString() {
	String result = this.getFirstName() + "/" + this.getLastName() + "/" + this.getPhoneNum() + "/" + this.getFee()
		+ "/" + this.getMemID() + "/" + club;
	return result;
    }

}
