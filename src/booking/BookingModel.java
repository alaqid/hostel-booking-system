package booking;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.Part;

import staff.Staff;

public class BookingModel {
	
	private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;
    
    public BookingModel() {
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
    
    public static ArrayList<Booking> viewBooking() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Booking> ivList = null;

        try {


           ivList = new ArrayList<Booking>();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM ((booking INNER JOIN room ON booking.room_id = room.room_id) INNER JOIN guest ON booking.guest_id = guest.guest_id)");
            

            while (rs.next()){

            	Booking iv = new Booking();
                iv.setBooking_id(rs.getInt("booking_id"));
                iv.setDate_checkin(rs.getDate("date_checkin"));
                iv.setDate_checkout(rs.getDate("date_checkout"));
                iv.setRoom_no(rs.getInt("room_no"));
                iv.setBed_no(rs.getInt("bed_no"));
                ivList.add(iv);
        }
      }

        catch (Exception ex) {

            System.out.println("viewBooking():"+ ex);
            ex.printStackTrace();
        }
        
        return ivList;
    } 
    
    public Booking getBookingById(int id){
    	Booking inv = new Booking();
     	try{
     		this.initJDBC();
     		String query = ("SELECT * FROM ((booking INNER JOIN room ON booking.room_id = room.room_id) INNER JOIN guest ON booking.guest_id = guest.guest_id)");
  	        PreparedStatement ps = connection.prepareStatement(query);
  	        ps.setInt(1, id);

  	        ResultSet rs = ps.executeQuery();

  	        while (rs.next()){
  	            inv.setBooking_id(rs.getInt("booking_id"));
  	            inv.setDate_checkin(rs.getDate("date_checkin"));
  	            inv.setDate_checkout(rs.getDate("date_checkout"));
  	        }
  	    }
  	    catch (Exception ex) {
  	        System.out.println(ex);
  	    }

  	return inv;
  	}
    
    public void addBooking(Booking iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();           
        java.util.Date utilStartDate1 = iv.getDate_checkin();
        java.sql.Date sqldate1 = new java.sql.Date(utilStartDate1.getTime());
        java.util.Date utilStartDate2 = iv.getDate_checkout();
        java.sql.Date sqldate2 = new java.sql.Date(utilStartDate2.getTime());
        
        try {

            String sql = "INSERT into booking(date_checkin,date_checkout,guest_id,room_id,room_no1) values(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(4, iv.getRoom_id());
            ps.setInt(3, iv.getGuest_id());  
            ps.setInt(5, iv.getBed_no());  
            ps.setDate(1, sqldate1); 
            ps.setDate(2, sqldate2);
          

            ps.executeUpdate();
            System.out.println("New record added successfully ");
        }
        catch (Exception ex) {
            System.out.println("addBooking()" + ex);
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<Booking> viewBookingGuest(int guest_id) throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Booking> ivList = null;

        try {


           ivList = new ArrayList<Booking>();

            Statement statement = connection.createStatement();

            String query = ("SELECT * FROM ((booking INNER JOIN room ON booking.room_id = room.room_id) INNER JOIN guest ON booking.guest_id = guest.guest_id) WHERE guest.guest_id = ?");
            PreparedStatement ps = connection.prepareStatement(query);
  	        ps.setInt(1, guest_id);

  	        ResultSet rs = ps.executeQuery();

            while (rs.next()){

            	Booking iv = new Booking();
                iv.setBooking_id(rs.getInt("booking_id"));
                iv.setGuest_id(rs.getInt("guest_id"));
                iv.setDate_checkin(rs.getDate("date_checkin"));
                iv.setDate_checkout(rs.getDate("date_checkout"));
                iv.setRoom_no(rs.getInt("room_no"));
                iv.setBed_no(rs.getInt("room_no1"));
                ivList.add(iv);
        }
      }

        catch (Exception ex) {

            System.out.println("viewBooking():"+ ex);
            ex.printStackTrace();
        }
        
        return ivList;
    } 
    
    public void deleteBookingById(int id)  throws ClassNotFoundException, SQLException{

        try {

            this.initJDBC();
            String sql = ("DELETE from booking WHERE  booking_id = ?");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Record deleted successfully");
        }
        catch (Exception ex) {
            System.out.println("deleteBookingById(): "+ ex);
            ex.printStackTrace();
        }
    }      

}
