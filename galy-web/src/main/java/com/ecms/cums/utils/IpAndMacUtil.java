package com.ecms.cums.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class IpAndMacUtil {
	public static String getLocalMac() throws SocketException, UnknownHostException {

		  InetAddress ia = InetAddress.getLocalHost();
		  byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

		  StringBuffer sb = new StringBuffer("");

		  for (int i = 0; i < mac.length; i++) {

		   if (i != 0) {

		    sb.append("-");

		   }

		   // 字节转换为整数
		   int temp = mac[i] & 0xff;

		   String str = Integer.toHexString(temp);

		   if (str.length() == 1) {

		    sb.append("0" + str.toUpperCase());

		   } else {

		    sb.append(str.toUpperCase());

		   }

		  }
		  return sb.toString();
		 }

		 public static String getLocalIp() throws UnknownHostException {

		  return InetAddress.getLocalHost().getHostAddress();

		 }

		 public static void main(String[] args) throws SocketException, UnknownHostException {
			System.out.println(getLocalMac());
			System.out.println(getLocalIp());
		}
}
