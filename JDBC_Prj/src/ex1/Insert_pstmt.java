
package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Insert_pstmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "TEST2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO notice (title,  writer_id,   content,  files) VALUES (?, ?, ?, ?)";
				
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "newlec", "1234");
//		Statement st = con.createStatement();
//		st.executeQuery(sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
//		preparedstatement의 parameter index는 1부터 시작한다. 
		pstmt.setString(2, writerId);
		pstmt.setString(3, content);
		pstmt.setString(4, files);
		
		int result = pstmt.executeUpdate();
//		preparedstatement의 executeUpdate 메소드는 적용된 행의 갯수를 반환한다. 
		
		System.out.println(result);
		
		pstmt.close();
		con.close();

	} // main

} // Insert_pstmt
