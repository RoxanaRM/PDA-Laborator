import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Cons extends Thread {

	private Queue<Integer> buffer;
	Object condProd;
	Object condCons;

	public Cons(Queue<Integer> buffer, Object condProd, Object condCons) {
		super();
		this.buffer = buffer;
		this.condProd = condProd;
		this.condCons = condCons;
	}

	public void run() {
		while (true) {
			synchronized (buffer) {
				while (buffer.size() == 0) {
					try {
						condCons.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int consumed = buffer.remove();
				System.out.println("Consumed" + consumed);
			}

			condProd.notify();
		}
	}
}
