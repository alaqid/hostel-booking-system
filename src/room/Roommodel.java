package room;

import java.sql.*;
import java.util.ArrayList;

import room.Room;

public class Roommodel {
	
	private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;
    
    public Roommodel() {
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
    
    public static ArrayList<Room> viewRoom() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Room> ivList = null;

        try {


           ivList = new ArrayList<Room>();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM room");

            while (rs.next()){

                Room iv = new Room();
                iv.setRoom_id(rs.getInt("room_id"));
                iv.setRoom_no(rs.getInt("room_no"));
                iv.setBed_no(rs.getInt("bed_no"));
                ivList.add(iv);
        }
      }

        catch (Exception ex) {

            System.out.println("viewRoom():"+ ex);
            ex.printStackTrace();
        }
        
        return ivList;
    } 
    
    public Room getRoomById(int room_id){
     	Room inv = new Room();
     	try{
     		this.initJDBC();
     		String query = ("SELECT * from room WHERE  room_id = ?");
  	        PreparedStatement ps = connection.prepareStatement(query);
  	        ps.setInt(1, room_id);

  	        ResultSet rs = ps.executeQuery();

  	        while (rs.next()){
  	        	inv.setRoom_id(rs.getInt("room_id"));
  	        	inv.setRoom_no(rs.getInt("room_no"));
                inv.setBed_no(rs.getInt("bed_no"));
  	        }
  	    }
  	    catch (Exception ex) {
  	        System.out.println(ex);
  	    }

  	return inv;
  	}
    
    public void addRoom(Room iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();           
        
        
        try {

            String sql = "INSERT into room(room_no,bed_no) values(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, iv.getRoom_no());
            ps.setInt(2, iv.getBed_no());            

            ps.executeUpdate();
            System.out.println("New record added successfully ");
        }
        catch (Exception ex) {
            System.out.println("addRoom()" + ex);
            ex.printStackTrace();
        }
    }
    
    public void deleteRoomById(int id)  throws ClassNotFoundException, SQLException{

        try {

            this.initJDBC();
            String sql = ("DELETE from room WHERE  room_id = ?");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Record deleted successfully");
        }
        catch (Exception ex) {
            System.out.println("deleteRoomById(): "+ ex);
            ex.printStackTrace();
        }
    }
    
    public void updateRoom(Room iv) throws ClassNotFoundException, SQLException{

        this.initJDBC();

        try {

            String sql = "UPDATE room SET room_no = ?,bed_no = ? WHERE room_id = ?";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, iv.getRoom_no());
            ps.setInt(2, iv.getBed_no()); 
            ps.setInt(3, iv.getRoom_id());            

            ps.executeUpdate();
            System.out.println("Database updated successfully ");  
            
        }
        catch (Exception ex) {
            System.out.println("updateRoom()" + ex);
            ex.printStackTrace();
        }
	}
}
