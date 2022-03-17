/*
 * JavaCellPhoneBill Version1.0
 * Frank Bernal
 * CIS 084 Java Programming
 * Input
 * Output
 * 17 Mar 2022
 */

package javacellphonebill;

// Import the scanner for input
import java.util.Scanner;

public class JavaCellPhoneBill {

    // Defining GB limits and billing rates for each plan
    
    // Price per gig over limit
    private static final double OVER_LIMIT_CHARGE = 15.0;
    
    // Defining row index names into the PLAN_TIERS array
    private static final int PLAN_A = 0;   // Plan A
    private static final int PLAN_B = 1;   // Plan B
    private static final int PLAN_C = 2;   // Plan C
    private static final int PLAN_D = 3;   // Plan D
    
    // Defining column index names into the PLAN_TIERS array
    private static final int LIMIT = 0;   // GB limit per plan
    private static final int PRICE = 1;   // Price for plan
    
    // Defining PLAN_TIERS Array
    private static final double [ ] [ ] PLAN_TIERS = {
        // 0 - Limit, 1 - Price
        { 0.0, 50.0},   // 0 - Plan A
        { 2.0, 60.0},   // 1 - Plan B
        { 4.0, 70.0},   // 2 - Plan C
        {10.0, 90.0}    // 3 - Plan D
    };   // End of PLAN_TIERS array
    
    // Defining column index names for ACCOUNTS array
    private static final int ACCT = 0;   // 0 - Account number
    private static final int NAME = 1;   // 1 - Name on account
    private static final int PLAN = 2;   // 2 - Plan tier
    private static final int USED = 3;   // 3 - GB used
    private static final int BILL = 4;   // 4 - Amount billed
    
    // Defining ACCOUNTS array
    private static String [ ] [ ] Accounts = {
        // 0 - Account, 1 - Name, 2 - Plan, 3 - Used, 4 - Bill
        {"323998-9", "Dan McElroy",    "Plan-A", "0.0", "0.0"},   //  0
        {"264442-8", "Manuel Estrada", "Plan-C", "0.0", "0.0"},   //  1
        {"355591-3", "Charles Aitken", "Plan-B", "0.0", "0.0"},   //  2
        {"100355-4", "Linh Nguyen",    "Plan-D", "0.0", "0.0"},   //  3
        {"256052-9", "Alice Brown",    "Plan-D", "0.0", "0.0"},   //  4
        {"726619-8", "Dave Ha",        "Plan-D", "0.0", "0.0"},   //  5
        {"145767-3", "Rachel Bush",    "Plan-B", "0.0", "0.0"},   //  6
        {"767372-3", "Jose Gonzales",  "Plan-A", "0.0", "0.0"},   //  7
        {"531923-3", "Oscar Meyer",    "Plan-D", "0.0", "0.0"},   //  8
        {"120517-4", "Anastazja Rose", "Plan-A", "0.0", "0.0"},   //  9
        {"082789-2", "Frank Bernal",   "Plan-B", "0.0", "0.0"},   // 10
        {"061190-1", "Shayla Zemrak",  "Plan-C", "0.0", "0.0"},   // 11
    };   // End of ACCOUNTS array
    
    // Start Main
    public static void main(String[] args) {
        // Define Local Error flag
        boolean error;
        // Call method to input GB used and place into array
        inputGBused();   
        // Bill each customer and return error flag 
        error = billEachCustomer();
        // Don't print bill if error
        if (!error)
            printBilling();
    }   // End of PSV Main
    
    // Start inputGBused
    private static void inputGBused() {
        // Create Scanner object
        Scanner stdin = new Scanner(System.in);
        
        // Print how many customer acounts
        System.out.printf ("There are %d customers\n\n", Accounts.length);
        
        // Prompt for input, ask for GB per account
        System.out.println ("Enter GB for: ");
        
        // Declare limit for loop
        int numberOfCustomers = Accounts.length;
        // Start loop
        for (int customer = 0; customer < numberOfCustomers; customer++) {
            System.out.printf ("%-15.15s %s %s: ",
                    Accounts[customer][NAME],
                    Accounts[customer][ACCT],
                    Accounts[customer][PLAN]);
            // Input GB used
            Accounts[customer][USED] = stdin.nextLine();
        }   // End of for loop
    }   // End of inputGBused
    
    // Start billEachCustomer
    private static boolean billEachCustomer() {
        // GB used pulled from array
        double GBused;
        // bill
        double bill;
        // Flag assumes no errors
        boolean errorFlag = false;
        // Number of customers derived from ACCOUNTS array length
        int numberOfCustomers = Accounts.length;
        
        // Let's try some testing
        try {
            // Loop through each customer
            for (int customer = 0; customer < numberOfCustomers; customer++) {
                // Get amount used from array  as string and convert to double
                GBused = Double.valueOf(Accounts[customer][USED]);
                
                
                // Compute bill based on customer's plan
                // bill set to switch statement
                bill = switch (Accounts[customer][PLAN]) {
                    // Plan A
                    case "Plan-A" -> computeBill(GBused, PLAN_TIERS[PLAN_A][LIMIT],
                            PLAN_TIERS[PLAN_A][PRICE]);
                    // Plan B
                    case "Plan-B" -> computeBill(GBused, PLAN_TIERS[PLAN_B][LIMIT],
                            PLAN_TIERS[PLAN_B][PRICE]);
                    // Plan C
                    case "Plan-C" -> computeBill(GBused, PLAN_TIERS[PLAN_C][LIMIT],
                            PLAN_TIERS[PLAN_C][PRICE]);
                    // Plan D
                    case "Plan-D" -> computeBill(GBused, PLAN_TIERS[PLAN_D][LIMIT],
                            PLAN_TIERS[PLAN_D][PRICE]);
                    // "Phony" plan set 0.00
                    default -> 0.00;
                }; 
                
                // Convert bill from double back to string
                Accounts[customer][BILL] = String.valueOf(bill);
            }   // End of for loop
        }   // End of Try   // End of Try   // End of Try   // End of Try
        catch (NumberFormatException e) {
            // If input isn't numeric
            System.out.println ("Values for GB must be numeric");
            // Set flag for error present
            errorFlag = true;
        }   // End of catch
        return errorFlag;
    }   // End of billEachCustomer
    
    // Start of computeBill
    private static double computeBill(double used, double limit, double rate) {
        // Overlimit var
        double overLimit;
        // Total of bill
        double bill;
        
        // Is used over limit?
        if (used <= limit) {
            // If no
            overLimit = 0;   
        } else {
            // If yes, seperate and round up
            overLimit = Math.ceil(used - limit);   
        }   // End of check
        
        // Bill is plans base rate + any charge for GB over limit
        bill = rate + overLimit * OVER_LIMIT_CHARGE;
        // Pass value of bill to whoever called
        return bill;
    }   // End of computeBill
    
    // Start printBilling
    private static void printBilling() {
        // Display each customer bill using 2 lines with 1 digit
        //   past the decimal for GB used and 2 digits pas the 
        //   decimal for the total billed for all customers
        System.out.printf ("\n\n============= Customer Billing =================\n");
        
        // Define limit for loop
        int numberOfCustomers = Accounts.length;
        // Start loop for display
        for (int customer = 0; customer < numberOfCustomers; customer++) {
            System.out.printf ("%-15s %s %s\n",
                    Accounts[customer][NAME],
                    Accounts[customer][ACCT],
                    Accounts[customer][PLAN]
            );
            System.out.printf ("  %.1f GB used, bill=%6.2f\n\n",
                    Double.valueOf(Accounts[customer][USED]),
                    Double.valueOf(Accounts[customer][BILL])
            );
        }   // End of for loop
    }   // End of printBilling
}   // End of JavaCellPhoneBill
