package VO;

import java.io.Serializable;
import java.util.Date;

public class User1VO implements Serializable{

	private long u1_id;
	private String uname;
	private String first_Name;
	private String last_Name;
	private String gender;
	private String email;
	private Date bday;
	private String pan;
	private String num1;
	private String aname;
	private UserVO uservo;
	private CityVO cityvo;
	private AreaVO areavo;
	private StreetVO streetvo;
	
	
	
	public long getU1_id() {
		return u1_id;
	}
	public void setU1_id(long u1_id) {
		this.u1_id = u1_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public UserVO getUservo() {
		return uservo;
	}
	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}
	public CityVO getCityvo() {
		return cityvo;
	}
	public void setCityvo(CityVO cityvo) {
		this.cityvo = cityvo;
	}
	public AreaVO getAreavo() {
		return areavo;
	}
	public void setAreavo(AreaVO areavo) {
		this.areavo = areavo;
	}
	public StreetVO getStreetvo() {
		return streetvo;
	}
	public void setStreetvo(StreetVO streetvo) {
		this.streetvo = streetvo;
	}
	
	
	
	
}
