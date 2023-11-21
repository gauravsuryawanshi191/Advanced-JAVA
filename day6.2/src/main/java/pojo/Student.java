package pojo;

public class Student {
private String FName;
private String lName;
private int marks;
private String course;
public Student() {
	super();
}
public Student(String fName, String lName, int marks, String course) {
	super();
	FName = fName;
	this.lName = lName;
	this.marks = marks;
	this.course = course;
}
public String getFName() {
	return FName;
}
public void setFName(String fName) {
	FName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
@Override
public String toString() {
	return "Student [FName=" + FName + ", lName=" + lName + ", marks=" + marks + ", course=" + course + "]";
}

}
