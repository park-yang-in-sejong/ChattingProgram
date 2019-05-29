import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
   String userName;
   String userID;
   String userPasswd;

   public static void main(String[] args) throws Exception {
   //   Socket s = new Socket("172.16.24.102", 5000);
      

   }

   public String getUserName() {
      return userName;
   }

   String setUserName(String userName) {
      return userName;
   }

   public String getUserID() {
      return userID;
   }

   String setUserID(String userID) {
	  return userID;
   }

   public String getUserPasswd() {
      return userPasswd;
   }

   String setUserPasswd(String userPasswd) {
      return userPasswd;
   }

   public void request(String userName, String userID, String userPasswd) {
      
      try {
      Socket s = new Socket("172.16.21.240", 5000);
      
      	//ArrayList list;
//      
      	//list.add(getUserName());
      	//list.add(userID);
      	//list.add(getUserPasswd());
//      
      String[] list = new String[3];
      list[0] = userName;
      list[1] = userID;
      list[2] = userPasswd;
      
      
      OutputStream out = s.getOutputStream();
      InputStream in = s.getInputStream();
   
      PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
      int i = 0;
      String line = null;
      
      while (i != 3) {
    	 
    	 line = list[i];
    	 
         // 6. PrintWriter에 있는 println() 메소드를 이용해 서버에게 전송

         pw.println(line);
         pw.flush();

         // 7. 서버가 다시 반환하는 문자열을 BufferedReader에 있는

         // readLine()을 이용해서 읽어들임

         String echo = br.readLine();

         System.out.println("서버로부터 전달받은 문자열 :" + echo);
         i++;
      }
      
      // pw.close();
      // br.close();
      // s.close();   
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
}