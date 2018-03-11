import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Cons_sem extends Thread {
	
	private Queue<Integer> buffer;
	private Semaphore sFull;
	private Semaphore sFree;
	
	public Cons_sem(Queue<Integer> buffer) {
		this.buffer = buffer;
	}
	
	public void run(){
		while(true) {
			try {
				sFull.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized(buffer) {
				if(buffer.size()!=0)
					buffer.remove();
			}
			
			sFree.release();
		}
	}
}
