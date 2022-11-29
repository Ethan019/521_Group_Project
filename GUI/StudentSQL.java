package UniversitySystemGUI;

//WIP

import java.io.*;
import java.sql.*;
import java.util.Scanner;




public class StudentSQL {

    //student views (needs return objects)
    public void student_View(Connection conn, String STUDID){
        try{
        Statement st = conn.createStatement();

        String query = "CREATE OR REPLACE VIEW STUDENTCOR (COURSENUM, LETTERGRADE) AS SELECT COURSE.COURSENUM, STUDENTRECORD.LETTERGRADE FROM COURSE, STUDENTRECORD WHERE STUDENTRECORD.STUDID = '" + STUDID + "' AND COURSE.CRN = STUDENTRECORD.CRN;";
        st.executeUpdate(query);

        String query2 = "Select * from STUDENTCOR;";
        st.executeQuery(query2);

            ResultSet rs = st.executeQuery(query2);
            System.out.println("Course | Grade");
            while(rs.next()){
                System.out.println("--------------");
                String course = rs.getString("COURSENUM");
                String grade = rs.getString("LETTERGRADE");
                System.out.println(course + "         " + grade);


            }
            System.out.println("--------------");
         rs.close();
         st.close();
        }
        catch(SQLException e){
            System.out.println("Message: "+e.getMessage());

        }

    }
    //student display courses (not complete)
    public void show_Courses(Connection conn,String DEPART ) throws SQLException, IOException{
        try(
            Statement st = conn.createStatement();
        )
        {
            String query = "SELECT CRN, COURSENUM, SECTIONNUM, PROFNAME, DES FROM COURSE WHERE DEPTKEY IN (SELECT DEPTKEY FROM DEPARTMENT WHERE DEPTNAME = '"+DEPART+"');";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                String crn = rs.getString("CRN");
                String coursenum = rs.getString("COURSENUM");
                String sectionnum = rs.getString("SECTIONNUM");
                String profname = rs.getString("PROFNAME");
                String desc = rs.getString("DES");

                System.out.println("CRN: " +crn + " Course Number: "+ coursenum  + " Section Number: " + sectionnum +" Professors Name: "+ profname +" Course Description: "+ desc);
            }

        }
    }


    //student add course (not complete)
    public void add_Course(Connection conn, int STUDID, int CRN, char COURSENUM) throws SQLException, IOException{

        Statement st = conn.createStatement();
        String stud = Integer.toString(STUDID);
        String nCRN = Integer.toString(CRN);
        String nCN = Character.toString(COURSENUM);
        

        String query1 = "select* from REGISTEREDFOR Where STUDID = '" + stud +"' AND CRN = '" +nCN +'"';

        ResultSet rs = st.executeQuery(query1);
        if(rs.next()==true){
            System.out.println("You are already registered for this course");
            rs.close();

            return;
        }
        rs.close();


        String query2 ="Insert into Registeredfor(STUDID, CRN, COURSENUM) values('" + STUDID + "', '" + nCRN + "', '" +nCRN +"')";

        try {

            st.executeUpdate(query2);

        }

        catch (SQLException e)
        {
            System.out.println("Message: " + e.getMessage());
        }
        st.close();

    }

    //student drop class (not finished)
    public void student_Drop(Connection conn, int CRN, int STUDID) throws SQLException{

        Statement st = conn.createStatement();
        String stud = Integer.toString(STUDID);
        String scrn = Integer.toString(CRN);
        String query = "select CRN from RegisteredFor where CRN = '" + scrn+ "' AND STUDID = '"+stud+"'";
        
        ResultSet rs = st.executeQuery(query);
        
        //escape clause for when course is not registered for. 
        if(rs.next()==false){
            return;
        }
        else{{
            query ="Delete From RegisteredFor WHERE CRN = '" + scrn+ "' AND STUDID = '"+stud+"'"; 
        
        
            try{
                st.executeUpdate(query);
            }
            catch(SQLException e){
                System.out.println("message: "+e.getMessage());
            }
        }
         }

    }




}
