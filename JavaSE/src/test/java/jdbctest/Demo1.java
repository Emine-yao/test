package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.DBUtil;

public class Demo1 {
    
    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            System.out.println(conn);
            Statement state = conn.createStatement();
            
            ResultSet rs = state.executeQuery("select username,age,salary from emp");
            while (rs.next()) {
                String username = rs.getString("username");
                int age = rs.getInt("age");
                double salary = rs.getDouble("salary");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DBUtil.closeConnection();
        }
        
        
       
        
        
    }
}
