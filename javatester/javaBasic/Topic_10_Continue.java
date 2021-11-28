package javaBasic;

public class Topic_10_Continue {

	public static void main(String[] args) {

		for(int y = 0; y < 10; y++) {
			//loai tru so 5 ra
			if(y==5) {
				continue;
			}
			System.out.println(y);
	
		}
		
		for (int i = 0; i <= 5; i++) {
			System.out.println("Lan chay cua i (for thu nhat) = " + i);
			//i=1
			//moi 1 lan chay cua for tren se apply cho tat ca cac lan chay cua for duoi
			for (int j = 1; j <= 5; j++) {
				if( j == 4) {
					continue;
					
				}
				System.out.println("Lan chay cua j (for thu 2) = " + j);
				for (int x = 0; x <= 5; x++) {
					if(x==4) {
						continue;
					}
					System.out.println("x cua for thu 3 = " + x);
				}
			}
		}
	}
	//Nested for
	

}
