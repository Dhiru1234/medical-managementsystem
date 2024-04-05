package com.entity;

public class Medicine {
	private int mid;
	
	private String diseasename;
	private String symtomname;
	private String medicineName;
	private int quantity;
	private String schedule;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getDiseasename() {
		return diseasename;
	}
	public void setDiseasename(String diseasename) {
		this.diseasename = diseasename;
	}
	public String getSymtomname() {
		return symtomname;
	}
	public void setSymtomname(String symtomname) {
		this.symtomname = symtomname;
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
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "Medicine [mid=" + mid + ", diseasename=" + diseasename + ", symtomname=" + symtomname
				+ ", medicineName=" + medicineName + ", quantity=" + quantity + ", schedule=" + schedule + "]";
	}
	
}