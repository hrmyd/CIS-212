import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageService implements Runnable{
	
	private static int _PORT;
	private static ConcurrentLinkedQueue<ObjectSocket> _socketQueue;
	
	public MessageService(ConcurrentLinkedQueue<ObjectSocket> socketQueue, int PORT){
		_socketQueue = socketQueue;
		_PORT = PORT;
	}

	@Override
	public void run() {
		try{
			ServerSocket serverSocket = new ServerSocket(_PORT);
			
			while(true){
				System.out.println("Waiting for connection...");
				
				Socket socket = serverSocket.accept();
				_socketQueue.offer(new ObjectSocket(socket));
				
				System.out.println("connected!");
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
