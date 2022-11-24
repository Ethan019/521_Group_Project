package UniversitySystemGUI;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.sql.*;

public class UserLogin{

    public static  String UserLogin(String ID, String Password) throws SQLException{
        Connection conn;
        String url = "jdbc:mysql://localhost/sys";  //test is the database name
        String user = "root"; //username
        String password = "Password12345"; //root password, you set it when you install the DBMS

        conn = DriverManager.getConnection(url, user, password);
        //print menu
        Statement st = conn.createStatement();
        String query = "select* from users where USERID= '"+ID +"' AND Password= '"+Password+"';";

        ResultSet rs = st.executeQuery(query);
        String role = null;
        while(rs.next()){
            role = rs.getString("role");
        }
        return role;
    }
}
