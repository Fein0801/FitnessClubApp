package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Orestis Sinis
 * @author Natasha Langston
 * @author Benjamin Feinstein
 * @author Christopher Ciric
 */

public class FitnessClubApp {

	private static final String FILE_NAME = "save_data.txt";

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
				scan.nextLine();
				break;
			case 2:
				addMember(scan, memberList);
				break;
			case 3:
				removeMember(scan, memberList);
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("Sorry, I didn't recognize that.");
				break;
			}
		}
		System.out.println("Goodbye.");
		writeToFile(memberList);
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
	 * Writes to a file
	 * 
	 * @param list: Our list of members stored
	 */
	public static void writeToFile(ArrayList<Member> list) {
		String fileName = FILE_NAME;
		Path path = Paths.get(fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file));
			if (list.isEmpty()) {
				return;
			}
			for (Member member : list) {
				output.println(member.generateSaveDataString());
			}
		} catch (FileNotFoundException e) {
			System.err.println("I AM ERROR!");
		} finally {
			output.close();
		}
	}

	private static void removeMember(Scanner scan, ArrayList<Member> list) {
		System.out.println("DELETE MEMBER:");
		int n1 = 1;
		for (Member t : list) {
			System.out.println(n1++ + " " + t);
		}
		int delete = Validator.getInt(scan, "Which member would you like to delete? ", 1, list.size());
		list.remove(delete - 1);
		System.out.println("MEMBER DELETED! - MAKE SURE WE GET OUR MONEY FIRST.");
	}

	// TODO Auto-generated method stub

	/**
	 * This method adds a new member to the list, based on user input.
	 * 
	 * locale variable in addMember() will store the scanner input for which
	 * location they select.
	 * 
	 * @param scan:    A Scanner object handling user input
	 * @param memList: A list of members
	 */
	private static void addMember(Scanner scan, ArrayList<Member> memList) {
		int locale = 0;
		String club = " ";

		String[] locations = { "BeastMaster Midtown", "BeastMaster Troy", "BeastMaster Yorkshire",
				"BeastMaster Farmington" };

		System.out.print("Enter the First Name of the new Member. ");
		String memFirstName = scan.nextLine();
		System.out.print("Enter the Last Name of the new Member. ");
		String memLastName = scan.nextLine();
		System.out.print("Enter the Type (Multi-Gym or Single-Gym) of the new Member. ");
		String memberType = scan.nextLine();
		String memPhoneNum = Validator.getStringMatchingRegex(scan, "Enter phone number as: (313-555-1212)",
				"\\d{3}-\\d{3}-\\d{4}");

		int memID = Member.generateMemID();
		Member member = null;
		if (memberType.equalsIgnoreCase("multi-gym")) {
			member = new MultiClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID, 0); // FIXME get rid of //
			// fee
			System.out.println();
		} else if (memberType.equalsIgnoreCase("single-gym")) {
//			member = new SingleClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID);

			System.out.println("Please select one of the following 4 locations:");
			for (int i = 0; i < locations.length; i++) {
				System.out.println((i + 1) + ". " + locations[i]);
			}

			locale = scan.nextInt();
			switch (locale) {
			case 1:
				club = "BeastMaster Midtown";
				break;
			case 2:
				club = "BeastMaster Troy";
				break;
			case 3:
				club = "BeastMaster Yorkshire";
				break;
			case 4:
				club = "BeastMaster Farmington";
				break;

			default:
				System.out.println("Please only select 1-4");
				break;
			}

			member = new SingleClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID, club);

		}

		memList.add(member);
		System.out.println(member);
		// scan.nextLine();
	}

	private static String validateInfo(String data, String regex) {
		if (data.matches(regex)) {
			return data;
		}
		return "The information you entered doesn't match the format.";
	}

	public static void removeMember(ArrayList<Member> listMem) {

	}
}
