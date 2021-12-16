package javaOOP;

import org.openqa.selenium.remote.server.handler.ClickElement;

public class Testing_II extends Animal {

	
	public static void main(String[] args) {
		
		
		//truy cập trực tiếp từ tên class
		//ko cần tạo object
		//ko nê lạm dụng tạo các biến là static
		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		
		//khởi tạo các cái class
		Topic_04_Non_Access_Modifier.sendKeyToElement("Link");
		
		
//		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier ();
//		System.out.println(topic.colorCar);
//		
	
		
	}
		
	//lớp lồng (khi có nested mới tạo được class static)
		public static class NestedTesting {
			
        }
	
	@Override
	void setAnmalName() {
		
	}
	
	
	
}
