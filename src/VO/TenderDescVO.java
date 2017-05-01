package VO;

import java.io.Serializable;
import java.util.Date;

public class TenderDescVO implements Serializable{
	
	private CategoryVO categoryVO;
	private SubCategoryVO subCategoryVO;
	private TenderVO tenderVO;
	
	private long tenderDescId;
	private long earnest_Money;
	private long max_Amount;
	private long min_Amount;
	private long year;
	private long month;
	
	private Date submission;
	private StreetVO StreetVO;
	private CityVO cityVO;
	private AreaVO areaVO;
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
	public TenderVO getTenderVO() {
		return tenderVO;
	}
	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
	}
	public long getTenderDescId() {
		return tenderDescId;
	}
	public void setTenderDescId(long tenderDescId) {
		this.tenderDescId = tenderDescId;
	}
	public long getEarnest_Money() {
		return earnest_Money;
	}
	public void setEarnest_Money(long earnest_Money) {
		this.earnest_Money = earnest_Money;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	public Date getSubmission() {
		return submission;
	}
	public void setSubmission(Date submission) {
		this.submission = submission;
	}
	public StreetVO getStreetVO() {
		return StreetVO;
	}
	public void setStreetVO(StreetVO streetVO) {
		StreetVO = streetVO;
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
	public long getMax_Amount() {
		return max_Amount;
	}
	public void setMax_Amount(long max_Amount) {
		this.max_Amount = max_Amount;
	}
	public long getMin_Amount() {
		return min_Amount;
	}
	public void setMin_Amount(long min_Amount) {
		this.min_Amount = min_Amount;
	}
	
	
			}
