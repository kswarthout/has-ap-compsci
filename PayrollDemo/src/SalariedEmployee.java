
public class SalariedEmployee extends Employee {

	public SalariedEmployee(String name, int id) {
		super(name, id);
	}

	@Override
	double getPay() {
		return getPayRate() / 52;
	}

}
