package co.grandcircus;

/**
 * @author Orestis Sinis
 */
import java.util.Scanner;

public abstract class FeeCalculator {

    public static void calculateFee() {
	Scanner scan = new Scanner(System.in);

	System.out.println("How many apparel items would you like to buy?");
	int qtyItems = scan.nextInt();
	scan.nextLine();
	apparelFee(qtyItems);
	System.out.println("");
	System.out.println("How many group trainings would you like to attend?");
	int gtQty = scan.nextInt();
	scan.nextLine();
	groupTrainings(gtQty);
	System.out.println("");
	System.out.println("How many personal trainings would you like to book?");
	int qtyPt = scan.nextInt();
	scan.nextLine();
	personalTrainings(qtyPt);
	System.out.println("");
	System.out.println("How many months would you like to pre-pay for?");
	int monthsBooked = scan.nextInt();

	System.out.println("");
	double totalProShopPurchase = groupTrainings(gtQty) + apparelFee(qtyItems) + personalTrainings(qtyPt)
		+ monthlyMembership(monthsBooked); // This is not calculating correctly
	;
	System.out.println("\nYour total BeastMaster's Pro-Shop Order is: " + totalProShopPurchase);
    }

    public static double apparelFee(int itemQty) {
	double apparelCost = 9.99;
	double totalCost = 0.0;
	totalCost = apparelCost *= itemQty;
	System.out.println("\nYour total apparel cost is: " + totalCost);

	return apparelCost;

    }

    public static double groupTrainings(int gtQty) {
	double gtCost = 19.99;
	double totalGtCost = 0.0;
	totalGtCost = gtCost *= gtQty;
	System.out.println("\nYour total group training cost is: " + totalGtCost);

	return totalGtCost;
    }

    public static double personalTrainings(int ptQty) {
	double ptCost = 49.99;
	double totalPtCost = 0.0;
	totalPtCost = ptCost *= ptQty;
	if (ptQty >= 10) {

	    totalPtCost = totalPtCost * 0.90;
	}
	System.out.println("\nYour total pt training cost is: " + totalPtCost);
	return totalPtCost;

    }

    public static double monthlyMembership(int monthNum) {
	double monthlyMemCost = 49.99;
	double totalMonthlyMemCost = 0.0;
	totalMonthlyMemCost = monthlyMemCost *= monthNum;
	if (monthNum >= 12) {

	    totalMonthlyMemCost = totalMonthlyMemCost * 0.80;
	}
	System.out.println("\nYour total monthly membership cost is: " + totalMonthlyMemCost);

	return totalMonthlyMemCost;
    }

    public static double initiationFee(int intFee) {
	intFee = 250;
	return intFee;
    }

}
