package VO;
import java.io.Serializable;

public class GSubGradeVO implements Serializable{
	
	private Long csgid;
	private String sf;
	private String sc;
	private String ltf;
	private String ltc;
	private String ftf;
	private String ftc;
	private String inote;
	private String remark;
	private TenderVO tvo;
	
	
	
	
	public TenderVO getTvo() {
		return tvo;
	}
	public void setTvo(TenderVO tvo) {
		this.tvo = tvo;
	}
	public String getInote() {
		return inote;
	}
	public void setInote(String inote) {
		this.inote = inote;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getCsgid() {
		return csgid;
	}
	public void setCsgid(Long csgid) {
		this.csgid = csgid;
	}
	public String getSf() {
		return sf;
	}
	public void setSf(String sf) {
		this.sf = sf;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getLtf() {
		return ltf;
	}
	public void setLtf(String ltf) {
		this.ltf = ltf;
	}
	public String getLtc() {
		return ltc;
	}
	public void setLtc(String ltc) {
		this.ltc = ltc;
	}
	public String getFtf() {
		return ftf;
	}
	public void setFtf(String ftf) {
		this.ftf = ftf;
	}
	public String getFtc() {
		return ftc;
	}
	public void setFtc(String ftc) {
		this.ftc = ftc;
	}
	
	

}
