import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectSocket {
	private Socket _socket;
	private ObjectInputStream _inputStream;
	private ObjectOutputStream _outputStream;
	
	public ObjectSocket(Socket socket) {
		_socket = socket;
		
		try {
			_outputStream = new ObjectOutputStream(socket.getOutputStream());
			_outputStream.flush();
			
			_inputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Socket getSocket() {
		return _socket;
	}
	
	public ObjectInputStream getInputStream() {
		return _inputStream;
	}

	public ObjectOutputStream getOutputStream() {
		return _outputStream;
	}
}
