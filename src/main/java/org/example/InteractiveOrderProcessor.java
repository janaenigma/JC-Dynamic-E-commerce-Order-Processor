package org.example;

import java.io.PrintStream;
import  java.util.Scanner;

public class InteractiveOrderProcessor {
    // Initialize Scanner:
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // VARIABLES
        double discount;
        double quantityDiscount;
        double shippingCost = 0.00;

        // Get Order Data from User:
        System.out.println("Welcome to the Interactive Order Processor!");
        System.out.println("\n--- Enter Order Details ---");

        System.out.print("Enter unit price: ");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Is customer a member (true/false)? ");
        boolean isCustomerAMember = sc.nextBoolean();
        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = sc.next();
        System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = sc.next();
        System.out.print("Enter discount code (SAVE10, FREESHIP, or \"\" for none): ");
        String discountCode = sc.next();

        // Closing Scanner
        sc.close();

        // Subtotal Calculation:
        System.out.println("\n--- Calculation Steps ---");
        double subtotal = unitPrice * quantity;
        System.out.printf("Initial Subtotal: $%.2f%n", subtotal);

        // Tier-Based Discount:
        if (customerTier.equalsIgnoreCase("Gold")){
            discount = subtotal * 0.15;
            subtotal = subtotal - discount;
            System.out.printf("After Tier Discount (Gold - 15%%): $%.2f%n", subtotal);
        } else if (customerTier.equalsIgnoreCase("Silver")) {
            discount = subtotal * 0.10;
            subtotal = subtotal - discount;
            System.out.printf("After Tier Discount (Silver - 10%%): $%.2f%n", subtotal);
        } else {
            discount = subtotal * 0.00;
            subtotal = subtotal - discount;
            System.out.printf("After Tier Discount (Regular - No Discount): $%.2f%n", subtotal);
        }

        // Quantity Discount:
        if (quantity >= 5){
            quantityDiscount = subtotal * 0.05;
            subtotal = subtotal - quantityDiscount;
            System.out.printf("After Quantity Discount (5%% for >=5 items): $%.2f%n", subtotal);
        }

        // Promotional Code Application:
        if (discountCode.equals("SAVE10") && subtotal > 75.00){
            subtotal = subtotal - 10.00;
            System.out.printf("After Promotional Code (SAVE10 for >$75): $%.2f%n", subtotal);
        } else if (discountCode.equalsIgnoreCase("FREESHIP")) {
            shippingCost = 0.00;
        }

        // Small Order Surcharge:
        System.out.print("After Small Order Surcharge (if applicable): ");
        double surcharge = (subtotal < 25.00) ? 3.00 : 0.00;
        System.out.printf("$%.2f", (subtotal + surcharge));
        if (surcharge == 0.00) System.out.print(" (No surcharge)\n");

        // Shipping Cost Calculation:
        if (!discountCode.equalsIgnoreCase("FREESHIP")){
            switch (shippingZone){
                case "ZoneA":
                    shippingCost = 5.00;
                    break;
                case "ZoneB":
                    shippingCost = 12.00;
                    break;
                case "ZoneC":
                    shippingCost = 20.00;
                    break;
                default:
                    shippingCost = 25.00;
                    break;
            }
            System.out.printf("\nShipping Cost: $%.2f", shippingCost);
            System.out.print(" (" + shippingZone +")\n");
        }
        else {
            System.out.printf("\nShipping Cost: $%.2f", shippingCost);
            System.out.print(" (FREESHIP Code Applied)\n");
        }
        
        // Final Total:
        double finalOrderTotal = subtotal + shippingCost;
        System.out.printf("\nFinal Order Total: $%.2f%n", finalOrderTotal);
    }

    public static void stringEquality(){
        // Get Strings from User:
        System.out.println("--- String Equality Demo ---");
        System.out.println("Enter first string for comparison: ");
        String input1 = sc.next();
        System.out.println("Enter first string for comparison: ");
        String input2 = sc.next();
        sc.close();

        // Print Strings:
        System.out.println("\nString 1: " + input1);
        System.out.println("String 2: " + input2);

        // String Equality Demonstrations:

    }
}