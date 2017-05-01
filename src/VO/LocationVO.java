package VO;

import java.io.Serializable;

public class LocationVO implements Serializable {
	private long Mapping_ID;
	private CityVO cityVO;
	private AreaVO areaVO;
	private StreetVO streetVO;
	public long getMapping_ID() {
		return Mapping_ID;
	}
	public void setMapping_ID(long mapping_ID) {
		Mapping_ID = mapping_ID;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public AreaVO getAreaVO() {
		return areaVO;
	}
	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}
	public StreetVO getStreetVO() {
		return streetVO;
	}
	public void setStreetVO(StreetVO streetVO) {
		this.streetVO = streetVO;
	}
	
	
}
