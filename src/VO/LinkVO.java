package VO;

import java.io.Serializable;

public class LinkVO implements Serializable{

	private long linkID,dispatchDT,activationDT;
	private String link;
	private GovtEmpVO gevo;
	 
	
	
	public GovtEmpVO getGevo() {
		return gevo;
	}
	public void setGevo(GovtEmpVO gevo) {
		this.gevo = gevo;
	}
	private int status;
	
	public long getLinkID() {
		return linkID;
	}
	public void setLinkID(long linkID) {
		this.linkID = linkID;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getDispatchDT() {
		return dispatchDT;
	}
	public void setDispatchDT(long dispatchDT) {
		this.dispatchDT = dispatchDT;
	}
	public long getActivationDT() {
		return activationDT;
	}
	public void setActivationDT(long activationDT) {
		this.activationDT = activationDT;
	}
	
}
