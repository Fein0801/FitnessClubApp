package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

		System.out.println("Good day! Welcome to the BeastMaster's Fitness Club!");
		memberList = readFromFile();

		boolean run = true;
		while (run) {
			printOptions();
			int userChoice = Validator.getInt(scan, "Please choose your option (1, 2, 3, 4, 5) ", 1, 5);
			switch (userChoice) {
			case 1:
				for (Member m : memberList) {
					System.out.println();
					System.out.println(m);
				}
				System.out.println();
				break;
			case 2:
				printMemType(scan, memberList);

				break;

			case 3:
				addMember(scan, memberList);
				break;
			case 4:
				removeMember(scan, memberList);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("Sorry, I didn't recognize that.");
				break;
			}
		}

		System.out.println("Logging you out of the system!");
		writeToFile(memberList);
	}

	private static void printMemType(Scanner scan, ArrayList<Member> memberList) {
		String prompt = "Which member type would you like to view? (single/multi) ";
		String choice = Validator.getString(scan, prompt);
		System.out.println();

		if (choice.equalsIgnoreCase("single")) {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i) instanceof SingleClubMember) {
					System.out.println(memberList.get(i));
					System.out.println();
				}
			}
		}
		else if (choice.equalsIgnoreCase("multi")) {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i) instanceof MultiClubMember) {
					System.out.println(memberList.get(i));
					System.out.println();
				}

			}
		} else {
			printMemType(scan, memberList);
		}

	}

	/**
	 * Prints a user's options
	 */
	private static void printOptions() {
		System.out.println();
		System.out.println("Please select the number of your menu selection below: ");
		System.out.println("1: See Member-List: ");
		System.out.println("2. See Members by Type: ");
		System.out.println("3: Add New Member.");
		System.out.println("4: Remove Member.");
		System.out.println("5: Quit.");
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
		String memberType = "";
		System.out.print("Enter the Type (Multi-Gym or Single-Gym) of the new Member. ");
		memberType = scan.nextLine();
		while (!memberType.equalsIgnoreCase("Multi-Gym") && !memberType.equalsIgnoreCase("Single-Gym")) {
			System.out.println("Please enter multi-gym or single-gym");
			memberType = scan.nextLine();
		}
		String memPhoneNum = Validator.getStringMatchingRegex(scan, "Enter phone number as: (313-555-1212) ",
				"\\d{3}-\\d{3}-\\d{4}");

		int memID = Member.generateMemID();
		Member member = null;
		if (memberType.equalsIgnoreCase("multi-gym")) {
			member = new MultiClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID, 0);
			System.out.println();
		} else if (memberType.equalsIgnoreCase("single-gym")) {
			System.out.println();
			System.out.println("Please select one of the following 4 locations:");
			try {
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
			} catch (InputMismatchException e) {
				System.out.println("Ah, Ah, Ah...  You didn't say the magic number (1-4)... Try again...");
			}

			member = new SingleClubMember(memFirstName, memLastName, memPhoneNum, 0.0, memID, club);

		}

		System.out.println(member);
		System.out.println("Wanna shop? (y/n)");

		char userChar = scan.next().charAt(0);
		if (userChar == 'y') {
			double accountBalance = FeeCalculator.calculateFee();
			member.setFee(accountBalance);
		} else if (userChar == 'n') {
			member.setFee(FeeCalculator.initiationFee());
		}
		memList.add(member);
	}

	private static void removeMember(Scanner scan, ArrayList<Member> list) {
		System.out.println();
		System.out.println("DELETE MEMBER:");
		int n1 = 1;
		for (Member t : list) {
			System.out.println(n1++ + ". " + t + "\n");
		}
		int delete = Validator.getInt(scan, "Which member would you like to delete? ", 0, list.size());
		if (delete == 0) {
			System.out.println("No members were deleted.");
			return;
		}
		list.remove(delete - 1);
		System.out.println("MEMBER DELETED! - MAKE SURE WE GET OUR MONEY FIRST.");
	}

	private static ArrayList<Member> readFromFile() {
		ArrayList<Member> list = new ArrayList<Member>();

		String fileName = FILE_NAME;
		Path path = Paths.get(fileName);

		File file = path.toFile();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null && !line.equals("")) {
				String[] memberInfo = line.split("/");
				Member m;
				String firstName = memberInfo[0];
				String lastName = memberInfo[1];
				String phoneNum = memberInfo[2];
				double fee = Double.parseDouble(memberInfo[3]);
				int memID = Integer.parseInt(memberInfo[4]);

				try {
					int points = Integer.parseInt(memberInfo[5]);
					m = new MultiClubMember(firstName, lastName, phoneNum, fee, memID, points);
				} catch (NumberFormatException e) {
					String club = memberInfo[5];
					m = new SingleClubMember(firstName, lastName, phoneNum, fee, memID, club);
				}
				list.add(m);
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("error reading from save file");
		} catch (IOException e) {
			System.out.println();
		}

		return list;
	}
}
