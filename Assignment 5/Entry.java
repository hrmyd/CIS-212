
public class Entry{
	// creates a phonebook entry with name and phone number.
	
	private String _name;
	private String _number;
	
	public Entry(String name, String number) {
		_name = name;
		_number = number;
	}
	
	public String getName() {
		
		return _name;
	}
	
	public String getNumber() {
		
		return _number;
	}
	
	public int compareTo(Entry e){
		return this._name.compareToIgnoreCase(e._name);
	}
}
