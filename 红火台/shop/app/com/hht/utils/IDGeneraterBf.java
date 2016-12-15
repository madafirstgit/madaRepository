package com.hht.utils;

/**
 * Created by mada on 2016/12/7.
 */
public class IDGeneraterBf {

    private final long twepoch = 1288834974657L;
    // 机器标识位数
    private final long workerIdBits = 5L;
    // 数据中心标识位数
    private final long datacenterIdBits = 5L;
    // 机器ID最大值
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 数据中心ID最大值
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 毫秒内自增位
    private final long sequenceBits = 12L;
    // 机器ID偏左移12位
    private final long workerIdShift = sequenceBits;
    // 数据中心ID左移17位
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间毫秒左移22位
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public IDGeneraterBf(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
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
        System.out.println(Long.toBinaryString(timestamp - twepoch));
        System.out.println(Long.toBinaryString(timestamp - twepoch).length());
        System.out.println(Long.toBinaryString((timestamp - twepoch) << timestampLeftShift));
        System.out.println(Long.toBinaryString((timestamp - twepoch) << timestampLeftShift).length());

        System.out.println(Long.toBinaryString(datacenterId));
        System.out.println(Long.toBinaryString(datacenterId).length());
        System.out.println(Long.toBinaryString(datacenterId << datacenterIdShift));
        System.out.println(Long.toBinaryString(datacenterId << datacenterIdShift).length());

        System.out.println(Long.toBinaryString(workerId));
        System.out.println(Long.toBinaryString(workerId).length());
        System.out.println(Long.toBinaryString(workerId << workerIdShift));
        System.out.println(Long.toBinaryString(workerId << workerIdShift).length());
        System.out.println(Long.toBinaryString(sequence));
        System.out.println(Long.toBinaryString(sequence).length());
        System.out.println(Long.toBinaryString(((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence));
        System.out.println(Long.toBinaryString(((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence).length());

        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
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

    public static void main(String[] args) {
//        IDGenerater1version IDGenerater1version = new IDGenerater1version(2, 3);
//        for (int i = 0; i < 1; i++) {
//            long id = IDGenerater1version.nextId();
//            System.out.println(id);
//        }
//        System.out.println(Long.toBinaryString(-1L));
//        System.out.println(-1L << 15L);
//        System.out.println(-1L ^ (-1L << 15L));

    }
}
