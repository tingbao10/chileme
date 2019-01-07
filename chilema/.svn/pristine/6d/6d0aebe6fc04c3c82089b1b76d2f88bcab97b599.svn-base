package com.chilema.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {
	private static final String URL="127.0.0.1";
	private static final int PORT=21;
	private static final String USERNAME="chilema";
	private static final String PASSWORD="123456789";
	public static boolean uploadFile(String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(URL);//连接FTP服务器
			ftp.login(USERNAME, PASSWORD);//登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			success=ftp.storeFile(filename, input); 
			input.close();
			ftp.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	public static InputStream downloadFtpFile(String fileName) {  

		FTPClient ftp = new FTPClient();
		InputStream in=null;
		try {
			int reply;
			ftp.connect(URL);//连接FTP服务器
			ftp.login(USERNAME, PASSWORD);//登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			in=ftp.retrieveFileStream(fileName);
			ftp.logout();  

		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} catch (SocketException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		return in;
	}  
}  
