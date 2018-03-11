import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> buffer = new LinkedList<Integer>();
		
		Thread t1 = new Thread (new Prod_sem(buffer, 6)); 
		Thread t2 = new Thread(new Cons_sem(buffer));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
