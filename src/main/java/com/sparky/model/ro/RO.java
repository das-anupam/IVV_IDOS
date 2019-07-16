package com.sparky.model.ro;

public class RO {

	private String Userid;
	private String Password;
	private String Role;
	private String ExecuteFlag;
	

	public RO() {
		super();

	}


	/**
	 * @return the userid
	 */
	public String getUserid() {
		return Userid;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		Userid = userid;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return Role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		Role = role;
	}


	/**
	 * @return the executeFlag
	 */
	public String getExecuteFlag() {
		return ExecuteFlag;
	}


	/**
	 * @param executeFlag the executeFlag to set
	 */
	public void setExecuteFlag(String executeFlag) {
		ExecuteFlag = executeFlag;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RO [Userid=" + Userid + ", Password=" + Password + ", Role=" + Role + ", ExecuteFlag=" + ExecuteFlag
				+ "]";
	}


	public RO(String userid, String password, String role, String executeFlag) {
		super();
		Userid = userid;
		Password = password;
		Role = role;
		ExecuteFlag = executeFlag;
	}				

	}


