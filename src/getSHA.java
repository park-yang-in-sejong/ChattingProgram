import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class getSHA {
	public static String getSHA(String text) {
		try {
        	MessageDigest md = MessageDigest.getInstance("SHA-256");
        	
        	byte[] messageDigest = md.digest(text.getBytes());
        	BigInteger no = new BigInteger(1, messageDigest);
        	String hashtext = no.toString(16);
        	
        	while(hashtext.length() < 32) {
        		hashtext = "0"+hashtext;
        	}
        	
        	return hashtext;
        }
		catch(NoSuchAlgorithmException e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
			
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getSHA pw = new getSHA();
	}

}
