package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Orestis Sinis
 * @author Natasha Langston
 * @author Benjamin Feinstein
 */

public class FitnessClubApp {

    public static void main(String[] args) {
	ArrayList<Member> memberList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	System.out.println("Good day! Welcome to the BeastMaster's Fitness Club\n");



	boolean run = true;
	while (run) {
	    printOptions();
	    int userChoice = Validator.getInt(scan, "Please choose your option (1, 2, 3 or 4...)", 1, 4);

	    switch (userChoice) {
	    case 1:
		for (Member m : memberList) {
		    System.out.println(m);
		}
		userChoice = scan.nextInt();
		break;
	    case 2:
		addMember(scan, memberList);
		break;
	    }
	}

	for (Member m : memberList) {
	    System.out.println(m);
	}
	System.out.println("Alright bye, here's the members you entered :");
    }

    private static void printOptions() {
	System.out.println("Please select the number of your menu selection below: ");
	System.out.println("1: See Member-List: ");
	System.out.println("2: Add New Member.");
	System.out.println("3: Remove Member.");
	System.out.println("4: Quit.");
    }

    private static void addMember(Scanner scan, ArrayList<Member> memList) {
	System.out.println("Enter the First Name of the new Member.");
	String memFirstName = scan.nextLine();
	System.out.println("Enter the Last Name of the new Member.");
	String memLastName = scan.nextLine();
	System.out.println("Enter the Type (Multi-Gym or Single-Gym) of the new Member.");
	String memberType = scan.nextLine();
	System.out.println("Enter a Unique ID of the new Member.  Please use exactly 7 integers.");
	int memID = scan.nextInt();
	System.out.println(
		"Enter a Phone Number, including Area Code, of the new Member.  Please use exactly 7 integers.");
	String memPhoneNum = scan.next(); // FIXME phone number not working
	Member member = null;
	if (memberType.equalsIgnoreCase("multi-gym")) {
	    member = new MultiClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID, 50); // FIXME get rid of
												  // fee
	} else if (memberType.equalsIgnoreCase("single-gym")) {
	    System.out.println(""); // TODO add 4 location options
	    member = new SingleClubMember();
	}

	memList.add(member);
	System.out.println(member);
	scan.nextLine();

    }
}
