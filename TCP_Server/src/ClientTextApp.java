import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This method launch the frame and manage the connection to the server.
 * 
 * @author Izzah Hayati
 * 
 *
 */

public class ClientTextApp {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		// Launch client-side frame
		ClientTextFrame clientTextFrame = new ClientTextFrame();
		clientTextFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4338
		Socket socket = new Socket(InetAddress.getLocalHost(), 4338);
		
		// Update the status of the connection
		clientTextFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		DataInputStream inputstream = new DataInputStream(socket.getInputStream());
		
		// Display the total words
		int totalword  = inputstream.readInt();
		clientTextFrame.updateText(totalword);
		
		// Close everything
		socket.close();

	}
}