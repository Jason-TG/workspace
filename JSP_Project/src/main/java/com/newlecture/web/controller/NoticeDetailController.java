package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;


@WebServlet("/notice/detail")

public class NoticeDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "1234");
			PreparedStatement pstmt = con.prepareStatement(sql);
			/* preparedStatement�� Statement�� �ٸ��� ���� �ÿ� �̸� �������� �غ��Ѵ�.  */
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regdate = rs.getDate("REGDATE");
			String hit = rs.getString("HIT");
			String files = rs.getString("FILES");
			String content = rs.getString("CONTENT");
			
			Notice notice = 	new Notice(id, title, writerId, regdate, hit, files, content); 

			request.setAttribute("n", notice);
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // t-c{}
		
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp")
		.forward(request, response);

	} // doGet()
	
} // NoticeDetailController()























