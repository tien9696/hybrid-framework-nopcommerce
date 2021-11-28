package javaAccModSecond;

import javaAccModFirst.Computer;

public class PC extends Computer {
	public static void main(String[] args) {
		Computer comp = new Computer();

		// Property
		comp.vgaSize = 6;
		System.out.println(comp.vgaSize);
		// Method
		comp.setVgaSize(4);
		System.out.println(comp.vgaSize);

	}

	// //Property
	// comp.ramProductName = "Kington";
	// System.out.println(comp.ramProductName);
	// //Method
	// comp.setRamProductName("Kingmax");
	// System.out.println(comp.ramProductName);
	//
	//

	public void showCPUProductName() {

		cpuProductName = "Kington";
		System.out.println(cpuProductName);

		setCpuProductName("Kingmax");
		System.out.println(cpuProductName);

	}

}
