
public class Child extends Parent {

	private String childName;
	
	public Child(String name) {
		super(name); //call to parent constructor
		this.childName = name;
	}

	@Override
	public void printName() {
		// Child class must provide implementation
		// because printName() was declared abstract in parent class
		System.out.println("Accessing instance variable defined in parent class from child class: " + super.getName());
	}
	
	public void printChildName() {
		System.out.println("Accessing method defined in child class: " + childName);
	}

}
