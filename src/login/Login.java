package login;

public class Login {
	int admin_id;
	String admin_email;
	String admin_pwd;
	
	public Login() {
		super();
		this.admin_id = admin_id;
		this.admin_email = admin_email;
		this.admin_pwd = admin_pwd;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	
	
}
