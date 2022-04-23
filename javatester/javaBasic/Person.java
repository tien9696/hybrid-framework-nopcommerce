package javaBasic;

public class Person {

	 String name;
	 int age;
	 float height;
	
	public Person(String name, int age, float height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public void eat(String foodName) {
		System.out.println(name + "is eating" + foodName);
	}
	
	public int getAge() {
		return age;
	}
	public Person() {
	
	}



}



