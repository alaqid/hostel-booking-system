package staff;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;

import staff.Staff;

public class StaffModel {
	
	private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;
    
    public StaffModel() {
        super();
        this.statement = statement;
        this.ps = ps;
        this.connection = connection;
    }
    
    public static void initJDBC() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

       connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/mondstadt" , "root", "");
        System.out.println("Database connected");

    }
    
    public static ArrayList<Staff> viewStaff() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Staff> ivList = null;

        try {


           ivList = new ArrayList<Staff>();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM staff");

            while (rs.next()){

            	Staff iv = new Staff();
            	byte[] byteArray = rs.getBytes("staff_dp");
                String encode=Base64.encodeBase64String(byteArray);
                iv.setSqlimage(encode);
            	iv.setStaff_id(rs.getInt("staff_id"));
                iv.setStaff_name(rs.getString("staff_name"));
                iv.setStaff_ic(rs.getString("staff_ic"));
                iv.setStaff_position(rs.getString("staff_position"));
                iv.setStaff_email(rs.getString("staff_email"));
                iv.setStaff_phone(rs.getString("staff_phone"));
                iv.setStaff_address(rs.getString("staff_address"));    
                ivList.add(iv);
        }
      }

        catch (Exception ex) {

            System.out.println("viewStaff():"+ ex);
            ex.printStackTrace();
        }
        
        return ivList;
    } 
    
    public Staff getStaffById(int staff_id){
     	Staff inv = new Staff();
     	try{
     		this.initJDBC();
     		String query = ("SELECT * from staff WHERE  staff_id = ?");
  	        PreparedStatement ps = connection.prepareStatement(query);
  	        ps.setInt(1, staff_id);

  	        ResultSet rs = ps.executeQuery();

  	        while (rs.next()){
  	        	inv.setStaff_id(rs.getInt("staff_id"));
  	        	inv.setStaff_name(rs.getString("staff_name"));
  	        	inv.setStaff_ic(rs.getString("staff_ic"));
                inv.setStaff_position(rs.getString("staff_position"));
                inv.setStaff_email(rs.getString("staff_email"));
                inv.setStaff_phone(rs.getString("staff_phone"));
                inv.setStaff_address(rs.getString("staff_address"));   
                
  	        }
  	    }
  	    catch (Exception ex) {
  	        System.out.println(ex);
  	    }

  	return inv;
  	}
    
    public void addStaff(Staff iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();  
        Part part = iv.getImage();
        
        
        try {
        	
            String sql = "INSERT into staff(staff_name,staff_ic,staff_position,staff_email,staff_phone,staff_address,staff_dp) values(?,?,?,?,?,?,?)";
            InputStream is = part.getInputStream();
            ps = connection.prepareStatement(sql);
            ps.setString(1, iv.getStaff_name());
            ps.setString(2, iv.getStaff_ic());
            ps.setString(3, iv.getStaff_position());
            ps.setString(4, iv.getStaff_email());
            ps.setString(5, iv.getStaff_phone());  
            ps.setString(6, iv.getStaff_address());
            ps.setBlob(7, is);
            


            ps.executeUpdate();
            System.out.println("New record added successfully ");
        }
        catch (Exception ex) {
            System.out.println("addStaff()" + ex);
            ex.printStackTrace();
        }
    }
    
    public void deleteStaffById(int id)  throws ClassNotFoundException, SQLException{

        try {

            this.initJDBC();
            String sql = ("DELETE from staff WHERE  staff_id = ?");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Record deleted successfully");
        }
        catch (Exception ex) {
            System.out.println("deleteStaffById(): "+ ex);
            ex.printStackTrace();
        }
    }
    
    public void updateStaff(Staff iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();
        Part part = iv.getImage();

        try {

            String sql = "UPDATE staff SET staff_name = ?,staff_ic = ?,staff_position = ? ,staff_email = ? ,staff_phone = ?, staff_address = ?, staff_dp = ? WHERE staff_id = ?";
            InputStream is = part.getInputStream();
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, iv.getStaff_name());
            ps.setString(2, iv.getStaff_ic());
            ps.setString(3, iv.getStaff_position());
            ps.setString(4, iv.getStaff_email());
            ps.setString(5, iv.getStaff_phone());             
            ps.setString(6, iv.getStaff_address());
            ps.setBlob(7, is);
            ps.setInt(8, iv.getStaff_id());
            



            ps.executeUpdate();
            System.out.println("Database updated successfully ");  
            
        }
        catch (Exception ex) {
            System.out.println("updateStaff()" + ex);
            ex.printStackTrace();
        }
	}
}
