package com.test;

public class Test {
	public static void main(String[] args) {
		/*int x = test();
		System.out.println("main === "+x);*/
		testRenMinBi(12345);
		
	}
	
	public static int test(){
		int x=1;
		try{
			return x;
		}finally{
			++x;
			System.out.println("==== " + x);
		}
	}
	
	public static void testRenMinBi(int money){
		char[] data = new char[]{
				'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
			}; 
		
		char[] units = new char[]{
				'元','拾','佰','仟','万','拾','佰','仟','亿'
			};

		StringBuffer sbf = new StringBuffer();
		int unit = 0;
		while(money!=0){
			sbf.insert(0,units[unit++]);
			int number = money%10;
			sbf.insert(0, data[number]);
			money /= 10;
		}
		
		System.out.println(sbf.toString());
	}
}
