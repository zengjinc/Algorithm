package com.algorithm.interview.producerandconsumer.version1;

import java.util.List;

public class Producer implements Runnable {

	Product product;

	Producer(Product product) {
		this.product = product;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (Thread.currentThread().isInterrupted())
					break;
				synchronized (product) {
					if (product.queue.size() < product.capacity) {
						System.out.println("线程 " + Thread.currentThread().getId() + " 生产了产品 ：" + product.addProduct());
						product.notifyAll();
						Thread.sleep(1000);
					} else {
						product.wait();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
