import java.util.Queue;

public class Consumer implements Runnable {
	Queue<Integer> buffer;
	
	public Consumer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}

	public void run(){
		while(true) {
			synchronized (buffer) {
				while(buffer.size() == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			}
				
			int consume = buffer.remove();
			System.out.println("Consumed" + consume);
			notify();
			
			
			}
		}
	}
}
