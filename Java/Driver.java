

//Ethan Massingill
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.sql.*;

public class Driver {


    public static void main(String[] args) throws SQLException, IOException
	{
    	//connect to database server	
    	Connection conn;
		try
		{
			String input;
			System.out.print("Please input ID: ");
			Scanner scan = new Scanner(System.in);
			String userID = scan.nextLine();
			System.out.print("please input Password: ");
			String Newpassword = scan.nextLine();
			String url = "jdbc:mysql://localhost/sys";  //test is the database name
			String user = "root"; //username
			String password = "Password12345"; //root password, you set it when you install the DBMS

			conn = DriverManager.getConnection(url, user, password);
		    //print menu
			

			Statement st = conn.createStatement();
			
			String query = "select* from users where USERID= '"+userID +"' AND Password= '"+Newpassword+"';";

			ResultSet rs = st.executeQuery(query);
			String role = null;
			while(rs.next()){
				role = rs.getString("role");
			}


			
			//only for student

			if(Objects.equals(role, "Student")) {
				System.out.println("trying to connect...");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/sys", "Student", "StudentPassword");
				Student(conn, userID);
			}
			else if(role=="Professor"){
				conn = DriverManager.getConnection("jdbc:mysql://localhost/sys", "Professor", "ProfessorPassword");
				Professor(conn, userID);
			} else if (role=="Schooladmin") {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/sys", "Schooladmin", "SchoolPassword");
				SchoolAdmin(conn, userID);
			} else if (role=="Dbadmin") {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/sys", "Dbadmin", "DatabadminPassword");
				DatabaseAdmin(conn, userID);
			} else if (role==null) {
				conn.close();
				rs.close();
				return;
			}



		}
		catch (SQLException ex)
		{
			System.out.println("An error occurred when connecting to the database server.");
			ex.printStackTrace();
		}				
  }
    public static void printmenu()
    {
    		System.out.println();
    		System.out.println("*********************************************************************");
	      	System.out.println("");
	      	System.out.println("***                                                               ***");
	      	System.out.println("");
	      	System.out.println("***              Welcome to Online Registration System            ***");
	      	System.out.println("");
	      	System.out.println("***                                                               ***");
	      	System.out.println("");
	      	System.out.println("*********************************************************************");
	      	System.out.println("1. Add a course");
	      	System.out.println("2. Show all course");
			System.out.println("3. Delete a course");
			//System.out.println("4. Add a Student");
			//System.out.println("5. Delete a Student");
			//System.out.println("6. Register a course");
			System.out.println("7. Check student registration");   
	      	System.out.println("0. Quit ");
	      	System.out.println();
	      	System.out.println("Please choose an option");
    }




	public static void Student(Connection conn, String studid) throws SQLException, IOException {
		int command;

		boolean keepGoing = true;
		while (keepGoing == true) {
			printmenu();
			String input;

			//TESTING HARD CODE
			String crn1 = "12345";

			Scanner scan = new Scanner(System.in);
			input = scan.nextLine();
			command = Integer.parseInt(input);
			StudentSQL SQL = new StudentSQL();
			switch (command) {
				case 1:
					SQL.add_course(conn, studid, crn1);
					System.out.println("course was sucessfully registered!");
					break;
				case 2:
					//SQL.show_courses(conn);
					break;
				case 3:
					//SQL.delete_course(conn, scan);
					break;
				//case 4: SQL.add_student(conn, scan); break;
				//case 5: SQL.delete_student(conn, scan); break;
				//case 6: SQL.register_course(conn, scan); break;
				case 7:
					//SQL.show_regist(conn, scan);
					break;

				case 0:
					System.out.println("The Session has been ended, Thank you!");
					keepGoing = false;
					conn.close(); //close database connection
					break;
			}
		}
	}
	public static void Professor(Connection conn, String profid){
		
	}
	public static void SchoolAdmin(Connection conn, String SCHADID){
		
	}
	public static void DatabaseAdmin(Connection conn, String DBAID){
		
	}
}



