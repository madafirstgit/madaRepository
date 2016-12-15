package com.hht.utils.print;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;


public class PrintJob {
    
	private PrintTemplete pt;
	public static int wait = 1;
	public static int printing = 2;
	public static int printed = 3;
    int status = wait;
	
	public void print() {
		PrintWriter oStream;
		try {
			oStream = Connection.getConn();
			String p = new String (PrintTemplete.clientPaper());
			oStream.write(p);
			oStream.flush();
			status  = printed;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			status = printing;
			e.printStackTrace();
		} catch (IOException e) {
			status = printing;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    
	
	public PrintTemplete getPt() {
		return pt;
	}



	public void setPt(PrintTemplete pt) {
		this.pt = pt;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public PrintJob(PrintTemplete pt){
		this.pt = pt;
	}
}
