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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String blog = null;
		//jspからタイトルをもってきたい
		String gettitle = request.getParameter("title");
		System.out.println(gettitle);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/web?serverTimezone=JST",
					"root", "yassan5800");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM blog where title='" + gettitle + "'");

			while (rs.next()) {
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

		request.setAttribute("blog", blog);

		String path = "/blog_string.jsp"; // フォワード先
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}