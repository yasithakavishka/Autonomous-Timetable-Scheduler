package TTGS.Login;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class LOGIN {
	String url, url1, to;
	String from = getClass().getResource("/resources/TTGS.accdb").toString();          ///////////////////
	String error;
	String hd = System.getenv("HOMEDRIVE");
	String hp = System.getenv("HOMEPATH");
	String tp = hd + hp;
	File db;
	boolean PASSF, USERF, userVal = false;

	public LOGIN() {
		db = new File(tp + "/Local Settings/Temp/TTGS");
		if (!db.isDirectory())
			if (db.mkdir()) {/* System.out.println("Created..."); */
			}
		if (from.contains("jar:")) {
			url1 = from;
			url1 = url1.substring(6 + 4);
			url1 = url1.replaceAll("%20", " ");
			url1 = url1.substring(0, url1.indexOf("!"));
			CopyFile();
		} else {
			url1 = from;
			url1 = url1.substring(6);
			url1 = url1.replaceAll("%20", " ");
			url = "jdbc:ucanaccess://C:\\Users\\Pc\\Documents\\NetBeansProjects\\CO328_Proj\\src\\resources\\TTGS.accdb";
		}
		error = "";
	}

	public void CopyFile() {
		File fo = new File(db.getPath() + "/TTGS.accdb");                   ///////////////
		OutputStream fos;
		try {
			JarFile jf = new JarFile(url1);
			JarEntry je = jf.getJarEntry("resources/TTGS.accdb");            //////////////////
			InputStream ins = jf.getInputStream(je);
			fos = new DataOutputStream(new FileOutputStream(fo));
			int eof = 0;
			eof = ins.read();
			while (eof != -1) {
				fos.write(eof);
				//System.out.println("b:" + eof);
				eof = ins.read();
			}
			//System.out.println(" eof:" + eof);
			ins.close();
			fos.close();
			from = fo.getPath();
			// System.out.println(from);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		url1 = from;
		url1 = url1.replaceAll("%20", " ");
		url = "jdbc:ucanaccess://C:\\Users\\Pc\\Documents\\NetBeansProjects\\CO328_Proj\\src\\resources\\TTGS.accdb";    //////////////////
	}

	public User CHECK(User luser) {
		User user = new User();
                //System.out.println("here");
		try {
                        //System.out.println("here1");
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");            
                        //System.out.println("here2");
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			String eks = "SELECT * FROM LOGIN";
			ResultSet rs = stmt.executeQuery(eks);
			while (rs.next()) {
				user.setUserName(rs.getString("LOGINNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setType(rs.getString("TYPE"));

				if (luser.getUserName().equals(user.getUserName())) {            
					USERF = true;// user name is right
					if (luser.getPassword().equals(user.getPassword())) {
						PASSF = true;// user password is right
						break;
					} else {
						PASSF = false;// user password is wrong
						break;
					}
				} else
					USERF = false;// user name is wrong
			}
			stmt.close();
			con.close();
			if (PASSF == true && USERF == true) {
				error = "Welcome to TTGS >> " + user.getName() + " : " + user.getType();
				userVal = true;
				return user;
			} else {
				error = "Sorry try again ! ";
				return user;
			}
		/*} catch (ClassNotFoundException cls) {
			error = "Error >> " + "Cannot Find Driver";*/
		} catch (SQLException ql) {
			PASSF = false;
			USERF = false;
			error = "Error >> " + ql.getErrorCode() + " : " + ql.getMessage();
		}
		return null;
	}

	public boolean isValid() {
		return userVal;
	}

	public String getMsg() {
		return error;
	}
}
