package VO;

import java.io.Serializable;
import java.util.Date;

public class BasicUserVO implements Serializable {
	private long id;
	private UserVO userVO;
	private String First_Name;
	private String Last_Name;
	private String PAN_No;
	private String Gender;
	private Date Birthdate;
	private String EmailId;
	private long Contact_No;
	private String Apt;
	private StreetVO streetVO;
	private AreaVO areaVO;
	private CityVO cityVO;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getPAN_No() {
		return PAN_No;
	}
	public void setPAN_No(String pAN_No) {
		PAN_No = pAN_No;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}
	
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public long getContact_No() {
		return Contact_No;
	}
	public void setContact_No(long contact_No) {
		Contact_No = contact_No;
	}
	
	public String getApt() {
		return Apt;
	}
	public void setApt(String apt) {
		Apt = apt;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public StreetVO getStreetVO() {
		return streetVO;
	}
	public void setStreetVO(StreetVO streetVO) {
		this.streetVO = streetVO;
	}
	public AreaVO getAreaVO() {
		return areaVO;
	}
	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	
	
	}
