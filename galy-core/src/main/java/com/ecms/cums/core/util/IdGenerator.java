package com.ecms.cums.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 与snowflake算法区别,返回字符串id,占用更多字节,但直观从id中看出生成时间
 * 生成订单编号
 * @Project concurrency
 * Created by wgy on 16/7/19.
 */
public enum IdGenerator {

    INSTANCE;

    private long workerId;   //用ip地址最后几个字节标示
    private long datacenterId = 0L; //可配置在properties中,启动时加载,此处默认先写成0
    private long sequence = 0L;
    private long workerIdBits = 8L; //节点ID长度
    private long sequenceBits = 12L; //序列号12位
    private long workerIdShift = sequenceBits; //机器节点左移12位
    private long datacenterIdShift = sequenceBits + workerIdBits; //数据中心节点左移14位
    private long sequenceMask = -1L ^ (-1L << sequenceBits); //4095
    private long lastTimestamp = -1L;

    IdGenerator(){
        workerId = 0x000000FF & getLastIP();
    }


    public synchronized String nextId() {
        long timestamp = timeGen(); //获取当前毫秒数
        //如果服务器时间有问题(时钟后退) 报错。
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果上次生成时间和当前时间相同,在同一毫秒内
        if (lastTimestamp == timestamp) {
            //sequence自增，因为sequence只有12bit，所以和sequenceMask相与一下，去掉高位
            sequence = (sequence + 1) & sequenceMask;
            //判断是否溢出,也就是每毫秒内超过4095，当为4096时，与sequenceMask相与，sequence就等于0
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp); //自旋等待到下一毫秒
            }
        } else {
            sequence = 0L; //如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加
        }
        lastTimestamp = timestamp;


        long suffix = (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;

        String datePrefix = DateFormatUtils.format(timestamp, "yyyyMMddHHMMssSSS");

        return datePrefix + suffix;
    }

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

    private byte getLastIP(){
        byte lastip = 0;
        try{
            InetAddress ip = InetAddress.getLocalHost();
            byte[] ipByte = ip.getAddress();
            lastip = ipByte[ipByte.length - 1];
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return lastip;
    }

    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    public static String getRandomFileName() {
	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	   Date date = new Date();
	   String str = simpleDateFormat.format(date);
	   Random random = new Random();
	   int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
	   return str+rannum;// 当前时间
    }



    private static long[] ls = new long[3000];
    private static int li = 0;
    public synchronized static long getPK()
    {
        long lo = getpk();
        for (int i = 0; i < 3000; i++)
        {
            long lt = ls[i];
            if (lt == lo)
            {
                lo = getPK();
                break;
            }
        }
        ls[li] = lo;
        li++;
        if (li == 3000)
        {
            li = 0;
        }
        return lo;
    }

    private static long getpk()
    {
        String a = (String.valueOf(System.currentTimeMillis())).substring(3, 13);
        String d = (String.valueOf(Math.random())).substring(2, 8);
        return Long.parseLong(a + d);
    }

    public static void main(String[] args) {
    	final IdGenerator idg = IdGenerator.INSTANCE;
    	for(int i=1;i<10;i++){
    		 String id= idg.nextId();
        	 System.out.println(id);
    	}
    	 System.out.println(getOrderIdByUUId());
    	 System.out.println(getRandomFileName());
    	 System.out.println(getPK());
	}
}