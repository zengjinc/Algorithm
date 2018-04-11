package com.algorithm.interview.producerandconsumer.version1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		Product product = new Product(10);
		Thread producer1 = new Thread(new Producer(product));
		Thread producer2 = new Thread(new Producer(product));
		Thread consumer1 = new Thread(new Consumer(product));
		producer1.start();
		producer2.start();
		consumer1.start();
		
//		Producer producer1 = new Producer(product);
//		Producer producer2 = new Producer(product);
//		Consumer consumer = new Consumer(product);
//		 ExecutorService service = Executors.newCachedThreadPool();
//	        service.execute(producer1);
//	        service.execute(producer2);
//	        service.execute(consumer);
	}
}
