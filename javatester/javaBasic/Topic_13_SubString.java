package javaBasic;

public class Topic_13_SubString {

	public static void main (String [] args) {
		
		String firstText = "id=Email";
		String secondText = "css=input[id='password']";
		String thirdText =  "xpath=//input[@id='password']";

		//SubString to tach chuoi
		System.out.println(firstText.substring(3));
		System.out.println(secondText.substring(4));
		System.out.println(thirdText.substring(6));

	}
}
