import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
	 public InventoryBag<Item> readInventory() {
		 InventoryBag<Item> inventoryBag = new InventoryBag<>(500);
		 
		 String fileName = "CENG112_Homework1_Bags_Inventory.txt";
		 try {
			 Scanner inFile = new Scanner(new File(fileName));
			 String line = null;
			 while (inFile.hasNextLine()) {
				 line = inFile.nextLine();
				 String[] informations = line.split(",");
				 String name = informations[0];
				 String type = informations[1];
				 String number = informations[2];
				 int amount = Integer.parseInt(number);
				 Item item = new Item(name,type);
				 for(int i = 0; i < amount;i++) {
					 inventoryBag.add(item);
				 }
			 }
			 inFile.close();
			 
		 }
		 catch (FileNotFoundException e) {
			 System.out.println("File" + fileName + "not found.");
		 }
		 catch (IOException e) {
			 System.out.println("Error reading from file" + fileName);
		 }
		 return inventoryBag; 
	 }
}