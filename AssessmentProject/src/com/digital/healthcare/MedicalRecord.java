package com.digital.healthcare;

import java.util.Date;

public class MedicalRecord {

	private String recordId;
	private String daignosis;
	private Date recordDate;
	
	public MedicalRecord(String recordId, String daignosis, Date recordDate) {
		super();
		this.recordId = recordId;
		this.daignosis = daignosis;
		this.recordDate = recordDate;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getDaignosis() {
		return daignosis;
	}
	public void setDaignosis(String daignosis) {
		this.daignosis = daignosis;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	@Override
	public String toString() {
		return "MedicalRecord [recordId=" + recordId + ", daignosis=" + daignosis + ", recordDate=" + recordDate + "]";
	}
	
	
	
}
