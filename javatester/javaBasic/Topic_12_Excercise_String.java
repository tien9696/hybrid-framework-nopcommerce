package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Excercise_String {

	String courseName = "Automation Tesing Advanced 2020";
	
	public void TC_01() {
		char courseNameArr[] = courseName.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;

		for (char character : courseNameArr) {

			//upper case
			if(character <= 'Z' && character >= 'A') {
				countUpper++;
			}
			//lower case
			if(character <= 'z' && character >= 'a') {
				countLower++;
			}
			//number
			if(character <= '9' && character >= '0') {
				countNumber++;
			}
		}
		System.out.println("Sum of upperase = " + countUpper);
		System.out.println("Sum of upperase = " + countLower);
		System.out.println("Sum of upperase = " + countNumber);

	}
	
	
}
