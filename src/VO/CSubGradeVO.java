package VO;
import java.io.Serializable;

public class CSubGradeVO implements Serializable{
	
	private Long csgid;
	private String sf;
	private String sc;
	private String ltf;
	private String ltc;
	private String ftf;
	private String ftc;
	
	
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
