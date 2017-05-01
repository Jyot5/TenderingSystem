package VO;

import java.io.Serializable;

public class GradeVO implements Serializable {
	private long grade_ID;
	private String grade_Name;
	private String grade_Description;
	public long getGrade_ID() {
		return grade_ID;
	}
	public void setGrade_ID(long grade_ID) {
		this.grade_ID = grade_ID;
	}
	public String getGrade_Name() {
		return grade_Name;
	}
	public void setGrade_Name(String grade_Name) {
		this.grade_Name = grade_Name;
	}
	public String getGrade_Description() {
		return grade_Description;
	}
	public void setGrade_Description(String grade_Description) {
		this.grade_Description = grade_Description;
	}
	
}
