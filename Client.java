import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws Exception {
		//3. �������Ͽ� ���� �õ�
//		Socket s = new Socket(String host,int port);
		Socket s = new Socket("169.254.168.153", 5000);
	}
}
