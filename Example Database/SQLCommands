
//EXAMPLE SQL COMMMANDS 
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class SQLCommands {
	
	//this method adds a course to the registration table. First it checks to see if the corse already exists
	public void add_course(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
		Statement st = conn.createStatement();
		System.out.println("Add a course");
		System.out.println("Please input course code: ");
		String courseCode = keyboard.nextLine().toUpperCase().trim();
		System.out.println("Please input course title: ");
		String courseTitle = keyboard.nextLine().trim();
		String query = "select code from Course Where code = '" + courseCode + "'";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) 
		{
			System.out.println("Course already exists");
			return;
		}
		query = "Insert into Course (code, title) values ('" + courseCode + "', '" + courseTitle + "')";
		try 
		{
			st.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			System.out.println("Message: " + e.getMessage());
		
		}
		rs.close();
		st.close();
		System.out.println("A new course is added.");
	}
	//this method desplays all courses
	public void show_courses(Connection conn) throws SQLException, IOException
	{
		
		try
		(
			Statement st = conn.createStatement();
			
		)
		{
			String query = "select * from Course";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) 
			{
				 String code = rs.getString("code");
				 String title = rs.getString("title");
			     System.out.println("Code: " + code + "\tTitle: " + title);
			}
			rs.close();
			st.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Message: " + e.getMessage());
		
		}
	}
	//this method deletes a course and deletes its from the registration table
	public void delete_course(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
		Statement st = conn.createStatement();
		System.out.println("Delete a course");
		System.out.println("Please input course code: ");
		String courseCode = keyboard.nextLine().toUpperCase().trim();
		String query = "select code from Course Where code = '" + courseCode + "'";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()==false) 
		{
			System.out.println("This Coourse does not exist");
			return;
		}
		else { {
			query = "Delete From Registered Where code = ('" + courseCode+ "')";
			
		try 
		{
			st.executeUpdate(query);
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Message: " + e.getMessage());
		
		}
		}
		query = "Delete From Course Where code = ('" + courseCode + "')";
	
		try
		{
			st.executeUpdate(query);
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Message: " + e.getMessage());
		
		}
	   }
	   rs.close();
	   st.close();
	   System.out.println("The course "+ courseCode+"has been deleted sucessfully");
	}
	//this method adds a student
	public void add_student(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
		Statement st = conn.createStatement();
		System.out.println("Add a Student");
		System.out.println("Please input student ssn:");
		String studentSSN = keyboard.nextLine().trim();
		System.out.println("Please input student name in format: 'First Last'");
		String studentName = keyboard.nextLine().trim();
		System.out.println("Please input Address in format XXXX Street Name., City, State Zipcode");
		String studentAddress = keyboard.nextLine().trim();
		System.out.println("Please input major");
		String studentMajor = keyboard.nextLine().trim();
		String query = "select ssn from Student Where ssn = '" + studentSSN + "'";
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) 
		{
			System.out.println("This Student SSN already exists.");
			return;
		}
		query = "Insert into Student (ssn, name, address, major) values ('" + studentSSN + "', '" + studentName  + "', '" + studentAddress  + "', '" + studentMajor + "')";
		try 
		{
			st.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			System.out.println("Message: " + e.getMessage());
		
		}
		rs.close();
		st.close();
		System.out.println("The student " + studentName + " has been added.");


	}
	//this method deletes a student and unregisters them. 
	public void delete_student(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
	Statement st = conn.createStatement();
	System.out.println("Delete a student");
	System.out.println("Please input student ssn: ");
	String studentSSN = keyboard.nextLine().trim();
	String query = "select ssn from Student Where ssn = '" + studentSSN + "'";
	ResultSet rs = st.executeQuery(query);
	if (rs.next()==false) 
	{
		System.out.println("This student ssn does not exists");
		return;
	}
	else { {
		query = "Delete From Registered Where ssn = ('" + studentSSN + "')";
		
	try 
	{
		st.executeUpdate(query);
		
	} 
	catch (SQLException e) 
	{
		System.out.println("Message: " + e.getMessage());
	
	}
	}
	query = "Delete From Student Where ssn = ('" + studentSSN + "')";

	try
	{
		st.executeUpdate(query);
		
	} 
	catch (SQLException e) 
	{
		System.out.println("Message: " + e.getMessage());
	
	}
   }
	rs.close();
	st.close();
	System.out.println("The student SSN " + studentSSN + " has been deleted");


	}
	//this method registers the courses
	public void register_course(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
		Statement st = conn.createStatement();
		System.out.println("Register a course");
		System.out.println("Please input student SSN");
		String studentSSN = keyboard.nextLine().trim();
		//this first query checks to make sure the student is actually in the system. Returns false if ssn is not found.
		String query1 = "select ssn from Student where ssn = '" + studentSSN + "'";
		ResultSet rs1 = st.executeQuery(query1);
		if (rs1.next()==false){
			System.out.println("This student does not exist. Please add add student first");
			return;
		}
		System.out.println("Please input course code");
		//this second query checks to make sure the corse code exists. Returns false if course code is not found.
		String code = keyboard.nextLine().toUpperCase().trim();
		String query2 = "select code from Course where code = '" + code + "'";
		ResultSet rs2 = st.executeQuery(query2);
		if (rs2.next()==false){
			System.out.println("This Course does not exist. Please add course first.");
			return;
		}
		System.out.println("Please input year");
		String year = keyboard.nextLine().trim();
		System.out.println("Please input semester");
		//this third and final query makes sure that the student has not registered for this same course during the same year and semester. Registers course if passes.
		String semester = keyboard.nextLine().toUpperCase().trim();
		String query = "select* from Registered Where ssn = '" + studentSSN + "' AND code = '" +code+"' AND year = '" +year+"' AND semester ='"+ semester + "'";
		ResultSet rs = st.executeQuery(query);
		if(rs.next()==true)
		{
			System.out.println("Course already exists");
			return;
		}
		query = "Insert into Registered (ssn, code, year, semester) values ('" + studentSSN+ "', '" + code+ "', '" + year+ "','" + semester+ "')";
		try 
		{
			st.executeUpdate(query);
		} 
		catch (SQLException e) 
		{
			System.out.println("Message: " + e.getMessage());
		
		}
		rs.close();
		st.close();
		System.out.println("Course was sucessfully registered.");
	}
	//this method looks up a students registration class code year and semester. First it checks to see if the student exists
	public void show_regist(Connection conn, Scanner keyboard) throws SQLException, IOException
	{
			Statement st = conn.createStatement();
			System.out.println("Showing registration for Student");
			System.out.println("Please input student SSN");
			String studentSSN = keyboard.nextLine().trim();
			try

			{
				String query1 = "select ssn from Registered where ssn = '" + studentSSN+ "'";
				ResultSet rs1 = st.executeQuery(query1);
				if( rs1.next()==false){
					System.out.println("This student does not exist. Please try again");
					return;
				}
				String query = "select * from Registered where ssn = '" + studentSSN+ "'";
				ResultSet rs = st.executeQuery(query);
				System.out.println("Student SSN: " +studentSSN+ "\thas registered for the following:");
			
				while(rs.next()){
					String code = rs.getString("code");
					String year = rs.getString("year");
					String semester = rs.getString("semester");
				System.out.println("Code: " +code + " Year: "+year+ " Semester: "+ semester);
		
			}
			rs.close();
			st.close();
			
		}
			catch (SQLException e) 
			{
				System.out.println("Message: " + e.getMessage());
			
			}
		
	}
}
