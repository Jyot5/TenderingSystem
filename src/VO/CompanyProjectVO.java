package VO;

import java.io.Serializable;

public class CompanyProjectVO implements Serializable {
	private long Mapping_ID;
	private UserVO userVO;
	private TenderVO tenderVO;
	private Long t_amount;
	
	
	public long getMapping_ID() {
		return Mapping_ID;
	}
	public void setMapping_ID(long mapping_ID) {
		Mapping_ID = mapping_ID;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public TenderVO getTenderVO() {
		return tenderVO;
	}
	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
	}
	public Long getT_amount() {
		return t_amount;
	}
	public void setT_amount(Long t_amount) {
		this.t_amount = t_amount;
	}
	
	
}
