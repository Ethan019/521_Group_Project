package UniversitySystemGUI;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ProfessorSQL{
    //getter for returning the CRN. WIll return null if crn is not found or SQL error. 
    public static String getCrn(Connection conn, String coursenum, String sectionnum){
        try{
            Statement st = conn.createStatement();

            String query1 = "select CRN from Course where coursenum= '" +coursenum+ "' AND sectionnum= '"+sectionnum+"';";

            ResultSet rs1 = st.executeQuery(query1);
            if(rs1.next()==false){
                return null;
            }
    
            String ccode = rs1.getString("CRN");
            return ccode;
            
            
        }
        catch(SQLException e){
            System.out.println("message: "+ e.getMessage());
            return null;
        }
       
        
    }
    public void displayCourses(Connection conn, String profid){
        try{
            Statement st = conn.createStatement();

            String query1 = "select CRN, COURSENUM, SECTIONNUM, coursename from Course where PROFID = '" + profid+"';";

            ResultSet rs1 = st.executeQuery(query1);
            while(rs1.next()){
                Statement st2 = conn.createStatement();
                String crn = rs1.getString("CRN");
                String coursenum = rs1.getString("COURSENUM");
                String sectionnum = rs1.getString("SECTIONNUM");
                String name = rs1.getString("coursename");
                System.out.println("|CRN:"+crn+ " |COURSENUM:"+coursenum+ " |Section:"+sectionnum +" |Name:"+name);
                String query2 = "select STUDENT.studid, STUDENT.FNAME, STUDENT.LNAME, REGISTEREDFOR.GRADE from STUDENT, REGISTEREDFOR WHERE REGISTEREDFOR.STUDID =STUDENT.STUDID AND STUDENT.STUDID = (SELECT STUDID GRADE FROM REGISTEREDFOR WHERE CRN =" +crn+") AND REGISTEREDFOR.CRN IN (SELECT CRN FROM COURSE WHERE PROFID = "+profid+");";
                ResultSet rs2 = st2.executeQuery(query2);
                System.out.println("|Students Registered:");
                while(rs2.next()){
                    String stud = rs2.getString("STUDID");


                        String firstn= rs2.getString("FNAME");
                        String lname= rs2.getString("LNAME");
                        String grade = rs2.getString("GRADE");
                        System.out.println("|NAME:"+firstn+ " "+lname+" |Grade " +grade+" ID:"+ stud+" ");

                    }
                System.out.println("====================");



            }



        }
        catch(SQLException e){
            System.out.println("message: "+ e.getMessage());

        }
    }

    public void createCourse(Connection conn, String depart,String coursenum, String sectionnum,String profid, String profname, String desc, String semester, String year) throws SQLException, IOException{

        try{
            Statement st = conn.createStatement();
            
            



            String query = "Insert into COURSE (deptkey, coursenum, sectionnum, profid, profname, desc, semester, year) values ('" + depart + "', '" + coursenum + "', '" + sectionnum + "', '" + profid + "', '" + profname + "', '" + desc + "', '" + semester + "', '" + year + "')";


            st.executeUpdate(query);
            st.close();
        }catch(SQLException e){
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println("A new course was added.");

    }

    //there is no current course name in course table. We need to add a course name there. 
    public void updateCourseName(Connection conn, String COURSENAME, String CRN) throws SQLException{

        try{
            Statement st = conn.createStatement();

           String query = "UPDATE COURSE SET coursename = '" +COURSENAME+"' WHERE CRN = '"+CRN+"';";
           st.executeUpdate(query);
           st.close();
        } catch(SQLException e){
            System.out.println("Message: "+ e.getMessage());
        }
    }

    //updates course description 
    public void updateCourseDesc(Connection conn, String CRN, String DESC)throws SQLException{

        try{
            Statement st = conn.createStatement();
            
            String query = "UPDATE COURSE SET DESC = '" +DESC+"' WHERE CRN = '"+CRN+"';";
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e){
            System.out.println("Message: "+e.getMessage());
        }
        
    }


    public void updateGrades(Connection conn, String STUDID, String CRN, String GRADE) throws SQLException{

        try{
            Statement st = conn.createStatement();

            String query = "Update REGISTEREDFOR SET Grade ='" +GRADE+"' WHERE STUDID ='"+STUDID+"' AND CRN ='"+CRN+"';";
            st.executeUpdate(query);
            st.close();
        }catch (SQLException e){
            System.out.println("Message: "+e.getMessage());
        }
    }
}
