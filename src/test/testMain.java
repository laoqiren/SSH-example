package test;

import java.util.ArrayList;

import implDao.StationDaoImpl;
import implDao.TrainDaoImpl;
import model.Station;
import model.Train;
import model.Remain;

public class testMain {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		// 添加Station
		Station stat1 = new Station();
		stat1.setStationName("Hangzhou");
		Station stat2 = new Station();
		stat2.setStationName("Shizhu");
		Train train1 = new Train();
		train1.setNumber("D2222");
		train1.setStartId(stat1);
		train1.setEndId(stat2);
		
		StationDaoImpl stationDao = new StationDaoImpl();
		TrainDaoImpl trainDao = new TrainDaoImpl();
		
		stationDao.add(stat1);
		stationDao.add(stat2);
		trainDao.add(train1);
		
		ArrayList stations = stationDao.list();
		ArrayList trains = trainDao.list();
		
		for(int i=0; i<stations.size(); i++){
			Station station = (Station)stations.get(i);
			System.out.println("id:" + station.getStationId() + " name:" + station.getStationName());
		}
		
	}

}
