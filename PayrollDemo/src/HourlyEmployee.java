
public class HourlyEmployee extends Employee {

	private int hoursWorked;

	public HourlyEmployee(String name, int id) {
		super(name, id);
	}

	@Override
	double getPay() {
		double pay = 0.0;
		double overtimePay = 0.0;

		if (hoursWorked > 40) {
			pay = 40 * getPayRate();
			int overtime = hoursWorked - 40;
			overtimePay = overtime * (getPayRate() * 1.5);
		} else {
			pay = hoursWorked * getPayRate();
		}

		return pay + overtimePay;
	}

}
