import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
	private static final int PORT = 1233;
	
	public static void main(String[] args){
		
		ArrayList<Integer> numList = new ArrayList<Integer>(createIntList());
		
		try{
			InetAddress localHost = InetAddress.getLocalHost();
			Socket socket = new Socket(localHost, PORT);
			
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			
			outputStream.writeObject(numList);
			outputStream.flush();
			
			System.out.println("client sent: " + numList);
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer> primes = (ArrayList<Integer>) inputStream.readObject();
			
			System.out.println("client received: " + primes);
			
			inputStream.close();
			outputStream.close();
			socket.close();
	
		}catch (IOException | ClassNotFoundException ex){
			ex.printStackTrace();
		}
		
	}
	public static ArrayList<Integer> createIntList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number, -1 to quit: ");
		do{
			try{
				num = sc.nextInt();
				if(num == -1){
					break;
				}else{
					list.add(num);
				}

				System.out.println("Enter a number, -1 to quit: ");
				
			}catch(InputMismatchException ex){
				System.out.println("invalid input, please enter a number");
			}
		}while(sc.hasNextInt());
		
		sc.close();
		
		return list;
	}
}
