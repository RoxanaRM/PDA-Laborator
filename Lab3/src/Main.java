import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> buffer = new LinkedList<Integer>();
		int capacity = 6;
		Object condProd = new Object();
		Object condCons = new Object();

		Thread t1 = new Thread(new Prod(condProd, condCons, buffer, capacity));
		Thread t2 = new Thread(new Cons(buffer, condProd, condCons));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
