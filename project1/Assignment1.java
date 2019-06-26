import java.util.Scanner;

public class Assignment1 {
	
	//main method 
	public static void main(String[] args) {
		
			//creates new scanner
			Scanner input = new Scanner ( System.in ); 
			
			int number1 = 0; //first compared number
			int number2 = 0; //second compared number
			int sum; // the sum of the 2 numbers
			
			while (number1 != -1) {
				
				System.out.printf( "Enter a positive integer (-3 to print, -2 to reset, -1 to quit):" ); // prompt
				number1 = input.nextInt();
			
				if (number1 < -3) {
					System.out.println("Please use a number greater than -3");
				}
				
				else if (number1 == -3) {
					System.out.printf("Sum: %d", number1);
				}
			
				else if (number1 == -2) {
					number2 = 0;
					System.out.printf("Sum: %d\n", number2);
				}
			
				else if (number1 == -1) {
					System.out.printf("Sum: %d", number1);
					return;
				}
			
				else if (number1 == 0) {
					System.out.println("Please use a number greater than -3");
				}
			
				else if (number1 >= 1) {
					number2 = number1 + number2;
					System.out.printf("Sum: %d\n", number2);
				}
			}
			
	}
}
