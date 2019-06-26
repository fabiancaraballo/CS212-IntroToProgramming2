import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.SortedMap;

import javax.lang.model.element.Element;

import java.util.Map; 

public class OccurrenceSet<T> implements Set<T> {
	
	Map <T, Integer > myMap = new HashMap<>();
		
	
	public int size() {
		// TODO Auto-generated method stub
		return myMap.size();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean contains(Object o) {
		if (myMap.containsKey(o)) {
			return true;
		}
		else {
			return false;
		}
	}


	


	public Object[] toArray() {
		Object[] list = new String[myMap.size()];
		int count = 0;
		for(Object i: myMap.keySet()) {
			list[count] = i;
		}
		return list;
	}
	

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
		
	}

	
	
	public boolean add(T element) {
		if (myMap.containsKey(element)) {
			//System.out.println("Hi");
			int keyCount = myMap.get(element);
			//System.out.println("keyCount = " + keyCount);
			myMap.put(element, keyCount +1 );
			return false;
		}
		else {
			myMap.put(element, 1);
			return true;
		}
		 
	}


	
	public boolean remove(Object o) {
		if (myMap.containsKey(o)) {
			myMap.remove(o);
			return true;
		}
		return false;
		
	}

	
	
	public boolean containsAll(Collection<?> c) {
		for(int i = 0; i < c.size(); i++)
		{
			if(!myMap.containsKey(i)) {
				return false;
				
			}
		}
		return true;
		
	}
		
		

	public boolean addAll(Collection<? extends T> c) {
		if (c != myMap) {
            OccurrenceSet<T> cSet = (OccurrenceSet<T>)c; // cast "c" to the right type, OccuranceSet<T>            
            Set<T> keySet = cSet.myMap.keySet(); // get the keySet from "myMap" inside cSet

            for(T element: keySet){
                if(myMap.containsKey(element)) {
                    int keyCount = myMap.get(element);
                    myMap.put(element, keyCount + 1);
                }
                else {
                    myMap.put(element, 1);

                }
            }
            return true;
        }
        return false;
    }
						
	


	@Override
	public boolean retainAll(Collection<?> collect) {
		int count = 0;
		OccurrenceSet<T> cSet = (OccurrenceSet<T>)collect; // cast "c" to the right type, OccuranceSet<T>            
        Set<T> keySet = cSet.myMap.keySet(); // get the keySet from "myMap" inside cSet

        for(T element: keySet){
        		if(!collect.contains(element)) {
        			myMap.remove(element);
        			count++;
        		}
        }
        if(count > 0) {
        		return true;
        }
        else {
        		return false;
        }
	}


	public boolean removeAll(Collection<?> collect) {
		int count = 0;
		OccurrenceSet<T> cSet = (OccurrenceSet<T>)collect; // cast "c" to the right type, OccuranceSet<T>            
		Set<T> keySet = cSet.myMap.keySet(); // get the keySet from "myMap" inside cSet

		for(T element: keySet){
    			if(collect.contains(element)) {
    				myMap.remove(element);
    				count++;
    			}
		}
		if(count > 0) {
    			return true;
		}
		else {
    			return false;
		}
	}
	


	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		//return myMap.toString();
		String everything = "";
		everything += myMap.keySet();
		return everything;
		
		
	}

	@Override
	public Iterator<T> iterator() {
		ArrayList<T> list = new ArrayList<T>();
		HashSet<T> set = new HashSet<T>(myMap.keySet());
		for(T i : set) {
			list.add(i);
		}
		
		
		
		return null; 
		
	}



}


	

