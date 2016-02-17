import java.util.concurrent.LinkedBlockingQueue;
import java.util.UUID;

public class Producer implements Runnable{
	
	private final LinkedBlockingQueue<String> _queue;
	private static final int SIZE = 2000000;
	private static int produced = 0;
	private static boolean isComplete = false;

	public Producer(LinkedBlockingQueue<String> queue){
		_queue = queue;
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i < SIZE; i++){
			
			if((i % 1000 == 0)){
				System.out.println("produced: " + i);
			}
			
			try{
				String str = UUID.randomUUID().toString();
				_queue.put(str);
				
				produced = i;
			} catch(InterruptedException ex){
				System.out.println("interuppted: " + ex);
			}
		}
		
		System.out.println("done producing! " + produced + " produced");
		isComplete = true;
		
	}
	
	public static boolean complete() {
		
		return isComplete;
	}

}
