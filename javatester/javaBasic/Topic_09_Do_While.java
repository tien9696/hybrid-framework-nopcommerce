package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Do_While {
	static Scanner scanner = new Scanner(System.in);
	static String Name = "An";

	
	public void TC_03() {
		int number = scanner.nextInt();
		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}

	
	public void TC_04_While() {
		int number = scanner.nextInt();
		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);

			}
			number++;
		}

	}

	
	public void TC_05() {
		int number = scanner.nextInt();
		do {
			if (number % 2 == 0) {
				System.out.println(number);

			}
			number++;
		} while (number < 100);

	}

	public void TC_06() {
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 3 == 0 && number % 5 == 0) {
				System.out.println(number);

			}
			number++;
		}

	}

	public void TC_07() {
		int number = scanner.nextInt();

		int i = 0;
		while (number > 0) {
			if (number % 2 != 0) {
				System.out.println(number);
				i += number;
			}
			number--;
		}
		System.out.println(i);

	}

	public void TC_08() {
		int number = scanner.nextInt();

		int i = 1;
		while (number > 0) {
			i *= number;
			number--;
		}
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		/*do {
			System.out.println(i);
			i+=1;
		}while(i < 10);
	*/

	
	while (i<10) {
		System.out.println(i);
	i+=1;	
	} 
	}
}
