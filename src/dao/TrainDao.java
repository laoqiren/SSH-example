package dao;

import java.util.List;

import java.util.ArrayList;

import model.Train;
import model.Station;
/**
 * 与列车相关的数据库方法
 * @author laoqiren
 *
 */
public interface TrainDao {
	public void add(Train train);
	public ArrayList list();
	public Train query(String number);
	public List queryByStartEnd(Station startStation,Station endStation);
	public void delete(Train train);
	public List queryPro(Station startStation,Station centerStation,Station endStation);
}
