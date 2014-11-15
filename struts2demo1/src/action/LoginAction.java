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

	
	
	
	
	 

}
