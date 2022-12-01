package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
	/**
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 * @param id the ID number of the Student
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	/**
	 * @return the full name of the student
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 */
	public void setFullName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * @return the ID number of the student
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the ID number of the student
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param grade the course grade as a value between 0 and 4
	 * @param credits the number of credits given from the course
	 */
	public void submitGrade(double grade, int credits) {
		if(grade >= 1.7) {
			passingCredits += credits;
		} 
		attemptedCredits += credits;
		totalGradeQualityPoints += grade * credits;
	}
	
	/**
	 * @return the number of total attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	/**
	 * @return the number of total passing credits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * @return the GradePointAverage of the student
	 */
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / getTotalAttemptedCredits(); 
	}
	
	/**
	 * @return the student's class standing based on how many passing credits they have
	 */
	public String getClassStanding() {
		if(getTotalPassingCredits() < 30) {
			return "First Year";
		} else if(getTotalPassingCredits() < 60) {
			return "Sophomore";
		} else if(getTotalPassingCredits() < 90) {
			return "Junior";
		} else {
			return "Senior";
		}		
	}
	
	/**
	 * @return if the student is eligible for PhiBetaKappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (passingCredits >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		} else if (passingCredits >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param amount the amount to add to the bearBucksBalance
	 */
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	
	/**
	 * @param amount the amount to deduct from the bearBucksBalance
	 */
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	
	/**
	 * @return the bearBucksBalance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	
	/**
	 * @return the remaining balance minus a $10 administrative fee, while the refund is forfeited if the balance is equal to or less than $10
	 */
	public double cashOutBearBucks() {
		double refund = bearBucksBalance - 10;
		bearBucksBalance = 0;
		if(refund > 0) {
			return refund;
		} else {
			return 0;
		}
	}
	
	/**
	 * @param firstName the first name of the child
	 * @param other the other parent
	 * @param isHyphenated whether the last name should be hyphened
	 * @param id the student ID number of the child
	 * @return the child
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String childLastName;
		if (isHyphenated) {
			childLastName = this.lastName + "-" + other.lastName;	
		} else {
			childLastName = this.lastName;
		}
		Student newStudent = new Student (firstName, childLastName, id);
		newStudent.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		return newStudent;
	}
	
	/**
	 * @return the student's full name and student ID
	 */
	public String toString() {
		return getFullName() + getId();
	}
}
