import java.io.File;

public class Test_Seperator {

	public static void main(String[] args) {

	String PROJECT_PATH = System.getProperty("user.dir");
	String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "upLoadFiles" + File.separator ;
		
		System.out.println(UPLOAD_FOLDER_PATH);
	}

}
