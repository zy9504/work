package Model;

/**
 * Login entity. @author MyEclipse Persistence Tools
 */

public class Login implements java.io.Serializable {

	// Fields

	private String userName;
	private String password;
	private String role;

	// Constructors

	/** default constructor */
	public Login() {
	}

	/** full constructor */
	public Login(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}