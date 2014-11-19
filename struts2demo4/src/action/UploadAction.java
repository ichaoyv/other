package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private File upload;
	
	//获取提交的文件类型
	private String uploadContentType;
	//封装上传文件名称
	private String uploadFileName;
	//获取文件上传的路径 upload文件夹
	private String savePath;
	
	
	@Override
	public String execute() throws Exception {
		//空杯子
		byte[] buff=new  byte[1000];
		//文件保存文件
		String path=ServletActionContext.getServletContext().getRealPath(savePath);
		System.out.println(path);
		
		String loaction=path+"/"+uploadFileName;
		//空瓶子
		FileOutputStream fos=new FileOutputStream(loaction);
		
		
		//循环读取文件，并且写入到fos
		//大可乐瓶子
		FileInputStream fis=new FileInputStream(upload);
		
		int lenght=fis.read(buff);
		
		while(lenght>0){
			fos.write(buff, 0, lenght);
			lenght=fis.read(buff);
			
		}
		
		//关闭资源
		fis.close();
		fos.close();
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
