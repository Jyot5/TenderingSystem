package VO;

import java.io.Serializable;

import java.util.Date;

public class ApplyTenderVO implements Serializable {
	
	private long applyTender_ID;
	private long dd_NO;
	private Date dd_Date;
	private long amount;
	private TenderVO tenderVO;
	private UserVO uservo;
	
	
	
	
	
	public UserVO getUservo() {
		return uservo;
	}
	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}
	public long getApplyTender_ID() {
		return applyTender_ID;
	}
	public void setApplyTender_ID(long applyTender_ID) {
		this.applyTender_ID = applyTender_ID;
	}
	public long getDd_NO() {
		return dd_NO;
	}
	public void setDd_NO(long dd_NO) {
		this.dd_NO = dd_NO;
	}
	public Date getDd_Date() {
		return dd_Date;
	}
	public void setDd_Date(Date dd_Date) {
		this.dd_Date = dd_Date;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public TenderVO getTenderVO() {
		return tenderVO;
	}
	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
	}


}
