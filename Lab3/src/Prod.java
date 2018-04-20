import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Prod implements Runnable {
	Object condProd;
	Object condCons;
	Queue<Integer> buffer;
	int capacity;

	public Prod(Object condProd, Object condCons, Queue<Integer> buffer, int capacity) {
		super();
		this.condProd = condProd;
		this.condCons = condCons;
		this.buffer = buffer;
		this.capacity = capacity;
	}

	public void run() {
		Random number = new Random();
		while (true) {

			int product = number.nextInt(capacity);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			synchronized (buffer) {
				while (buffer.size() == capacity) {
					try {
						condProd.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer.add(product);
				System.out.println("Produced" + product);
				condCons.notify();
			}

		}
	}

}
