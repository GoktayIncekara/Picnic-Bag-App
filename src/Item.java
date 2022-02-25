
public class Item {
	 private String name;
	 private String type;
	 public Item(String name,String type) {
		 this.name = name;
		 this.type = type;
	 }
	 public String toString() {
		 return name;
	 }
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Item o = (Item)obj;
		return name.equals(o.name) && type.equals(o.type);
	 }
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
}
