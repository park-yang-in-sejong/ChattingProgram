import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class charClient extends JFrame implements ActionListener, Runnable{

	JTextArea ta;
	JScrollPane scrol_ta;
	JTextField tf_send;
	
	Socket s;
	
	//소켓 입출력 객체
	Scanner in;  // from 서버
	OutputStream out; // to 서버
	
	public charClient() {
		setTitle("대화방");
		
		ta = new JTextArea();
		scrol_ta = new JScrollPane(ta); // 스크롤이 지원되는 textarea
		
		tf_send = new JTextField();
					
		add("Center",scrol_ta);
		add("South",tf_send);
		
		setBounds(200,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		connect();

//		Thread t - new Thread(this);
//		t.start(); // 이거해도 되고 아래한줄해도되고
		new Thread(this).start();
		
		tf_send.addActionListener(this);
		// 텍스트필드에 엔터가 입력되는 것을 감시

		
	}//생성자

	
	// 서버에 접속
	public void connect() {
		try {
			//3. 서버에 접속
			s = new Socket("192.168.134.128", 5000);
			
			// 4.소켓 입출력 객체 생성
			in = new Scanner(s.getInputStream());
			out = s.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("액션");
		String str = tf_send.getText();
		str= str+ "\n"; // 라인 구분, 데이터 구분
		
		try {
			//5. 서버에게 write()
			out.write(str.getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		tf_send.setText(""); // 전달된 데이터 초기화시켜줌
	}
	
	// 8.서버가 보내는 메시지를 받아서 TextArea 출력~!!
	@Override
	public void run() {
		while (true) {
			String msg = in.nextLine();
			ta.append(msg+"\n");
			
			// 스크롤바 따라 내려오게 하려고
			ta.setCaretPosition(ta.getText().length());
		}
	}
	
	public static void main(String[] args) {
		new charClient();
	}
}
