package com.chilema.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class ImgUtil {
	public static String saveImg(MultipartFile file, HttpServletRequest request){
		if(file!=null){
			if (!file.isEmpty()) {
				InputStream in =null;
				OutputStream out=null;
				try {
					String p= (request.getRealPath("/")+"chilemapage/menuImg/").replaceAll("\\\\", "/");
					String filePath = p+file.getOriginalFilename();
					File storeFile = new File(filePath);
					in = file.getInputStream();
					out = new FileOutputStream(storeFile);
					int len = 0;// 读取写入长度
					byte[] b = new byte[1024];
					while ((len = in.read(b)) != -1) {
						out.write(b, 0, len);
					}
					String imgpath=file.getOriginalFilename();
					return imgpath;
				}catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						if(in!=null){
							in.close();
						}
						if(out!=null){
							out.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}
