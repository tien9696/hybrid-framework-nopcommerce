package javaOOP;

public class Testing {

	public static void main(String[] args) {
		
		// có thể gọi biến ở class kia bằng cách khởi tạo
		Topic_02_Variable_Property_Method firstName = new Topic_02_Variable_Property_Method();
		
		firstName.studentAddress = "sđ kk";
		
		firstName.studentID = 5757;
		
		
		System.out.println(Topic_02_Variable_Property_Method.studentAddress);
		
		Topic_02_Variable_Property_Method.studentAddress = "Ha Noi";
		
		Topic_03_Method.showCarColor();

	}

}
