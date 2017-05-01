package VO;

import java.io.Serializable;

public class StreetVO implements Serializable{
	private long street_ID;
	private String street_Name;
	private String street_Desc;
	private AreaVO areaVO;
	private CityVO cityVO;
	
	
	public String getStreet_Desc() {
		return street_Desc;
	}
	public void setStreet_Desc(String street_Desc) {
		this.street_Desc = street_Desc;
	}
	public long getStreet_ID() {
		return street_ID;
	}
	public void setStreet_ID(long street_ID) {
		this.street_ID = street_ID;
	}
	public String getStreet_Name() {
		return street_Name;
	}
	public void setStreet_Name(String street_Name) {
		this.street_Name = street_Name;
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
