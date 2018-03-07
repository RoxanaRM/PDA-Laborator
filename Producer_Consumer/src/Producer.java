import java.util.ArrayList;
import java.util.Random;


public class Producer implements Runnable {
	ArrayList<Integer> list = new ArrayList<Integer>();
	int capacity;
	
	public Producer(ArrayList<Integer> list, int capacity) {
		super();
		this.list = list;
		this.capacity= capacity;
	}
	
	
	public void run(){
		Random number = new Random();
		int product = number.nextInt(capacity);
		
		while(true) {
			synchronized (list) {
			while(list.size() == capacity) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			System.out.println("Produced: " + product);
			list.add(product);
			notify();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
}
