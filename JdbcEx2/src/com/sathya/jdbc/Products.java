package com.sathya.jdbc;

public class Products {
	Integer proId;
	String proName;
	Float proPrice;
	public Products(Integer proId, String proName, float proPrice) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Float getProPrice() {
		return proPrice;
	}
	public void setProPrice(Float proPrice) {
		this.proPrice = proPrice;
	}
	@Override
	public String toString() {
		return "Products [proId=" + proId + ", proName=" + proName + ", proPrice=" + proPrice + "]";
	}
	public Products() {
		super();
	}
	
}
