import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static final int PORT = 1337;

	
	public static void main(String[] args) throws ClassNotFoundException {		
		System.out.println("running server!");
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;		
		try {
			serverSocket = new ServerSocket(PORT);
			
			socket = serverSocket.accept();
			
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			
			// Always flush an object output stream preemptively (see docs).
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			@SuppressWarnings("unchecked")
			ArrayList<Integer> alist = (ArrayList<Integer>)inputStream.readObject();
			
			System.out.println("Received: " + alist);

			

			outputStream.writeObject(primeChecker(alist));
			outputStream.flush();
		
			socket.close();
			outputStream.close();
			inputStream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("server finished");
	}
	
	public static ArrayList<Integer> primeChecker(ArrayList<Integer> aList) {
		ArrayList<Integer> pList = new ArrayList<Integer>();
		
		for(int i : aList) {
    		if(isPrime(i)) {
    			pList.add(i);
    			}
		}
		return pList;
	}
	
	static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}