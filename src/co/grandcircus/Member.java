package co.grandcircus;

/**
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 * @author Natasha Langston
 */
public abstract class Member {

    private String firstName;
    private String lastName;
    private String phoneNum;
    private double fee;
    private int memID;

    public Member() {
	this.firstName = "Grant";
	this.lastName = "Chirpus";
	this.phoneNum = "111-111-1111";
	this.fee = 0.0;
	this.memID = -1;
    }

    /**
     * @param firstName: Accepts first name
     * @param lastName:  Accepts last name
     * @param phoneNum:  Accepts phone number
     * @param fee:       Assigns fee
     * @param memID:     Assigns member ID
     */
    public Member(String firstName, String lastName, String phoneNum, double fee, int memID) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.phoneNum = phoneNum;
	this.fee = fee;
	this.memID = memID;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getPhoneNum() {
	return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
    }

    public double getFee() {
	return fee;
    }

    public void setFee(double fee) {
	this.fee = fee;
    }

    public int getMemID() {
	return memID;
    }

    public void setMemID(int memID) {
	this.memID = memID;
    }

    @Override
    public String toString() {
	String formattedFee = String.format("$%.2f", fee);
	return "First Name: " + firstName + "\nLast Name: " + lastName + "\nPhone Number: " + phoneNum + "\nFee: "
		+ formattedFee + "\nMember ID: " + memID;
    }
//<<<<<<< Updated upstream

    public abstract String generateSaveDataString();

    public static int generateMemID() {
	int max = 9999999;
	int min = 1000000;
	int range = max - min + 1;
	int memID = (int) (Math.random() * range) + min;
	
	    return memID;

	
    }
//>>>>>>> Stashed changes
}
