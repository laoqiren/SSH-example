package model;

import model.Station;
public class Train {
	private String number;
	private Station startId;
	private Station endId;
	private String center;
	private int time;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Station getStartId() {
		return startId;
	}
	public void setStartId(Station startId) {
		this.startId = startId;
	}
	public Station getEndId() {
		return endId;
	}
	public void setEndId(Station endId) {
		this.endId = endId;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
