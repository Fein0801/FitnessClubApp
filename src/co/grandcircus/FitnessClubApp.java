package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Orestis Sinis
 * @author Natasha Langston
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 */

public class FitnessClubApp {

    public static void main(String[] args) {
	ArrayList<Member> memberList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	System.out.println("Good day! Welcome to the BeastMaster's Fitness Club!\n");



	boolean run = true;
	while (run) {
	    printOptions();
	    int userChoice = Validator.getInt(scan, "Please choose your option (1, 2, 3 or 4) ", 1, 4);

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

    /**
     * Prints a user's options
     */
    private static void printOptions() {
	System.out.println("Please select the number of your menu selection below: ");
	System.out.println("1: See Member-List: ");
	System.out.println("2: Add New Member.");
	System.out.println("3: Remove Member.");
	System.out.println("4: Quit.");
	System.out.println();
    }

    /**
     * This method adds a new member to the list, based on user input.
     * 
     * @param scan:    A Scanner object handling user input
     * @param memList: A list of members
     */
    private static void addMember(Scanner scan, ArrayList<Member> memList) {

	String[] locations = { "BeastMaster Midtown", "BeastMaster Troy", "BeastMaster Yorkshire",
		"BeastMaster Farmington" };

	System.out.print("Enter the First Name of the new Member. ");
	String memFirstName = scan.nextLine();
	System.out.print("Enter the Last Name of the new Member. ");
	String memLastName = scan.nextLine();
	System.out.print("Enter the Type (Multi-Gym or Single-Gym) of the new Member. ");
	String memberType = scan.nextLine();
	System.out.print("Enter a Unique ID of the new Member.  Please use exactly 7 integers. ");
	int memID = scan.nextInt();
	System.out.print("Enter a Phone Number. "); // TODO add example
	String memPhoneNum = scan.next();
	Member member = null;
	if (memberType.equalsIgnoreCase("multi-gym")) {
	    member = new MultiClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID, 50); // FIXME get rid of //
												  // fee
	} else if (memberType.equalsIgnoreCase("single-gym")) {
	    System.out.println("Please select one of the following 4 locations:");
	    for (int i = 0; i < locations.length; i++) {
		System.out.println((i + 1) + ". " + locations[i]);
	    }
//	    member = new SingleClubMember();
	}

	memList.add(member);
	System.out.println(member);
	scan.nextLine();

    }
}
