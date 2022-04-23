package javaBasic;

public class HelloPerson {

	public static void main(String[] args) {

		Person[] a = new Person[3];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = new Person();
			a[i].age = i;
			a[i].height = 1.6f;
			a[i].name = "Ten " + i;
		}
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i].name);
			System.out.println(a[i].age);
			System.out.println(a[i].height);

		}

	}

}
