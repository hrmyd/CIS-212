import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	
	private final LinkedBlockingQueue<String> _queue;
	private int consumed = 0;
	private String _name;
	private String maxString = "";
	
	public Consumer(LinkedBlockingQueue<String> queue, String name){
		_queue = queue;
		_name = name;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(_name);
		
		while(!Producer.complete()){
			try{
				String n = _queue.poll(1000, TimeUnit.MILLISECONDS);
				if (n != null) {
					if(maxString.compareTo(n) < 0){
						maxString = n;
					}
					consumed += 1;
					if(consumed % 1000 == 0){
						System.out.println(Thread.currentThread().getName() + " consumed " + consumed);
					}
				}
				Thread.sleep((long) (10 * Math.random()));
			} catch(InterruptedException ex){
				System.out.println("interrupted: " + ex);
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " finished consuming! " + consumed + " consumed.");
		System.out.println(Thread.currentThread().getName() + " max string: " + maxString);
	}

}
