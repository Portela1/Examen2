import java.util.ArrayList;

public class UPRMStudent {
	
	private String studentId;
	private String firstName;
	private String lastName;
	private String academicProgram;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private double gpa;

	public UPRMStudent(String studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAcademicProgram() {
		return academicProgram;
	}

	public int getBirthDate() {
		return birthDay;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public double getGpa() {
		return gpa;
	}
	
	public void setAcademicProgram(String academicProgram) {
		this.academicProgram = academicProgram;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void setBirthDate(int day, int month, int year) {
		this.birthDay = day;
		this.birthMonth = month;
		this.birthYear = year;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof UPRMStudent) {
			UPRMStudent s = (UPRMStudent) o;
			return s.getStudentId().equals(this.getStudentId());
		}
		return false;
	}
		
	/*
	 * Returns the UPRMStudent with the highest GPA among all students in the given roster.
	 * Returns null if the roster is empty
	 */
	public static UPRMStudent maxGPA(UPRMStudent[] roster) {
		if(roster.length == 0) {
			return null;
		}
		int index = 0;
		double max = roster[0].getGpa();
		for(int i = 0; i<roster.length;i++) {
			if(roster[i].getGpa() > max) {
				index = i;
			}
		}
		return roster[index]; // dummy return
	}
	
	/*
	 * Returns true if all students in the roster have a GPA higher or equal that that of the target student
	 * Stops searching as soon as a student is found with lower GPA than the target
	 */
	public boolean allWithHigherGPA(UPRMStudent[] roster) {
		for(UPRMStudent i : roster) {
			if(this.gpa>i.gpa) {
				return false;
			}
		}
		return true; // Dummy return
	}
	
	/*
	 * Returns a new array of students containing only those students from the given roster that belong
	 * to the given academic program
	 * The resulting array must not contain any null entries
	 * Returns empty array (length == 0) if no students belong to the program
	 */
	public static UPRMStudent[] filterByProgram(String program, UPRMStudent[] roster) {
		UPRMStudent[] r = new UPRMStudent[roster.length];
		
		int count = 0;
		for(int i = 0; i<roster.length; i++) {
			if(roster[i].getAcademicProgram().equals(program)) 
			{
				r[count] = roster[i];
				count++;
			}
		}
		UPRMStudent[] r1 = new UPRMStudent[count];
		
		for(int i = 0; i<count;i++) {
			r1[i] = r[i];
		}
		
		
		
		if(roster.length == 0 || count == 0) {
			return new UPRMStudent[0];
		}
		else {
		return r1;
		}
	}

	/* Returns the new course roster resulting from adding the
	 * target student at the end of the original roster
	 * You may assume that the target student is not already in 
	 * the course.
	 */
	public UPRMStudent[] append(UPRMStudent[] courseRoster) {
		
		
		if(courseRoster.length == 0) {
			UPRMStudent[] r1 = new UPRMStudent[1];
			r1[0] = this;
			return r1;
		}
		else if(courseRoster.length == 1) {
			UPRMStudent[] r1 = new UPRMStudent[2];
			r1[0] = courseRoster[0];
			r1[1] = this;
			return r1;
		}
		else {
			UPRMStudent[] r1 = new UPRMStudent[courseRoster.length+1];
			for(int i = 0;i<courseRoster.length;i++) {
				r1[i] = courseRoster[i];
			}
			r1[r1.length-1] = this;
			return r1;
		}
		
		
		
	}
}

