package com.jks.entity;

public class User {
   
    private Integer id;

  
    public User(Integer id, String usercode, String password, String level, String schoolname) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.password = password;
		this.level = level;
		this.schoolname = schoolname;
	}

	public User() {
		super();
	}

	private String usercode;

   
    private String password;

   
    private String level;

    private String schoolname;

   
    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Usercode
     *
     * @return the value of user.Usercode
     *
     * @mbg.generated
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Usercode
     *
     * @param usercode the value for user.Usercode
     *
     * @mbg.generated
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Password
     *
     * @return the value of user.Password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Password
     *
     * @param password the value for user.Password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Level
     *
     * @return the value of user.Level
     *
     * @mbg.generated
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Level
     *
     * @param level the value for user.Level
     *
     * @mbg.generated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.SchoolName
     *
     * @return the value of user.SchoolName
     *
     * @mbg.generated
     */
    public String getSchoolname() {
        return schoolname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.SchoolName
     *
     * @param schoolname the value for user.SchoolName
     *
     * @mbg.generated
     */
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", password=" + password + ", level=" + level
				+ ", schoolname=" + schoolname + "]";
	}
}