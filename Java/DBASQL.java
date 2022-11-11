// Caroline 
// WIP

import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class DBASQL {
    // Raw SQL Command Enter
    public void RawSql(Connection conn, Scanner scan, String COMMAND) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            //System.out.println("Enter SQL Command: ");
            //Scanner sc = new Scanner(System.in);
            //String command = sc.nextLine();
            //sc.close();

            String query = (COMMAND);
            ResultSet rs = st.executeQuery(query);
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        st.close();
        rs.close();
        sc.close();

    }

    // Grant privileges
    // ********************** UPDATE TABLES **********************
    public void UpdateStudTables(Connection conn, String STUD_ID) throws SQLException, IOException {
        try {
            Statement st = conn.createStatement();

            Scanner sc = new Scanner(System.in);
            //System.out.println("Please Enter Student ID to Edit: ");
            //String stud_id = sc.nextLine();

            String select_query = "SELECT * FROM STUDENT WHERE STUDID = '" + STUD_ID + "';";
            ResultSet rs1 = st.executeQuery(select_query);

            //System.out.println("Enter Updated Student Information:\n");
            //System.out.println("First Name: ");
            //String f_name = sc.nextLine();
            //System.out.println("Last Name: ");
            //String l_name = sc.nextLine();
            //System.out.println("Major: ");
            //String major = sc.nextLine();
            //System.out.println("Student ID: ");
            //String new_stud_id = sc.nextLine();

            String update_query = "UPDATE STUDENT SET FNAME = '" + f_name + "', LNAME = '" + l_name + "', MAJOR = '" + major + "', STUDID = '" + new_stud_id + "';";
            ResultSet rs2 = st.executeQuery(updateQuery);

            if(rs2.hasNext() == true) {
                System.out.println("The input information is already current.");
                //rs.close();
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

        }
    }

 
