package org.example;

import  java.util.Scanner;

public class InteractiveOrderProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Interactive Order Processor!");
        System.out.println("\n--- Enter Order Details ---");

        // Get Order Data from User:
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

        sc.close();

        System.out.println("\n--- Calculation Steps ---");
        // Subtotal Calculation:
        double subtotal = unitPrice * quantity;
        System.out.printf("Initial Subtotal: $%.2f%n", subtotal);
        double discount = 0.00;

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
            double quantityDiscount = subtotal * 0.05;
            subtotal = subtotal - quantityDiscount;
            System.out.printf("After Quantity Discount (5%% for >=5 items): $%.2f%n", subtotal);
        }

    }
}