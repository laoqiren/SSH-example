package implDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Station;
import model.Train;
import dao.TrainDao;

public class TrainDaoImpl implements TrainDao {
	// 获取Session
	public Session getSession(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	public void add(Train train){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.save(train);
		tran.commit();
		session.close();
	}
	public ArrayList list(){
		Session session = this.getSession();
		String hql = "from Train";
		Query query = session.createQuery(hql);
		ArrayList trains = new ArrayList();
		List list = query.list();
		for(int i=0; i<list.size();i++){
			Train train = (Train)list.get(i);
			trains.add(train);
		}
		session.close();
		return trains;
	}
	public Train query(String number){
		Session session = this.getSession();
		
		Train train = (Train)session.get(Train.class,number);
		
		return train;
	}
	public List queryByStartEnd(Station startStation,Station endStation){
		int startId = startStation.getStationId();
		int endId = endStation.getStationId();
		
		Session session = this.getSession();
		
		String hql = "from Train as train where train.startId=:startId and train.endId=:endId";
		Query query = session.createQuery(hql);
		query.setInteger("startId", startId);
		query.setInteger("endId",endId);
		List<Train> results = query.list();
		
		return results;
	}
	public List queryPro(Station startStation,Station centerStation,Station endStation){
		int startId = startStation.getStationId();
		int centerId = centerStation.getStationId();
		int endId = endStation.getStationId();
		
		Session session = this.getSession();
		
		String hql = "from Train as train where train.startId=:startId and train.endId=:centerId";
		Query query = session.createQuery(hql);
		query.setInteger("startId", startId);
		query.setInteger("centerId",centerId);
		List<Train> results1 = query.list();
		
		String hql2 = "from Train as train where train.startId=:centerId and train.endId=:endId";
		Query query2 = session.createQuery(hql2);
		query2.setInteger("centerId", centerId);
		query2.setInteger("endId",endId);
		List<Train> results2 = query2.list();
		
		List results = null;
		results.add(results1);
		results.add(results2);
		return results;
	}
	public void delete(Train train){
		Session session = this.getSession();
		Transaction tran = session.beginTransaction();
		session.delete(train);
		tran.commit();
		session.close();
	}
}
