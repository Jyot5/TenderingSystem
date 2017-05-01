package VO;

import java.io.Serializable;

public class WorkTypeVO implements Serializable {
	private long workType_ID;
	private String workType_Name;
	private String workType_Description;
	public long getWorkType_ID() {
		return workType_ID;
	}
	public void setWorkType_ID(long workType_ID) {
		this.workType_ID = workType_ID;
	}
	public String getWorkType_Name() {
		return workType_Name;
	}
	public void setWorkType_Name(String workType_Name) {
		this.workType_Name = workType_Name;
	}
	public String getWorkType_Description() {
		return workType_Description;
	}
	public void setWorkType_Description(String workType_Description) {
		this.workType_Description = workType_Description;
	}
	
		
}
