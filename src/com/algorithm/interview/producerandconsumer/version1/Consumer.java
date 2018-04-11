package com.algorithm.interview.producerandconsumer.version1;

public class Consumer implements Runnable {
	Product product;

	Consumer(Product product) {
		this.product = product;
	}

	@Override
	public void run() {
		try{
			while (true) {
				synchronized (product) {
					if (product.queue.size() > 0) {
						System.out.println("线程 " + Thread.currentThread().getId() + " 消费了产品 ： " + product.consumeProduct());
						product.notify();
						Thread.sleep(500);
					} else {
						product.wait();
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
