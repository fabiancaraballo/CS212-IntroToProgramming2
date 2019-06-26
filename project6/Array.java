import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<T> implements Iterable<T> {
	T[] values; 
	//... constructors, other methods, etc...
	// private iterator class for use in iterator()
	class ArrayIterator implements Iterator<T> {
		
		int current = 0;  // the current element we are looking at
		
		public boolean hasNext() {
			if (current < Array.this.values.length) {
				return true;
			} 
			else {
					return false;
			}
		}
		
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
				}
				return values[current++];
			}
		
		// Return the value at a given index
	    public T get(int index) {
	        return values[index];
	    }

	    // Set the value at a given index
	    public void set(int index, T value) {
	        values[index] = value;
	    }

	    // Return the length of the array
	    public int length() {
	        return values.length;
	    }
		
		
		}//gist.github.com/jnwhiteh/68d095c630dfcaddffd1
	
	
	
	public Iterator<T> iterator() {
		return new ArrayIterator(); 
	}
	
}