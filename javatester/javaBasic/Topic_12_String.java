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

		System.out.println("Ä�á»™ dÃ i = " + SchoolName.length());
		System.out.println("lÃ¢y sra 1 lÃ­ tá»± = " + SchoolName.charAt(0));
		System.out.println("Ná»‘i 2 chuá»—i = " + SchoolName + (SchoolAddress));

		System.out.println("Kiá»ƒm tra 2 chuá»—i báº±ng nhau tuyá»‡t Ä‘á»‘i = " + SchoolName.equals(SchoolAddress));
		System.out.println("Kiá»ƒm tra 2 chuá»—i báº±ng nhau tuyá»‡t Ä‘á»‘i = " + SchoolName.equals("Automation Teting Advanced"));
		// ko phÃ¢n biÃªt hoa thÆ°á»�ng (Multi Browser)
		System.out.println("Kiá»ƒm tra 2 chuá»—i báº±ng nhau tÆ°Æ¡ng Ä‘á»‘i = " + SchoolName.equalsIgnoreCase(CourseName));

		// startwith/ endwith/ contains
		System.out.println("cÃ³ báº¯t Ä‘áº§u báº±ng 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.startsWith("A"));
		System.out.println("cÃ³ báº¯t Ä‘áº§u báº±ng 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.startsWith("T"));

		System.out.println("cÃ³ chá»©a 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.contains("Auto"));
		System.out.println("cÃ³ chá»©a 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.contains("Testing"));

		System.out.println("cÃ³ káº¿t thÃºc báº±ng 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.endsWith("T"));
		System.out.println("cÃ³ káº¿t thÃºc báº±ng 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.endsWith("d"));
		System.out.println("cÃ³ káº¿t thÃºc báº±ng 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± = " + SchoolName.endsWith("Advanced"));

		// index
		System.out.println("Vin trÃ­ cá»§a 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± trong chuá»—i  = " + SchoolName.indexOf("Automation"));
		System.out.println("Vin trÃ­ cá»§a 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± trong chuá»—i  = " + SchoolName.indexOf("A"));
		System.out.println("Vin trÃ­ cá»§a 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± trong chuá»—i  = " + SchoolName.indexOf("Testing"));

		//
		System.out.println("TÃ¡ch 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± trong chuá»—i  = " + SchoolName.substring(11));
		System.out.println("TÃ¡ch 1 kÃ­ tá»±/ chuá»—i kÃ­ tá»± trong chuá»—i  = " + SchoolName.substring(11, 15));

		// split : tÃ¡ch chuá»—i thÃ nh máº£ng dá»±a vÃ o kÃ­ tá»± hoáº·c chuá»—i kÃ­ tá»±
		String result = "view 48 of 123 results";
		String results[] = result.split(" ");

		System.out.println(results[1]);
		System.out.println(results[0]);
		System.out.println(results[2]);

		// replace
		String productPrice = "100.00";
		productPrice.replace("$", " ");
		System.out.println(productPrice);

		// Sáº¯p xáº¿p nÃ³: sort data (Asc/ Desc)
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
		// sleep cá»©ng thÃªm 5s chuyá»ƒn page
		// }

		// trim
		String helloWorld = " \n  \t    helloWold";
		System.out.println(helloWorld.trim());
		System.out.println(helloWorld);

		helloWorld = " ";
		System.out.println("Empty = " + helloWorld.isEmpty());
		// Blank váº«n chá»©a kÃ­ tá»± thÃ¬ true
		System.out.println("Blank = " + helloWorld.isEmpty());

		// Dynamic locator
		// Ä�áº i diá»‡n cho 1 chuá»—i : %s
		// %b %c %d
		String dynamicButonXpath = "button[@id='%s']";
		System.out.println("click to login button = " + String.format(dynamicButonXpath, "Login"));
		System.out.println("click to login search = " + String.format(dynamicButonXpath, "Search"));

	}

	@Test

	public void TC_02() {
		
	}
	
}
