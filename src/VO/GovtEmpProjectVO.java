package VO;

import java.io.Serializable;

public class GovtEmpProjectVO implements Serializable {
	private long Mapping_ID;
	private GovtEmpVO geVO;
	
	private TenderVO tenderVO;

	public long getMapping_ID() {
		return Mapping_ID;
	}

	public void setMapping_ID(long mapping_ID) {
		Mapping_ID = mapping_ID;
	}

	public GovtEmpVO getGeVO() {
		return geVO;
	}

	public void setGeVO(GovtEmpVO geVO) {
		this.geVO = geVO;
	}

	public TenderVO getTenderVO() {
		return tenderVO;
	}

	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
	}
	
	
	
	
}
