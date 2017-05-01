package VO;
import java.io.Serializable;


public class GBituminousVO implements Serializable {

	private Long cbid;
	private String bm;
	private String bc;
	private String sdbc;
	private String dbm;
	private String bt;
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
	public Long getCbid() {
		return cbid;
	}
	public void setCbid(Long cbid) {
		this.cbid = cbid;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getBc() {
		return bc;
	}
	public void setBc(String bc) {
		this.bc = bc;
	}
	public String getSdbc() {
		return sdbc;
	}
	public void setSdbc(String sdbc) {
		this.sdbc = sdbc;
	}
	public String getDbm() {
		return dbm;
	}
	public void setDbm(String dbm) {
		this.dbm = dbm;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	
	

}

