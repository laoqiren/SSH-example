package implService;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StationDao;
import dao.TrainDao;
import model.Station;

import java.util.List;

/**
 * 查票有关的service具体实现
 * @author laoqiren
 *
 */
public class QueryServiceImpl {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	StationDao stationDao = (StationDao)context.getBean("stationDao");
	TrainDao trainDao = (TrainDao)context.getBean("trainDao");
	
	public List query(String startStation,String endStation,String date){
		/**
		 * 先根据用户输入的起始站点名和终点站名获取到站点
		 */
		Station start = stationDao.queryByName(startStation);
		Station end = stationDao.queryByName(endStation);
		
		List trains;
		try{
			trains = trainDao.queryByStartEnd(start, end);
		} catch(Exception e){
			return null;
		}
		
		return trains;
	}
	public List queryPro(String startStation, String centerStation,String endStation, String date,String condition){
		Station start = stationDao.queryByName(startStation);
		Station center = stationDao.queryByName(centerStation);
		Station end = stationDao.queryByName(endStation);
		List trains;
		try{
			trains = trainDao.queryPro(start, center, end);
		} catch(Exception e){
			return null;
		}
		System.out.println(trains.size());
		//System.out.println(trains.get(1).get(0).getStationName());
		return trains;
	}
}
