package javaOOP;

public class CarOOP {

	protected CarOOP(String carCompany, String carType, String fuelType, Float mileAge, Double carPrice) {
		super();
		this.carCompany = carCompany;
		this.carType = carType;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	private String carCompany;
	private String carType;
	private String fuelType;
	
	protected String getCarCompany() {
		return carCompany;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getCarType() {
		return carType;
	}

	protected void setCarType(String carType) {
		this.carType = carType;
	}

	protected String getFuelType() {
		return fuelType;
	}

	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected Float getMileAge() {
		return mileAge;
	}

	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	protected Double getCarPrice() {
		return carPrice;
	}

	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfor() {
		System.out.println("Car company = " + getCarCompany());
		System.out.println("Car Type = " + getCarType());
		System.out.println("Car fuel = " + getFuelType());
		System.out.println("Car mile Age = " + getMileAge());
		System.out.println("Car price = " + getCarPrice());
	}
	
	private Float mileAge;
	private Double carPrice;

	public static void main (String[] args) {
		//Honda
		CarOOP honda = new CarOOP("Honda", "City", "petrol", 150f, 50000d);
			honda.showCarInfor();
		
		
//		    honda.setCarCompany("Honda");
//			honda.setCarType("City");
//			honda.setFuelType("petrol");
//			honda.setMileAge(150f);
//			honda.setCarPrice(50000d);
//			
			
		}
}
