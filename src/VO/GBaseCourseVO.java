package VO;
import java.io.Serializable;

public class GBaseCourseVO implements Serializable{
	private Long cscid;
	private String s1;
	private String s2;
	private String lt1;
	private String lt2;
	private String ft1;
	private String ft2;
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
	public Long getCscid() {
		return cscid;
	}
	public void setCscid(Long cscid) {
		this.cscid = cscid;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getLt1() {
		return lt1;
	}
	public void setLt1(String lt1) {
		this.lt1 = lt1;
	}
	public String getLt2() {
		return lt2;
	}
	public void setLt2(String lt2) {
		this.lt2 = lt2;
	}
	public String getFt1() {
		return ft1;
	}
	public void setFt1(String ft1) {
		this.ft1 = ft1;
	}
	public String getFt2() {
		return ft2;
	}
	public void setFt2(String ft2) {
		this.ft2 = ft2;
	}
	
	

}
