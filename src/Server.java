import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{

	//1. �������ϰ�ü ����
	ServerSocket ss;
	BufferedReader br;
	
	int i = 0;
	// ���ʹ� ��̸���Ʈ�� �Ȱ���
	//Vector<Service> v; // ������ Ŭ���̾�Ʈ �������� ����, ����
	
	public Server() {
	
		//v = new Vector<Service>();
	try {
		ServerSocket ss = new ServerSocket(5000);
		Socket socket = ss.accept();
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		saveData sd = new saveData();
		String[] message = new String[3];
		
		while(i != 3) {
		//ss = new ServerSocket(��Ʈ);		
			message[i] = bufReader.readLine();
			
			System.out.println("Message : " + message[i]);
			System.out.println("���� ����...");
			i++;
		//start();
		//run();
		}
		
		sd.DBcon(message[0], message[1], message[2]);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}// ������
	
	/*
	public void run() {
		try {
			while (true) {
				//2. ������ �ߴ����, Ŭ���̾�Ʈ ���� ���
				//ss.accept(); // ���� ������ Ŭ���̾�Ʈ ��ٸ�
				Socket s = ss.accept(); // ���� Ŭ���̾�Ʈ ����
				
				//Service serv = new Service(s,v); // ���� Ŭ���̾�Ʈ ���� �Ȱ�����
				// ���񽺴� ���������� ���������� ���� ������ �ؾ�
				BufferedReader bufReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String message = bufReader.readLine();
				//v.add(serv); // ���Ϳ��ٰ� �������!!
				System.out.println("Message : " + message);
				//InetAddress ia = s.getInetAddress();
				//System.out.println("Ŭ���̾�Ʈ ���� ����!!"+ ia.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public static void main(String[] args) {
		new Server();
	}

}
