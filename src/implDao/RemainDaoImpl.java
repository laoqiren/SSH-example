package implDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Remain;
import model.RemainPK;
import dao.RemainDao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RemainDaoImpl implements RemainDao{
	// 获取Session
	public Session getSession(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	public Remain query(String number, String date){
		Session session = this.getSession();
		RemainPK rpk = new RemainPK();
		rpk.setNumber(number);
		rpk.setDate(date);
		
		Remain remain = (Remain)session.get(Remain.class, rpk);
		return remain;
	}
	public void add(Remain remain){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.save(remain);
		tran.commit();
		session.close();
	}
	public void update(Remain remain){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.update(remain);
		tran.commit();
		session.close();
	}
	public void bookOne(String number, String date, String type){
		Remain remain = this.query(number, date);
		switch(type){
			case "seatOne":
				remain.setSeatOne(remain.getSeatOne() - 1);
				break;
			case "seatTwo":
				remain.setSeatTwo(remain.getSeatTwo() - 1);
				break;
			/*
			 * 由于没有订票功能，省略
			 */
			default:
				//
		}
	}
}
