package VO;

import java.io.Serializable;

public class CategoryVO implements Serializable {
	private long category_ID;
	private String category_Name;
	private String category_Description;
	public long getCategory_ID() {
		return category_ID;
	}
	public void setCategory_ID(long category_ID) {
		this.category_ID = category_ID;
	}
	public String getCategory_Name() {
		return category_Name;
	}
	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}
	public String getCategory_Description() {
		return category_Description;
	}
	public void setCategory_Description(String category_Description) {
		this.category_Description = category_Description;
	}
	
	
}
