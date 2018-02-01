package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implService.AdmainServiceImpl;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;  
import com.opensymphony.xwork2.ActionContext; 

/**
 * 与管理员有关的Action
 * @author laoqiren
 * 
 */
public class AdminAction {
	private String adminName;
	private String adminPwd;
	private String prePage;	
	
	public String getPrePage() {
		return prePage;
	}
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	private AdmainServiceImpl adminImpl = new AdmainServiceImpl();
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String admin(){
		return "success";
	}
	/**
	 * 处理管理员登陆
	 * @return String
	 */
	public String login(){
		ActionContext ctx = ActionContext.getContext();  
        Map<String, Object> session = ctx.getSession(); 
		System.out.println("登陆账号：" + adminName + " 密码：" + adminPwd);
		
		System.out.println(adminImpl.login(adminName, adminPwd));
		
		// 调用登陆相关service，验证用户名和密码
		if(adminImpl.login(adminName, adminPwd)){
			session.put("admin_session", this.getAdminName());  //如果登陆成功，session中保存管理员账户
			prePage = (String) session.get("prePage");  // 登陆成功后跳转回原来的页面
			session.remove("prePage"); 
			return "success";
		} else {
			return "fail";
		}
	}
	/**
	 * 管理员添加站点API
	 * @return null
	 * @throws IOException
	 */
	public String addStation() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 获取查询字符串参数
		int stationId = Integer.parseInt(request.getParameter("stationId"));
		String stationName = request.getParameter("stationName");
        
		Boolean result = adminImpl.addStation(stationId, stationName);
		
		PrintWriter out = response.getWriter();
		
		if(result){
			out.print("success");
		} else {
			out.print("fail");
		}
		
        out.flush();  
        out.close();
		return  null;
	}
	/**
	 * 管理员添加列车信息API
	 * @return null
	 * @throws IOException
	 */
	public String addTrain() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 获取查询字符串参数
		String number = request.getParameter("number");
		String startId = request.getParameter("startId");
		String endId = request.getParameter("endId");
		String center = request.getParameter("center");
		int time = Integer.parseInt(request.getParameter("time"));
        
		// 调用service层
		Boolean result = adminImpl.addTrain(number, startId, endId, center, time);
		
		PrintWriter out = response.getWriter();
		
		if(result){
			out.print("success");
		} else {
			out.print("fail");
		}
		
        out.flush();  
        out.close();
		return  null;
	}
	/**
	 *  管理员查询所有站点信息action
	 * @return String
	 */
	public String queryStations(){
		ArrayList stations = adminImpl.queryStations();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("stations", stations);
		return "success";
	}
	/**
	 * 管理员查询所有列车信息action
	 * @return String
	 */
	public String queryTrains(){
		ArrayList trains = adminImpl.queryTrains();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("trains", trains);
		return "success";
	}
	/**
	 * 管理员删除站点API
	 * @return null
	 * @throws IOException
	 */
	public String deleteStation() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 获取查询字符串参数
		int stationId = Integer.parseInt(request.getParameter("stationId"));
		Boolean result = adminImpl.deleteStation(stationId);
		
		PrintWriter out = response.getWriter();
		
		if(result){
			out.print("success");
		} else {
			out.print("fail");
		}
		
        out.flush();  
        out.close();
		return  null;
	}
	/**
	 * 管理员删除列车信息API
	 * @return null
	 * @throws IOException
	 */
	public String deleteTrain() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 获取查询字符串参数
		String number = request.getParameter("number");
		Boolean result = adminImpl.deleteTrain(number);
		
		PrintWriter out = response.getWriter();
		
		if(result){
			out.print("success");
		} else {
			out.print("fail");
		}
		
        out.flush();  
        out.close();
		return  null;
	}
	/**
	 * 管理员修改站点信息API
	 * @return null
	 * @throws IOException
	 */
	public String updateStation() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 获取查询字符串参数
		int stationId = Integer.parseInt(request.getParameter("stationId"));
		String stationName = request.getParameter("stationName");
		Boolean result = adminImpl.updateStation(stationId,stationName);
		
		PrintWriter out = response.getWriter();
		
		if(result){
			out.print("success");
		} else {
			out.print("fail");
		}
		
        out.flush();  
        out.close();
		return  null;
	}
}
