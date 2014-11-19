package interceptor;

import bean.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	
	//计算拦截器经过当前的拦截器的耗费时间
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		long startTime = System.currentTimeMillis();
		System.out.println("执行Action之前的工作，开始时间" + startTime);
		//2、 执行后续拦截器或ACtion 递归调用
//		User user=(User) invocation.getInvocationContext().getSession().get("User");
//		if(null!=user){
//			return "input";
//			
//		}else{
//			
//			
//		}
		String result = invocation.invoke();
		//3、执行Action之后的工作：计算并输出执行时间
		long endTime = System.currentTimeMillis();
		long execTime = endTime - startTime;
		System.out.println("执行Action后的，结束时间" + endTime);
		System.out.println("总共用时" + execTime);
		//返回结果字符串
		return result;
		
		
		
	}

}
