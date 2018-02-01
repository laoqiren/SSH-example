package test;

import model.Remain;
import model.RemainPK;
import implDao.RemainDaoImpl;

public class testRemain {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
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

}
