package com.rest.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {

	//local path
	//public  final String upload_dir="C:\\eclipse\\ResrAPIbook\\src\\main\\resources\\static\\Image";  //double slash compulsory
	
	
	//dynamic path
	public  final String upload_dir=new ClassPathResource("static/Image/").getFile().getAbsolutePath();
	
	public fileUploadHelper()throws IOException{  //default constructor to handle exception
		
	}
	
	
	
	public boolean uploadFile(MultipartFile multipartfile) {
		boolean f =false;
		
		
		try {
			
		
			//method 1
//			InputStream is=multipartfile.getInputStream();
//			byte data[]= new byte[is.available()];
//			
//			is.read(data);
//			
//			//write
//			FileOutputStream fos=new FileOutputStream(upload_dir+"\\"+multipartfile.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			
			
			//method 2
			Files.copy(multipartfile.getInputStream(), Paths.get(upload_dir+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			
			
			f=true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
}
