package VO;

import java.io.Serializable;

public class AreaVO implements Serializable{
	private long area_ID;
	private String area_Name;
	private String area_Desc;
	private CityVO cityVO;
	
	
	
	
	public String getArea_Desc() {
		return area_Desc;
	}
	public void setArea_Desc(String area_Desc) {
		this.area_Desc = area_Desc;
	}
	public long getArea_ID() {
		return area_ID;
	}
	public void setArea_ID(long area_ID) {
		this.area_ID = area_ID;
	}
	public String getArea_Name() {
		return area_Name;
	}
	public void setArea_Name(String area_Name) {
		this.area_Name = area_Name;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	
	
}
