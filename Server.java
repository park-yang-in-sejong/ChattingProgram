import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{

	//1. 서버소켓객체 생성
	ServerSocket ss;
	
	// 벡터는 어레이리스트랑 똑같음
	Vector<Service> v; // 접속한 클라이언트 정보들을 저장, 관리
	
	public Server() {
	
		v = new Vector<Service>();
	try {
		//ss = new ServerSocket(포트);
		ss = new ServerSocket(5000);
		System.out.println("서버 시작...");
		
		start();
		
		
		
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}// 생성자
	
	
	public void run() {
		try {
			
			while (true) {
				//2. 생성을 했더라면, 클라이언트 접속 대기
				//ss.accept(); // 서버 소켓이 클라이언트 기다림
				Socket s = ss.accept(); // 들어온 클라이언트 받음
				
				Service serv = new Service(s,v); // 접속 클라이언트 수라 똑같다함
				// 서비스는 소켓정보와 벡터정보도 같이 전달을 해야
				
				v.add(serv); // 벡터에다가 집어넣음!!
				
				InetAddress ia = s.getInetAddress();
				System.out.println("클라이언트 접속 성공!!"+ ia.getHostAddress());
			
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
