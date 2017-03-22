package com.thread.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

import com.thread.SleepUtils;

public class Main {
	public static void main(String[] args) {
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generate(30);
		
		Task task = new Task(products, 0, products.size(), 0.20);
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		
		do{
			System.out.printf("Main : ThreadCount: %d \n",pool.getActiveThreadCount());
			System.out.printf("Main : Thread Steal: %d \n",pool.getStealCount());
			System.out.printf("Main : Parallelism: %d \n",pool.getParallelism());
			
			SleepUtils.second(5);
		}while(!task.isDone());
		
		pool.shutdown();
		
		
		if(task.isCompletedNormally()){
			System.out.printf("Main : The process has completed normally. \n");
		}
		
		for(int i = 0;i < products.size();i++){
			Product product = products.get(i);
			if(product.getPrice() != 12){
				System.out.printf("Product %s : %f \n",product.getName(),product.getPrice());
			}
		}
		
		System.out.println("Main : End of the program . \n");
	}
}
