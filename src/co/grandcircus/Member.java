package co.grandcircus;

/**
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 * 
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
	this.memID = 0;
    }

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

}
