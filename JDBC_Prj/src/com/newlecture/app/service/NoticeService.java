
package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.app.service.entity.Notice;

public class NoticeService {

	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String userid = "newlec";
	private String passwd = "1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<Notice> getList(int page)
			throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM NOTICE_VIEW "
				+ "WHERE NUM BETWEEN ? AND ?";
		
		int start = 1 + (page-1)*10; // 1, 11, 21, 31
//		등차수열 식 : a1 + (n-1)*d || a1:초항, n:차수, d:각 항의 차
		int end = 10*page; // 10, 20, 30, 40

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userid, passwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();

		List<Notice> list = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");

			Notice notice = new Notice(id, title, writerId, regDate, content, hit, files);

			list.add(notice);

		} // while

		rs.close();
		pstmt.close();
		con.close();

		return list;

	} // getList()
	
	public int getCount() 
			throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
		
		int count=0;

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userid, passwd);
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);

		List<Notice> list = new ArrayList<>();
		
		if(rs.next())
		count = rs.getInt("COUNT");

		rs.close();
		st.close();
		con.close();

		return count;

		
	} // getCount()

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();

		String sql = "INSERT INTO notice (title,  writer_id,   content,  files) VALUES (?, ?, ?, ?)";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userid, passwd);

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writerId);
		pstmt.setString(3, content);
		pstmt.setString(4, files);

		int result = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return result;
	} // insert(Notice notice)

	public int update(Notice notice) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE notice SET title = ?, content = ?, files = ? " + "WHERE ID = ?";

		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userid, passwd);

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, files);
		pstmt.setInt(4, id);

		int result = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return result;
	} // update(Notice notice)

	public int delete(int id) throws SQLException, ClassNotFoundException {

		String sql = "DELETE NOTICE WHERE ID = ?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userid, passwd);

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);

		int result = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return result;

	} // delete(int id)



 
} // NoticeService{}




















