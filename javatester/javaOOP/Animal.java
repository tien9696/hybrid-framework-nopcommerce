package javaOOP;


//abstract class
//template
public abstract class Animal {

	//variable (ko dùng abstract đc)
	  String animalName = "Dog";
	  
	//method
	  //ko có phần thân
	  //public, protected
	  //bắt buộc các class con phải overide các hàm lại
	abstract void setAnmalName();
	
	
	
}
