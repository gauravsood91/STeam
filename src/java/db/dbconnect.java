/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;
/**
 *
 * @author saurabh
 */
public class dbconnect {
    String query;
    Connection conn;
    Statement st;
    public dbconnect(String query){
        this.query=query;
        try {
            
         Class.forName("org.postgresql.Driver");   

        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
                try{
                    conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/steam","postgres","");
                    st=conn.createStatement();
                }
                catch(SQLException f){
                    f.printStackTrace();
                }
    }
    
    public ResultSet returnResults(){
        ResultSet res=null;
        try{
            res=st.executeQuery(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    
    public int modifyQuery(){
        int res=0;
        try{
            res=st.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    
}
