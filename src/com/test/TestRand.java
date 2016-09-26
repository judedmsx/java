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
	 * �߶�ģʽ        .<br>
	 * ��λ�ֽڷ��ڸ�λ��ַ�ϣ���λ�ֽڷŵ���λ��ַ��
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
	 * �Ͷ�ģʽ          .<br>
	 *
	 * @param res
	 * @return  byte[]
	 */
	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[0] = (byte) (res & 0xff);// ���λ
		targets[1] = (byte) ((res >> 8) & 0xff);// �ε�λ
		targets[2] = (byte) ((res >> 16) & 0xff);// �θ�λ
		targets[3] = (byte) (res >>> 24);// ���λ,�޷������ơ�
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
