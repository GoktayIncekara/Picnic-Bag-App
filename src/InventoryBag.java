
public class InventoryBag<T> implements IBag<T> {
	private T[] inventory;
	private boolean initialized = false;
	private int numberOfEntries = 0;
	private static final int DEFAULT_CAPACITY= 500;
	@SuppressWarnings("unchecked")
	public InventoryBag(int size) {
		 inventory = (T[]) (new Object[size]);
		 initialized = true;
	}
	public InventoryBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public boolean add(T item) {
	 checkInitialization();
	 boolean result = true;
		if(isFull()) {
			result = false;
		}
		else {
			inventory[numberOfEntries] = item;
			numberOfEntries++;
		}
	    return result;
}
	private void checkInitialization() {
		if (!initialized) {
			throw new SecurityException("ArrayBag object is not initialized properly.");
		}
}

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	public boolean isFull() {
		return numberOfEntries >= inventory.length;
    }
    public T removeByIndex(int givenIndex) {
	T result = null;
	if (!isEmpty() && (givenIndex >=0)) {
		result = inventory[givenIndex];
		inventory[givenIndex] = inventory[numberOfEntries-1];
		inventory[numberOfEntries-1] = null;
		numberOfEntries--;
		}
	return result;
}
    public T remove(T item) {
		checkInitialization();
		int index = getIndexOf(item);
		T result = removeByIndex(index);
		return result;
	}
    public int getIndexOf(T item) {
		int where = -1;
		int index = 0;
		while(!isEmpty() && index < numberOfEntries) {
			if(item.equals(inventory[index])) {
				where = index;
			}
			index++;
		}
		return where;
	}
    public T remove() {
		checkInitialization();
		T result = null;
		if(numberOfEntries > 0 ) {
			result = inventory[numberOfEntries-1];
			inventory[numberOfEntries-1] = null;
			numberOfEntries --;
			
		}
		return result;
	}
    public int getItemCount() {
		checkInitialization();
		return numberOfEntries;
	}
    public boolean contains(T item) {
		checkInitialization();
		return getIndexOf(item) > -1;
	}
    public void displayItems() {
    	int numberOfItems = getItemCount();
    	System.out.println("Names of the items in the inventory bag:");
    	for (int i = 0; i < numberOfItems; i++) {
    		System.out.println(inventory[i]);
    	}
    }
    public void dump() {
    	int numberOfItems = getItemCount();
    	for (int i = 0; i < numberOfItems; i++) {
    		inventory[i] = null;
    	}
    }
    public boolean transferTo(IBag<T> targetBag, T item) {
    	boolean result = false;
    	for (int i = 0; i < numberOfEntries; i++) {		
    		if(((Item)item).getName().equals(((Item)inventory[i]).getName().toString())) {
    			remove(inventory[i]);
    			targetBag.add(item);
    			result = true;
    			break;
    		}
    		
    	}
     	return result;	
    	}
    
    public T findItem(String item_input) {
    	T result = null;
    	for (int i =0;i<numberOfEntries;i++) {
			if (item_input.equals(((Item)inventory[i]).getName().toString())) {
				result = inventory[i];
				break;
			}	
		}
    	return result;
    }
}
  
