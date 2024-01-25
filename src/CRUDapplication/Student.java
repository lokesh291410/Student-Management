package CRUDapplication;

public class Student {
	private int sID;
	private String name;
	private String course;
	private int score;
	
	public Student(int sID, String name, String course, int score) {
		this.sID = sID;
		this.name = name;
		this.course = course;
		this.score = score;
	}
	
	public int getsID() {
		return sID;
	}
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [sID=" + sID + ", name=" + name + ", course=" + course + ", score=" + score + "]";
	}
}
