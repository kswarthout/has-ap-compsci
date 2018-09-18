
public abstract class Employee {
	
	private String name;
	private int id;
	private double payRate;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
		this.setPayRate(0);
	}
	
	public String changeName(String newName) {
		this.name = newName;
		return this.name;
	}
	
	abstract double getPay();
	
	public double giveRaise(double raiseAmt) {
		this.payRate += raiseAmt;
		return this.payRate;
	}
	
	@Override
	public String toString() {
		return "name: " + name + ", id: " + id + ", salary: " + getPayRate();
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

}
