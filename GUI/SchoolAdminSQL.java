package UniversitySystemGUI;// Caroline
// WIP
// School admin methods

import java.io.*;
import java.sql.*;
//import java.util.Scanner;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SchoolAdminSQL {
    // Allow admin to view student record info
    public void ViewStudRec(Connection conn, String STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            
            String query = "SELECT * FROM STUDENTRECORD WHERE STUDID = '" + STUD_ID + "';";
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
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    // Allow admin to view professor info
    public void ViewProfInfo(Connection conn, String PROF_ID) throws SQLException, IOException {
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
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    // Allow admin to add student 
    public void AddStud(Connection conn, String F_NAME, String L_NAME, String MAJOR) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();

           // int stud = rand.nextInt(11000000, 11999999);
            //String STUD_ID = Integer.toString(stud);

            //String update_query = "INSERT INTO STUDENT(FNAME, LNAME, MAJOR, STUDID) VALUES('" + F_NAME + "', '" + L_NAME + "', '" + MAJOR + "', '" + STUD_ID + "';";
           // st.executeQuery(update_query);
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    // Allow admin to update professor info
    public void AddProf(Connection conn, String F_NAME, String L_NAME, String DEPT_KEY) throws SQLException, IOException {
        try {

            //ethan error check. Had to change how the ids were assigned to fix database design.
            Statement st = conn.createStatement();
            Random rand = new Random();
            int randomNum = ThreadLocalRandom.current().nextInt(1100000, 1199999 + 1);

            String checkID = "Select PROFID FROM PROFESSOR WHERE PROFID = " +randomNum+ ";";
            ResultSet rs1 =st.executeQuery(checkID);
            //while(rs1!=null){
              //  String PROF_ID = Integer.toString(randomNum);
           // } else{
             //   String checkIDloop = "Select PROFID FROM PROFESSOR WHERE PROFID = " +randomNum+ ";";

            //}

                //NOT WORKING
            //
            //
            //
            // String update_query = "INSERT INTO PROFESSOR(FNAME, LNAME, DEPTKEY, PROFID) VALUES('" + F_NAME + "', '" + L_NAME + "', DEPTKEY = '" + DEPT_KEY + "' '" "');";;
            //st.executeUpdate(update_query);

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

    }

    // Allow admin to add student to course - add button is selected
    public void AddStudToCourse(Connection conn, String STUD_ID, String COURSE_NUM, String CRN) {
        try {
            Statement st = conn.createStatement();

            // Display registered courses first
            String select_query = "SELECT * FROM REGISTEREDFOR WHERE STUDID = '" + STUD_ID + "';";
            ResultSet rs1 = st.executeQuery(select_query);
            while(rs1.next() == true) {
                String course_nums = rs1.getString("COURSENUM");
                String crn = rs1.getString("CRN");
                String grade = rs1.getString("GRADE");
                System.out.println("Course Number: " + COURSE_NUM);
                System.out.println("CRN: " + crn);
                System.out.println("Grade: " + grade);

                String add_course = "INSERT INTO REGISTEREDFOR(CRN, COURSENUM) VALUES('" + crn + "', '" + course_nums + "') WHERE STUDID = '" + STUD_ID + "';";

            }
        }catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }


    public void DelProfessor(Connection conn, String PROF_ID) {
        try {
            Statement st = conn.createStatement();

            String del_prof = "DELETE FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            st.executeUpdate(del_prof);

            String check = "SELECT * FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            ResultSet rs = st.executeQuery(check);
            if(rs.next() == false) {
                System.out.println("Professor deleted.");
            }
            else {
                System.out.println("Try again.");
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void DelStud(Connection conn, String STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            
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

    }
        
    // Add a course WORKS -- TESTED
    public  boolean AddCourse(Connection conn, String DEPARTMENT, String COURSE_NUM, String COURSE_NAME, String DES, String PROF_NAME, String Semester, String Year, String Section_NUM, String PROFID){
        try {
            Statement st = conn.createStatement();

            


            String add_course_query = "INSERT INTO COURSE(DEPTKEY, coursename, COURSENUM, SECTIONNUM, PROFID, PROFNAME, DES, SEMESTER, YEAR) VALUES('" + DEPARTMENT + "', '" + COURSE_NAME + "', '" + COURSE_NUM + "', '" + Section_NUM + "', '" + PROFID + "', '"+PROF_NAME+"', '"+DES+"', '"+Semester+"', '"+Year+"');";
            st.executeUpdate(add_course_query);

            String select_query = "SELECT * FROM COURSE WHERE COURSENUM = '" + COURSE_NUM + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("This course is in the system.");
                return true;
            }

            rs.close();
            st.close();
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage() +"Please try to add course again");
            return false;
        }
        return  false;
    }

    // Delete a course WORKS -- TESTED
    public boolean DeleteCourse(Connection conn, String CRN, String ID) {
        try {
            Statement st = conn.createStatement();
            String dept = "Select DEPTKEY FROM COURSE WHERE CRN ="+CRN+";";
            st.executeQuery(dept);
            ResultSet r1=st.executeQuery(dept);

            while(r1.next()){
                String deptk = r1.getString("DEPTKEY");
                String adept ="Select DEPTKEY FROM SCHOOLADMIN WHERE SCHADID=" +ID+";";
                ResultSet r2 = st.executeQuery(adept);

                while(r2.next()){
                    if(!Objects.equals(deptk, r2.getString("DEPTKEY"))){
                        System.out.println("THIS CLASS IS OUTSIDE OF YOUR DEPARTMENT");
                        return false;

                    }
                    else{
                        String deleter = "DELETE FROM REGISTEREDFOR WHERE CRN = "+CRN+";";
                        st.executeUpdate(deleter);
                        String delete_query = "DELETE FROM COURSE WHERE CRN ="+CRN+";";
                        st.executeUpdate(delete_query);
                        System.out.println("Course was deleted");
                        return true;
                    }
                }

            }


        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void EditStud(Connection conn, Scanner scan, String STUD_ID, String F_NAME, String L_NAME, String MAJOR) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String update_query = "UPDATE STUDENT SET FNAME = '" + F_NAME + "', LNAME = '" + L_NAME + "', MAJOR = '" + MAJOR + "' WHERE STUDID = '" + STUD_ID + "';";
            st.executeUpdate(update_query);

            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
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


//student record view works
//add class works
//delete class works
//delete student works
//delete professor works


//not yet finished implmeneting
// add student
//add professor
//edit student
//edit professor
//drop student from course (just unregister from registered for)


