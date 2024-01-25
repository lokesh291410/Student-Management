package CRUDapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDao {
	public static void sIDException(int sID) throws SQLException, InvalidsIDException {
		int count = 0;
		ArrayList<Student> slist = readStudent();
		for(Student st : slist) {
			if(st.getsID() == sID) {
				count = 1;
				break;
			}
		}
		if(count == 0) {
			throw new InvalidsIDException("sID not found");
		}
	}
	public static void createStudent(Student std) throws SQLException {
		Connection conn = DB.createDB();
		String query = Query.create();
		PreparedStatement stm = conn.prepareStatement(query);
		stm.setInt(1, std.getsID());
		stm.setString(2, std.getName());
		stm.setString(3, std.getCourse());
		stm.setInt(4, std.getScore());
		stm.executeUpdate();
	}
	public static void updateStudent(int sID, String up, String value) throws SQLException, InvalidsIDException {
		Connection conn = DB.createDB();
		String query = Query.update(up);
		PreparedStatement stm = conn.prepareStatement(query);
		sIDException(sID);
		if ("score".equalsIgnoreCase(up)) {
            stm.setInt(1, Integer.parseInt(value));
        } else {
            stm.setString(1, value);
        }
		stm.setInt(2, sID);
		stm.executeUpdate();
	}
	public static ArrayList<Student> readStudent() throws SQLException {
		Connection conn = DB.createDB();
		String query = Query.read();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(query);
		
		ArrayList<Student> list = new ArrayList<Student>();
		while(rs.next()) {
			Student std = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			list.add(std);
		}
		return list;
	}
	public static void deleteStudent(int sID) throws SQLException, InvalidsIDException {
		Connection conn = DB.createDB();
		String query = Query.delete();
		PreparedStatement stm = conn.prepareStatement(query);
		sIDException(sID);
		stm.setInt(1, sID);
		stm.executeUpdate();
	}
}
