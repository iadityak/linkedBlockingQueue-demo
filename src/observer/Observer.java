package observer;

import java.util.concurrent.LinkedBlockingQueue;

import producer.Producer;

public class Observer implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private Producer producer;

	public Observer(LinkedBlockingQueue<String> queue, Producer producer) {
		this.queue = queue;
		this.producer = producer;
	}

	@Override
	public void run() {
		while (producer.isRunning()) {
			try {
				System.out.println("OC\tElements left: " + queue);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Observer Dead.");
		System.out.println("Final elements in the queue: " + queue);
	}
}
