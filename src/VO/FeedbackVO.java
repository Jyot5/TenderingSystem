package VO;

import java.io.Serializable;

public class FeedbackVO implements Serializable {
	private long Feedback_ID;
	
	private String sub;
	private String msg;
	private UserVO userVO;
	private TenderVO tenderVO;
	
	public long getFeedback_ID() {
		return Feedback_ID;
	}
	public void setFeedback_ID(long feedback_ID) {
		Feedback_ID = feedback_ID;
	}
	
	public TenderVO getTenderVO() {
		return tenderVO;
	}
	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
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
