package javaBasic;

import java.util.Iterator;

public class Topic_11_Array {

	public static void main(String[] args) {

		int[] student = {12, 5, 57, 8, 9};
		System.out.println(student[4]);
		System.out.println(student[1]);

		
		String studentName[]= {"Nam", "Long", "An"};
		studentName[0] = "Hoa";
		
		for (String std : studentName) {
			if(std.equals("Long")) {
				System.out.println("Click to Long");
			}
			
		}
		int b[]= new int[5];
		b[0] = 10;
		
		for (int i = 0; i < studentName.length; i++) {
			
			if(i == 2) {
				System.out.println(studentName[i]);

			}
		}
		//ko pho bien
//		for (String a : studentName) {
//			System.out.println(a);
//		}
	}

}
