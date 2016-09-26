package com.effective;

import java.util.Date;

public final class Period {
	private final Date start;
	private final Date end;
	
	/**
	 * �����Կ������ڼ���������Ч��֮ǰ���У�������Ч�Լ������Կ���֮��Ķ��󣬶��������ԭʼ�Ķ���
	 * @param start
	 * @param end
	 */
	public Period(Date start,Date end){
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if(this.start.compareTo(this.end)>0)
			throw new IllegalArgumentException(start+" after "+end);
		
		/*if(start.compareTo(end)>0)
			throw new IllegalArgumentException(start+" after "+end);
		this.start = start;
		this.end = end;*/
	}

	public Date getStart() {
//		return start;
		return new Date(start.getTime());
	}

	public Date getEnd() {
//		return end;
		return new Date(end.getTime());
	}
	
	public static void main(String[] args) {
		try {
			Date start = new Date();
			Thread.sleep(1000L);
			Date end = new Date();
			Period p = new Period(start, end);
//			Period p = new Period(end, start);
			end.setYear(78);
			System.out.println(p.getEnd().getYear());
			
			p.getEnd().setYear(78);
			System.out.println(p.getEnd().getYear());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
