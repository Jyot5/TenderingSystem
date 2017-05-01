package VO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TenderVO implements Serializable{
	private CategoryVO categoryVO;
	private SubCategoryVO subCategoryVO;
	private long tender_Id;
	private String tender_Name;
	private String tender_Description;

	private Set tset =	new HashSet(0);
	private Set t1set =	new HashSet(0);

	public Set getT1set() {
		return t1set;
	}
	public void setT1set(Set t1set) {
		this.t1set = t1set;
	}
	public Set getTset() {
		return tset;
	}
	public void setTset(Set tset) {
		this.tset = tset;
	}
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public SubCategoryVO getSubCategoryVO() {
		return subCategoryVO;
	}
	public void setSubCategoryVO(SubCategoryVO subCategoryVO) {
		this.subCategoryVO = subCategoryVO;
	}
	public long getTender_Id() {
		return tender_Id;
	}
	public void setTender_Id(long tender_Id) {
		this.tender_Id = tender_Id;
	}
	public String getTender_Name() {
		return tender_Name;
	}
	public void setTender_Name(String tender_Name) {
		this.tender_Name = tender_Name;
	}
	public String getTender_Description() {
		return tender_Description;
	}
	public void setTender_Description(String tender_Description) {
		this.tender_Description = tender_Description;
	}
		}
