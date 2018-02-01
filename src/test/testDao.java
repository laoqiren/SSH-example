package test;

import java.util.ArrayList;

import model.Station;
import model.Train;
import model.Remain;
import model.Admin;
import model.Remain;
import model.RemainPK;
import implDao.StationDaoImpl;
import implDao.TrainDaoImpl;
import implDao.RemainDaoImpl;
import implDao.AdminDaoImpl;

public class testDao {

	public void Train(){
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
	public void Admin(){
		AdminDaoImpl adminDao = new AdminDaoImpl();
		Admin admin = new Admin();
		admin.setAdminName("laoqiren");
		admin.setAdminPwd("abcd");
		
		adminDao.add(admin);
		
		Admin queriedAdmin = adminDao.queryByName("laoqiren");
		System.out.println("管理员：" + queriedAdmin.getAdminName() + " 密码:" + queriedAdmin.getAdminPwd());
	}
	public void Remain(){
		RemainDaoImpl rd = new RemainDaoImpl();
		Remain remain = new Remain();
		RemainPK rpk = new RemainPK();
		
		rpk.setDate("2017-12-25");
		rpk.setNumber("D2222");
		remain.setRpk(rpk);
		remain.setSeatOne(300);
		remain.setSeatTwo(300);
		remain.setMoveLay(300);
		
		rd.add(remain);
		
		Remain info = rd.query("D2222", "2017-12-25");
		System.out.println("车次：" + info.getRpk().getNumber() + " 日期:" + info.getRpk().getDate() + " 一等座：" + info.getSeatOne());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDao test = new testDao();
		test.Admin();
	}

}
