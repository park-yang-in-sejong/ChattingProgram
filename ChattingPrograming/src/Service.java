import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class Service extends Thread{ // 소켓 입출력 서비스
	
	Scanner in;
	OutputStream out;
	Vector<Service> v;
	
	public Service(Socket s, Vector<Service> v) {
		this.v = v;
		
		try {
			// 4.소켓 입출력 객체 생성
			in = new Scanner(s.getInputStream());
			out = s.getOutputStream();
			
			start();
			//run();
		} catch (IOException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
	}

	//6. from 클라이언트 (클라이언트에서 전달한 메시지 읽기)
	public void run() {
		//while(true) {
		
			//String msg = in.nextLine();
			//msg = msg+"\n";
			
			//toMsgAll(msg);
		//}
	}
	public void toMsgAll(String msg) { // 전체 접속 클라이언트에게 메시지 보내기
		for (int i = 0; i < v.size(); i++) {// 접속한 클라이언트 수만큼 반복
			try {
				v.get(i).toMsg(msg);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void toMsg(String msg) throws IOException { // 실제 한개 한개의 클라이언트에게 메시지 보내기
		//7. 서버 ---> 클라이언트
		out.write(msg.getBytes());
	}
}
