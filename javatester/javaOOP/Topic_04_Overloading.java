package javaOOP;

public class Topic_04_Overloading {
	static int plusMethodInt(int x, int y) {
		return x + y;
	}

	static double plusMethodDouble(double x, double y) {
		return x + y;

	}

	static int plusMethod(int x, int y) {

		return x + y;
	}

	static double plusMethod(double x, double y) {

		return x + y;

	}

	public static void main(String[] args) {
		// int number1 = plusMethodInt(5, 4);FFFFF
		// double number2 = plusMethodDouble(5.5, 83.4);
		//
		int number1 = plusMethod(8, 62);
		System.out.println(plusMethod(8.57, 6.2));
		System.out.println(plusMethod(8, 6));


	}

}
