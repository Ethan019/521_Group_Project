// Caroline 
// WIP
// DBA methods

import java.sql.*;
import java.io.*;
//import java.util.Scanner;
import java.util.Random;

public class DBASQL {
    // Raw SQL Command Enter
    public void RawSql(Connection conn, Scanner scan, String COMMAND) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            // Enter SQL Command
            // String q = kdjflaksdf;
            String query = COMMAND;
            st.executeQuery(query);
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
    }

    // ********************** COURSE FUNCTIONS *******************
    // Add a course - Original Caroline, New Ethan & Liz
    public  boolean AddCourse(Connection conn,  String COURSE_NUM, String COURSE_NAME, String DES, String PROF_NAME, String Semester, String Year, String Section_NUM ){
        try {
            Statement st = conn.createStatement();


            String adept ="Select DEPTKEY, PROFID FROM PROFESSOR WHERE PROFNAME = '"+PROF_NAME+"';";
            ResultSet r2 = st.executeQuery(adept);

            if(r2.next()) {
                String deptk = r2.getString("DEPTKEY");
                String profi = r2.getString("PROFID");
                System.out.println(deptk);
                String add_course_query = "INSERT INTO COURSE(DEPTKEY, coursename, COURSENUM, SECTIONNUM, PROFID, PROFNAME, DES, SEMESTER, YEAR) VALUES('" + deptk + "', '" + COURSE_NAME + "', '" + COURSE_NUM + "', '" + Section_NUM + "', " + profi + ", '"+PROF_NAME+"', '"+DES+"', '"+Semester+"', '"+Year+"');";
                st.executeUpdate(add_course_query);
                return true;
            }


            //String select_query = "SELECT * FROM COURSE WHERE COURSENUM = '" + COURSE_NUM + "';";
            //ResultSet rs = st.executeQuery(select_query);

            //if(rs.next() == true) {
              //  System.out.println("This course is in the system.");
               // return true;
            //}


        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage() +"Please try to add course again");
            return false;
        }
        return  false;
    }

    //Delete a course - Caroline & Ethan Original, Liz Modified
    public boolean DeleteCourse(Connection conn, String CRN, String ID) {
        try {
            Statement st = conn.createStatement();
            
            String deleter = "DELETE FROM REGISTEREDFOR WHERE CRN = "+CRN+";";
            st.executeUpdate(deleter);
            String delete_query = "DELETE FROM COURSE WHERE CRN ="+CRN+";";
            st.executeUpdate(delete_query);
            System.out.println("Course was deleted");
            return true;
                    
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }


    //Modify a course 
    public void UpdateCourse(Connection conn, String CRN, String DESC, String DEPT_KEY, String COURSE_NUM, String SECT_NUM, String PROF_ID, String PROF_NAME, String SEMESTER, String YEAR) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            //Prompt for info, enter CRN of course to edit

            String update_query = "UPDATE COURSE SET DESC = '" + DESC + "', SECTTIONNUM = '" + SECT_NUM + "', COURSENUM = '" + COURSE_NUM + "', PROFNAME = '" + PROF_NAME + "', SEMESTER = '" + SEMESTER + "', YEAR = '" + YEAR + "' WHERE CRN = '" + CRN + "';";
            st.executeUpdate(update_query);
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ********************** STUDENT **********************
    //Add a student
    //Liz+Ethan edit: Adding student to student table & users table
    public boolean AddStudent(Connection conn, String F_NAME, String L_NAME, String MAJOR, String Password){
        try{
            Statement st = conn.createStatement();

            //checks for student first
            String query = "SELECT * FROM STUDENT WHERE FNAME= '"+F_NAME+"' AND LNAME ='"+L_NAME+"' AND MAJOR = '"+MAJOR+"';";

            ResultSet rs1 = st.executeQuery(query);

            if(!rs1.next()){

                String addstu = "INSERT INTO STUDENT(FNAME, LNAME, MAJOR) VALUES ('"+F_NAME+"', '"+L_NAME+"', '"+MAJOR+"');";

                st.executeUpdate(addstu);

            }else
            {
                //uncomment if boolean instead of void
                return false;
            }

            String query2 = "SELECT STUDID FROM STUDENT WHERE FNAME= '"+F_NAME+"' AND LNAME ='"+L_NAME+"' AND MAJOR = '"+MAJOR+"';";


            ResultSet rs2 = st.executeQuery(query2);

            if(rs2.next()){
                String userid = rs2.getString("STUDID");
                String adduse = "INSERT INTO USERS(USERID, PASSWORD, ROLE) VALUES ("+userid+", '"+Password+"', 'Student');";


                st.executeUpdate(adduse);
                //uncomment if returning true.
                return true;
            }
        }
        catch (SQLException e){
           System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
     
    //Delete a student - Caroline Original, Liz & Ethan New
    public boolean DeleteStudent(Connection conn, String Fname, String Lname, String Major){
        try {
            Statement st = conn.createStatement();
            String stud = "SELECT STUDID FROM STUDENT WHERE FNAME = '"+Fname+"' AND LNAME='"+Lname+"' AND MAJOR='"+Major+"';";
            ResultSet rs1 = st.executeQuery(stud);
            while(rs1.next()){
                String studid = rs1.getString("STUDID");
                String query = "select * from registeredfor where studid ="+studid+";";
                ResultSet rs2=st.executeQuery(query);
                if(rs2.next()){
                    String dele_course ="DELETE FROM REGISTEREDFOR WHERE STUDID ="+studid+";";
                    st.executeUpdate(dele_course);
                    String del_student = "DELETE FROM STUDENT WHERE STUDID ="+studid+";";
                    st.executeUpdate(del_student);
                    String dele_stuser = "DELETE FROM USERS WHERE STUDID = "+studid+";";
                    st.executeUpdate(dele_pruser);
                    return true;

                }else{
                    String del_student = "DELETE FROM STUDENT WHERE STUDID ="+studid+";";
                    st.executeUpdate(del_student);
                    String dele_stuser = "DELETE FROM USERS WHERE STUDID = "+studid+";";
                    st.executeUpdate(dele_pruser);
                    return true;
                }



            }


        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return false;
    }

    //Update student info - Caroline original, Liz & Ethan Update
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

    // This will get and display information when "modify student registration" is selected
    public void RegInfo(Connection conn, Scanner scan, String STUD_ID) throws SQLException, IOException {
        Statement st = conn.createStatement();

        String query = "SELECT * FROM REGISTEREDFOR WHERE STUDID = '" + STUD_ID + "';";
        st.executeQuery(query);

        String crn = rs.getString("CRN");
        String course_num = rs.getString("COURSENUM");
        String grade = rs.getString("GRADE");
        System.out.println("CRN: " + crn);
        System.out.println("Course Number: " + course_num);
        System.out.println("Grade: ");

        st.close();
    }

    //Add Student to Course - 
    public void AddStudToCourse(Connection conn, String STUD_ID, String CRN) {
        try {
            Statement st = conn.createStatement();

            // Display registered courses first
            String select_query = "SELECT * FROM REGISTEREDFOR WHERE STUDID = '" + STUD_ID + " AND CRN = "+CRN+";";
            ResultSet rs1 = st.executeQuery(select_query);
            if(!rs1.next()) {
                String insert_student="Insert into REGISTEREDFOR(STUDID, CRN) VALUES("+STUD_ID+","+CRN+");";
                st.executeUpdate(insert_student);
            }
        }catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    // Update grade
    public void UpdateGrade(Connection conn, String STUD_ID, String CRN, String GRADE) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String query = "UPDATE REGISTEREDFOR SET GRADE = '" + GRADE + "' WHERE STUDID = '" + STUD_ID + "' AND CRN = '" + CRN + "';";
            st.executeUpdate();

            String select_query = "SELECT GRADE FROM REGISTEREDFOR WHERE STUDID = '" + stud + "' AND CRN = '" + crn + "';";
            ResultSet rs = st.executeQuery(select_query);
            String updated_grade = rs.getString("GRADE");
            Systme.out.println("Grade for course with CRN " + crn + " is " + updated_grade + ".");
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        rs.close();
        st.close();
    }
    // ******************** PROFESSOR *********************
    // Add professor 
    //Liz: Adding professor to professor table & users table
    
    public boolean AddProfessor(Connection conn, String PROF_NAME, String DEPT_KEY, String Password){
        try{
            Statement st = conn.createStatement();

            //checks for prof first
            String query = "SELECT * FROM PROFESSOR WHERE PROFNAME = '"+PROF_NAME+"' AND DEPTKEY = '"+DEPT_KEY+"';";

            ResultSet rs1 = st.executeQuery(query);

            if(!rs1.next()){

                String addprof = "INSERT INTO PROFESSOR(PROFNAME, DEPTKEY) VALUES ('"+PROF_NAME+"', '"+DEPT_KEY+"');";

                st.executeUpdate(addprof);

            }else
            {
                //uncomment if boolean instead of void
                return false;
            }

            String query2 = "SELECT PROFID FROM PROFESSOR WHERE PROFNAME= '"+PROF_NAME+"' AND DEPTKEY = '"+DEPT_KEY+"';";


            ResultSet rs2 = st.executeQuery(query2);

            if(rs2.next()){
                String userid = rs2.getString("PROFID");
                String adduse = "INSERT INTO USERS(USERID, PASSWORD, ROLE) VALUES ("+userid+", '"+Password+"', 'Professor');";


                st.executeUpdate(adduse);
                //uncomment if returning true.
                return true;
            }
        }
        catch (SQLException e){
           System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    //Delete professor - Original Caroline, Updated version Liz & Ethan
    public boolean DeleteProfessor(Connection conn, String Fname, String Lname, String Depart){
        try {
            Statement st = conn.createStatement();
            String stud = "SELECT PROFID FROM PROFESSOR WHERE FNAME = '"+Fname+"' AND LNAME='"+Lname+"' AND DEPTKEY='"+Depart+"';";
            ResultSet rs1 = st.executeQuery(stud);
            while(rs1.next()){
                String profid = rs1.getString("PROFID");
                String query = "select * from course where PROFID ="+profid+";";
                ResultSet rs2=st.executeQuery(query);
                if(rs2.next()){
                    String crn = rs2.getString("CRN");
                    ResultSet rs3=st.executeQuery("Select CRN FROM REGISTEREDFOR WHERE CRN ="+crn+";");

                    if(rs3.next()){
                        String dele_reg = "Delete FROM REGISTEREDFOR WHERE CRN ="+crn+";";
                        st.executeUpdate(dele_reg);
                        String dele_course ="DELETE FROM COURSE WHERE PROFID ="+profid+";";
                        st.executeUpdate(dele_course);
                        String del_prof = "DELETE FROM Professor WHERE STUDID ="+profid+";";
                        st.executeUpdate(del_prof);
                        String dele_pruser = "DELETE FROM USERS WHERE PROFID = "+profid+";";
                        st.executeUpdate(dele_pruser);
                        return true;
                    }else{
                        String dele_course ="DELETE FROM COURSE WHERE PROFID ="+profid+";";
                        st.executeUpdate(dele_course);
                        String del_student = "DELETE FROM PROFESSOR WHERE PROFID ="+profid+";";
                        st.executeUpdate(del_student);
                        String dele_pruser = "DELETE FROM USERS WHERE PROFID = "+profid+";";
                        st.executeUpdate(dele_pruser);
                        return true;
                    }


                }else{
                    String del_prof3 = "DELETE FROM PROFESSOR WHERE PROFID ="+profid+";";
                    st.executeUpdate(del_prof3);
                    String dele_pruser = "DELETE FROM USERS WHERE PROFID = "+profid+";";
                    st.executeUpdate(dele_pruser);
                    return true;
                }



            }


        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return false;
    }

//Edit Professor Information - Original Caroline, Update Liz & Ethan
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
            
    public void RegStud(Connection conn, Scanner scan, String STUD_ID, String CRN, String COURSE_NUM, String GRADE) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String insert_query = "INSERT INTO REGISTEREDFOR(CRN, COURSENUM, GRADE) VALUES ('" + CRN + "', '" + COURSE_NUM + "', '" + GRADE + "') WHERE STUD_ID = '" + STUD_ID + "';";
            st.executeUpdate(insert_query);

            String select_query = "SELECT * FROM REGISTEREDFOR WHERE STUDID = '" + STUD_ID + "' AND CRN = '" + CRN + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next == true) {
                System.out.println("Student registered for course.");
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

        // Delete student from course
    public void DropStud(Connection conn, String STUD_ID, String CRN) {
        try {
            Statement st = conn.createStatement();

            String delete_query = "DELETE FROM REGISTEREDFOR WHERE STUDID = '" + STUD_ID + "' AND CRN = '" + CRN + "';";
            st.executeUpdate(delete_query);

            String select_query = "SELECT * FROM REGISTEREDFOR WHERE STUDID = '" + STUD_ID + "' AND CRN = '" + CRN + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == false) {
                System.out.println("Student dropped from course.");
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

    // ************************* DEPARTMENT ******************************
    // Add a department
    public void AddDept(Connection conn, String DEPT_NAME) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();
            //Enter department name
            int department = rand.nextInt(100, 499);
            String DEPT_KEY = Integer.toString(department);
            String insert_query = "INSERT INTO DEPARTMENT(DEPTKEY, DEPTNAME) VALUES ('" + DEPT_KEY + "', '" + DEPT_NAME + "');";
            st.executeUpdate(insert_query);

            String select_query = "SELECT * FROM DEPARTMENT WHERE DEPTKEY = '" + DEPT_KEY + "';";
            ResultSet rs = st.executeQuery(select_query);
            if(rs.next() == true) {
                System.out.println("Department added successfully.");
            }
            else {
                System.out.println("Please try again.");
            }
        }
            catch(SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
            rs.close();
            st.close();
    }

    // Delete a department
    public void DelDept(Connection conn, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            // Prompt for dept key
            String delete_query = "DELETE * FROM DEPARTMENT WHERE DEPTKEY = '" + DEPT_KEY + "';";
            st.executeQuery(delete_query);

            // Check and see if values are still in department table
            String select_query = "SELECT * FROM DEPARTMENT WHERE DEPTKEY = '" + DEPT_KEY + "';";
            ResultSet rs = st.executeUpdate(select_query);
            if(rs.next() == false) {
                System.out.println("Department deleted.");
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

    // Modify department
    public void ModDept(Connection conn, String DEPT_KEY, String DEPT_NAME) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            // Enter department key of department to edit
            // Enter name change
            String update_query = "UPDATE DEPARTMENT SET DEPTNAME = '" + DEPT_KEY + "';";
            st.executeUpdate(update_query);
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
    }

    // ********************** ADMINISTRATOR ****************************
    // Add administrator
    //Liz: Adding school administrator to schooladmin table & users table
    
    public boolean AddSchAdmin(Connection conn, String F_NAME, String L_NAME, String DEPT_KEY, String Password){
        try{
            Statement st = conn.createStatement();

            //checks for schadmin first
            String query = "SELECT * FROM SCHADMIN WHERE FNAME = '"+F_NAME+"' AND LNAME = '"+L_NAME+"' AND DEPTKEY = '"+DEPT_KEY+"';";

            ResultSet rs1 = st.executeQuery(query);

            if(!rs1.next()){

                String addschad = "INSERT INTO SCHADMIN(FNAME, LNAME, DEPTKEY) VALUES ('"+F_NAME+"', '"+L_NAME+"', '"+DEPT_KEY+"');";

                st.executeUpdate(addschad);

            }else
            {
                //uncomment if boolean instead of void
                return false;
            }

            String query2 = "SELECT SCHADID FROM SCHOOLADMIN WHERE FNAME= '"+F_NAME+"' AND LNAME = '"+L_NAME+"' AND DEPTKEY = '"+DEPT_KEY+"';";


            ResultSet rs2 = st.executeQuery(query2);

            if(rs2.next()){
                String userid = rs2.getString("SCHADID");
                String adduse = "INSERT INTO USERS(USERID, PASSWORD, ROLE) VALUES ("+userid+", '"+Password+"', 'SchoolAdmin');";


                st.executeUpdate(adduse);
                //uncomment if returning true.
                return true;
            }
        }
        catch (SQLException e){
           System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    // Delete administrator - Updated 12/3 by Liz
    public void DelAdmin(Connection conn, String ADMIN_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String delete_query = "DELETE * FROM SCHADMIN WHERE SCHADID = '" + ADMIN_ID + "';";
            st.executeUpdate(delete_query);
            String delete_uquery = "DELETE * FROM USERS WHERE SCHADID = '" + ADMIN_ID + "';";
            st.executeUpdate(delete_uquery);

            String select_query = "SELECT * FROM SCHADMIN WHERE SCHADID = '" + ADMIN_ID + "';";
            ResultSet rs = st.executeQuery(select_query);
            String select_uquery = "SELECT * FROM USERS WHERE SCHADID = '" + ADMIN_ID + "';";
            ResultSet rs1 = st.executeQuery(select_uquery);

            if(rs.next == false AND rs1.next == false) {
                System.out.println("Administrator deleted.");
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

    // Update administrator
    public void UpdateSchAdmin(Connection conn, String ADMIN_ID, String F_NAME, String L_NAME, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            // Prompt for info
            String update_query = "UPDATE SCHADMIN SET FNAME = '" + F_NAME + "', LNAME = '" + LNAME + "', DEPTKEY = '" + DEPT_KEY + "' WHERE SCHADID = '" + ADMIN_ID + "';";
            st.executeUpdate(update_query);
            System.out.println("Information updated.");
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
    }
}
        //Delete Student - done
        //Add student - done
        //Update student - done
        //Register stud for course - done
        //Del student from course - done
        //Edit grades - done
        //Add professor - done
        //Delete professor - done
        //Update professor info - done
        //Add administrator - done
        //Delete administrator - done
        //Update admin info - done
        //Add course - done
        //Delete course - done
        //Modify course - done
        //Add department - done
        //Delete department - done
        //Modify department - done
