package javaBasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_ForEach {

	WebDriver driver;
	
 
	public void TC_01_For() {
		for (int i = 0; i<5; i++) {
			System.out.println();
		}
//			List<WebElement> Links = driver.findElements(By.id(""));
//	        Links.size();
	String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang"};
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[1].equals("Da Nang")) {
			System.out.println("Do action");
			break;
			}
		}
		
		//all element deu duoc chay qua du da thoa man dk
		for (int i = 0; i < cityName.length; i++) {
			if(cityName[1].equals("Da Nang")) {
			System.out.println("Do action");
		
			}
		}
	}
	
	@Test 
	public void TC_02_For_Each() {
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang"};

		for(String city : cityName) {
			System.out.println(city);
		}
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress);
		//combine
		cityAddress.add("Bac Giang");
		cityAddress.add("An Giang");
		cityAddress.add("Ha Giang");

		System.out.println(cityAddress);
 
		//Runtime
		for(String city : cityName) {
			cityAddress.add(city);
		}
		System.out.println(cityAddress);

	}
	
}
