import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
public class
VendingMachine {
    public Map<String, Slot<? extends Product>> slots;


    public VendingMachine() {
        this.slots = new HashMap<>();
    }
    public void addProduct(String code, Slot<? extends Product> slot) {
        this.slots.put(code, slot);
    }

    public Product dispenseProduct(String code) {

        System.out.println("Dsipense Proiduct Method Start here");
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code can not be null or Empty");
        }
        Slot<? extends Product> slot = slots.get(code);
        if (slot != null && slot.getQuantity() > 0) {
            slot.setQuantity(slot.getQuantity() - 1);
            Product product = slot.getProduct();
            try {
                printReceipt(product);
                if (slot.getQuantity() == 0) {
                    sendVendorNotification(product);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return product;
        } else {
            System.out.println(" Product not found");
            return null;
        }





 }

 // Load product from CSV method
    public void loadProductsFromCSV(String csvFile)  {
       try(BufferedReader reader = new BufferedReader(new FileReader("products.csv"))) {
           String line;
           int temp;
           while((line = reader.readLine()) != null){
               String[] productDetails = line.split(",");
               String code = productDetails[0];
               String type = productDetails[1];
               String name = productDetails[2];
               //String price = productDetails[3];
               double price= Double.parseDouble(productDetails[3]);
              // String quantity = productDetails[4];
               int quantity= Integer.parseInt(productDetails[4]);
               Product product;
               if (type.equalsIgnoreCase("Snack")){
                   product = new Snack(name,price,true);
               }
               else if (type.equalsIgnoreCase("Beverage")){
                   product = new Beverage(name, price,3.0);
               }else {
                   System.out.println("Invalid product type");
                   continue;
               }
               Slot<Product>  slot = new Slot<>(product, quantity);
               slots.put(code,slot);
           }

        }catch ( IOException e ){
           e.printStackTrace();



        }

    }
    // Method to send notification
    private void sendVendorNotification(Product product) throws IOException {
        String fileName = "notification_" + product.getName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Product:" + product.getName() + "is out of stock." + LocalDateTime.now());
            writer.newLine();

        }
    }

    // Method to display available products in the vending machine
    public void displayProducts() {
        for (Map.Entry<String, Slot<? extends Product>> entry : slots.entrySet()) {
            System.out.println("Code: " + entry.getKey() + ", Slot: " + entry.getValue());
        }
    }


    // Method to print receipt to file
    public void printReceipt(Product product)  {
        System.out.println("PrintReceipt method called here");
//        FileWriter writer = new FileWriter("receipt.txt");
//        writer.write("Product:"+ Product.getName() + "Price:" + Product.getPrice());
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt", true))) {
            writer.write("Product:" + product.getName() + "Price:" + product.getPrice());
            writer.write("Receipt - " + LocalDateTime.now());
            writer.newLine();
        }catch (IOException e) {
            e.printStackTrace();

        }
    }


//    public void displayProducts(){
//        for (Map.Entry<String, Slot<? extends Product>> entry : slots.entrySet()){
//            System.out.println("Code:" + entry.getKey() + ", Slot " + entry.getValue());
//        }
//    }
}
