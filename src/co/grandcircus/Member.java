package co.grandcircus;

/**
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 * 
 */

public abstract class Member {

	private String name;
	private String phoneNum;
	private double fee;
	private int memID;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String name, String phoneNum, double fee, int memID) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.fee = fee;
		this.memID = memID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Member [name=" + name + ", phoneNum=" + phoneNum + ", fee=" + fee + ", memID=" + memID + "]";
	}

	public Member(String memFirstName, String memLastName, String memberType, int memID, String memPhoneNum) {
		// TODO Auto-generated constructor stub
	}

}
