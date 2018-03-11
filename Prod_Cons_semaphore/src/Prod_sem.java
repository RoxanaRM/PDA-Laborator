import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Prod_sem extends Thread {
	private Queue<Integer> buffer;
	private Semaphore sFull;
	private Semaphore sFree;
	int capacity;
	
	public Prod_sem(Queue<Integer> buffer, int capacity) {
		super();
		this.buffer = buffer;
		this.capacity= capacity;
	}
	
	public void run(){
		
		while(true) {
			Random number = new Random();
			int product = number.nextInt(capacity);

				try {
					sFree.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (buffer) {
				if (buffer.size() != capacity) 
					buffer.add(product);
			}
				sFull.release();
		}
	}
}
