package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestRand {
	public static void main(String[] args) {
		/*System.out.println((int)(Math.random()*100));
		System.out.println((int)(Math.random()*100));
		String url = "http://www.onelife88.com/index.php/ad/api/test_callback?source=test";
        System.out.println(URLEncoder.encode(url));*/
//		byte[] result = int2ByteArray(10);
//		byte[] result = int2byte(2);
//		for(byte i : result){
//			System.out.println(i);
//		}
		
		try {
			System.out.println(getCurrentAgeByBirthdate("1991-11-11"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 高端模式        .<br>
	 * 低位字节放在高位地址上，高位字节放到地位地址上
	 *
	 * @param res
	 * @return  byte[]
	 */
	public static byte[] int2ByteArray(int i){
		byte []result = new byte[4];
		result[0] = (byte)((i>>24) & 0xFF);
		result[1] = (byte)((i>>16) & 0xFF);
		result[2] = (byte)((i>>8) & 0xFF);
		result[3] = (byte)(i & 0xFF);
		return result;
	}
	
	/**
	 * 
	 * 低端模式          .<br>
	 *
	 * @param res
	 * @return  byte[]
	 */
	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[0] = (byte) (res & 0xff);// 最低位
		targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
		targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
		targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
		return targets;
	}
	
	public static int getCurrentAgeByBirthdate(String brithday)
			throws ParseException, Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			String currentTime = formatDate.format(calendar.getTime());
			Date today = formatDate.parse(currentTime);
			Date brithDay = formatDate.parse(brithday);

			return today.getYear() - brithDay.getYear();
		} catch (Exception e) {
			return 0;
		}
	}
}
