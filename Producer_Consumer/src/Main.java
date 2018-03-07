import java.util.ArrayList;

public class Main {

	public static void main(String[] args)throws InterruptedException {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Thread t1 = new Thread (new Producer(list, 6));
		Thread t2 = new Thread (new Consumer(list));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		

	}

}
