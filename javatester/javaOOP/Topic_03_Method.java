package javaOOP;

public class Topic_03_Method {

	private void showCarName() {
		System.out.println("Huyn dai");
	}
	
	static void showCarColor() {
		
	}
	
	public static void main(String[] args) {

		//gọi vào trong hàm static khác được
		showCarColor();
		Topic_03_Method.showCarColor();
		
		//goi qua instance / object
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName();
		
		
	}

}
