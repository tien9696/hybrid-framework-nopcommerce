package javaBasic;

public class Topic_05_Casting {

	public static void main(String[] args) {

		//kieu Ngam Dinh (ko mat du lieu)
//		byte bNumber = 126;
//		System.out.println(bNumber);
//		
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//
//		
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//
//
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//
//		
//		double dNumber = fNumber;
//		System.out.println(dNumber);

		//kieu Tuong Minh
		double dNumber = 456798646154d;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
	    System.out.println(lNumber);
	    
	    int iNumber = (int) lNumber;
	    System.out.println(iNumber);
	    


		
		
		
	}

}
