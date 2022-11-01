

//WIP


import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class StudentSQL {

    public void studentView(Connection conn, int STUDID) throws SQLException, IOException{
        try{
        Statement st = conn.createStatement(); 

        String query = "CREATE VIEW STUDENTCOR (COURSENUM, LETTERGRADE) AS SELECT COURSENUM, LETTERGRADE FROM STUDENTRECORD WHERE STUDID = '" + STUDID + "'";
        ResultSet rs = st.executeQuery(query);
         while(rs.next()){
            String course = rs.getString("COURSENUM");
            String grade = rs.getString("LETTERGRADE");

         }
         rs.close();
         st.close();
        }
        catch(SQLException e){
            System.out.println("Message: "+e.getMessage());

        }

    }
    public void showcourses(Connection conn,String depart ) throws SQLException, IOException{
        try(
            Statement st = conn.createStatement();
        )
        {
            String query = "SELECT CRN, COURSENUM, SECTIONNUM, PROFNAME, DESC FROM COURSE WHERE DEPTKEY IN (SELECT DEPTKEY FROM DEPARTMENT WHERE DEPTNAME = '"+depart+"');";
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                String crn = rs.getString("CRN");
                String coursenum = rs.getString("COURSENUM");
                String sectionnum = rs.getString("SECTIONNUM");
                String profname = rs.getString("PROFNAME");
                String desc = rs.getString("DESC");

                System.out.println("CRN: " +crn + " Course Number: "+ coursenum  + " Section Number: " + sectionnum +" Professors Name: "+ profname +" Course Description: "+ desc);
            }

        }
    }
    public void add_course(Connection conn, int STUDID, int CRN, char COURSENUM) throws SQLException, IOException{

        Statement st = conn.createStatement();
        String stud = (String)STUDID;
        String nCRN = (String)CRN;
        String nCN = (String)COURSENUM;
        Statement st = conn.createStatement();

        String query1 = "select* from Regigeredfor Where STUDID = '" + stud "' AND CRN = '" +nCN +'"';

        ResultSet rs = st.executeQuery(query1)
        if(rs.next()==true){
            Sytem.out.println("You are already registered for this course");
            return;
        }
        rs.close()


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





}
