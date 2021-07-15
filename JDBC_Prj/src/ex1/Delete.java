
package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int id = 274;

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "newlec", "1234");

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);

		int result = pstmt.executeUpdate();

		System.out.println(result);

		pstmt.close();
		con.close();

	} // main

} // Delete
