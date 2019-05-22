package consumer;

import java.util.concurrent.LinkedBlockingQueue;

import producer.Producer;

public class Consumer implements Runnable{

	private LinkedBlockingQueue<String> queue;
	private Producer producer;

	public Consumer(LinkedBlockingQueue<String> queue, Producer producer) {
		this.queue = queue;
		this.producer = producer;
	}

	@Override
	public void run() {
		while (producer.isRunning()) {
			try {
				System.out.println("OC\tElements removed: " + queue.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer Dead.");
	}
}
