
public class OrganicTrashBag<T> implements IBag<T> {
	private T[] organicTrashBag;
	private boolean initialized = false;
	private int numberOfEntries = 0;
	private static final int DEFAULT_CAPACITY= 50;
	@SuppressWarnings("unchecked")
	public OrganicTrashBag(int size) {
		 organicTrashBag = (T[]) (new Object[size]);
		 initialized = true;
	}
	public OrganicTrashBag() {
		this(DEFAULT_CAPACITY);
	}
	public boolean add(T item) {
		 checkInitialization();
		 boolean result = true;
			if(isFull()) {
				result = false;
			}
			else {
				organicTrashBag[numberOfEntries] = item;
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
			return numberOfEntries >= organicTrashBag.length;
	    }
	    public T removeByIndex(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >=0)) {
			result = organicTrashBag[givenIndex];
			organicTrashBag[givenIndex] = organicTrashBag[numberOfEntries-1];
			organicTrashBag[numberOfEntries-1] = null;
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
				if(item.equals(organicTrashBag[index])) {
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
				result =organicTrashBag[numberOfEntries-1];
				organicTrashBag[numberOfEntries-1] = null;
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
	    	System.out.println("Names of the items in the organic trash bag:");
	    	for (int i = 0; i < numberOfItems; i++) {
	    		System.out.println(organicTrashBag[i]);
	    	}
	    }
	    public void dump() {
	    	System.out.println("You had " + numberOfEntries + " items in your organic trash bag.");
	    	for (int i = 0; i < numberOfEntries; i++) {
	    		organicTrashBag[i] = null;
	    	}
	    }
	    public boolean transferTo(IBag<T> targetBag, T item) {
	    	boolean result = false;
	    	for (int i = 0; i < numberOfEntries; i++) {
	    		if(item.equals(organicTrashBag[i])) {
	    			remove(organicTrashBag[i]);
	    			targetBag.add(item);
	    			result = true;	
	    		}
	    		
	    	}
	    	return result;	
	    }
	    
	    public T findItem(String item_input) {
	    	T result = null;
	    	for (int i =0;i<numberOfEntries;i++) {
				if (item_input.equals(((Item)organicTrashBag[i]).getName().toString())) {
					result = organicTrashBag[i];
				}	
			}
	    	return result;
	    }
	
}
