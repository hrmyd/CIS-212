import java.util.Scanner;


public class Input {
	public static void main(String[] args) {
		
		System.out.println("Enter a positive integer (-1 to quit, -2 "
				+ "to print, -3 to reset):");
		
		Scanner input = new Scanner(System.in);
		int num;
		int product = 1;
		
		while(input.hasNext()){
			num = input.nextInt();
			
			// only find product if num is positive.
			if(num > 0){
				product = product * num; 
			}
			switch(num){
				// print product and quit app
				case -1: System.out.println("Product: " + product);
					System.exit(0);
					break;
				// print product, keep asking for num
				case -2: System.out.println("Product: " + product);
					break;
				// reset product
				case -3: product = 1;
					break;
			}
			System.out.println("Enter a positive integer (-1 to quit, -2 "
					+ "to print, -3 to reset):");
		}
		input.close();
	}
}
