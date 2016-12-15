package com.hht.utils.print;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Zhu Tao on 2016-11-29.
 */
public class Connection {
    public static final String ip = "10.1.22.222";
    public static final int port = 9100;
    private static OutputStream out = null;
    private static InputStream in = null;
    private static Socket s = null;
    private static PrintWriter ps = null;

    private Connection(){}

    public static synchronized PrintWriter getConn() throws UnknownHostException, IOException{
        if(ps==null) {
            clientStart();
        }
        return ps;
    }

    public static synchronized InputStream getInputStream(){
        return in;
    }

    public static synchronized OutputStream getOutputStream(){
        return out;
    }
    public static void clientStart() throws UnknownHostException, IOException{

        s=new Socket(ip,port);

        out=s.getOutputStream();
        in = s.getInputStream();
        ps =  new PrintWriter((new OutputStreamWriter(out,"GBK")),true);



    }
}