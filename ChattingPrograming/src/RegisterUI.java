import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.driver.OracleDriver;

public class RegisterUI extends JFrame{
   
   JPanel idPanel,passPanel,namePanel,loginPanel; 
   JTextField userID,userName; // 유저 아이디, 유저 이름
   JPasswordField userPasswd; // 유저 패스워드
   JButton btnSubmit, btnCancel; // 가입 확인, 취소버튼
   JLabel lb1,lb2,lb3,lb4;
   String id,name,psw;
   
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
    	 Client C = new Client();
         getSHA pw = new getSHA();
         
         if(e.getSource() == btnSubmit){
        	  Connection conn = null; // DB연결된 상태(세션)을 담은 객체
              PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
              ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
              
              try {
                  // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
                  // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
                  String query = "insert into chatuser values(?,?,?)";
                  
                  conn = DBConnection.getConnection();
                  pstm = conn.prepareStatement(query);
                 
                  id = C.setUserID(userID.getText());
                  name = C.setUserName(userName.getText());
                  psw = C.setUserPasswd(pw.getSHA(userPasswd.getText()));
                  
                  C.request(name,id,psw); // SS에게 위의 정보 전달하기 위한 멧소드!
//                  String username = ;                 
//                  String userid = ;
//                  String passwd = ;
//                  
//                  passwd = pw.getSHA(passwd);
                  
                  //System.out.println(C.getUserPasswd());
                  pstm.setString(1, name);
                  pstm.setString(2, id);
                  pstm.setString(3, psw);
                   
                  pstm.executeUpdate();
                   
                  System.out.println("Complete to insert data");
                  
              } catch (SQLException sqle) { 
                  sqle.printStackTrace();
                  
              }finally{
                  // DB 연결을 종료한다. 
                  try{
                      if ( rs != null ){rs.close();}   
                      if ( pstm != null ){pstm.close();}   
                      if ( conn != null ){conn.close(); }
                  }catch(Exception ex){
                      throw new RuntimeException(ex.getMessage());
                  }
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
      RegisterUI re = new RegisterUI();
      
   }
}