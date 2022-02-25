
import java.util.Scanner;

public class PicnicBagApp {
	public static void main(String[] args) {
		IBag<Item> plasticTrashBag = new PlasticTrashBag<>();
		IBag<Item> organicTrashBag = new OrganicTrashBag<>();
		IBag<Item> paperTrashBag = new PaperTrashBag<>();
		@SuppressWarnings("unchecked")
		IBag<Item>[] trashBags = new IBag[3];
		trashBags[0] = plasticTrashBag;
		trashBags[1] = organicTrashBag;
		trashBags[2] = paperTrashBag;
		System.out.println("Your picnic bag size can be either 5,10 or 15. If you don't enter anything, the size will be automatically setted to 15.");
		System.out.println("Enter your picnic bag size:");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		scan.nextLine();
		IBag<Item> picnicBag = new PicnicBag<>(size);
		FileIO fileio = new FileIO();
		System.out.println("THESE ARE THE ITEMS, WHICH YOU CAN CHOOSE TO EAT");
		InventoryBag<Item> inventoryBag = fileio.readInventory();
		inventoryBag.displayItems();
		for (int i =0;i<size;i++) {
				System.out.println("Please choose one of the items above:");
				String users_choice = scan.nextLine();
				Item user_item = inventoryBag.findItem(users_choice);
				System.out.println(user_item);
				inventoryBag.transferTo(picnicBag, user_item);
				System.out.println("The item " + user_item.getName() + " is being eaten...");
				picnicBag.displayItems();
		}
		System.out.println("Your updated inventory bag:");
		inventoryBag.displayItems();
		for ( int i = 0;i<size;i++) {
				System.out.println("Please enter the items which IN YOUR PICNIC BAG.");
				String users_choice2 = scan.nextLine();
				System.out.println("Consuming...");
				Item user_item2 = ((PicnicBag<Item>)picnicBag).findItem(users_choice2);
				((PicnicBag<Item>)picnicBag).consume(user_item2, trashBags);
				
		}
		paperTrashBag.displayItems();
		organicTrashBag.displayItems();
		plasticTrashBag.displayItems();
		System.out.println("Now its time to dump all the trash bags..");
		System.out.println("Paper trash bag is being dumped...");
		paperTrashBag.dump();
		System.out.println("Organic trash bag is being dumped...");
		organicTrashBag.dump();
		System.out.println("Plastic trash bag is being dumped..");
		plasticTrashBag.dump();
		scan.close();
		
		
			
}
}