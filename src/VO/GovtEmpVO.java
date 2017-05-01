package VO;

import java.io.Serializable;
import java.util.Date;

public class GovtEmpVO implements Serializable {
	
	private long g_id;
	private String first_Name;
	private String last_Name;
	private String uname;
	private String designation;
	private String email;
	private String department;
	private String education;
	private Date bday;
	private String aname;
	private UserVO uservo;
	private CityVO cityvo;
	private AreaVO areavo;
	private StreetVO streetvo;
	private String gender;
	private String num1;
	
	
	
	public String getGender() {
		return gender;
	}
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
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
	public UserVO getUservo() {
		return uservo;
	}
	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}

	
	
	
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	public long getG_id() {
		return g_id;
	}
	public void setG_id(long g_id) {
		this.g_id = g_id;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	
	


}
