package com.algorithm.interview.producerandconsumer.version3;

import java.util.List;

public class Consumer implements Runnable{
    private List<PCData> queue;
    public Consumer(List<PCData> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
                Main.lock.lock();
                if (queue.size() == 0){
                    Main.empty.await();
                }else{
                	PCData data = null;
                	data = queue.remove(0);
                	System.out.println("消费者ID:"+Thread.currentThread().getId()+" 消费了:"+data.getData());
                	Main.full.signalAll();
                }
                Thread.sleep(1000);
                Main.lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
