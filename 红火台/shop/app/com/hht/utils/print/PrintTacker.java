package com.hht.utils.print;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.UnknownHostException;


public class PrintTacker extends Thread {
	public static PrintTacker printTacker = null;
	public MyQueue queue = null;
	public PrintJob po = null;





	private PrintTacker(MyQueue queue){
		this.queue = queue;
	}
	public static PrintTacker getInstance(MyQueue queue){
		if(printTacker==null){
			printTacker = new PrintTacker(queue);
		}
		return printTacker;
	}
	/**
	 * 针对一个打印对象三种情况：
	 * 1.已经发送打印，打印机打印成功，queue删除成功，抛异常，该对象还存在队列，应该继续打印(如下代码，该种情况会重复打印)
	 * 2.已经发送打印，打印机没有打印成功，queue删除成功，抛异常，该对象被队列删除，应把对象重新加入队列，打印
	 * 3.已经发送打印，打印机没有打印成功，queue没有删除成功，抛异常，应该继续打印
	 */
	public void run(){
		Object o = null;
		while(!queue.QueueEmpty()){
			try {
				queue.QueueLength();
//		    Connection.clientStart();
//		    //PrintTemplete.clientPaper();
//		    BufferedInputStream bis1 = new BufferedInputStream(Connection.getInputStream());
//		    OutputStream op = Connection.getOutputStream();
//		    op.write(new byte[]{0x10, 0x04, 0x03});
//			op.flush();
//			BufferedReader bf1 = new BufferedReader(new InputStreamReader(bis1));
//			System.out.println(Integer.toBinaryString(bf1.read()));
//			
//			PrintWriter oStream = Connection.getConn();
				o = queue.QueuePeek();
				po = (PrintJob)o;
//			String p = new String (((PrintJob)o).pt.clientPaper());
//			BufferedInputStream bis = new BufferedInputStream(Connection.getInputStream());
//			OutputStream op = Connection.getOutputStream();
//			oStream.write(p);
//			oStream.flush();
//			op.write(new byte[]{0x10, 0x04, 0x04});
//			op.flush();
				po.print();
				//((PrintJob)o).setStatus(PrintJob.printed);
//			BufferedReader bf = new BufferedReader(new InputStreamReader(bis));
//			System.out.println(Integer.toBinaryString(bf.read()));
				Thread.sleep(1000);
				if(po.status==3)
					queue.deQueue();
				if(po.status==2||po.status==1){
					if(o!=null&&!queue.exist(o)){
						queue.enQueue(po);
					}
				}
				//throw new IOException();
			}catch (InterruptedException e) {
				if(po.status==2||po.status==1){
					if(o!=null&&!queue.exist(o)){
						queue.enQueue(po);
					}
				}
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
