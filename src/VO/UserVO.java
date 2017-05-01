package VO;

import java.io.Serializable;

public class UserVO implements Serializable{
	private long User_ID;
	private String first_Name;
	private String last_Name;
	private String user_Type;
	private String user_Status;
	private String user_Password;
	
	
	
	
	public long getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(long user_ID) {
		User_ID = user_ID;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getUser_Type() {
		return user_Type;
	}
	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
	}
	public String getUser_Status() {
		return user_Status;
	}
	public void setUser_Status(String user_Status) {
		this.user_Status = user_Status;
	}
	public String getUser_Password() {
		return user_Password;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	
		
}
