package main;

import java.util.concurrent.LinkedBlockingQueue;

import consumer.Consumer;
import observer.Observer;
import producer.Producer;

public class Main {
	public static void main(String[] args) {

		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);

		Producer producer = new Producer(queue);
		Observer observer = new Observer(queue, producer);
		Consumer consumer = new Consumer(queue, producer);

		Thread producerThread = new Thread(producer);
		Thread observerThread = new Thread(observer);
		Thread cosumerThread = new Thread(consumer);

		producerThread.start();
		observerThread.start();
		cosumerThread.start();
	}
}
