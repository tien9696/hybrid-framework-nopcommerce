package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_12_String {

	

	public void TC_01() {
		// System.setProperty("webdriver.gecko.driver", ".\\BrowserDriver\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		String SchoolName = "Automation Testing Advanced";
		String CourseName = "automation testing advanced";

		String SchoolAddress = "Da Nang";

		System.out.println("Độ dài = " + SchoolName.length());
		System.out.println("lây sra 1 lí tự = " + SchoolName.charAt(0));
		System.out.println("Nối 2 chuỗi = " + SchoolName + (SchoolAddress));

		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + SchoolName.equals(SchoolAddress));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + SchoolName.equals("Automation Teting Advanced"));
		// ko phân biêt hoa thường (Multi Browser)
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + SchoolName.equalsIgnoreCase(CourseName));

		// startwith/ endwith/ contains
		System.out.println("có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + SchoolName.startsWith("A"));
		System.out.println("có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + SchoolName.startsWith("T"));

		System.out.println("có chứa 1 kí tự/ chuỗi kí tự = " + SchoolName.contains("Auto"));
		System.out.println("có chứa 1 kí tự/ chuỗi kí tự = " + SchoolName.contains("Testing"));

		System.out.println("có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + SchoolName.endsWith("T"));
		System.out.println("có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + SchoolName.endsWith("d"));
		System.out.println("có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + SchoolName.endsWith("Advanced"));

		// index
		System.out.println("Vin trí của 1 kí tự/ chuỗi kí tự trong chuỗi  = " + SchoolName.indexOf("Automation"));
		System.out.println("Vin trí của 1 kí tự/ chuỗi kí tự trong chuỗi  = " + SchoolName.indexOf("A"));
		System.out.println("Vin trí của 1 kí tự/ chuỗi kí tự trong chuỗi  = " + SchoolName.indexOf("Testing"));

		//
		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi  = " + SchoolName.substring(11));
		System.out.println("Tách 1 kí tự/ chuỗi kí tự trong chuỗi  = " + SchoolName.substring(11, 15));

		// split : tách chuỗi thành mảng dựa vào kí tự hoặc chuỗi kí tự
		String result = "view 48 of 123 results";
		String results[] = result.split(" ");

		System.out.println(results[1]);
		System.out.println(results[0]);
		System.out.println(results[2]);

		// replace
		String productPrice = "100.00";
		productPrice.replace("$", " ");
		System.out.println(productPrice);

		// Sắp xếp nó: sort data (Asc/ Desc)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);

		productPrice = String.valueOf(productPriceF);
		productPrice = String.valueOf(productPrice);

		// Handle mutiple Os: Mac/ win...

		// String osName = System.getProperty("os.Name");
		// System.out.println(osName);
		//
		// if(osName.toLowerCase().contains("windowns")) {
		// Keys key = Keys.CONTROL;
		// }else {
		// Keys key = Keys.COMMAND;
		// }

		// String driverInstanceName = driver.toString();
		// System.out.println(driverInstanceName);

		// close browser/ driver
		// if(driverInstanceName.contains("internetexplorer")) {
		// sleep cứng thêm 5s chuyển page
		// }

		// trim
		String helloWorld = " \n  \t    helloWold";
		System.out.println(helloWorld.trim());
		System.out.println(helloWorld);

		helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty());
		// Blank vẫn chứa kí tự thì true
		System.out.println("Blank = " + helloWorld.isBlank());

		// Dynamic locator
		// ĐẠi diện cho 1 chuỗi : %s
		// %b %c %d
		String dynamicButonXpath = "button[@id='%s']";
		System.out.println("click to login button = " + String.format(dynamicButonXpath, "Login"));
		System.out.println("click to login search = " + String.format(dynamicButonXpath, "Search"));

	}

	@Test

	public void TC_02() {
		
	}
	
}
