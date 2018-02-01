package service;

import java.util.ArrayList;

public interface QueryService {
	public ArrayList query(String startStation,String endStation,String date);
	public ArrayList queryPro(String startStation, String centerStation,String endStation, String date,String condition);
}
