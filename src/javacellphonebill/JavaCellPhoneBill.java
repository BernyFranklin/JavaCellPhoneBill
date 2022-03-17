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
    private static string [ ] [ ] ACCOUNTS = {
        // 0 - Account, 1 - Name, 2 - Plan, 3 - Used, 4 - Bill
        {"323998-9", "Dan McElroy",    "Plan-A", "0.0", "0.0"},   // 0
        {"264442-8", "Manuel Estrada", "Plan-C", "0.0", "0.0"},   // 1
        {"355591-3", "Charles Aitken", "Plan-B", "0.0", "0.0"},   // 2
        {"100355-4", "Linh Nguyen",    "Plan-D", "0.0", "0.0"},   // 3
        {"256052-9", "Alice Brown",    "Plan-D", "0.0", "0.0"},   // 4
        {"726619-8", "Dave Ha",        "Plan-D", "0.0", "0.0"},   // 5
        {"145767-3", "Rachel Bush",    "Plan-B", "0.0", "0.0"},   // 6
        {"767372-3", "Jose Gonzales",  "Plan-A", "0.0", "0.0"},   // 7
        {"531923-3", "Oscar Meyer",    "Plan-D", "0.0", "0.0"},   // 8
    };   // End of ACCOUNTS array
    
    // Start Main
    public static void main(String[] args) {
        // TODO code application logic here
    }   // End of PSV Main
    
}   // End of JavaCellPhoneBill
