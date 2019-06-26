import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class extraClient {
	private static final int PORT = 1337;
	
	static ArrayList<Integer> list = new ArrayList<Integer>(randomList());
	
	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		
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
			Thread.sleep(1000);
			
					
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// Close resources in finally block so that they
			// get closed even if we hit an exception above.
			try {
				if (socket != null) {
					socket.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public static ArrayList<Integer> firstList() {
		ArrayList<Integer> fList = new ArrayList<Integer>();
		String num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter “!” to start and stop, “#” to quit:");
		do{
			try{
				num = sc.nextLine();
				if(num == "#"){
					break;
				} if(num == "!") {
					randomList();
				}

				System.out.println("Enter a number(“!” to send):");
				
			}catch(InputMismatchException ex){
				System.out.println("Enter “!” to start and stop, “#” to quit:");
			}
		} while(sc.hasNextInt());
		
		sc.close();
		
		return fList;
	}
	
	
	public static ArrayList<Integer> randomList() {
		ArrayList<Integer> randList = new ArrayList<Integer>(5);
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) {
			randList.add(rand.nextInt(97) +2 );
		}
		return randList;
	}
	
}


