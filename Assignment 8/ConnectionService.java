import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionService implements Runnable{

	private static ConcurrentLinkedQueue<ObjectSocket> _socketQueue;
	
	public ConnectionService(ConcurrentLinkedQueue<ObjectSocket> socketQueue){
		_socketQueue = socketQueue;
	}
		
	@Override
	public void run() {
		while (true) {
			for(ObjectSocket socket : _socketQueue) {
				try {
					ObjectInputStream inputStream = socket.getInputStream();
					
					ObjectOutputStream outputStream = socket.getOutputStream();
					outputStream.flush();
					
					if(inputStream.available() > 0) {
						
						@SuppressWarnings("unchecked")
						ArrayList<Integer> received = (ArrayList<Integer>) inputStream.readObject();
						
						System.out.println("list received: " + received);
						
						ArrayList<Integer> primeNums = new ArrayList<Integer>(primeList(received));
						
						outputStream.writeObject(primeNums);
						outputStream.flush();
					}
					
				}catch (IOException | ClassNotFoundException ex){
					ex.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(100);
			} catch(InterruptedException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	public static ArrayList<Integer> primeList(ArrayList<Integer> intList){
		ArrayList<Integer> prime = new ArrayList<Integer>();
		
		for(int i : intList){
			if(isPrime(i)){
				prime.add(i);
			}
		}
		
		return prime;
	}
	
	public static boolean isPrime(int n){
		
		if(n == 2){
			return true;
		}
		if(n % 2 == 0 || n == 1){
			return false;
		}
		for(int i = 3; i*i <= n; i += 2){
			if(n % i == 0){
				return false;
			}
		}
		
		return true;
	}

}
