package room;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySQLAccess extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = (Connection) DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/mondstadt" , "root", "");
        System.out.println("Database connected");

        // Create a statement
        Statement statement = (Statement) connection.createStatement();

        // Execute a statement
        ResultSet resultSet = statement.executeQuery("SELECT * FROM room");

        // Iterate through the result and print the student names
        while (resultSet.next()){
            System.out.print(resultSet.getString(2));
            System.out.print(" " + resultSet.getString(3));
            System.out.println(" " + resultSet.getString(4));
        }

        // Close the connection
        connection.close();
    }
}