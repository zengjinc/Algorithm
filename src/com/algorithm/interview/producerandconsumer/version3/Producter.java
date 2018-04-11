package com.algorithm.interview.producerandconsumer.version3;

import java.util.List;
import java.util.Random;

public class Producter implements Runnable {
	private List<PCData> queue;
	private int len;

	public Producter(List<PCData> queue, int len) {
		this.queue = queue;
		this.len = len;
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (Thread.currentThread().isInterrupted())
					break;
				Main.lock.lock();
				if (queue.size() >= len) {
					Main.full.await();
				}else{
					int temp = queue.size() + 1;
					PCData data = new PCData();
					data.setData(temp);
					queue.add(data);
					System.out.println("生产者ID:" + Thread.currentThread().getId() + " 生产了:" + data.getData());
					Main.empty.signalAll();
				}
				Thread.sleep(1000);
				Main.lock.unlock();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
