import java.util.Scanner;

public class WarehouseInventory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] productName = new String[5];
        int[] productId = new int[5];
        double[] price = new double[5];
        int[] quantity = new int[5];
        int[] reorderLevel = new int[5];

        // Enter product details
        System.out.println("===== WAREHOUSE INVENTORY SYSTEM =====");

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter details for Product " + (i + 1));

            System.out.print("Enter Product ID: ");
            productId[i] = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Product Name: ");
            productName[i] = sc.nextLine();

            System.out.print("Enter Price: ");
            price[i] = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            quantity[i] = sc.nextInt();

            System.out.print("Enter Reorder Level: ");
            reorderLevel[i] = sc.nextInt();
        }

        // Display products
        System.out.println("\n===== PRODUCT DETAILS =====");

        for (int i = 0; i < 5; i++) {

            System.out.println("\nProduct " + (i + 1));
            System.out.println("Product ID: " + productId[i]);
            System.out.println("Product Name: " + productName[i]);
            System.out.println("Price: ₹" + price[i]);
            System.out.println("Quantity: " + quantity[i]);
            System.out.println("Reorder Level: " + reorderLevel[i]);

            double totalValue = price[i] * quantity[i];

            System.out.println("Total Value: ₹" + totalValue);

            if (quantity[i] <= reorderLevel[i]) {
                System.out.println("Status: REORDER REQUIRED");
            } else {
                System.out.println("Status: Stock Available");
            }
        }

        // Sell products
        System.out.println("\n===== SELL PRODUCT =====");

        System.out.print("Enter Product ID to sell: ");
        int searchId = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < 5; i++) {

            if (productId[i] == searchId) {

                found = true;

                System.out.print("Enter quantity to sell: ");
                int sold = sc.nextInt();

                if (sold <= quantity[i]) {

                    quantity[i] = quantity[i] - sold;

                    System.out.println("Sale successful!");
                    System.out.println("Remaining Quantity: " + quantity[i]);

                    if (quantity[i] <= reorderLevel[i]) {
                        System.out.println("WARNING: REORDER REQUIRED!");
                    } else {
                        System.out.println("Stock is sufficient.");
                    }

                } else {
                    System.out.println("Not enough stock available.");
                }
            }
        }

        if (found == false) {
            System.out.println("Product not found.");
        }

        sc.close();
    }
}