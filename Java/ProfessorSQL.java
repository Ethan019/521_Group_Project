import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ProfessorSQL{
    //getter for returning the CRN. WIll return null if crn is not found or SQL error. 
    public static String get_crn(Connection conn, String coursenum, String sectionnum){
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

    public void create_course(Connection conn, String depart,String coursenum, String sectionnum,String profid, String profname, String desc, String semester, String year) throws SQLException, IOException{

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
    public void update_course_Name(Connection conn, String coursename, String crn) throws SQLException{

        try{
            Statement st = conn.createStatement();

           String query = "UPDATE COURSE SET coursename = '" +coursename+"' WHERE CRN = '"+crn+"';";
           st.executeUpdate(query);
           st.close();
        } catch(SQLException e){
            System.out.println("Message: "+ e.getMessage());
        }
    }

    //updates course description 
    public void update_course_desc(Connection conn, String crn, String desc)throws SQLException{

        try{
            Statement st = conn.createStatement();
            
            String query = "UPDATE COURSE SET DESC = '" +desc+"' WHERE CRN = '"+crn+"';";
            st.executeUpdate(query);
            st.close();
        } catch(SQLException e){
            System.out.println("Message: "+e.getMessage());
        }
        
    }


    public void update_grades(Connection conn, String studid, String crn, String grade) throws SQLException{

        try{
            Statement st = conn.createStatement();

            String query = "Update REGISTEREDFOR SET Grade ='" +grade+"' WHERE STUDID ='"+studid+"' AND CRN ='"+crn+"';";
            st.executeUpdate(query);
            st.close();
        }catch (SQLException e){
            system.out.println("Message: "+e.getMessage());
        }
    }
}
