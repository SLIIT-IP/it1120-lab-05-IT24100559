import java.util.Scanner;

public class IT24100559Lab5Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
		final int RC_PER_DAY = 48000; // Room charge per day
        final int NO_DISCOUNT_DAYS = 3; // No discount if reserved less than 3 days
        final int MID_DISCOUNT_DAYS = 4; // Discount of 10% for 3 to 4 days
        final int HIGH_DISCOUNT_DAYS = 5; // Discount of 20% for 5 or more days

        System.out.print("Enter Start Date (1-31): ");
        int startDate = scanner.nextInt();

        System.out.print("Enter End Date (1-31): ");
        int endDate = scanner.nextInt();

        if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31) {
            System.out.print("Error: Days must be between 1 and 31");
            scanner.close();
            return;
        }

        if (startDate >= endDate) {
            System.out.print("Error: Start Date must be less than End Date");
            scanner.close();
            return;
        }

        int daysReserved = endDate - startDate;

        double discountRate;
        if (daysReserved < NO_DISCOUNT_DAYS) {
            discountRate = 0;
        } else if (daysReserved >= NO_DISCOUNT_DAYS && daysReserved <= MID_DISCOUNT_DAYS) {
            discountRate = 10;
        } else { // daysReserved >= HIGH_DISCOUNT_DAYS
            discountRate = 20;
        }

        double totalAmount = RC_PER_DAY * daysReserved * (1 - discountRate * 0.01);

        System.out.println("");
        System.out.println("Room Charge Per Day: Rs. 48000.0/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be paid: Rs. " + totalAmount);

        scanner.close();
    }
}
