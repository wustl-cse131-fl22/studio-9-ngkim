package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> students;
	
	public UniversityDatabase() {
		this.students = new HashMap<>();
	}
	public void addStudent(String accountName, Student student) {
		students.put(accountName, student);
	}

	public int getStudentCount() {
		return students.size();
	}

	public String lookupFullName(String accountName) {
		Student s = students.get(accountName);
		if(s == null) {
			return null;
		} else {
			return s.getFullName();
		}
	}

	public double getTotalBearBucks() {
		double sum = 0;
		for(String account : students.keySet()) {
			Student s = students.get(account);
			sum += s.getBearBucksBalance();
		}
		return sum;
	}
}
