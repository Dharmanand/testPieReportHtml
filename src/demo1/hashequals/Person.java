package demo1.hashequals;

public class Person {

	private int perId;
	private String name;

	public Person(int perId, String name) {
		this.perId = perId;
		this.name = name;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*@Override
	public String toString() {
		return "to";
	}*/

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.hashCode() == ((Person) obj).hashCode())
			return true;
		return false;
	}
	
	
	
}
