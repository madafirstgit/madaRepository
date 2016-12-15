package com.hht.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mada on 2016/12/7.
 */
public class IDGenerater128 {

    private static String hexStr =  "0123456789ABCDEF";

    private final long twepoch = 1288834974657L;
    // 机器标识位数
    private final long workerIdBits = 28L;
    // 数据中心标识位数
    private final long datacenterIdBits = 24L;
    // 机器ID最大值
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 数据中心ID最大值
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 毫秒内自增位
    private final long sequenceBits = 12L;
    // 机器ID偏左移12位
    private final long workerIdShift = sequenceBits;
    // 数据中心ID左移40位
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间毫秒左移26位
    private final long timestampLeftShift = 26;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public IDGenerater128() {
            // 用IP地址初始化 workerId datacenterId;
            workerId = getMACAddress();
            datacenterId = getThreadId();
            if (workerId > maxWorkerId || workerId < 0) {
                throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
            }
            if (datacenterId > maxDatacenterId || datacenterId < 0) {
                throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
            }
            this.workerId = workerId;
            this.datacenterId = datacenterId;
    }

    public synchronized String nextId() {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            //当前毫秒内，则+1
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 当前毫秒内计数满了，则等待下一秒
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;
        System.out.println(Long.toBinaryString(timestamp));
        System.out.println(Long.toBinaryString(timestamp - twepoch));
        System.out.println(Long.toBinaryString(timestamp - twepoch).length());
        System.out.println(Long.toBinaryString((timestamp - twepoch) << timestampLeftShift));
        System.out.println(Long.toBinaryString((timestamp - twepoch) << timestampLeftShift).length());

        System.out.println(Long.toBinaryString(datacenterId));
        System.out.println(Long.toBinaryString(datacenterId).length());
        System.out.println(Long.toBinaryString(datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())));
        System.out.println(Long.toBinaryString(datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())).length());

        System.out.println(Long.toBinaryString(workerId));
        System.out.println(Long.toBinaryString(workerId).length());
        System.out.println(Long.toBinaryString(workerId << workerIdShift));
        System.out.println(Long.toBinaryString(workerId << workerIdShift).length());

        System.out.println(Long.toBinaryString(sequence));
        System.out.println(Long.toBinaryString(sequence).length());
        System.out.println(Long.toBinaryString(((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())) | (workerId << workerIdShift) | sequence));
        System.out.println(Long.toBinaryString(((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())) | (workerId << workerIdShift) | sequence).length());



        System.out.println(Long.toBinaryString((datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())) | (workerId << workerIdShift) | sequence));
        System.out.println(Long.toBinaryString((datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())) | (workerId << workerIdShift) | sequence).length());

        System.out.println(Long.toBinaryString((timestamp - twepoch) << timestampLeftShift));
        System.out.println(Long.toBinaryString((timestamp - twepoch) << timestampLeftShift).length());

        // ID偏移组合生成最终的ID，并返回ID
        return getResult(Long.toBinaryString(((timestamp - twepoch) << timestampLeftShift)) +Long.toBinaryString((datacenterId << datacenterIdShift+(datacenterIdBits-Long.toBinaryString(datacenterId).length())) | (workerId << workerIdShift) | sequence));
    }

    // 等待下一个毫秒的到来
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    // 获取MAC地址
    private  long getMACAddress(){
        // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        try {
            InetAddress localhost= InetAddress.getLocalHost();
            byte[] mac = NetworkInterface.getByInetAddress(localhost).getHardwareAddress();
            long macSum=0l;
            for(int i=0;i<mac.length;i++){
                //mac[i] & 0xFF 是为了把byte转化为正整数
                macSum += (mac[i] & 0xFF);
            }
            return macSum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 获取ip地址
//    public String getIpAddr() {
//        return localhost.getHostAddress();
//    }
    // 获取当前线程ID
    private  long getThreadId() {
        return Thread.currentThread().getId();
    }

    private String getResult(String ResultBinary){
        String str1="";
        char arr[]=new char[ResultBinary.length()/4];
        for(int i=0;i<ResultBinary.length();i++){
            str1+=ResultBinary.charAt(i);
            if((i+1)%4==0){
                arr[i/4]=bin2HexStr(str1);
                str1="";
            }
        }
        return String.valueOf(arr);
    }


    private char bin2HexStr(String str){
        int sum = Integer.parseInt(str.charAt(0)+"")*8+Integer.parseInt(str.charAt(1)+"")*4+Integer.parseInt(str.charAt(2)+"")*2+Integer.parseInt(str.charAt(3)+"")*1;
        return hexStr.charAt(sum);
    }
    // 转换为二进制字符串

    public static void main(String[] args) {

            System.out.println(System.nanoTime());
            System.out.println(System.currentTimeMillis());

//        IDGenerater128 IDGenerater128 = new IDGenerater128();
//        for (int i = 0; i < 1; i++) {
//            String id = IDGenerater128.nextId();
//            System.out.println(id);
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(System.currentTimeMillis());
//            System.out.println(System.currentTimeMillis());
//            System.out.println(System.currentTimeMillis());
//            System.out.println(System.currentTimeMillis());
//        }

//        Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssSSS");
//        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));   // 时间戳转换成时间
//        System.out.println(sd);
//        System.out.println(Long.toBinaryString(-1L));
//        System.out.println(Long.toBinaryString(255l));
//        System.out.println(Long.toBinaryString(255l).length());
//        System.out.println(-1L << 15L);
//        System.out.println(-1L ^ (-1L << 15L));
//        System.out.println(Long.toBinaryString(System.currentTimeMillis()).length());
//        System.out.println(Long.toBinaryString(System.currentTimeMillis()));
//        System.out.println(Long.toBinaryString(System.currentTimeMillis()<< 40));
//        System.out.println(Long.toBinaryString((System.currentTimeMillis()<< 40)).length());

//        System.out.println(Long.toBinaryString(System.currentTimeMillis()<< 3).length());
//        System.out.println(Long.toBinaryString(806694681244475400l).length());

//        try {
//            InetAddress localhost= InetAddress.getLocalHost();
//            //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
//            byte[] mac = NetworkInterface.getByInetAddress(localhost).getHardwareAddress();
//
//            //下面代码是把mac地址拼装成String
//            StringBuffer sb = new StringBuffer();
//            Long macSum=0l;
//            for(int i=0;i<mac.length;i++){
////                if(i!=0){
////                    sb.append("-");
////                }
//                //mac[i] & 0xFF 是为了把byte转化为正整数
//                macSum += (mac[i] & 0xFF);
//                //String s = Integer.toHexString(mac[i] & 0xFF);
//            }
//
//            //把字符串所有小写字母改为大写成为正规的mac地址并返回
//            System.out.println(sb.toString());
//            System.out.println(Long.toBinaryString(Long.parseLong(sb.toString())));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
