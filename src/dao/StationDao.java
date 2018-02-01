package dao;

import java.util.ArrayList;

import model.Station;
/**
 * 与站点相关的数据库方法
 * @author laoqiren
 *
 */
public interface StationDao {
	public void add(Station station);
	public void update(Station station);
	public ArrayList list();
	public Station query(int Station);
	public Station queryByName(String stationName);
	public void delete(Station station);
}
