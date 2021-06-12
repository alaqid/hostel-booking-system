package guest;

import java.sql.*;
import java.util.ArrayList;

import guest.Guest;

public class GuestModel {
	
	private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;
    
    public GuestModel() {
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
    
    public static ArrayList<Guest> viewGuest() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Guest> ivList = null;

        try {


           ivList = new ArrayList<Guest>();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM guest");

            while (rs.next()){

                Guest iv = new Guest();
                iv.setGuest_id(rs.getInt("guest_id"));
                iv.setGuest_name(rs.getString("guest_name"));
                iv.setGuest_age(rs.getInt("guest_age"));
                iv.setGuest_gender(rs.getString("guest_gender"));
                iv.setGuest_email(rs.getString("guest_email"));
                iv.setGuest_phone(rs.getString("guest_phone"));                
                ivList.add(iv);
        }
      }

        catch (Exception ex) {

            System.out.println("viewGuest():"+ ex);
            ex.printStackTrace();
        }
        
        return ivList;
    } 
    
    public Guest getGuestById(int guest_id){
     	Guest inv = new Guest();
     	try{
     		this.initJDBC();
     		String query = ("SELECT * from guest WHERE  guest_id = ?");
  	        PreparedStatement ps = connection.prepareStatement(query);
  	        ps.setInt(1, guest_id);

  	        ResultSet rs = ps.executeQuery();

  	        while (rs.next()){
  	        	inv.setGuest_id(rs.getInt("guest_id"));
  	        	inv.setGuest_name(rs.getString("guest_name"));
                inv.setGuest_age(rs.getInt("guest_age"));
                inv.setGuest_gender(rs.getString("guest_gender"));
                inv.setGuest_email(rs.getString("guest_email"));
                inv.setGuest_phone(rs.getString("guest_phone"));                
  	        }
  	    }
  	    catch (Exception ex) {
  	        System.out.println(ex);
  	    }

  	return inv;
  	}
    
    public void addGuest(Guest iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();           
        
        
        try {

            String sql = "INSERT into guest(guest_name,guest_age,guest_gender,guest_email,guest_phone) values(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, iv.getGuest_name());
            ps.setInt(2, iv.getGuest_age());
            ps.setString(3, iv.getGuest_gender());
            ps.setString(4, iv.getGuest_email());
            ps.setString(5, iv.getGuest_phone());  

            ps.executeUpdate();
            System.out.println("New record added successfully ");
        }
        catch (Exception ex) {
            System.out.println("addGuest()" + ex);
            ex.printStackTrace();
        }
    }
    
    public void deleteGuestById(int id)  throws ClassNotFoundException, SQLException{

        try {

            this.initJDBC();
            String sql = ("DELETE from guest WHERE  guest_id = ?");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Record deleted successfully");
        }
        catch (Exception ex) {
            System.out.println("deleteGuestById(): "+ ex);
            ex.printStackTrace();
        }
    }
    
    public void updateGuest(Guest iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();

        try {

            String sql = "UPDATE guest SET guest_name = ?,guest_age = ?,guest_gender = ? ,guest_email = ? ,guest_phone = ? WHERE guest_id = ?";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, iv.getGuest_name());
            ps.setInt(2, iv.getGuest_age());
            ps.setString(3, iv.getGuest_gender());
            ps.setString(4, iv.getGuest_email());
            ps.setString(5, iv.getGuest_phone());             
            ps.setInt(6, iv.getGuest_id());

            ps.executeUpdate();
            System.out.println("Database updated successfully ");  
            
        }
        catch (Exception ex) {
            System.out.println("updateGuest()" + ex);
            ex.printStackTrace();
        }
	}
}
