package producer;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {

	private LinkedBlockingQueue<String> queue;
	private boolean running;

	public Producer(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			String element = "String" + i;
			try {
				queue.put(element);
				System.out.println("P\tAdding element: " + element);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("P Completed.");
		running = false;
	}

}
