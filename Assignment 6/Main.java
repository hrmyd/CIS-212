import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		// testing with Integer types.
		OccurenceSet<Integer> ints = new OccurenceSet<Integer>();
		
		ints.add(1);
		ints.add(4);
		ints.add(4);
		ints.add(5);
		ints.add(6);
		ints.add(6);
		ints.add(7);
		ints.add(2);
		ints.add(1);
		ints.add(4);
		
		// string representation
		System.out.println("map string representation: " + ints);
		
		// removing elements
		ints.remove(6);
		ints.remove(4);
		
		System.out.println("removing elements: " + ints);
		
		// to array types
		System.out.println("to array: " + Arrays.toString(ints.toArray()));
		
		ints.add(9);
		ints.add(10);
		ints.add(3);
		ints.add(3);
		
		System.out.println(ints);
		
		Integer[] a = new Integer[ints.size()];
		System.out.println("to array S[]: " + Arrays.toString(ints.toArray(a)));
		
		System.out.println("size: " + ints.size());
		
		System.out.println("contains 5: " + ints.contains(5) + ", contains 11: " + ints.contains(11));
		
		// test with strings
		OccurenceSet<String> strings = new OccurenceSet<String>();
		
		strings.add("hello");
		strings.add("hello");
		strings.add("cat");
		strings.add("dog");
		strings.add("dog");
		strings.add("dog");
		
		// size and string representation
		System.out.println();
		System.out.println(strings + " " + strings.size());
		
		strings.add("bird");
		strings.add("bird");
		strings.add("bird");
		strings.add("blah");
		
		System.out.println(strings);
		System.out.println("to array: " + Arrays.toString(strings.toArray()));
		
		// testing addAll
		OccurenceSet<String> addtest = new OccurenceSet<String>();
		
		addtest.add("voldemort");
		addtest.add("voldemort");
		addtest.add("voldemort");
		addtest.add("basalisk");
		addtest.add("azkaban");
		addtest.add("azkaban");
		addtest.add("dog");
		addtest.add("cat");
		
		System.out.println();
		System.out.println(addtest);
		
		strings.addAll(addtest);
		
		System.out.println(strings);
		
		// remove all test and contains all tests
		
		System.out.println();
		System.out.println("strings contains addtest (true exp): " + strings.containsAll(addtest));
		
		strings.removeAll(addtest);
		System.out.println();
		System.out.println(strings);
		
		System.out.println("strings contains addtest (false exp): " + strings.containsAll(addtest));
		
		strings.clear();
		System.out.println();
		System.out.println("clear: " + strings);
		
	
	}
}
