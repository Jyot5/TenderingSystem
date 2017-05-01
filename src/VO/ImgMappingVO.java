package VO;

import java.io.Serializable;

public class ImgMappingVO implements Serializable  {

	private int mpg_ID;
	private String mpg_Name;
	private String path;
	private GovtEmpVO gvo;
	
	
	public int getMpg_ID() {
		return mpg_ID;
	}
	public void setMpg_ID(int mpg_ID) {
		this.mpg_ID = mpg_ID;
	}
	public String getMpg_Name() {
		return mpg_Name;
	}
	public void setMpg_Name(String mpg_Name) {
		this.mpg_Name = mpg_Name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public GovtEmpVO getGvo() {
		return gvo;
	}
	public void setGvo(GovtEmpVO gvo) {
		this.gvo = gvo;
	}
	
	
	
	
}
