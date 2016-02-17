import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static final int PORT = 1233;
	
	public static void main(String[] args){
		System.out.println("running server...");
		
		try{
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			
			Socket socket = serverSocket.accept();
			
			System.out.println("connected to socket");
			
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer> received = (ArrayList<Integer>) inputStream.readObject();
			
			System.out.println("list received: " + received);
			
			ArrayList<Integer> primeNums = new ArrayList<Integer>(primeList(received));
			
			outputStream.writeObject(primeNums);
			outputStream.flush();
			
			inputStream.close();
			outputStream.close();
			serverSocket.close();
			
		}catch(IOException | ClassNotFoundException ex){
			ex.printStackTrace();
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
