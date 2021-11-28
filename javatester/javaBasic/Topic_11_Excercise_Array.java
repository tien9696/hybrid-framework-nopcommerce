package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Excercise_Array {

	int number[] = {74, 85, 0, 58, 25};
	
	
	
	public void TC_01_Find_Max_Number() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			//nếu x < i thì gán x = i 
			if(x < number[i]) {
				x = number[i];
			}
			
		}
			System.out.println("Max number = " + x);	
	}

	public void TC_02_Sum_First_And_Last_Number() {
//		int x = 0;
//		for (int i = 0; i < number.length; i++) {
	System.out.println(number[0] + number[number.length - 1]);
		
		
	}
	
	
	public void TC_03_() {
		for (int i = 0; i < number.length; i++) {
			if(number[i] % 2 == 0){
			System.out.println("Even number = " + number[i]);
			}
		}
	}
	
	public void TC_04_() {
		for (int i = 0; i < number.length; i++) {
			if(number[i] >= 0 && number[i] <= 10) {
				System.out.println("number in (0 <= number <= 10) = " + number[i]);
			}
		}
	}
	
	public void TC_05_() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			// sum = sum + number[i]
			sum += number[i];
			
			//1 sum = 0 + 74 = 74
			//2 sum = 74 + 85 = ...
			//6 sum = ... + 25 = ...
		}
		
		System.out.println("Sum all number = " + sum);
		float average =  sum /number.length;
		
		System.out.println("Average all number = " + average);
	}
	
	
}
