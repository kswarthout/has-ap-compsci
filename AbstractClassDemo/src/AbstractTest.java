
public class AbstractTest {

	public static void main(String[] args) {

		Child child = new Child("child");
		child.printName();
		child.setName("new child name");
		child.printName();

		// Instantiating child using parent type reference
		Parent parentTypedChild = new Child("parent child");
		parentTypedChild.printName();
		parentTypedChild.setName("new parent child name");
		parentTypedChild.printName();

		// variable of type "Parent" cannot access child method
		// parentTypedChild.printChildName(); <--Not valid (if you uncomment, you'd get
		// a compiler error)
		child.printChildName();

//		System.out.println(child.name); <-- Not valid (cannot access private variables using child reference
	}

}
