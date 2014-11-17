package action;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action{
	
	private String name;
	
	
	private String message;


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		System.out.println("setName method invoked");
		this.name = name;
	}
	
	
	
	public String execute() throws Exception{
		
		this.message="Hello World "+this.name;
		return SUCCESS;
		
	}

	
	public String execute2() throws Exception{
		
		this.message="Hello World2 "+this.name;
		
		
		
		return SUCCESS;
		
		
		
		
		
	}
	
	public String find() throws Exception{
		
		return  "fatal";
	}


	
	
	 

}
