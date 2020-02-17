package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectSampleServlet1
 */
@WebServlet("/Blog_stringServlet")
public class Blog_stringServlet extends HttpServlet {

		//家用
		public static final String DB_NAME = "sgt";
		public static final String HOST_NAME = "localhost:3306";
		public static final String USER_NAME = "root";
		public static final String USER_PASS = "0423";
		public static final String URL = "jdbc:mysql://" + HOST_NAME + "/" + DB_NAME + "?serverTimezone=JST";


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String blog = null;
		String date = null;
		String title = null;


		String gettitle = request.getParameter("title");
		System.out.println(gettitle);
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/web?serverTimezone=JST",
//					"root", "yassan5800");

			//家用
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM blog where title='" + gettitle + "'");

			while (rs.next()) {
				date = rs.getString("date");
				title = rs.getString("title");
				blog = rs.getString("blog_string");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				}
			}
		}

		System.out.println(blog);

		request.setAttribute("date", date);
		request.setAttribute("title", title);
		request.setAttribute("blog", blog);

		String path = "/blog_string.jsp"; // フォワード先
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}