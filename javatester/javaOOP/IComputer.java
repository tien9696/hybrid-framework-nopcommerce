package javaOOP;

public interface IComputer {

	//interface chỉ chưa abstract method
	//nếu ko gán từ khóa abstract cho hàm thì tự hiểu đây vẫn là 1 hàm abstract
	public abstract void showComputerRam();

	//interface ko được phép chứa các method thường
//	public void showComputerPerformance() {
//		System.out.println();
//	}
}
