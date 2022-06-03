import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server generates number of words .
 * Each connected client will received total word from the server.
 * 
 * @author Izzah Hayati
 *
 */

public class ServerTextApp {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerTextFrame serverFrame = new ServerTextFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4338;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		WordGenerator wordGenerator = new WordGenerator();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		String sentences = "My mother's name is Hasiah.";
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Generate current word
			int countWord = wordGenerator.countTotalWords(sentences);
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current date back to the client
			outputStream.writeInt(countWord);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + countWord);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );		
		}
	}
}