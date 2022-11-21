// Caroline 
// WIP
// DBA methods

import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class DBASQL {
    // Raw SQL Command Enter
    public void RawSql(Connection conn, Scanner scan, String COMMAND) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            // Enter SQL Command

            String query = (COMMAND);
            st.executeQuery(query);
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
    }

    // ********************** COURSE FUNCTIONS *******************
    // Add a course
    public void AddCourse(Connection conn, String DEPT_KEY, String COURSE_NUM, String DESC, String PROF_NAME) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();

            int CRN = rand.nextInt(10000, 49999);
            String add_course_query = "INSERT INTO COURSE(DEPTKEY, COURSENUM, PROFNAME, DESC, CRN) VALUES ('" + DEPT_KEY + "', '" + COURSE_NUM + "', '" + PROF_NAME + "', '" + DESC + "', '" + CRN + "');";
            st.executeQuery(add_course_query);

            String select_query = "SELECT * FROM COURSE WHERE CRN = '" + CRN + "'';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("Course is in the system.");
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

    //Delete a course
    public void DeleteCourse(Connection conn, String COURSE_NUM, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

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
        st.close();
        rs.close();
        sc.close();
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
    public void AddStud(Connection conn, Scanner scan, String F_NAME, String L_NAME, String MAJOR) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();

            int STUD_ID = rand.nextInt(10000000, 19999999);
            String stud = Int.toString(STUD_ID);
            String update_query = "INSERT INTO STUDENT(FNAME, LNAME, MAJOR, STUDID) VALUES '" + F_NAME + "', '" + L_NAME + "', '" + MAJOR + "', '" + stud + "';";
            st.executeQuery(update_query);

            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("Student added.");
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

    //Delete a student
    public void DelStud(Connection conn, Scanner scan, String STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            
            String del_student = "DELETE FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            st.executeUpdate(del_student);

            String check = "SELECT * FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            ResultSet rs = st.executeQuery(check);
            if(rs.next() == false) {
                System.out.println("Student deleted.");
                return;
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
        sc.close();
    }

    //Update student info
    public void UpdateStud(Connection conn, Scanner scan, String STUD_ID, String F_NAME, String L_NAME, String MAJOR, String CLASS) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            String update_query = "UPDATE STUDENT SET FNAME = '" + F_NAME + "', LNAME = '" + L_NAME + "', MAJOR = '" + MAJOR + ", CLASS = '" + CLASS + "' WHERE STUDID = '" + STUD_ID + "';";
            st.executeUpdate(update_query);

            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + stud + "';";
            ResultSet rs = st.executeQuery(select_query);
            
            if(rs.next() == true) {
                System.out.println("Update successful.");
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

        // This will get and display information when "modify student registration" is selected
    public static RegInfo(Connection conn, Scanner scan, String STUD_ID) throws SQLException, IOException {
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
    public void AddProf(Connection conn, Scanner scan, String F_NAME, String L_NAME, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
            Random rand = new Random();

            int prof = rand.nextInt(22000000, 22999999);
            String PROF_ID = Integer.toString(prof);
            String update_query = "INSERT INTO PROFESSOR(FNAME, LNAME, DEPTKEY, PROFID) VALUES '" + F_NAME + "', '" + L_NAME + "', DEPTKEY = '" + DEPT_KEY + "', '" + PROF_ID + "';";
            ResultSet rs = st.executeQuery(update_query);
    
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

    //Delete professor
    public void DelProfessor(Connection conn, Scanner scan, String PROF_ID) {
        try {
            Statement st = conn.createStatement();
            // Enter ID of professor to remove

            String del_prof = "DELETE FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            st.executeUpdate(del_prof);

            String check = "SELECT * FROM PROFESSOR WHERE PROFID = '" + PROF_ID + "';";
            ResultSet rs = st.executeQuery(check);
            if(rs.next() == false) {
                System.out.println("Professor deleted.");
                return;
            }
        }
        catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
    }

    public void UpdateProf(Connection conn, Scanner scan, String PROF_ID, String F_NAME, String L_NAME, String DEPT_KEY) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();
        
            String update_query = "UPDATE PROFESSOR SET FNAME = '" + F_NAME + "', LNAME = '" + L_NAME + "', DEPARTMENT = '" + DEPT_KEY + "' WHERE PROFID = '" + PROF_ID + "';";
            st.executeUpdate(update_query);
        
            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            ResultSet rs = st.executeQuery(select_query);

            if(rs.next() == true) {
                System.out.println("Update successful.");
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
                String insert_query = "INSERT INTO DEPARTMENT VALUES '" + DEPT_KEY + "', '" + DEPT_NAME + "';";
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
        public void AddAdmin(Connection conn, String F_NAME, String L_NAME, String DEPARTMENT) throws SQLException, IOException {
            try {
                Statement st = conn.createStatement();
                Random rand = new Random();
                // Prompt for first name, last name, department 
                int id = rand.nextInt(33000000, 33999999);
                String ADMIN_ID = Integer.toString(id);
                String insert_query = "INSERT INTO SCHADMIN(FNAME, LNAME, DEPARTMENT, SCHADID) VALUES ('" + F_NAME + "', '" + L_NAME + "', '" + DEPARTMENT + "', " + ADMIN_ID + "');";
                st.executeUpdate(insert_query);
                System.out.println("Administrator added.");
            }
                catch(SQLException e) {
                    System.out.println("Error: " + e.getMessage);
                }
                st.close();
        }

        // Delete administrator
        public void DelAdmin(Connection conn, String ADMIN_ID) throws SQLException, IOException {
            try {
                Statement st = conn.createStatement();

                String delete_query = "DELETE * FROM SCHADMIN WHERE SCHADID = '" + ADMIN_ID + "';";
                st.executeUpdate(delete_query);

                String select_query = "SELECT * FROM SCHADMIN WHERE SCHADID = '" + ADMIN_ID + "';";
                ResultSet rs = st.executeQuery(select_query);

                if(rs.next == false) {
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
                String update_query = "UPDATE SCHADMIN(FNAME, LNAME, DEPTKEY) SET FNAME = '" + F_NAME + "', LNAME = '" + LNAME + "', DEPTKEY = '" + DEPT_KEY + "' WHERE SCHADID = '" + ADMIN_ID + "';";
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
