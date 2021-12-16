package javaOOP;

public class Topic_01_Class_Object_Student {

	private int studentID;
	private int getStudentID() {
		return studentID;
	}

	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	private String getStudentName() {
		return studentName;
	}

	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	private float getKnowledgePoint() {
		return knowledgePoint;
	}

	private void setKnowledgePoint(float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	private float getPracticePoint() {
		return practicePoint;
	}

	private void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}

	private Float getaveragePoint() {
		return (this.knowledgePoint + this.practicePoint * 2) / 3;
	}
	
	private void showStudentInfor() {
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student NAme = " + getStudentName());
		System.out.println("Student knowledge Point = " + getKnowledgePoint());
		System.out.println("Student practice Point = " + getPracticePoint());
		System.out.println("Student average Point = " + getaveragePoint());

	}
	
	
	
	private String studentName;
	private Float knowledgePoint;
	private Float practicePoint;
	
	public static void main(String[] args) {
 
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(1010);
		firstStudent.setStudentName("John");
		firstStudent.setKnowledgePoint(8.5f);
		firstStudent.setPracticePoint(7.5f);
        firstStudent.showStudentInfor();
        
        
        Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
        secondStudent.setStudentID(1011);
        secondStudent.setStudentName("ddep");
        secondStudent.setKnowledgePoint(7.5f);
        secondStudent.setPracticePoint(7.5f);
        secondStudent.showStudentInfor();
       
        
	}

}
