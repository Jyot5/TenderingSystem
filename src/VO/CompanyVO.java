package VO;

import java.io.Serializable;


public class CompanyVO implements Serializable {
	private long id;
	private UserVO userVO;
	private String Name;
	private String FAX;
	private String complex;
	private StreetVO streetVO;
	private AreaVO areaVO;
	private CityVO cityVO;
	private GradeVO gradevo;
	private long WorkExpind;
	private long WorkExpjoin;
	private String ContactNo;
	private String EmailId;
	private Long Turnover;
	private Long HighestValueProj;
	private GradeVO gradeVO;
	private Long minBalance;
	
	
	
	
	public Long getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(Long minBalance) {
		this.minBalance = minBalance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	
	public String getFAX() {
		return FAX;
	}
	public void setFAX(String fAX) {
		FAX = fAX;
	}
	public String getComplex() {
		return complex;
	}
	public void setComplex(String complex) {
		this.complex = complex;
	}
	public long getWorkExpind() {
		return WorkExpind;
	}
	public void setWorkExpind(long workExpind) {
		WorkExpind = workExpind;
	}
	public long getWorkExpjoin() {
		return WorkExpjoin;
	}
	public void setWorkExpjoin(long workExpjoin) {
		WorkExpjoin = workExpjoin;
	}
	public String getEmailId() {
		return EmailId;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	
	public Long getTurnover() {
		return Turnover;
	}
	public void setTurnover(Long turnover) {
		Turnover = turnover;
	}
	public Long getHighestValueProj() {
		return HighestValueProj;
	}
	public void setHighestValueProj(Long highestValueProj) {
		HighestValueProj = highestValueProj;
	}
	public GradeVO getGradevo() {
		return gradevo;
	}
	public void setGradevo(GradeVO gradevo) {
		this.gradevo = gradevo;
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
	public GradeVO getGradeVO() {
		return gradeVO;
	}
	public void setGradeVO(GradeVO gradeVO) {
		this.gradeVO = gradeVO;
	}
	
}
