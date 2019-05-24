import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainUI extends JFrame{
	
	JPanel idPanel,passPanel,loginPanel; 
	JTextField userID; // ���� ���̵�, ���� �̸�
	JPasswordField userPasswd; // ���� �н�����
	JButton btnLogin, btnRegister; // ���� Ȯ��, ��ҹ�ư
	JLabel lb1,lb2,lb3;
	String dbName,dbPassword,dbuserID;
	boolean check;
	
	public MainUI() {
		setTitle("Chatting Program");
		
		setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
		
		lb1 = new JLabel("Chatting Program");
		lb1.setFont(new Font("���� ���",Font.BOLD,25));
		
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
		btnLogin.addActionListener(new MyAction());
		btnRegister.addActionListener(new MyAction());
		
		
	}
	
	class MyAction implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnLogin){
				Connection conn = null; // DB����� ����(����)�� ���� ��ü
		        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
		        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
		        
		        try {
		        	String userid = userID.getText();
		            String passwd = userPasswd.getText();
		            String query = "select name,id,password from chatuser";
		            
		            conn = DBConnection.getConnection();
		            pstm = conn.prepareStatement(query);
		            
		            rs = pstm.executeQuery();
	                while(rs.next()) {
	                	dbName = rs.getString(1);
	                	dbuserID = rs.getString(2);
	                	dbPassword = rs.getString(3);
	                	
	                	if(dbuserID.equalsIgnoreCase(userid)) {
	                		if(dbPassword.equalsIgnoreCase(passwd))
	                		{
	                			System.out.println("Login Success");
	                			charClient st = new charClient();
	                			check = true;
	                		}
	                		else {
	                			System.out.println("Login Fail");
	                			check = false;
	                		}
	                	}
	                }
	                if(!check) {
	                	System.out.println("Login Fail");
	                }
	                
	                
		        } catch (SQLException sqle) {
		            sqle.printStackTrace();
		            
		        }finally{
		            // DB ������ �����Ѵ�.
		            try{
		                if ( rs != null ){rs.close();}   
		                if ( pstm != null ){pstm.close();}   
		                if ( conn != null ){conn.close(); }
		            }catch(Exception ex){
		                throw new RuntimeException(ex.getMessage());
		            }
		        }
			}
			else if(e.getSource() == btnRegister) {
				setVisible(false);
				getContentPane().removeAll();
				getContentPane().add(new RegisterUI());
				revalidate();
				repaint();
			}	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainUI start = new MainUI();
	}
}


