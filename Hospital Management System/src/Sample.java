import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Sample {
	static Connection conn=null;
	static Statement stmt=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	//using oracle
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","2820");
			stmt = conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT DEPT_NAME FROM Department_details ORDER BY dept_no ASC");
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
