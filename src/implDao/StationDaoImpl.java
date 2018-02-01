package implDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import dao.StationDao;
import model.Station;

public class StationDaoImpl implements StationDao{
	// 获取Session
	public Session getSession(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	public void add(Station station){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.save(station);
		tran.commit();
		session.close();
	}
	public void update(Station station){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.update(station);
		tran.commit();
		session.close();
	}
	public ArrayList list(){
		Session session = this.getSession();
		String hql = "from Station";
		Query query = session.createQuery(hql);
		ArrayList stations = new ArrayList();
		List list = query.list();
		for(int i=0; i<list.size();i++){
			Station station = (Station)list.get(i);
			stations.add(station);
		}
		session.close();
		return stations;
	}
	public Station query(int stationId){
		Session session = this.getSession();
		
		Station station = (Station)session.get(Station.class,stationId);
		
		return station;
	}
	public Station queryByName(String stationName){
		Session session = this.getSession();
		List results = session.createCriteria(Station.class)
				.add(Restrictions.eq("stationName",new String(stationName)))
				.list();
		if(results.size()!=0){
			return (Station) results.get(0);
		}
		return null;
	}
	public void delete(Station station){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.delete(station);
		tran.commit();
		session.close();
	}
}
