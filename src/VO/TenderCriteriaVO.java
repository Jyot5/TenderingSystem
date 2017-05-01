package VO;

import java.io.Serializable;

public class TenderCriteriaVO implements Serializable {
	private long tenderCriteriaId;
	
	private TenderVO tenderVO;
	private GradeVO gradeVO;
	private long minimumTurnover;
	private long individualWE;
	private long partnershipWE;
	private long minimumBankBalance;
	private String Description;
	
	public long getTenderCriteriaId() {
		return tenderCriteriaId;
	}
	public void setTenderCriteriaId(long tenderCriteriaId) {
		this.tenderCriteriaId = tenderCriteriaId;
	}
	
	public TenderVO getTenderVO() {
		return tenderVO;
	}
	public void setTenderVO(TenderVO tenderVO) {
		this.tenderVO = tenderVO;
	}
	public GradeVO getGradeVO() {
		return gradeVO;
	}
	public void setGradeVO(GradeVO gradeVO) {
		this.gradeVO = gradeVO;
	}
	public long getMinimumTurnover() {
		return minimumTurnover;
	}
	public void setMinimumTurnover(long minimumTurnover) {
		this.minimumTurnover = minimumTurnover;
	}
	public long getIndividualWE() {
		return individualWE;
	}
	public void setIndividualWE(long individualWE) {
		this.individualWE = individualWE;
	}
	public long getPartnershipWE() {
		return partnershipWE;
	}
	public void setPartnershipWE(long partnershipWE) {
		this.partnershipWE = partnershipWE;
	}
	public long getMinimumBankBalance() {
		return minimumBankBalance;
	}
	public void setMinimumBankBalance(long minimumBankBalance) {
		this.minimumBankBalance = minimumBankBalance;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}