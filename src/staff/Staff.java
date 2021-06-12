package staff;

import javax.servlet.http.Part;

public class Staff {
	int staff_id;
	String staff_name;
	String staff_ic;
	String staff_position;
	String staff_email;
	String staff_phone;
	String staff_address;
	String staff_pwd;
	Part image;
    byte[] blob;
    String sqlimage;
	
	public Staff() {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.staff_ic = staff_ic;
		this.staff_position = staff_position;
		this.staff_email = staff_email;
		this.staff_phone = staff_phone;
		this.staff_address = staff_address;		
		this.staff_pwd = staff_pwd;	
		this.image = image;
		this.blob = blob;
		this.sqlimage = sqlimage;
	}
	
	

	public Part getImage() {
		return image;
	}



	public void setImage(Part image) {
		this.image = image;
	}



	public byte[] getBlob() {
		return blob;
	}



	public void setBlob(byte[] blob) {
		this.blob = blob;
	}



	public String getSqlimage() {
		return sqlimage;
	}



	public void setSqlimage(String sqlimage) {
		this.sqlimage = sqlimage;
	}



	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_ic() {
		return staff_ic;
	}

	public void setStaff_ic(String staff_ic) {
		this.staff_ic = staff_ic;
	}

	public String getStaff_position() {
		return staff_position;
	}

	public void setStaff_position(String staff_position) {
		this.staff_position = staff_position;
	}

	public String getStaff_email() {
		return staff_email;
	}

	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}

	public String getStaff_pwd() {
		return staff_pwd;
	}

	public void setStaff_pwd(String staff_pwd) {
		this.staff_pwd = staff_pwd;
	}
	
	
}
