package javaOOP;

public class Topic_02_Variable_Property_Method {

	static int studentNumbers;
	static String studentCountry;
	static boolean studentstatus;

	// biến toàn cục
	private static String studentName = "Automation FC";
	// static variable : có thể gán dữ liệu lại được
	public static String studentAddress = "Ho Chi Minh";
	private static String studentPhone = "09354445550";

	// final variable
	public final String country = "Viet Nam";

	// static final
	static final float PI_NUMber = 3.14454f;

	int studentID = 5757;

	public static void main(String[] args) {
		// local variable : biến cục bộ /hàm
		String studentName = "Automation FC";

		if (studentName.startsWith("Automation")) {
			// local variable : biến cục bộ /hàm / block code
			int number = 100;
		}
		studentAddress = "Da Nang";

		// local variable bắt buộc khởi tạo mới dùng được
		int studentNumber = 1;
		String studentCountry = "2";
		boolean studentstatus = false;

		System.out.println(studentNumbers);
		System.out.println(studentCountry);
		System.out.println(studentstatus);
	}

	public Topic_02_Variable_Property_Method() {
		// local variable : biến cục bộ / contructor
		String studentName = "Automation FC";

		if (this.studentName.startsWith("Automation")) {
			// local variable : biến cục bộ /hàm / block code
			int number = 100;
		}

	}

	public void display() {
		// local variable : biến cục bộ /hàm
		String studentName = "Automation FC";

	}

	//variable agrument (String... params)
	
	
}
