import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class saveData {
	public void DBcon(String name, String id, String pw) {
		   Connection conn = null; // DB����� ����(����)�� ���� ��ü
	       PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
	       ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
	       Client C = new Client();
	    
	       try {
	           // SQL ������ ����� ���� ������ ���Ǿ�(SELECT��)���
	           // �� ����� ���� ResulSet ��ü�� �غ��� �� �����Ų��.
	           String query = "insert into chatuser values(?,?,?)";
	           
	           conn = DBConnection.getConnection();
	           pstm = conn.prepareStatement(query);
	          
	           //id = C.setUserID(id);
	           //name = C.setUserName(name);
	          // password = C.setUserPasswd(pw.getSHA(userPasswd.getText()));
	           //pw = C.setUserPasswd(pw);
	           
	          // C.request(name,id,pw); // SS���� ���� ���� �����ϱ� ���� ��ҵ�!
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
