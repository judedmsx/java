package com.md5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;


public class MD5Test {
	public static void main(String[] args) {
		String result = md5Encode();
		System.out.println(result);
	}
	
	public static void test_1(){
		try {
//			String url = "http://www.wanjiadr.com/daren/qj/callback?key=value1&channelId=value2&idfa=value3&mac=value4";
			String param = "sercret=8O3F4ADJ600FQCA6D911G41DC38A4H5Lpartner=ZL999IOSAPI&timestamp=1467772620&uid=13597&msg=2元红包&code=G14695243758131431";
			String sign = MD5Util.textToMD5L32(URLEncoder.encode(param, "UTF-8"));
			System.out.println(sign);//522ec2ac68a2527da775b178a66f309b d6d438863f4f7e9a8663b9f3f1f8ed64
			System.out.println("aaa");
//			String url = "http://localhost/index.php/yungouapi/index/upload_award_info?partner=ZL999IOSAPI&sign=33a92c386f6ad136cb5fd3f41ada2fba&timestamp=1467772620&uid=13597&msg=1元红包&code=G14695243758131431";
//			System.out.println(URLEncoder.encode(url, "UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * md5对url加密生成消息摘要           .<br>
	 * url格式：name=NAME_VALUE&idfa=IDFA_VALUE&source=SOURCE_VALUE
	 * @return  String
	 */
	public static String md5Encode(){
		//treemap对参数进行升序排序
		TreeMap<String, String> map = new TreeMap<String, String>();
		/*map.put("name", "NAME_VALUE");
		map.put("idfa", "IDFA_VALUE");
		map.put("source", "SOURCE_VALUE");*/
		map.put("name", "你好");
		map.put("idfa", "IDFA_VALUE");
		map.put("source", "SOURCE_VALUE");
		
        try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			//拼接参数，格式：key=valuekey=valuekey=value
			StringBuffer params = new StringBuffer();
			for(String key : map.keySet()){
				params.append(key+"=").append(map.get(key));
			}
			//md5加密
			byte[] byteArray = params.toString().getBytes("UTF-8");
	        byte[] md5Bytes = md5.digest(byteArray);
	        //转化16进制 
	        return convertByteToHexString(md5Bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	/**
	 * 
	 * bytes数组转化16进制           .<br>
	 *
	 * @param bytes
	 * @return  String
	 */
	public static String convertByteToHexString(byte[] bytes){
		String result = "";
		for(int i = 0;i < bytes.length;i++){
			int temp = bytes[i] & 0xff;
			String tempHex = Integer.toHexString(temp);
			if(tempHex.length() < 2)
				result += "0"+tempHex;
			else
				result += tempHex;
			
		}
		return result;
	}
}
