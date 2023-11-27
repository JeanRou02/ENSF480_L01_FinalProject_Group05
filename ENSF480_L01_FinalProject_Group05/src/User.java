public class User {
    private String name;
    private String userName;
    private String password;
    private String dateOfBirth;
    private String userType;

    // Constructor
    public User(String name, String userName, String password, String dateOfBirth, String userType) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUserType() {
        return userType;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

