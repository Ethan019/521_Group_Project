// Caroline
// WIP
// School admin methods

import java.io.*;
import java.sql.*;
//import java.util.Scanner;
import java.util.Random;

public class SchoolAdminSQL {
    // Allow admin to view student record info
    public static ViewStudRec(Connection conn, int STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            String stud = Integer.toString(STUD_ID);

            //Scanner sc = new Scanner(System.in);
            //System.out.println("Enter Student ID: ");
            //String stud_id = sc.nextLine();
            
            String query = "SELECT * FROM STUDENTRECORD WHERE STUDID = '" + stud + "';";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String record_id = rs.getString("RECORDID");
                String stud_id = rs.getString("STUDID");
                String dept_key = rs.getString("DEPTKEY");
                String course_num = rs.getString("COURSENUM");
                String grade = rs.getString("GRADE");
                String letter_grade = rs.getString("LETTERGRADE");
                String semester = rs.getString("SEMESTER");
                String year = rs.getString("YEAR");
                System.out.println("Record ID: " + record_id);
                System.out.println("Student ID: " + stud_id);
                System.out.println("Department: " + dept_key);
                System.out.println("Course Number: " + course_num);
                System.out.println("Grades: " + grade);
                System.out.println("Letter Grade: " + letter_grade);
                System.out.println("Semester: " + semester);
                System.out.println("Year: " + year);
            }
            rs.close();
            st.close();
            sc.close();
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Allow admin to view professor info
    public static ViewProfInfo(Connection conn, String PROF_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String query = "SELECT * FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String f_name = rs.getString("FNAME");
                String l_name = rs.getString("LNAME");
                String department = rs.getString("DEPTKEY");
                System.out.println("Professor ID: " + PROF_ID);
                System.out.println("First Name: " + f_name);
                System.out.println("Last Name: " + l_name);
                System.out.println("Department: " + department); 
            }
            rs.close();
            st.close();
            sc.close();
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
        sc.close();
    }

    // Allow admin to add student 
    public void AddStud(Connection conn, String F_NAME, String L_NAME, String MAJOR) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();

            int stud = rand.nextInt(11000000, 11999999);
            String STUD_ID = Integer.toString(stud);

            String update_query = "INSERT INTO STUDENT(FNAME, LNAME, MAJOR, STUDID) VALUES('" + F_NAME + "', '" + L_NAME + "', '" + MAJOR + "', '" + STUD_ID + "';";
            st.executeQuery(update_query);
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
        sc.close();
    }

    // Allow admin to update professor info
    public void AddProf(Connection conn, String F_NAME, String L_NAME, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();

            int prof = rand.nextInt(22000000, 22999999);
            String PROF_ID = Integer.toString(prof);

            String update_query = "INSERT INTO PROFESSOR(FNAME, LNAME, DEPTKEY, PROFID) VALUES '" + F_NAME + "', '" + L_NAME + "', DEPTKEY = '" + DEPT_KEY + "', '" + PROF_ID + "';";
            st.executeUpdate(update_query);

            String select_query = "SELECT * FROM PROFESSOR WHERE LNAME = '" + L_NAME + "' AND FNAME = '" + F_NAME + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("Professor added.");
                return;
            }
            else {
                System.out.println("Try again.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
        sc.close();
    }

    // Allow admin to add student to course - add button is selected
    public void AddStudToCourse(Connection conn, String STUD_ID, String COURSE_NUM, String CRN) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            // Display registered courses first
            String select_query = "SELECT * FROM REGISTEREDFOR WHERE STUDID = '" + stud_id + "';";
            ResultSet rs1 = st.executeQuery(select_query);
            while(rs1.next() == true) {
                String course_nums = rs.getString("COURSENUM");
                String crn = rs.getString("CRN");
                String grade = rs.getString("GRADE");
                System.out.println("Course Number: " + course_num);
                System.out.println("CRN: " + crn);
                System.out.println("Grade: " + grade);

                String add_course = "INSERT INTO REGISTEREDFOR(CRN, COURSENUM) VALUES ('" + CRN + "', '" + COURSE_NUM + "') WHERE STUDID = '" + STUD_ID + "';"; 
                st.executeUpdate(add_course);

                String check = "SELECT * FROM REGISTEREDFOR WHERE CRN = '" + CRN + "' AND STUD_ID = '" + STUD_ID + "';";
                rs2 = st.executeQuery(check);
                if(rs2.next() == true) {
                System.out.println("Student is enrolled in this course.");
                return;
            }
                else {
                System.out.println("Student with this ID is not registered for this course. Try again.");
            }
            rs1.close();
            rs2.close();
            st.close();
            sc.close();
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void DelProfessor(Connection conn, String PROF_ID) {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);

            String del_prof = "DELETE FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            st.executeUpdate(del_prof);

            String check = "SELECT * FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            ResultSet rs = st.executeQuery(check);
            if(rs.next() == false) {
                System.out.println("Professor deleted.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
        sc.close();
    }

    public void DelStud(Connection conn, String STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            
            String del_student = "DELETE FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            st.executeUpdate(del_student);

            String check = "SELECT * FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            ResultSet rs = st.executeQuery(check);
            if(rs.next() == false) {
                System.out.println("Student deleted.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
        sc.close();
    }
    // Add a course
    public void AddCourse(Connection conn, String DEPARTMENT, String COURSE_NUM, String DESC, String PROF_NAME) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            Random rand = new Random();
            int crn = rand.nextInt(1000, 4999);

            String add_course_query = "INSERT INTO COURSE(DEPTKEY, COURSENUM, PROFNAME, DESC, CRN) VALUES ('" + DEPARTMENT + "', '" + COURSE_NUM + "', '" + PROF_NAME + "', '" + DESC + "');";
            st.executeUpdate(add_course_query);

            String select_query = "SELECT * FROM COURSE WHERE COURSENUM = '" + COURSE_NUM + "'';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("This course is in the system.");
                return;
            }
            else {
                System.out.println("Course not added.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
        sc.close();
    }

    // Delete a course
    public void DeleteCourse(Connection conn, String COURSE_NUM, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            
            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter Course Number to Delete: ");
            //String del_course_num = sc.nextLine();
            //System.out.println("Enter Department: ");
            //String department = sc.nextLine();

            String delete_query = "DELETE * FROM COURSE WHERE COURSENUM = '" + DEL_COURSE_NUM + "' AND DEPTKEY = '" + DEPT_KEY + "';";
            st.executeQuery(delete_query);

            String select_query = "SELECT * FROM COURSE WHERE COURSENUM = '" + DEL_COURSE_NUM + "' AND DEPTKEY = '" + DEPT_KEY + "';";
            ResultSet rs = st.executeQuery(select_query);
            if(rs.next() == false) {
                System.out.println("Course deleted.");
                return;
            }
            else {
                System.out.println("Course not deleted. Please try again.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
        sc.close();
    }

    public void EditStud(Connection conn, Scanner scan, String STUD_ID, String F_NAME, String L_NAME, String MAJOR) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String update_query = "UPDATE STUDENT SET FNAME = '" + F_NAME + "', LNAME = '" + L_NAME + "', MAJOR = '" + MAJOR + "' WHERE STUDID = '" + STUD_ID + "';";
            st.executeUpdate(update_query);


            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + stud_id + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("The input information is already current.");
                return;
            }

            else {
                System.out.println("Information updated successfully.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
        //sc.close();
    }
    public void EditProf(Connection conn, Scanner scan, String PROF_ID, String F_NAME, String L_NAME, String DEPARTMENT) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String update_query = "UPDATE PROFESSOR SET FNAME = '" + F_NAME + "', LNAME = '" + F_NAME + "', DEPARTMENT = '" + DEPARTMENT + "' WHERE PROFID = '" + PROF_ID + "';";
            st.executeUpdate(update_query);

            String select_query = "SELECT * FROM PROFESSOR WHERE PROF_ID = '" + PROF_ID + "';";
            ResultSet rs = st.executeQuery(select_query);
            if(rs.next() == true) {
                System.out.println("Professor added.");
                return;
            }

            else {
                System.out.println("Try again.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
    }

}

// Drop student from course
// Add course
// Remove course
// Add professor
// Remove professor
// Add student
// Delete student
// View record
// Edit student
// Edit professor

