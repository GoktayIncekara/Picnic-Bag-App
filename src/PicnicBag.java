
public class PicnicBag<T> implements IBag<T> {
	 private T[] picnicBag;
	 private int numberOfEntries = 0;
	 private int size;
	 private boolean initialized = false;
	 private static final int DEFAULT_SIZE = 15;
	 public int getSize() {
		return size;
	}
	@SuppressWarnings("unchecked")
	public PicnicBag(int size) {
		if ((size== 5) || (size == 10) || (size == 15)) {
			picnicBag = (T[])(new Object[size]);
			initialized= true;
		}
		else {
			System.out.println("Your" + size + "size bag can not be created. A bag whose size is 15, is automatically created");
			
		}
	}
	public PicnicBag() {
		this(DEFAULT_SIZE);
	}
	public boolean add(T item) {
		 checkInitialization();
		 boolean result = true;
			if(isFull()) {
				result = false;
			}
			else {
				picnicBag[numberOfEntries] = item;
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
			return numberOfEntries >= picnicBag.length;
	    }
	    public T removeByIndex(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >=0)) {
			result = picnicBag[givenIndex];
			picnicBag[givenIndex] = picnicBag[numberOfEntries-1];
			picnicBag[numberOfEntries-1] = null;
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
				if(item.equals(picnicBag[index])) {
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
				result = picnicBag[numberOfEntries-1];
				picnicBag[numberOfEntries-1] = null;
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
	    	System.out.println("Names of the items in the picnic bag:");
	    	for (int i = 0; i < numberOfItems; i++) {
	    		System.out.println(picnicBag[i]);
	    	}
	    }
	    public void dump() {
	    	int numberOfItems = getItemCount();
	    	for (int i = 0; i < numberOfItems; i++) {
	    		picnicBag[i] = null;
	    	}
	    }
	    public boolean transferTo(IBag<T> targetBag, T item) {
	    	boolean result = false;
	    	for (int i = 0; i < numberOfEntries; i++) {
	    		if(item.equals(picnicBag[i])) {
	    			remove(picnicBag[i]);
	    			targetBag.add(item);
	    			result = true;	
	    		}
	    		
	    	}
	    	return result;	
	    }
	 
	    public boolean consume(T item, IBag<T>[] trashBags) {
	    	boolean result = false;
	    	for (int i=0; i< trashBags.length;i++) {
	    		if (((Item)item).getType().equals("plastic")  && trashBags[i].getClass().toString().contains("PlasticTrashBag")) {
	    			remove(item);
	    			trashBags[i].add(item);
	    			result = true;
	    			
	    		}
	    		else if (((Item)item).getType().equals("organic") && trashBags[i].getClass().toString().contains("OrganicTrashBag")) {
	    			remove(item);
	    			trashBags[i].add(item);
	    			result = true;
	    		}
	    		else if (((Item)item).getType().equals("paper")&& trashBags[i].getClass().toString().contains("PaperTrashBag")){
	    			remove(item);
	    			trashBags[i].add(item);
	    			result = true;
	    		} 
       }
	    	return result;
}
	    public T findItem(String item_input) {
	    	T result = null;
	    	for (int i =0;i<numberOfEntries;i++) {
				if (item_input.equals(((Item)picnicBag[i]).getName().toString())) {
					result = picnicBag[i];
				}	
			}
	    	return result;
	    }
}