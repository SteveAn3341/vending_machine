import java.io.IOException;
import java.sql.SQLOutput;

public class VendRunner {
        public static void main(String[] args) {
            // Create instances of Snack and Beverage
           try{
               Snack snack = new Snack("chips", 1.50,true);
               Beverage beverage = new Beverage("Soda", 1.75, 0.03);

            // Create Slot instances for Snack and Beverage
            Slot<Snack> snackSlot = new Slot<>(snack, 1);
            Slot<Beverage> beverageSlot = new Slot<>(beverage, 2);

            // Create an instance of VendingMachine
            VendingMachine vendingMachine = new VendingMachine();

            // Add products to the vending machine
            vendingMachine.addProduct("A1", snackSlot);
            vendingMachine.addProduct("B1", beverageSlot);

            // Display available products
            System.out.println("Available products:");
            vendingMachine.displayProducts();

            // Dispense products and show the workflow
            System.out.println("\nDispensing product A1:");
            Product dispensedProduct1 = vendingMachine.dispenseProduct("A1");
            System.out.println("Dispensed: " + dispensedProduct1);

            System.out.println("\nDispensing product B1:");
            Product dispensedProduct2 = vendingMachine.dispenseProduct("B1");
            System.out.println("Dispensed: " + dispensedProduct2);

            // Display available products after dispensing
            System.out.println("\nAvailable products after dispensing:");
            System.out.println("------------");
            Product dispensedProduct3 = vendingMachine.dispenseProduct("A1");


               // Display available products after Dispensing
               System.out.println(" after Dispensing products:");
               vendingMachine.displayProducts();
               System.out.println("----------------Loading form CSV file-------------------------");



               vendingMachine.loadProductsFromCSV("products.csv");


           }
           catch(IllegalArgumentException exception){
               System.out.println(exception);


           }

           }

        }


