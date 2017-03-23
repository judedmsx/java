package com.thread.custom;

import java.util.Date;
import java.util.concurrent.Callable;

import com.thread.SleepUtils;

public class SleepTwoSecondsTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		SleepUtils.second(2);
		return new Date().toString();
	}

}
