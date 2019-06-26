import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;



public class Assignment2 {

	public static void main(String args[]) {
		
		Scanner input = new Scanner (System.in);
		
		int arrayLen;
		double arrayDensity;
		
		System.out.printf("Please enter array length:" ); // prompt
		arrayLen = input.nextInt();
		
		System.out.printf("Enter density:" ); // prompt
		arrayDensity = input.nextDouble();
		
		int[] denseArray = createArray(arrayLen, arrayDensity);
		
		ArrayList<int[]> sparseArray = createSparseArray(arrayLen, arrayDensity);
		
		ArrayList<int[]> dense2sparse = DenseToSparse(denseArray);
		
		int[] newDenseArray = denseConverter(arrayLen, dense2sparse);
		
		maxDense(denseArray);
		maxSparse(sparseArray);
		
		}
		
	
	
	public static int[] createArray(int len, double den) {
		long start = System.nanoTime();
		
		
	 	int[] array1 = new int[len];
	 
	 	Random rand = new Random();
	 	for (int i = 0; i < array1.length; i++) {
		 	
		 	double randDoub = rand.nextDouble() * .999999999;
		 	int randInt = rand.nextInt(1000000) +1;
	 		
		 	if (randDoub >= den) {
	 			array1[i] = randInt;
	 			 
	 		}
	 		else {
	 			array1[i] = 0;
	 		}
	 		
	 	}
	 	
	 	long end = System.nanoTime() - start;
	 	System.out.println("creates dense length: " + len + " time: " + (double)end/1000000);
	 	
	 	return array1;
	 	 
	}
	
	public static ArrayList<int[]> createSparseArray(int len, double den) {
		long start = System.nanoTime();
		
		Random rand = new Random();
		
		ArrayList<int[]> SparseList = new ArrayList<int[]>(); 
	 	
		for (int i = 0; i < len; i++) {
		 	
		 	double randDoub = rand.nextDouble() * .999999999;
		 	int randInt = rand.nextInt(1000000) +1;
	 		
		 	if (randDoub < den) {
	 			SparseList.add(new int[] {i, randInt});
		 	
		 	}
	
	 
		}
		long end = System.nanoTime() - start;
	 	System.out.println("creates sparse length: " + len + " time: " + (double)end/1000000);
	 	
	 	
		return SparseList; 
	
	}
	
	
	public static ArrayList<int[]> DenseToSparse(int[] denseArray) {
		long start = System.nanoTime();
		
		Random rand = new Random();
		
		ArrayList<int[]> newSparse = new ArrayList<int[]>(); 
		
		
		for (int i = 0; i < denseArray.length; i++) {
			
			if (denseArray[i] != 0) {
				newSparse.add(new int[] {i, denseArray[i]}); 
				
			}//end of for loop
		
		}
		long end = System.nanoTime() - start;
	 	System.out.println("creates sparse length: " + newSparse.size() + " time: " + (double)end/1000000);
		
		return newSparse; 
	
	
	} //end of DenseToSparse
	
	public static int[] denseConverter(int len, ArrayList<int[]> dense2sparse) {
		long start = System.nanoTime();
		
		int [] newDense = new int[len]; 
		
		for(int i = 0; i < len; i++) {
			
			newDense[dense2sparse.get(i)[0]] = dense2sparse.get(i)[1];
			
		}
		long end = System.nanoTime() - start;
	 	System.out.println("creates dense length: " + len + " time: " + (double)end/1000000);
		
		return newDense;
	}//end of denseConverter
	
	
	public static void maxDense(int[] denseArray) {
		long start = System.nanoTime();
		
		int maxValue = 0;
		int maxIndex = 0;
		
		for( int i = 0; i <denseArray.length; i++) {
			if(denseArray[i] > maxValue) {
				maxValue = denseArray[i];
				maxIndex = i;
						
			}
			System.out.println("Find max (dense); " + maxValue +" at: " + maxIndex);
			long end = System.nanoTime() - start;
		 	System.out.println("dense find time: " + (double)end/1000000);
		}
	}
	
	public static void maxSparse(ArrayList<int[]> sparseArray) {
		long start = System.nanoTime();
		
		int maxValue = 0;
		int maxIndex = 0;
		
		for( int i = 0; i < sparseArray.size(); i++) {
			if(sparseArray.get(i)[1] > maxValue) {
				maxValue = sparseArray.get(i)[1];
				maxIndex = sparseArray.get(i)[0];
						
			}
			System.out.println("Find max (sparse); " + maxValue +" at: " + maxIndex);
			long end = System.nanoTime() - start;
		 	System.out.println("sparse find time: " + (double)end/1000000);
			
		}
		
		
	}//end of maxSparse
	
	
	
	
	
}// end of class


