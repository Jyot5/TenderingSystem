package VO;

import java.io.Serializable;

public class CityVO implements Serializable {
	
	private long city_ID;
	private String city_Name;
	private String city_Description;
	public long getCity_ID() {
		return city_ID;
	}
	public void setCity_ID(long city_ID) {
		this.city_ID = city_ID;
	}
	public String getCity_Name() {
		return city_Name;
	}
	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}
	public String getCity_Description() {
		return city_Description;
	}
	public void setCity_Description(String city_Description) {
		this.city_Description = city_Description;
	}
	
	

}
