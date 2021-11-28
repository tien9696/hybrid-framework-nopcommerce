package javaAccModSecond;

import javaAccModFirst.Computer;

public class Workstation {

	public static void main(String[] args) {
		Computer comp = new Computer();

		// Property
		comp.vgaSize = 6;
		System.out.println(comp.vgaSize);
		// Method
		comp.setVgaSize(4);
		System.out.println(comp.vgaSize);

	}
	//
	//
	//// public static void main (String[] args) {
	//// Computer comp = new Computer();
	//// //Property
	//// comp.ramProductName = "Kington";
	//// System.out.println(comp.ramProductName);
	//// //Method
	//// comp.setRamProductName("Kingmax");
	//// System.out.println(comp.ramProductName);
	////
	////
	//// }
	//// }
	// public static void main (String[] args) {
	// Computer comp = new Computer();
	// //Property
	// comp.cpuProductName = "Kington";
	// System.out.println(comp.cpuProductName);
	// //Method
	// comp.setCpuProductName("Kingmax");
	// System.out.println(comp.cpuProductName);
	//
	//
	//
	// }

}
