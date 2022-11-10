
//Ethan Massingill
import java.io.*;
import java.util.Scanner;
import java.sql.*;


public class Driver {


    public static void main(String[] args) throws SQLException, IOException
	{
    	//connect to database server	
    	Connection conn;
		try
		{
			String url = "jdbc:mysql://localhost/bankaccount";  //test is the database name
			String user = "Student"; //username THIS WILL CHANGE TO AN OBJECT PASSED IN BY LOGIN. DEPENING ON ROLL THIS WILL ONLY BE SELECTED IF CURRENT USER IS SELECTED
			String password = "t123456"; //root password, you set it when you install the DBMS

			PreparedStatement st = conn.PreparedStatement("select* from users where uname=? and pass=?");
			st.setString(1, user);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();

			if(rs.next()){
				String username = rs.getString("uname");
				String role = rs.getString("role");
				if (role=null || role.isEmpty()){
					return;
				}
				else if (role.equals("student")){
					
				}
			}
			
		    //print menu


			//temp values for error checking DELETE 
			String STUDID = "U1234";
			String CRN = "2345";
			String COURSENUM = "U101";
			String DEPART = "SCI";


			//END OF TEMP VALUES FOR TEST CASE

			Scanner scan = new Scanner(System.in);
			//CREATES THE SQL CUSTOM CLASS FROM STUDENTSSQL;
			StudentSQL SQL = new StudentSQL();
			int command;
			String input;
	        boolean keepGoing = true;
	        while (keepGoing == true)
	        {
	            printmenu();
	            input = scan.nextLine();
	            command = Integer.parseInt(input);
				
				switch(command)
				{
					case 1: SQL.studentView(conn, STUDID);; break;
					case 2: SQL.add_course(conn, STUDID, CRN, COURSENUM); break;
					case 3: SQL.student_drop(conn, CRN, STUDID); break;
					case 4: SQL.add_student(conn, scan); break;	
					case 5: SQL.delete_student(conn, scan); break;
					case 6: SQL.register_course(conn, scan); break;
					case 7: SQL.show_regist(conn, scan); break;
					
					case 0: 
						System.out.println("The Session has been ended, Thank you!");
	               	    keepGoing = false;
	               	    conn.close(); //close database connection   
						break;
				}    		            			
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
			System.out.println("4. Add a Student");
			System.out.println("5. Delete a Student"); 
			System.out.println("6. Register a course");
			System.out.println("7. Check student registration");   
	      	System.out.println("0. Quit ");
	      	System.out.println();
	      	System.out.println("Please choose an option");
    }
}


