import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;


public class RegisterUI extends JFrame{
	
	JPanel idPanel,passPanel,namePanel,loginPanel; 
	JTextField userID,userName; // 유저 아이디, 유저 이름
	JPasswordField userPasswd; // 유저 패스워드
	JButton btnSubmit, btnCancel; // 가입 확인, 취소버튼
	JLabel lb1,lb2,lb3,lb4;
	
	public RegisterUI() {
		this.setTitle("Register");
		setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		EtchedBorder eborder = new EtchedBorder();
		
		lb1 = new JLabel("User Register");
		lb1.setFont(new Font("맑은 고딕",Font.BOLD,25));
		add(lb1);
		
		namePanel = new JPanel();
		idPanel = new JPanel();
		passPanel = new JPanel();
		
		lb2 = new JLabel("Name        ");
		lb3 = new JLabel("ID               ");
		lb4 = new JLabel("Password");
		
		userName = new JTextField(10);
		userID = new JTextField(10);
		userPasswd = new JPasswordField(10);
		
		namePanel.add(lb2);
		namePanel.add(userName);
		idPanel.add(lb3);
		idPanel.add(userID);
		passPanel.add(lb4);
		passPanel.add(userPasswd);
		
		loginPanel = new JPanel();
		btnSubmit = new JButton("Submit");
		btnCancel = new JButton("Cancel");
		
		loginPanel.add(btnSubmit);
		loginPanel.add(btnCancel);
		add(namePanel);
		add(idPanel);
		add(passPanel);
		add(loginPanel);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterUI();
		
	}

	

}
