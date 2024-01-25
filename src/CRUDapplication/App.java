package CRUDapplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException, InvalidsIDException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Student Management");
		System.out.print("(1:add, 2:read, 3:update, 4:delete): ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		if(choice == 3) {
			System.out.print("(1:update name, 2:update course, 3:update score): ");
			int upchoice = sc.nextInt();
			sc.nextLine();
			System.out.print("Student ID: ");
			int sID = sc.nextInt();
			sc.nextLine();
			switch (upchoice) {
			case 1: {
				System.out.print("new name: ");
				String newname = sc.nextLine();
				StudentDao.updateStudent(sID, "name", newname);
				System.out.println("database updated succesfully");
				break;
			}
			case 2: {
				System.out.print("new course: ");
				String newcourse = sc.nextLine();
				StudentDao.updateStudent(sID, "course", newcourse);
				System.out.println("database updated succesfully");
				break;
			}
			case 3: {
				System.out.print("new score: ");
				String newscore = sc.nextLine();
				StudentDao.updateStudent(sID, "score", newscore);
				System.out.println("database updated succesfully");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + upchoice);
			}
		}else {
			switch (choice) {
			case 1: {
				System.out.print("Student ID: ");
				int sID = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Student name: ");
				String name = sc.nextLine();
				
				System.out.print("Course: ");
				String course = sc.nextLine();
				
				System.out.print("score: ");
				int score = sc.nextInt();
				sc.nextLine();
				
				Student std = new Student(sID, name, course, score);
				StudentDao.createStudent(std);
				System.out.println("New student added succesfully");
				break;
			}
			case 2: {
				ArrayList<Student> list = StudentDao.readStudent();
				list.forEach(student->System.out.println(student));
				break;
			}
			case 4: {
				System.out.print("Student ID: ");
				int sID = sc.nextInt();
				sc.nextLine();
				StudentDao.deleteStudent(sID);
				System.out.println("student data deleted successfully");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
	}

}
