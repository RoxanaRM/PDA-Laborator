import java.util.ArrayList;

public class Consumer implements Runnable {
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public Consumer(ArrayList<Integer> list) {
		this.list = list;
	}

	public void run(){
		while(true) {
			synchronized (list) {
				while(list.size() == 0) {
					wait();	
			}
				
			int consume = list.remove();
			System.out.println("Consumed" + consume);
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
