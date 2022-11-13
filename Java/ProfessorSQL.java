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
            system.out.println("Message: "+e.getMessage());
        }
    }
}
