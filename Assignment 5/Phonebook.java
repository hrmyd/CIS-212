import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Phonebook {
	// reads file into phonebook entries and has selection and merge sort methods.
	
	
	public ArrayList<Entry> addEntries(){
		ArrayList<Entry> phonebook = new ArrayList<Entry>();
		String fileName = "phonebook.txt";
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = file.readLine()) != null){
				String[] entryline = line.split("([^,]) ");
				Entry entry = new Entry(entryline[1], entryline[0]);
				phonebook.add(entry);
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return phonebook;
	}
	
	public ArrayList<Entry> selectionSort(ArrayList<Entry> sortedPhonebook) {
		
		// http://www.csc.depauw.edu/~dharms/CS1-Myro-Java/BlueJ_Projects-F11/SortingAndSearching/SelectionSort.java
		for (int i = 0; i < sortedPhonebook.size() - 1; i++){
			for (int j = i + 1; j < sortedPhonebook.size(); j++) {
				if (sortedPhonebook.get(i).compareTo(sortedPhonebook.get(j)) > 0){
					
					// swap if name[j] is smaller than name[i]
					Collections.swap(sortedPhonebook, i, j);
				}
			}
			
		}
		
		return sortedPhonebook;
	}
	
	public ArrayList<Entry> mergeSort(ArrayList<Entry> phonebook) {
		// https://github.com/WWaldo/Sorting-Algorithms/blob/master/MergeSort.java
		ArrayList<Entry> sortedPhonebook = new ArrayList<Entry>();
		ArrayList<Entry> left = new ArrayList<Entry>();
		ArrayList<Entry> right = new ArrayList<Entry>();
		
		int mid = phonebook.size()/2;
		
		if (phonebook.size() <= 1){
			return phonebook;
		}
		
		for(int i = 0; i < phonebook.size(); i++){
			if(i < mid){
				left.add(phonebook.get(i));
			}
			else{
				right.add(phonebook.get(i));
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		sortedPhonebook = merge(left, right);
		
		return sortedPhonebook;
	}
	
	public ArrayList<Entry> merge(ArrayList<Entry> right, ArrayList<Entry> left){
		ArrayList<Entry> merged = new ArrayList<Entry>();
				
		while (left.size() > 0 || right.size() > 0){
			if (left.size() > 0 && right.size() > 0){
				if(left.get(0).compareTo(right.get(0)) < 0){
					merged.add(left.get(0));
					left.remove(0);
				}
				else{
					merged.add(right.get(0));
					right.remove(0);
				}
			}
			else if(left.size() > 0){
				merged.add(left.get(0));
				left.remove(0);
			}
			else if(right.size() > 0){
				merged.add(right.get(0));
				right.remove(0);
			}
		}
		
		return merged;
	}
	
	public boolean isSorted(ArrayList<Entry> toTest) {
		
		boolean sorted = true;
		
		for (int i = 0; i < toTest.size() - 1; i++){
				if (toTest.get(i).compareTo(toTest.get(i + 1)) > 0){
					sorted = false;
				}
				
			}
		return sorted;
	}
	
	
	public float elapsedTime(long startTime){
		long currentTime = System.nanoTime();
		
		return ((currentTime - startTime) / 1000000000.0f); // returns in seconds
	}
} 
