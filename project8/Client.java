import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
	private static final int PORT = 1337;
	
	static ArrayList<Integer> list = new ArrayList<Integer>(firstList());
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;		
		try {
			InetAddress address = InetAddress.getLocalHost();
			socket = new Socket(address, PORT);
			
			
	        
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			
			outputStream.writeObject(list);
			outputStream.flush();
			
			
			System.out.println("Sent: " + list);
			
			
	
			@SuppressWarnings("unchecked")
			ArrayList<Integer> prime = (ArrayList<Integer>) inputStream.readObject();
			
			System.out.println("Received: " + prime);
			
			socket.close();
			outputStream.close();
			inputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
	}
	
	public static ArrayList<Integer> firstList() {
		ArrayList<Integer> fList = new ArrayList<Integer>();
		String num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number(“!” to send):");
		do{
			try{
				num = sc.nextLine();
				if(num == "!"){
					break;
				} else {
					fList.add(Integer.parseInt(num));
				}

				System.out.println("Enter a number(“!” to send):");
				
			}catch(InputMismatchException ex){
				System.out.println("Please enter a number:");
			}
		}while(sc.hasNextInt());
		
		sc.close();
		
		return fList;
	}
	
}
