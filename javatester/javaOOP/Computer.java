package javaOOP;

public abstract class Computer {

	public void showComputerPerformance() {
		System.out.println();
	}
	
	
	//ko có phần thân
	//là khung để class con kế thừa nó phải overide lại (implement)
	public abstract void showComputerRam();
}
