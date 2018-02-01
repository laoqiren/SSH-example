package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import java.util.List;

import implService.QueryServiceImpl;

/**
 * 与查票有关的action处理
 * @author laoqiren
 *
 */
public class QueryAction {
	private String startStation;
	private String endStation;
	private String date;
	private String centerStation;
	public String getCenterStation() {
		return centerStation;
	}

	public void setCenterStation(String centerStation) {
		this.centerStation = centerStation;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	private String condition;
	QueryServiceImpl queryService = new QueryServiceImpl();
	
	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 根据用户输入的起始站点和终点站点查询列车信息，并将结果挂载到请求对象上
	 * @return String
	 */
	public String query(){
		List trains = queryService.query(startStation, endStation, date);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("trains", trains);
		return "success";
	}
	/**
	 * 高级查询
	 * @return
	 */
	public String queryPro(){
		List trains = queryService.queryPro(startStation, centerStation,endStation, date,condition);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("trains", trains);
		return "success";
	}
}
