import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class saveData {
	public void DBcon(String name, String id, String pw) {
		   Connection conn = null; // DB연결된 상태(세션)을 담은 객체
	       PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
	       ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
	       Client C = new Client();
	    
	       try {
	           // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
	           // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
	           String query = "insert into chatuser values(?,?,?)";
	           
	           conn = DBConnection.getConnection();
	           pstm = conn.prepareStatement(query);
	          
	           //id = C.setUserID(id);
	           //name = C.setUserName(name);
	          // password = C.setUserPasswd(pw.getSHA(userPasswd.getText()));
	           //pw = C.setUserPasswd(pw);
	           
	          // C.request(name,id,pw); // SS에게 위의 정보 전달하기 위한 멧소드!
//	           String username = ;                 
//	           String userid = ;
//	           String passwd = ;
//	           
//	           passwd = pw.getSHA(passwd);
	           
	           //System.out.println(C.getUserPasswd());
	           pstm.setString(1, name);
	           pstm.setString(2, id);
	           pstm.setString(3, pw);
	            
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
