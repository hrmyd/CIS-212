import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThread {
	private static final int PORT = 1234;
	
	public ServerThread(){
		final ConcurrentLinkedQueue<ObjectSocket> _socketQueue = new ConcurrentLinkedQueue<>();
		
		ExecutorService executor = Executors.newCachedThreadPool(); 
		executor.execute(new ConnectionService(_socketQueue));
		executor.execute(new MessageService(_socketQueue, PORT));
		executor.shutdown();
	}
	
	public static void main(String[] args){
		new ServerThread();
	}
}
