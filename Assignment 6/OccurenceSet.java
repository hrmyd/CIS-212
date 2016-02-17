import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Comparator;

public class OccurenceSet<T> implements Set<T> {

	HashMap<T, Integer> hashmap = new HashMap<T, Integer>();
	
	@Override
	public int size() {

		return hashmap.size();
	}

	@Override
	public boolean isEmpty() {
		
		return hashmap.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		return hashmap.containsKey(o);
	}
	

	@Override
	public Iterator<T> iterator() {
		Set<Map.Entry<T, Integer>> entrySet = hashmap.entrySet();
		ArrayList<Map.Entry<T, Integer>> toSort = new ArrayList<Map.Entry<T, Integer>>(entrySet);
		ArrayList<T> sortedKeys = new ArrayList<T>();
		
		Collections.sort(toSort, new Comparator<Map.Entry<T, Integer>>() {

			public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Map.Entry<T, Integer> key : toSort){
			sortedKeys.add(key.getKey());
		}
		
		return sortedKeys.iterator();
	}
	

	@Override
	public Object[] toArray() {
		Iterator<T> it = iterator();
		ArrayList<T> sorted = new ArrayList<T>();
		
		while(it.hasNext()){
			sorted.add(it.next());
		}
		
		return sorted.toArray();
	}

	@Override
	public <S> S[] toArray(S[] a) {
		ArrayList<T> sorted = new ArrayList<T>();
		Iterator<T> it = iterator();
		
		while(it.hasNext()){
			sorted.add(it.next());
		}
		return sorted.toArray(a);
	}

	@Override
	public boolean add(T e) {
		int value = 1;
		
		if(hashmap.containsKey(e)){
			value = hashmap.get(e) + 1;
		}
		
		return hashmap.put(e,  value) == null;
		
	}

	@Override
	public boolean remove(Object o) {
		
		return hashmap.remove(o, hashmap.get(o));
	
	}

	@Override
	public boolean containsAll(Collection<?> c) {
	
		boolean result = false;
		
		for(Object e : c){
			result = contains(e);
		}
		return result;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		boolean result = false;
		
		for(T e : c){
			result = add(e);
		}
		
		return result;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		boolean result = false; 
		
		for (Object e : c){
			if(!c.contains(hashmap.get(e))){
				result = remove(e);
			}
		}
		return result;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		boolean result = false;
		
		for(Object e : c){
			if(hashmap.containsKey(e)){
				result = remove(e);
			}
		}
		return result;
	}

	@Override
	public void clear() {
		
		hashmap.clear();
		
	}
	
	public String toString() {
		Iterator<T> it = iterator();
		ArrayList<T> strings = new ArrayList<T>();
		
		while(it.hasNext()){
			strings.add(it.next());
		}
		return "" + strings + "";
	}
}

