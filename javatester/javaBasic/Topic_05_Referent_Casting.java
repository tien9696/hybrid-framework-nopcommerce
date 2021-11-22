package javaBasic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_Referent_Casting {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void showstudentName() {
		System.out.println("Student name = " + studentName);
	}
	public static void main(String[] args) {
		Topic_05_Referent_Casting firstStudent = new Topic_05_Referent_Casting();
		
		Topic_05_Referent_Casting secondStudent = new Topic_05_Referent_Casting();

		firstStudent.setStudentName("Nguyen van nam");
		secondStudent.setStudentName("Nguyen van long");
		
		firstStudent.showstudentName();
		secondStudent.showstudentName();
		
		secondStudent.setStudentName("Dao M Dam");
		
		firstStudent.showstudentName();
		secondStudent.showstudentName();
		
		
		WebDriver driver = null;
		JavascriptExecutor jsExcecutor = (JavascriptExecutor) driver;
		
		
	}

	
		
	}
	

