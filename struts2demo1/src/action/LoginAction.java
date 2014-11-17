package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action{
	
	private User user;
	
	private String message;
	
	private String role;
	
	
	
	
	
	
	
	

	
	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public String execute() throws Exception{
		
		System.out.println("execute Method invoked");
		
		
		if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
			
			//通过解耦 不是直接操作HttpServletSession (Map)
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("USER", user);
			
			Map<String,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
			request.put("USERNAME", user.getUsername());
			
			Map<String,Object> application=ActionContext.getContext().getApplication();
			
			application.put("PASSWORD", user.getPassword());
			
			//耦合方式存储对象
			HttpServletRequest servletRequest=ServletActionContext.getRequest();
			servletRequest.setAttribute("USERNAME2", user.getUsername());
			
			HttpSession httpsession=ServletActionContext.getRequest().getSession();
			httpsession.setAttribute("USER2", user);
			
			
			
			
			
			return SUCCESS;
			
			
		}else{
			this.message="用户名或者密码错误";
			
			return INPUT;
		}
		
		
		
		
	}

	
	public String test() throws Exception{
		System.out.println("testMethod invoked");
		
		return INPUT;
	}
	
	
	public String adminLogin() throws Exception{
		System.out.println("adminLogin method invoked");
		
		return SUCCESS;
		
		
		
		
	}
	
	public String genricLogin() throws Exception{
		System.out.println("gerlicLogin method invoked");
		
		return SUCCESS;
	}
	
	public String dynamic() throws Exception{
		
		if("admin".equals(user.getUsername())){
			
			this.role="ADMIN";
		}else{
			this.role="USER";
			
			
		}
		return SUCCESS;
		
		
		
		
		
		
		
	}
	
	 

}
