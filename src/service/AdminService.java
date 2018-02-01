package service;

import java.util.ArrayList;
public interface AdminService {
	public boolean login(String adminName, String adminPwd);
	public ArrayList queryStations();
	public ArrayList queryTrains();
	public boolean addStation(int stationId,String stationName);
	public boolean addTrain(String number,String startId,String endId,String center,int time);
	public boolean deleteStation(int stationId);
	public boolean deleteTrain(String number);
	public boolean updateStation(int stationId,String stationName);
}
