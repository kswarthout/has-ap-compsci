
public abstract class Parent {

	private String name;
	
	public Parent(String name) {
		this.name = name;
		System.out.println("Call from parent constructor.");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void printName();
}
