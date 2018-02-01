package dao;
import model.Admin;

/**
 * 与管理员有关的数据库方法
 * @author laoqiren
 *
 */
public interface AdminDao {
	public Admin queryByName(String adminName);
	public void add(Admin admin);
}