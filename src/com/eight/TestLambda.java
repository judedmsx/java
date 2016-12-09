package com.eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestLambda {
	public static void demo1(){
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"}; 
		List<String> players = Arrays.asList(atp);
		
		players.forEach((player)->System.out.println(player+";"));
	}
	
	public static void main(String[] args) {
		demo1();
	}
}
