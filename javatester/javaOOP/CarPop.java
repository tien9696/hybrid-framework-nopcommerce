package javaOOP;

public class CarPop {

	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main (String[] args) {
		carCompany = "Honda";
		carType = "City";
		fuelType = "Pertrol";
		mileAge =200f;
		carPrice= 50000d;
		
		System.out.println("Car company = " + carCompany);
		System.out.println("Car Type = " + carType);
		System.out.println("Car fuel = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car price = " + carPrice);

		carCompany = "Toyota";
		carType = "Accent";
		fuelType = "Diesel";
		mileAge =150f;
		carPrice= 60000d;
		
		System.out.println("Car company = " + carCompany);
		System.out.println("Car Type = " + carType);
		System.out.println("Car fuel = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car price = " + carPrice);

	}
}
