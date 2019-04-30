import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{

	//1. �������ϰ�ü ����
	ServerSocket ss;
	
	// ���ʹ� ��̸���Ʈ�� �Ȱ���
	Vector<Service> v; // ������ Ŭ���̾�Ʈ �������� ����, ����
	
	public Server() {
	
		v = new Vector<Service>();
	try {
		//ss = new ServerSocket(��Ʈ);
		ss = new ServerSocket(5000);
		System.out.println("���� ����...");
		
		start();
		
		
		
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}// ������
	
	
	public void run() {
		try {
			
			while (true) {
				//2. ������ �ߴ����, Ŭ���̾�Ʈ ���� ���
				//ss.accept(); // ���� ������ Ŭ���̾�Ʈ ��ٸ�
				Socket s = ss.accept(); // ���� Ŭ���̾�Ʈ ����
				
				Service serv = new Service(s,v); // ���� Ŭ���̾�Ʈ ���� �Ȱ�����
				// ���񽺴� ���������� ���������� ���� ������ �ؾ�
				
				v.add(serv); // ���Ϳ��ٰ� �������!!
				
				InetAddress ia = s.getInetAddress();
				System.out.println("Ŭ���̾�Ʈ ���� ����!!"+ ia.getHostAddress());
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}

}
