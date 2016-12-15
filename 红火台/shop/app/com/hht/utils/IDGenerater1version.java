package com.hht.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * Created by mada on 2016/12/7.
 */
public class IDGenerater1version {

    private static String hexStr =  "0123456789ABCDEF";

    private final long twepoch = 1288834974657L;
    // 机器标识位数
    private final long workerIdBits = 14L;
    // 数据中心标识位数
    private final long datacenterIdBits = 14L;
    // 机器ID最大值
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 数据中心ID最大值
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 毫秒内自增位
    private final long sequenceBits = 12L;
    // 机器ID偏左移12位
    private final long workerIdShift = sequenceBits;
    // 数据中心ID左移26位
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间毫秒左移26位
    private final long timestampLeftShift = 26;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public IDGenerater1version() {
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

        // ID偏移组合生成最终的ID，并返回ID
        return getResult(Long.toBinaryString(((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence) +Long.toBinaryString(timeGen()<<23));
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

    // 4位二进制转换为1位16进制
    private char bin2HexStr(String str){
        int sum = Integer.parseInt(str.charAt(0)+"")*8+Integer.parseInt(str.charAt(1)+"")*4+Integer.parseInt(str.charAt(2)+"")*2+Integer.parseInt(str.charAt(3)+"")*1;
        return hexStr.charAt(sum);
    }


    public static void main(String[] args) {
        IDGenerater1version IDGenerater1version128 = new IDGenerater1version();
        IDGenerater1version IDGenerater1version129 = new IDGenerater1version();
        IDGenerater1version IDGenerater1version127 = new IDGenerater1version();
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 1; i++) {
            String id = IDGenerater1version128.nextId();
            System.out.println(id);
//            System.out.println(IDGenerater1version129.nextId());
//            System.out.println(IDGenerater1version127.nextId());
        }
        System.out.println(System.currentTimeMillis());
    }
}
