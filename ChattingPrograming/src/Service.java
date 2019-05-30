import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Service extends Thread{ // ���� ����� ����
	
	Scanner in;
	OutputStream out;
	Vector<Service> v;
	
	public Service(Socket s, Vector<Service> v) {
		this.v = v;
		
		try {
			// 4.���� ����� ��ü ����
			in = new Scanner(s.getInputStream());
			out = s.getOutputStream();
			
			start();
			//run();
		} catch (IOException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
	}

	//6. from Ŭ���̾�Ʈ (Ŭ���̾�Ʈ���� ������ �޽��� �б�)
	public void run() {
		//while(true) {
		
			//String msg = in.nextLine();
			//msg = msg+"\n";
			
			//toMsgAll(msg);
		//}
	}
	public void toMsgAll(String msg) { // ��ü ���� Ŭ���̾�Ʈ���� �޽��� ������
		for (int i = 0; i < v.size(); i++) {// ������ Ŭ���̾�Ʈ ����ŭ �ݺ�
			try {
				v.get(i).toMsg(msg);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void toMsg(String msg) throws IOException { // ���� �Ѱ� �Ѱ��� Ŭ���̾�Ʈ���� �޽��� ������
		//7. ���� ---> Ŭ���̾�Ʈ
		out.write(msg.getBytes());
	}
}
