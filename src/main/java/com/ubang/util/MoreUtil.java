package com.ubang.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class MoreUtil {
	public String savePic(HttpServletRequest request,int helpId) {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
        List<MultipartFile> fileList = multipartRequest.getFiles("image");  
		try {
			String filename = fileList.get(0).getOriginalFilename();
			
			if (filename != null) {
				filename = GeneratFileName.getRandomName() + "." + FilenameUtils.getExtension(filename);
			}
			
			String storeDirectoryTest = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\image\\ubang\\QRCode\\";
			//storeDirectoryTest = "C:\\Users\\huang\\Desktop\\ubang\\";
			
			File file = new File(storeDirectoryTest);
			if (!file.exists()) {
				file.mkdir();
			}
			SaveFileFromInputStream(fileList.get(0).getInputStream(),storeDirectoryTest+filename);
			String storeDirectory1 = "http://119.23.232.90:8080/image/ubang/QRCode/";
			
			return storeDirectory1 + filename;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}
	
	public List<String> saveMultPics(HttpServletRequest request) {
		
		String storeDirectory1 = "http://119.23.232.90:8080/image/ubang/QRCode/";
		List<String> path = new ArrayList<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
        List<MultipartFile> fileList = multipartRequest.getFiles("image");  
		try {
			
			for(MultipartFile files: fileList) {
				String filename = files.getOriginalFilename();
				
				if (filename != null) {
					filename = GeneratFileName.getRandomName() + "." + FilenameUtils.getExtension(filename);
				}
				
				String storeDirectoryTest = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\image\\ubang\\QRCode\\";
				//storeDirectoryTest = "C:\\Users\\huang\\Desktop\\ubang\\";
				File file = new File(storeDirectoryTest);
				if (!file.exists()) {
					file.mkdir();
				}
			
				SaveFileFromInputStream(files.getInputStream(),storeDirectoryTest+filename);
				path.add(storeDirectory1+filename);
			}
			
			return path;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private void SaveFileFromInputStream(InputStream stream ,String filename) throws IOException
	{   
	    FileOutputStream fs=new FileOutputStream(filename);
	    byte[] buffer =new byte[1024*1024];
	    int bytesum = 0;
	    int byteread = 0; 
	    while ((byteread=stream.read(buffer))!=-1)
	    {
	      bytesum+=byteread;
	      fs.write(buffer,0,byteread);
	      fs.flush();
	    } 
	    fs.close();
	    stream.close();   
	}   
	
	public String getTime() {
		java.util.Date date = new java.util.Date();          // 获取一个Date对象
        return new Timestamp(date.getTime()).toLocaleString();
	}
}
