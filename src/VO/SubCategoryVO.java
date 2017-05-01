package VO;

import java.io.Serializable;

public class SubCategoryVO implements Serializable{
	private long subCategory_ID;
	private String subCategory_Name;
	private String subCategory_Description;
	private CategoryVO categoryVO;
	
	public long getSubCategory_ID() {
		return subCategory_ID;
	}
	public void setSubCategory_ID(long subCategory_ID) {
		this.subCategory_ID = subCategory_ID;
	}
	public String getSubCategory_Name() {
		return subCategory_Name;
	}
	public void setSubCategory_Name(String subCategory_Name) {
		this.subCategory_Name = subCategory_Name;
	}
	public String getSubCategory_Description() {
		return subCategory_Description;
	}
	public void setSubCategory_Description(String subCategory_Description) {
		this.subCategory_Description = subCategory_Description;
	}
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	
	}
	

