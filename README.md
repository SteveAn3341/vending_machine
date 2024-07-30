# vending_machine
vending_machine_1.0.3
Practice project to solidify your Java skills using File I/O

Ticket Breakdown for File I/O/NIO
Ticket 1: Implement Receipt Printing

Description: Update the VendingMachine class to include functionality to print a receipt to a file when a product is dispensed.

Tasks:

Add a printReceipt method to the VendingMachine class that writes the product details to a file.
Hint: Use BufferedWriter and FileWriter to write to a file named receipt.txt.
Hint: Include details such as product name, price, and timestamp in the receipt.
Update the dispenseProduct method to call printReceipt after dispensing a product.
Ensure proper exception handling for file operations.
Ticket 2: Send Vendor Notification When Product Runs Out

Description: Update the VendingMachine class to include functionality to send a notification to the vendor when a product runs out. For this example, simulate email sending by writing to a file.

Tasks:

Add a sendVendorNotification method to the VendingMachine class that writes a notification to a file named after the product that is out of stock.
Hint: Use BufferedWriter and FileWriter to write to a file named notification_<product_name>.txt.(regex is your friend here)
Hint: Include details such as product name and timestamp in the notification.
Update the dispenseProduct method to call sendVendorNotification when product quantity reaches zero.
Ensure proper exception handling for file operations.
Ticket 3: Implement CSV File Reading for Product Upload

Description: Update the VendingMachine class to include functionality to read products from a CSV file and add them to the vending machine.

Tasks:

Add a loadProductsFromCSV method to the VendingMachine class that reads product details from a CSV file and adds them to the vending machine.
Hint: Use BufferedReader and FileReader to read from the CSV file.
Hint: Each line in the CSV should contain product code, type (Snack/Beverage), name, price, and quantity.
Ensure proper exception handling for file operations.
Sample products.csv:

D9,Snack,Doritos,1.50,2
G7,Snack,Snyder's Pretzels,1.25,5
B3,Beverage,Coca Cola,1.75,1
W1,Beverage,Water,1.00,15
Ticket 4: Demonstrate New Features in VendRunner Class

Description: Update the VendRunner class to demonstrate the new features: printing a receipt to a file, sending a vendor notification when a product runs out, and loading products from a CSV file.

Tasks:

Add code to the main method to load products from a CSV file, dispense products, and show the functionality of the new features.
Hint: Create a sample CSV file with product details to test the functionality.
Ensure the main method clearly shows the workflow and the file I/O operations.
Hint: Display the contents of the files created for receipts and notifications to verify that the file I/O operations are working correctly.
