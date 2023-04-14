package lib;

public class TaxFunction {
	private static final int tax_single = 54000000;
	private static final int tax_married = 58500000;
	private static final int tax_child = 1500000;
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (tax_single + tax_married + (numberOfChildren * tax_child))));
		}else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - tax_single));
		}
		


		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}
