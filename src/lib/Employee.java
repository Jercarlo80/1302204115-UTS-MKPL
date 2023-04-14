package lib;

import java.time.LocalDate;

import java.util.LinkedList;
import java.util.List;

public class Employee {
	private String idNumber;
	
	private int yearJoined;
	private int monthJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String idNumber, int yearJoined, int monthJoined, boolean isForeigner) {
	
	
		this.idNumber = idNumber;
	
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
	
		this.isForeigner = isForeigner;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	
	public void setMonthlySalary(int grade) {	
		switch (grade) {
			case 1:
				monthlySalary = 2000000;
				break;
			case 2:
				monthlySalary = 3000000;
				break;
			case 3:
				monthlySalary = 5000000;
				break;
			case 4:
				monthlySalary = 7000000;
			break;
			case 5:
				monthlySalary = 9000000;
			break;
			
			default:
				throw new IllegalArgumentException("Grade situation invalid: " + grade);
		}
		
		if (isForeigner) {
			monthlySalary *= 2.0;
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
