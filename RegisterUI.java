package ChattingProgramming;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

//import game.Cal;
import ChattingProgramming.registorDAO;
import ChattingProgramming.RegistorVO;


public class RegisterUI extends JFrame{
	
	JPanel idPanel,passPanel,namePanel,loginPanel; 
	JTextField userID,userName; // 유저 아이디, 유저 이름
	JPasswordField userPasswd; // 유저 패스워드
	JButton btnSubmit, btnCancel; // 가입 확인, 취소버튼
	JLabel lb1,lb2,lb3,lb4;
	
	public RegisterUI() {
		this.setTitle("Register");
		setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		
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
		
		btnSubmit.addActionListener(new MyAction());
		btnCancel.addActionListener(new MyAction());
	}
	
	class MyAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSubmit){
							
				String id = userID.getText();
				RegistorVO vo = new RegistorVO(userName.getText(), userID.getText(), userPasswd.getText()); // 여기서 전달 받음

				registorDAO dao = new registorDAO();
					if (dao.insert(vo)) {
					System.out.println("입력성공!!");
//						form.showMsg("입력성공!!");
//						form.setVisible(false);
//						mainView.setVisible(true);
//						play.setVisible(false);          
//					} 
//				else
//						.showMsg("이름을 입력해주세요");
//				
					}
				}
			else if(e.getSource() == btnCancel) {
				setVisible(false);
				getContentPane().removeAll();
				getContentPane().add(new MainUI());
				revalidate();
				repaint();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterUI();
		
	}

	

}