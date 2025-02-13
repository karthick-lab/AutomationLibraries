package com.base;

//import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import com.driverfactory.DriverFactory;

public class Base extends DriverFactory {



	// get screen size using Java (Maximize window using java)

	public Dimension getscreensize() {
		Dimension screensize = new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		return screensize;
	}

	// maximize window using javascript

	public void maximizewindow() {
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("window.resizeTo(1024, 1024);");
	}

	public String getcurrentdatetime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hhmmss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.format(dtf));
		return now.format(dtf);
	}

	public void encoder(String password) {
		byte[] encoded = Base64.encodeBase64("test@123".getBytes());
		String cyphertext = new String(encoded);
		System.out.println("text: " + cyphertext);
	}
	
	public String decoder(String cyphertext) {
		byte[] decoded = Base64.decodeBase64(cyphertext.getBytes());
		String password = new String(decoded);
		System.out.println("password: " + password);
		return password;
	}
	
	public void DBConnectivity()
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/thinketl","Ambikashayee","Ambika@3012");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from EMPLOYEES");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
			con.close();  
			}
		catch(Exception e)
		{ 
			System.out.println(e);
			
		} 
	}
	
	



}
