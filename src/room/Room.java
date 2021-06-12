package room;
import java.sql.*;

public class Room {
	int	room_id;
	int room_no;
	int bed_no;
	
	
	public Room() {
		super();
		this.room_id = room_id;
		this.room_no = room_no;
		this.bed_no = bed_no;
	}
	
	public int getRoom_id() {
		return room_id;
	}
	
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}


	public int getRoom_no() {
		return room_no;
	}


	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}


	public int getBed_no() {
		return bed_no;
	}


	public void setBed_no(int bed_no) {
		this.bed_no = bed_no;
	}

	
}

