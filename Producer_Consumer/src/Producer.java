import java.util.Queue;
import java.util.Random;


public class Producer implements Runnable {
	Queue<Integer> buffer;
	int capacity;
	
	public Producer(Queue<Integer> buffer, int capacity) {
		super();
		this.buffer = buffer;
		this.capacity= capacity;
	}
	
	
	public void run(){
		Random number = new Random();
		int product = number.nextInt(capacity);
		
		while(true) {
			synchronized (buffer) {
			while(buffer.size() == capacity) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			System.out.println("Produced: " + product);
			buffer.add(product);
			notify();
			
			}
		}
	}
}
