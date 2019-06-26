import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class sortClass extends fileData {
	
	public sortClass(String file_path) {
		super(file_path);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException  {
				
		long startTime = System.currentTimeMillis();
		//System.out.println(selectionSort(fileList()));
		selectionSort(fileList());
		long endTime = System.currentTimeMillis();
		System.out.println("Selection Sort: " + ((endTime - startTime)/1000.0) + " seconds");

		long sTime = System.currentTimeMillis();
		//System.out.println(mergeSort(fileList()));
		mergeSort(fileList());
		long eTime = System.currentTimeMillis();
		System.out.println("Merge Sort: " + ((eTime - sTime)/1000.0) + " seconds");
		
	}
	
	public static ArrayList<java.lang.String> selectionSort(ArrayList<String> arrList) {
		for(int i = 0; i < arrList.size()-1; i++) {
			int minIndex = i;
			for(int j = i+1; j < arrList.size(); j++) {
				if ((arrList.get(j).compareTo(arrList.get(minIndex)) < 0 )) {
					minIndex = j;
				}
			}
			String place = arrList.get(i);
			arrList.set(i, arrList.get(minIndex));
		    arrList.set(minIndex, place);
		}
		return arrList;
		
	
	}
	//Similar code to the class notes, however I adjusted it from being a int arrray[] to a string arrayList 
	
	
	public static ArrayList<String> mergeSort(ArrayList<String> aList) {
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        int minIndex;
 
        if (aList.size() == 1) {    
            return aList;
        } else {
            minIndex = aList.size()/2;
    
            for (int i= 0; i< minIndex; i++) {
                    left.add(aList.get(i));
            }

            for (int i= minIndex; i< aList.size(); i++) {
                    right.add(aList.get(i));
            }
 
            left  = mergeSort(left);
            right = mergeSort(right);
 
            merge(aList, right, left);
        }
        return aList;
    }
 
    private static void merge(ArrayList<String> newList, ArrayList<String> right, ArrayList<String> left) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                newList.set(listIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                newList.set(listIndex, right.get(rightIndex));
                rightIndex++;
            }
            listIndex++;
        }
 
        ArrayList<String> otherList;
        int otherIndex;
        if (leftIndex >= left.size()) {
            otherList = right;
            otherIndex = rightIndex;
        } 
        else {
            otherList = left;
            otherIndex = leftIndex;
        }

        for (int i= otherIndex; i< otherList.size(); i++) {
            newList.set(listIndex, otherList.get(i));
            listIndex++;
        }
         
    }// used lecture notes, Psuedo Code from Tuesday's lab, and the textbook as references to help with this part.
    
    public boolean isSorted(ArrayList<String> sortedList)
    {
        boolean sorted = true;        
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i-1).compareTo(sortedList.get(i)) > 0) {
            		return false;
            }
        }

        return sorted;
    }
    
}
    


