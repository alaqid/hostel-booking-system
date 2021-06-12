package guest;

public class Guest {
	int guest_id;
	String guest_name;
	int guest_age;
	String 	guest_gender;
	String guest_email;
	String guest_phone;	
	
	public Guest() {
		super();
		this.guest_id = guest_id;
		this.guest_name = guest_name;
		this.guest_age = guest_age;
		this.guest_gender = guest_gender;
		this.guest_email = guest_email;
		this.guest_phone = guest_phone;		
		
	}

	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}
	
	public String getGuest_name() {
		return guest_name;
	}
	
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public int getGuest_age() {
		return guest_age;
	}

	public void setGuest_age(int guest_age) {
		this.guest_age = guest_age;
	}

	public String getGuest_gender() {
		return guest_gender;
	}

	public void setGuest_gender(String guest_gender) {
		this.guest_gender = guest_gender;
	}

	public String getGuest_email() {
		return guest_email;
	}

	public void setGuest_email(String guest_email) {
		this.guest_email = guest_email;
	}

	public String getGuest_phone() {
		return guest_phone;
	}

	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}
	
	

}
