package implDao;

import dao.AdminDao;
import model.Admin;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminDaoImpl implements AdminDao{
	// 获取Session
	public Session getSession(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	public Admin queryByName(String adminName){
		Session session = this.getSession();
		
		Admin admin = (Admin)session.get(Admin.class,adminName);
		
		return admin;
	}
	public void add(Admin admin){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.save(admin);
		tran.commit();
		session.close();
	}
}
