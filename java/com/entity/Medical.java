package com.entity;

public class Medical {
	
	private int id;
	
	private String diseasename;
	private String symptomname;
	private String medicineName;
	private int quantity;
	private int costMedicine;
	private String available;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiseasename() {
		return diseasename;
	}
	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCostMedicine() {
		return costMedicine;
	}
	public void setCostMedicine(int costMedicine) {
		this.costMedicine = costMedicine;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	public String getSymptomname() {
		return symptomname;
	}
	public void setSymptomname(String symptomname) {
		this.symptomname = symptomname;
	}
	@Override
	public String toString() {
		return "Medical [id=" + id + ", diseasename=" + diseasename + ", symptomname=" + symptomname + ", medicineName="
				+ medicineName + ", quantity=" + quantity + ", costMedicine=" + costMedicine + ", available="
				+ available + "]";
	}

	
	
	

}
