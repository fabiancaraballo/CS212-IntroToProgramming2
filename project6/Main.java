import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.SortedMap;
import java.util.Map; 

public class Main extends OccurrenceSet {
	
	public static void main(String[] args) {
		 
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();  
		
		intSet.add(1);
		intSet.add(3);
		intSet.add(6);
		intSet.add(5);
		intSet.add(6);
		intSet.add(3);
		intSet.add(6);
		System.out.println(intSet);
		
		OccurrenceSet<Integer> int1 = new OccurrenceSet<Integer>();
		
		int1.add(7);
		int1.add(3);
		int1.add(4);
		int1.add(0);
		int1.add(2);
		int1.add(3);
		int1.add(6);
		System.out.println(int1);
		
		int1.addAll(intSet); 
		System.out.println(int1);
		
		
		
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		System.out.println(stringSet);
		
		OccurrenceSet<String> string1 = new OccurrenceSet<String>();
		string1.add("hello");
		string1.add("hello");
		string1.add("world");
		string1.add("world");
		string1.add("world");
		string1.add("here");
		System.out.println(string1);
		string1.removeAll(stringSet);
		System.out.println(string1);
		
	}
}
