package filter;

import java.util.Map;

import javax.servlet.http.Cookie;  

import com.opensymphony.xwork2.Action;  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;

/**
 * 管理员相关的action或API需要经过拦截层进行权限认证
 * @author laoqiren
 *
 */
public class AdminLogin extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();    
		
        Map session = ctx.getSession();  
        
        // 如果已经登陆则直接放行
        if (session != null && session.get("admin_session") != null){  
            return invocation.invoke();  
        }  
        HttpServletRequest req = ServletActionContext.getRequest();
        
       
        String path = req.getRequestURI();  //获取请求URL
        System.out.println("path:" + path);   
        session.put("prePage", path);    // 将来源页暂时存入session，以方便登陆成功后跳转回去
        
        // 没有登陆，跳转到登陆页面
		return Action.LOGIN;
	}
}
