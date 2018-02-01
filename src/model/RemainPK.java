package model;

import java.io.Serializable;

public class RemainPK implements Serializable{
	private String number;
	private String date;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	} 
}
