package CRUDapplication;

public class Query {
	public static String create() {
		return "insert into student values (?,?,?,?)";
	}
	public static String read() {
		return "select * from student";
	}
	public static String update(String up) {
		return String.format("update student set %s = ? where sID = ?",up);
	}
	public static String delete() {
		return "delete from student where sID = ?";
	}
	
}
