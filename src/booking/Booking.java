package booking;

import java.sql.*;

public class Booking {
	int booking_id;
	int guest_id;
	int room_id;
	Date date_checkin;
	Date date_checkout;
	int room_no;
	int bed_no;
	
	public Booking(){
		super();
		this.booking_id = booking_id;
		this.guest_id = guest_id;
		this.room_id = room_id;
		this.date_checkin = date_checkin;
		this.date_checkout = date_checkout;
		this.room_no = room_no;
		this.bed_no = bed_no;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Date getDate_checkin() {
		return date_checkin;
	}

	public void setDate_checkin(Date date_checkin) {
		this.date_checkin = date_checkin;
	}

	public Date getDate_checkout() {
		return date_checkout;
	}

	public void setDate_checkout(Date date_checkout) {
		this.date_checkout = date_checkout;
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
