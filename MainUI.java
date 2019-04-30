import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainUI extends JFrame{
	
	JPanel idPanel,passPanel,loginPanel; 
	JTextField userID; // 유저 아이디, 유저 이름
	JPasswordField userPasswd; // 유저 패스워드
	JButton btnLogin, btnRegister; // 가입 확인, 취소버튼
	JLabel lb1,lb2,lb3;
	
	public MainUI() {
		setTitle("Chatting Program");
		
		setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		
		
		lb1 = new JLabel("Chatting Program");
		lb1.setFont(new Font("맑은 고딕",Font.BOLD,25));
		
		add(lb1);
		
		idPanel = new JPanel();
		passPanel = new JPanel();
		
		lb2 = new JLabel("ID               ");
		lb3 = new JLabel("Password");
		
		userID = new JTextField(10);
		userPasswd = new JPasswordField(10);
		
		idPanel.add(lb2);
		idPanel.add(userID);
		passPanel.add(lb3);
		passPanel.add(userPasswd);
		
		loginPanel = new JPanel();
		btnLogin = new JButton("Login");
		btnRegister = new JButton("Register");
		
		loginPanel.add(btnLogin);
		loginPanel.add(btnRegister);
		add(idPanel);
		add(passPanel);
		add(loginPanel);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainUI();
	}

}
