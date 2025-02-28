import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		// You can use print statements as follows for debugging, they'll be visible
		// when running tests.
		System.err.println("Logs from your program will appear here!");

//		-- YOUR CODE HERE --		//
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		int port = 9092;
		try {
			serverSocket = new ServerSocket(port);

			// Since the tester restarts your program quite often, setting SO_REUSEADDR
			// ensures that we don't run into 'Address already in use' errors
			serverSocket.setReuseAddress(true);

			// Wait for connection from client.
			clientSocket = serverSocket.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null && !line.isEmpty()) {
				System.err.println("******* "+line); // Print each header line
//				OutputStream outputStream = clientSocket.getOutputStream();
//				outputStream.write(new byte[] { 0, 0, 0, 7 });
//				outputStream.write(new byte[] { 0, 0, 0, 0 });
			}

		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
		} finally {
			try {
				if (clientSocket != null) {
					clientSocket.close();
				}
			} catch (IOException e) {
				System.err.println("IOException: " + e.getMessage());
			}
		}
	}
}
