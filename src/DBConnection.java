import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection 
{
    public static Connection dbConn;
    
        public static Connection getConnection()
        {
            Connection conn = null;
            try {
                String user = "c##javadba"; 
                String pw = "root";
                String url = "jdbc:oracle:thin:@localhost?TNS_ADMIN=C:\\app\\admin\\product\\18.0.0\\dbhomeXE\\network\\admin";
                
                Class.forName("oracle.jdbc.driver.OracleDriver");        
                conn = DriverManager.getConnection(url, user, pw);
                
                System.out.println("Database�� ����Ǿ����ϴ�.\n");
                
            } catch (ClassNotFoundException cnfe) {
                System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
            } catch (SQLException sqle) {
                System.out.println("DB ���ӽ��� : "+sqle.toString());
            } catch (Exception e) {
                System.out.println("Unknown error");
                e.printStackTrace();
            }
            return conn;     
        }
}


