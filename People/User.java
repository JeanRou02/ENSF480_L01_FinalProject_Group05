public class User {
	private String name;
	private String username;
	private String password;
	private String dateOfBirth;
	private String userType;
	
	public void browseFlights() {
		// TODO
	}
	
	public String getName() {
		return this.name;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	public String getUserType() {
		return this.userType;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDateOfBirth(String DOB) {
		this.dateOfBirth = DOB;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
