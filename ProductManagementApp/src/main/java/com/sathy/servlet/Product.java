package com.sathy.servlet;

import java.util.Date;

public class Product {
	private String proId;
	private String proName;
	private double proPrice;
	private String proBrand;
	private String ProMadeIn;
	private Date ProManfDate;
	private Date ProExpDate;
	private byte[] proImage;
	private byte[] proAudio;
	private byte[] proVideo;
	public byte[] getProAudio() {
		return proAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.proAudio = proAudio;
	}
	public byte[] getProVideo() {
		return proVideo;
	}
	public void setProVideo(byte[] proVideo) {
		this.proVideo = proVideo;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double updateproPrice) {
		this.proPrice = updateproPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProMadeIn() {
		return ProMadeIn;
	}
	public void setProMadeIn(String proMadeIn) {
		ProMadeIn = proMadeIn;
	}
	public Date getProManfDate() {
		return ProManfDate;
	}
	public void setProManfDate(Date proManfDate) {
		ProManfDate = proManfDate;
	}
	public Date getProExpDate() {
		return ProExpDate;
	}
	public void setProExpDate(Date proExpDate) {
		ProExpDate = proExpDate;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	
}
