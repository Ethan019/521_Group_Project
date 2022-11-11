// Caroline
// Print & scanner statements to think through logic of how we're getting the parameters for methods -- ignore
// WIP

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class SchoolAdminSQL {
    // Allow admin to view student record info
    public static ViewStudRec(Connection conn, String STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter Student ID: ");
            //String stud_id = sc.nextLine();
            
            String query = "SELECT * FROM STUDENTRECORD WHERE STUDID = '" + stud_id + "';";
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
                System.out.println("Record ID: " + recordId);
                System.out.println("Student ID: " + studId);
                System.out.println("Department: " + deptKey);
                System.out.println("Course Number: " + courseNum);
                System.out.println("Grades: " + grade);
                System.out.println("Letter Grade: " + letterGrade);
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

            Scanner sc = new Scanner(System.in);
            //System.out.println("Please Enter Professor ID: ");
            //String prof_id = sc.nextLine();

            String query = "SELECT * FROM Professor WHERE PROFID = '" + prof_id + "';";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String f_name = rs.getString("FNAME");
                String l_name = rs.getString("LNAME");
                String department = rs.getString("DEPTKEY");
                System.out.println("Professor ID: " + prof_id);
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
    }

    // Allow admin to update student info
    public void EditStud(Connection conn, Scanner scan) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            //System.out.println("Please Enter Student ID to Edit: ");
            //String stud_id = sc.nextLine();

            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + stud_id + "';";
            ResultSet rs1 = st.executeQuery(select_query);

            //System.out.println("Enter Updated Student Information:");
            //System.out.println("First Name: ");
            //String f_name = sc.nextLine();
            //System.out.println("Last Name: ");
            //String l_name = sc.nextLine();
            //System.out.println("Major: ");
            //String major = sc.nextLine();

            String updateQuery = "UPDATE STUDENT SET FNAME = '" + f_name + "', LNAME = '" + l_name + "', MAJOR = '" + major + "' WHERE STUDID = '" + stud_id + "';";
            ResultSet rs2 = st.executeQuery(updateQuery);

            if(rs2.hasNext() == true) {
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
        rs1.close();
        rs2.close();
        st.close();
        sc.close();
    }

    // Allow admin to update professor info
    public void EditProf(Connection conn, Scanner scan) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter ID of Professor to Edit: ");
            //String prof_id = sc.nextLine();

            //String select_query = "SELECT * FROM PROFESSOR WHERE PROFID = '" + profId + "';";
            //ResultSet rs1 = st.executeQuery(select_query);

            //System.out.println("First Name: ");
            //String f_name = sc.nextLine();
            //System.out.println("Last Name: ");
            //String l_name = sc.nextLine();
            //System.out.println("Department: ");
            //String department = sc.nextLine();

            String update_query = "UPDATE PROFESSOR SET FNAME = '" + f_name + "', LNAME = '" + l_name + "', DEPTKEY = '" + department + "' WHERE PROFID = '" + prof_id + "';";
            ResultSet rs2 = st.executeQuery(update_query);

            if(rs.hasNext() == true) {
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
        rs1.close();
        rs2.close();
        st.close();
        sc.close();
    }

    // Allow admin to add student to course - add button is selected
    public void AddStudToCourse(Connection conn, String STUD_ID, String COURSE_NUM, String CRN) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            //Scanner sc = new Scanner(System.in);
            //System.out.println("Enter Student ID: ");
            //String stud_id = sc.nextLine();

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
            
                // Register student for course logic
                //System.out.println("Enter Course Number: "); 
                //course_num = sc.nextLine();
                //System.out.println("Enter CRN: ");
                //System.out.println("Enter Department: ");
                //String department = sc.nextLine();

                String add_course = "INSERT INTO REGISTEREDFOR(CRN, COURSENUM) VALUES ('" + CRN + "', '" + COURSE_NUM + "') WHERE STUDID = '" + STUD_ID + "';"; 
                st.executeQuery(add_course);

                String check = "SELECT * FROM REGISTEREDFOR WHERE CRN = '" + CRN + "' AND STUD_ID = '" + STUD_ID + "';";
                rs2 = st.executeQuery(check);
                if(rs2.next() == true) {
                System.out.println("Student is enrolled in this course.");
                return;
            }
                else {
                System.out.println("Student with this ID is not registered for this course. Try again.");
            }
            rs.close();
            st.close();
            sc.close();
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Add a course
    public void AddCourse(Connection conn, String DEPARTMENT, String COURSE_NUM, String DESC, String PROF_NAME) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter Department: ");
            //String department = sc.nextLine();
            //System.out.println("Enter New Course Number: ");
            //String new_course_num = sc.nextLine();
            //System.out.println("Enter New Course Description (Optional): ");
            //String desc = sc.nextLine();
            //System.out.println("Enter Professor Name (Optional): ");
            //String prof = sc.nextLine();
            String add_course_query = "INSERT INTO COURSE(DEPTKEY, COURSENUM, PROFNAME, DESC) VALUES ('" + DEPARTMENT + "', '" + COURSE_NUM + "', '" + PROF_NAME + "', '" + DESC + "');";
            st.executeQuery(add_course_query);

            String select_query = "SELECT * FROM COURSE WHERE COURSENUM = '" + COURSE_NUM + "'';";
            ResultSet rs2 = st.executeQuery(select_query);

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
        rs1.close();
        rs2.close();
        sc.close();
    }

    // Delete a course
    public void DeleteCourse(Connection conn, String COURSE_NUM, String DEPT_KEY) throws SQLException, IOException {
        Statement st = conn.createStatement();

        try {
            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter Course Number to Delete: ");
            //String del_course_num = sc.nextLine();
            //System.out.println("Enter Department: ");
            //String department = sc.nextLine();

            String delete_query = "DELETE * FROM COURSE WHERE COURSENUM = '" + DEL_COURSE_NUM + "' AND DEPTKEY = '" + DEPT_KEY + "';";
            st.executeQuery(delete_query);

            String select_query = "SELECT * FROM COURSE WHERE COURSENUM = '" + DEL_COURSE_NUM + "' AND DEPTKEY = '" + DEPT_KEY + "';";
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
        st.close();
        rs1.close();
        rs2.close();
        sc.close();
    }
}
