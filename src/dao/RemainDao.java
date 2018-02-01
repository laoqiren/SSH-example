package dao;

import model.Remain;
/**
 * 与余票有关的数据库方法
 * @author laoqiren
 *
 */
public interface RemainDao {
	public Remain query(String number, String date);
	public void add(Remain remain);
	public void update(Remain remain);
	public void bookOne(String number, String date, String type); //减少某一趟车某一天某种座位一张票
}