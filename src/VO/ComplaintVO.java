package VO;

import java.io.Serializable;

public class ComplaintVO implements Serializable {
	private long Complaint_ID;
	
	private String sub;
	private String msg;
	private UserVO userVO;
	private TenderVO tenderVO;
	
	public long getComplaint_ID() {
		return Complaint_ID;
	}
	public TenderVO getTenderVO() {
		return tenderVO;
	}
	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
	}
	public void setComplaint_ID(long complaint_ID) {
		Complaint_ID = complaint_ID;
	}
	
	
	public UserVO getUserVO() {
		return userVO;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

}
