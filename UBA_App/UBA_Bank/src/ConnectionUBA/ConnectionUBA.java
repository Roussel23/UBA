package ConnectionUBA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionUBA {
	Connection Con=null;
	public ConnectionUBA(){
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		Con=DriverManager.getConnection("jdbc:mysql://localhost/uba_bank","root","");
	//	JOptionPane.showMessageDialog(null, "Connection Etablie");
	
		}catch(Exception e) {
		JOptionPane.showMessageDialog(null,e.getMessage(), "Connection Etablie",JOptionPane.ERROR_MESSAGE);
	}

	}
	
	
	
	public static String doHashing(String password) {
		try {
		MessageDigest messageDigest=MessageDigest.getInstance("MD5");
		messageDigest.update(password.getBytes());
		byte[] resultByteArray=messageDigest.digest();
		StringBuilder sb=new StringBuilder();
		
		for(byte b:resultByteArray) {
			sb.append(String.format("%02x",b));
		}
		return sb.toString();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		
		
	}
	

	public Connection getConnection() {
		return Con;
	}
	public void Deconnect() {
		try {
			Con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

