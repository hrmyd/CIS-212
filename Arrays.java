import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Arrays {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int length = 0;
		double density = 0.0;
		
		do{
			System.out.println("enter array length: ");
			try{
				length = sc.nextInt();
			} catch(InputMismatchException ex){
				System.out.println("enter a positive number");
				sc.next();
			}

		} while(length <= 0);
		
		do{
			System.out.println("enter density: ");
			try{
				density = sc.nextDouble();
			} catch(IllegalArgumentException ex){
				System.out.println("enter a double value");
				sc.next();
			}
			
		} while(density >= 1 || density < 0);
		/* 
		 * Timing tests: 
		 * For smaller array sizes with low, find time for sparse is faster than finding the max 
		 * for a dense array. Sparse creation is also quicker than dense array creation
		 * and conversion also quicker. Same when the density is higher.
		 * 
		 * as array size increases, observations still hold, except for around 0.5 density sparse array
		 * find time is a little slower.
		 * 
		 * at larger array sizes, sparse array creation is slower than dense array creation. Conversion
		 * from sparse to dense is faster though.
		 * 
		 * at largest array size tested, low densities have about same time while larger densities sparse
		 * array creation is much slower.
		 */
		
		long startTime = System.nanoTime();
		int[] denseArray = createDenseArray(length, density);
		System.out.println("create dense, length: " + denseArray.length + " time: " + findTime(startTime));
		
		startTime = System.nanoTime();
		ArrayList<List<Integer>> denseToSparse = denseToSparse(denseArray);
		System.out.println("convert to sparse, length: " + denseToSparse.size() + " time: " + findTime(startTime));
		
		System.out.println();
		
		startTime = System.nanoTime();
		ArrayList<List<Integer>> sparseArray = createSparseArray(length, density);
		System.out.println("create sparse, length: " + sparseArray.size() + " time: " + findTime(startTime));
		
		startTime = System.nanoTime();
		int[] sparseToDense = sparseToDense(sparseArray);
		System.out.println("convert to dense, length: " + sparseToDense.length + " time: " + findTime(startTime));
		
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.print("find max (dense): ");
		findMaxDense(denseArray);
		System.out.println("dense find time: " + findTime(startTime));
		
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.print("find max (sparse): ");
		findMaxSparse(sparseArray);
		System.out.println("sparse find time: " + findTime(startTime));

	}
	
	public static int[] createDenseArray(int length, double density){
		
		Random random = new Random();
		
		int[] denseArray = new int[length];
		double randNum;
		
		for(int i = 0; i < denseArray.length; i++){
			randNum = random.nextDouble();
			if(randNum < density){
				denseArray[i] = 1 + random.nextInt(1000000);
			} else{
				denseArray[i] = 0;
			}
		}
		return denseArray;
	}
	
	public static ArrayList<List<Integer>> createSparseArray(int length, double density) {
		ArrayList<List<Integer>> sparseArray = new ArrayList<List<Integer>>(length);
		Random random = new Random();
		double randNum;
		
		for(int i = 0; i < length; i++){
			randNum = random.nextDouble();
			
			if(randNum < density){
				List<Integer> innerArray = new ArrayList<Integer>(2);
				innerArray.add(i);
				innerArray.add(1 + random.nextInt(1000000));
				sparseArray.add(innerArray);
			}
		}
		return sparseArray;
	}
	
	public static ArrayList<List<Integer>> denseToSparse(int[] denseArray){
		ArrayList<List<Integer>> sparseArray = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < denseArray.length; i++){
			if(denseArray[i] != 0){
				List<Integer> innerArray = new ArrayList<Integer>(2);
				innerArray.add(i);
				innerArray.add(denseArray[i]);
				sparseArray.add(innerArray);
			}
		}
		
		return sparseArray;
	}
	
	public static int[] sparseToDense(ArrayList<List<Integer>> sparseArray){
		int[] denseArray;
				
		if(sparseArray.size() != 0){
			denseArray = new int[sparseArray.get(sparseArray.size() - 1).get(0) + 1];
					
			for(List<Integer> a : sparseArray){
				denseArray[a.get(0)] = a.get(1);
			}
			
		} else{
			denseArray = new int[0];
		}

		return denseArray;
	}
	
	public static void findMaxDense(int[] denseArray){
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < denseArray.length; i++){
			if(denseArray[i] > max){
				max = denseArray[i];
				index = i;
			}
		}
		
		System.out.println(max + " at: " + index);
	}
	
	public static void findMaxSparse(ArrayList<List<Integer>> sparseArray){
		int max = 0;
		int index = 0;
		
		for(List<Integer> i : sparseArray){
			if(i.get(1) > max){
				max = i.get(1);
				index = i.get(0);
			}
		}
		
		System.out.println(max + " at: " + index);
		
	}
	
	public static float findTime(long startTime){
		long currentTime = System.nanoTime();
		
		return ((currentTime - startTime) / 1000000.0f); // returns in milliseconds
	}
}
