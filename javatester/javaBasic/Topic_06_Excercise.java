package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Excercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);
	String projectPath = System.getProperty("user.dir");

	//@Test
	public void TC_01() {
		int number = scanner.nextInt();
		
//		int afternumber  = number %2;
//		System.out.println(afternumber);
//		
//		boolean status = afternumber == 0;
//		System.out.println(status);
		
		if(number %2== 0) {	
		System.out.println("So : " + number +  " la so chan");
		}else {
			System.out.println("So : " + number +  " la so le");
		}
		
		
//		Scanner scanner = new Scanner(System.in);
//		int age = scanner.nextInt();
//		System.out.println(age);
//		
		
		
	}
	

	//@Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();

		if (numberA > numberB) {
			System.out.println(numberA + " lon hon  " + numberB );
		}else if (numberA == numberB) {
			System.out.println(numberB + " bang " + numberB);
		}else {
			System.out.println(numberA + " nho hon " + numberB);
		}
		
	}

	//@Test
	public void TC_03() {
		String firstname = scanner.nextLine();
		String secondname = scanner.nextLine();

		//dung Equals vi la text/ neu la so thi dung ==
		//Reference String
		if (firstname.equals(secondname)) {
			System.out.println("Hai sv giong ten nhau");
		} else {
           System.out.println("Hai sv khac ten nhau");
		}
	
	
	}

	//@Test
	public void TC_04() {
		int NumberA = scanner.nextInt();
		int NumberB = scanner.nextInt();
		int NumberC = scanner.nextInt();

	   if (NumberA > NumberB && NumberA > NumberC) {
		   System.out.println(NumberA + " la so lon nhat");
	   }else if (NumberB > NumberC) {
		   System.out.println(NumberB + " la so lon nhat");
	   }else {
		   System.out.println(NumberC + " la so lon nhat2");
	   }
		
		
	}
	//@Test
	public void TC_05() {
		int numberA = scanner.nextInt();
		if (10 < numberA  && numberA < 100 ) {
			System.out.println(numberA + " nam trong khoang ");
		} else {
			System.out.println(numberA + " nam ngoai khoang ");

		}
	}
	
	@Test
	public void TC_06() {

		float numberA = scanner.nextFloat();
		
		
		if(numberA <= 10 && numberA >= 8.5) {
			System.out.println(" He so A");
		}else if(numberA <8.5 && numberA>= 7.5) {
			System.out.println(" he so B");
		}else if(numberA <7.5 && numberA>= 5) {
			System.out.println(" he so C");

		}else if(numberA <5 && numberA>= 0) {
			System.out.println(" he so D");

		}else {
			System.out.println("Ban vui long nhap so thich hop");
		}
		
	}

	//@Test
	public void TC_07() {
		int month = scanner.nextInt();
		
		if(month == 1 || month == 3 ||month == 5 || month == 7 || month == 8|| month == 12)  {
			System.out.println(" Thang nay co 31 ngay");
		}else if (month == 2) {
			System.out.println("Thang nay co 28 ngay");
		}else if(month == 4 || month == 6 || month == 11 || month == 9 ) {
			System.out.println("Thang nay co 30 ngay");
		}
		
		
	}
	

}
