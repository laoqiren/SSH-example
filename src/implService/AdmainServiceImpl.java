package implService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.*;
import model.Admin;
import model.Station;
import model.Train;

import java.util.ArrayList;

public class AdmainServiceImpl {
	/**
	 * 利用Spring控制反转
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	AdminDao adminDao = (AdminDao)context.getBean("adminDao");
	StationDao stationDao = (StationDao)context.getBean("stationDao");
	TrainDao trainDao = (TrainDao)context.getBean("trainDao");
	
	/**
	 * 处理管理员登陆
	 * @param adminName
	 * @param adminPwd
	 * @return boolean
	 */
	public boolean login(String adminName, String adminPwd){
		Admin queriedAdmin;
		
		try {
			queriedAdmin = adminDao.queryByName(adminName);
		} catch(Exception e){
			return false;
		}
		if(queriedAdmin!=null){
			System.out.println("查询到的用户:" + queriedAdmin.getAdminName() + "密码：" + queriedAdmin.getAdminPwd());
			return queriedAdmin.getAdminPwd().equals(adminPwd) ? true: false;
		}
		return false;
	}
	/**
	 * 管理员查询所有站点信息
	 * @return ArrayList
	 */
	public ArrayList queryStations(){
		ArrayList result;
		try {
			result = stationDao.list();
		} catch(Exception e){
			result = null;
		}
		return result;
	}
	/**
	 * 管理员查询所有列车信息
	 * @return ArrayList
	 */
	public ArrayList queryTrains(){
		ArrayList result;
		try {
			result = trainDao.list();
		} catch(Exception e){
			result = null;
		}
		return result;
	}
	/**
	 * 管理员查询所有站点信息
	 * @param stationId
	 * @param stationName
	 * @return boolean
	 */
	public boolean addStation(int stationId,String stationName){
		
		Station newStation = new Station();
		newStation.setStationId(stationId);
		newStation.setStationName(stationName);
		try {
			stationDao.add(newStation);
		} catch(Exception e){
			return false;
		}
		
		return true;
	}
	/**
	 * 管理员添加列车
	 * @param number
	 * @param startId
	 * @param endId
	 * @param center
	 * @param time
	 * @return boolean
	 */
	public boolean addTrain(String number,String startId,String endId,String center,int time){
		
		Train newTrain = new Train();
		Station startStation = stationDao.queryByName(startId);
		Station endStation = stationDao.queryByName(endId);
		
		newTrain.setNumber(number);
		newTrain.setCenter(center);
		newTrain.setStartId(startStation);
		newTrain.setEndId(endStation);
		newTrain.setTime(time);
		try {
			trainDao.add(newTrain);
		} catch(Exception e){
			return false;
		}
		
		return true;
	}
	/**
	 * 管理员删除站点
	 * @param stationId
	 * @return boolean
	 */
	public boolean deleteStation(int stationId){
		Station station = stationDao.query(stationId);
		try {
			stationDao.delete(station);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * 管理员删除列车
	 * @param number
	 * @return boolean
	 */
	public boolean deleteTrain(String number){
		Train train = trainDao.query(number);
		try {
			trainDao.delete(train);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * 管理员修改站点信息
	 * @param stationId
	 * @param stationName
	 * @return boolean
	 */
	public boolean updateStation(int stationId,String stationName){
		try {
			Station station = stationDao.query(stationId);
			station.setStationName(stationName);
			stationDao.update(station);
		} catch(Exception e){
			return false;
		}
		return true;
	}
}
