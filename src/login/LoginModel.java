package login;
 
import java.sql.*;
 
public class LoginModel {
 
    public Login checkLogin(String admin_email, String admin_pwd) throws SQLException,
            ClassNotFoundException {


        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
       Connection connection = DriverManager.getConnection

                ("jdbc:mysql://localhost:3306/mondstadt" , "root", "");
        System.out.println("Database connected");



        String sql = "SELECT * FROM admin WHERE admin_email = ? AND admin_pwd = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, admin_email );
        statement.setString(2, admin_pwd );

 
        ResultSet result = statement.executeQuery();
 
        Login admin = null;
 

        if (result.next()) {


        	admin = new Login(); 
        	admin.setAdmin_email(result.getString("admin_email"));
        	admin.setAdmin_pwd(result.getString("admin_pwd"));           

        }


 
        
 
        return admin;
    }
}