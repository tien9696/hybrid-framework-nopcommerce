package javaOOP;

public class Topic_04_Non_Access_Modifier {

	// Static variable / Method
	// dùng cho all các instance / object
	// phạm vi cho all system sủ dụng(global)
	// có thể overide được (gán lại giá trị được)
	static String browserName = "chrome";
	// Non static
	String severName = "Testing";

	// biến final phải khởi tạo ngay từ đầu(hằng số)
	final String colorCar = "Red";

	final static String REGISTER_BUTTON = "";

	public static void main(String[] args) {

		System.out.println(browserName);

		browserName = "firefox";
		System.out.println(browserName);

		// Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		// System.out.println(topic.severName);
		//
		// // ko được phép gán lại giá trị
		// System.out.println(topic.colorCar);
		//
		// topic.clickToElement("button");
		// sendKeyToElement("Link");

	}

	// Non static
	public void clickToElement(String elementName) {
		System.out.println(elementName);
	}

	// static
	public static void sendKeyToElement(String elementName) {
		System.out.println(elementName);
	}

	// final method
	// ko được overiding
	// final class thì ko được kế thừa, nhưng được khởi tạo thông qua new
	public final void setCarName() {

	}

	// abstract class ko cho khởi tạo đối tượng, nhưng được kế thừa

}
