package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Orestis Sinis
 * @author Natasha Langston
 * 
 */

public class FitnessClubApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Good day! Welcome to the BeastMaster's Fitness Club\n");
		System.out.println("Please select the number of your menu selection below: ");
		System.out.println("1: See Member-List: ");
		System.out.println("2: Add New Member.");
		System.out.println("3: Remove Member.");
		ArrayList<Member> memberList = new ArrayList<>();

		int userChoice = scan.nextInt();
		scan.nextLine();

		// int userData = Validator.getInt(scan, "Please choose your option (1, 2 or
		// 3)", 1, 3);

		while (userChoice == 1 || userChoice == 2) {

			if (userChoice == 1) {

				System.out.println(memberList);

				userChoice = scan.nextInt();

			} else if (userChoice == 2) {

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

				String memPhoneNum = scan.nextLine();

				Member memberObject = new Member(memFirstName, memLastName, memberType, memID, memPhoneNum);

				memberList.add(memberObject);

				scan.nextLine();

				System.out.println("You entered: 1. Member First Name: " + memFirstName);
				System.out.println("You entered: 1. Member First Name: " + memLastName);
				System.out.println("You entered: 1. Member First Name: " + memberType);
				System.out.println("You entered: 1. Member First Name: " + memID);
			}
			System.out.println(
					"Please choose your next menu option: \n1 - See the list of Members \n2 - Add a Member \n3 - Remove a Member");
			System.out.println("Enter menu number: ");
			userChoice = scan.nextInt();
			scan.nextLine();
		}
		for (Member m : memberList) {
			System.out.println(m);
		}
		System.out.println("Alright bye, here's the members you entered :");
	}
}
