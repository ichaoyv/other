package action;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DowloadAction extends ActionSupport {
	//读取下载文件的目录
	private String inputPath;
	//下载文件的文件名
	private String fileName;
	//读取下载文件的输入流
	private InputStream inputStream;
	
	
	
	
	

	 public String getInputPath() {
		return inputPath;
	}






	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}






	public String getFileName() {
		return fileName;
	}






	public void setFileName(String fileName) {
		this.fileName = fileName;
	}






	public InputStream getInputStream() {
		//从下载里面获取指定的文件名  upload /123.jpg
		String path=ServletActionContext.getServletContext().getRealPath(inputPath);
		
		String loaction=path+"/"+fileName;
		BufferedInputStream bis=null;
		
		try {
			FileInputStream fis=new FileInputStream(loaction);
			 bis=new BufferedInputStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bis;
	}






	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}






	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
