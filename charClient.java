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
	
	//���� ����� ��ü
	Scanner in;  // from ����
	OutputStream out; // to ����
	
	public charClient() {
		setTitle("��ȭ��");
		
		ta = new JTextArea();
		scrol_ta = new JScrollPane(ta); // ��ũ���� �����Ǵ� textarea
		
		tf_send = new JTextField();
					
		add("Center",scrol_ta);
		add("South",tf_send);
		
		setBounds(200,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		connect();

//		Thread t - new Thread(this);
//		t.start(); // �̰��ص� �ǰ� �Ʒ������ص��ǰ�
		new Thread(this).start();
		
		tf_send.addActionListener(this);
		// �ؽ�Ʈ�ʵ忡 ���Ͱ� �ԷµǴ� ���� ����

		
	}//������

	
	// ������ ����
	public void connect() {
		try {
			//3. ������ ����
			s = new Socket("192.168.134.128", 5000);
			
			// 4.���� ����� ��ü ����
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
		//System.out.println("�׼�");
		String str = tf_send.getText();
		str= str+ "\n"; // ���� ����, ������ ����
		
		try {
			//5. �������� write()
			out.write(str.getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		tf_send.setText(""); // ���޵� ������ �ʱ�ȭ������
	}
	
	// 8.������ ������ �޽����� �޾Ƽ� TextArea ���~!!
	@Override
	public void run() {
		while (true) {
			String msg = in.nextLine();
			ta.append(msg+"\n");
			
			// ��ũ�ѹ� ���� �������� �Ϸ���
			ta.setCaretPosition(ta.getText().length());
		}
	}
	
	public static void main(String[] args) {
		new charClient();
	}
}
