package diary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectSampleServlet
 */
@WebServlet("/InsertSampleServlet")
public class DiaryServlet extends HttpServlet {

	/*
		public static final String HOST_NAME = "10.15.121.37:3306";
		public static final String DB_NAME   = "webapp2019_sgt2";
		public static final String USER_NAME = "user_sgt2";
		public static final String USER_PASS = "sgt2";
	*/

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ret = 0;

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://10.15.121.37:3306/webapp2019_sgt2?serverTimezone=JST",
				"user_sgt2"," sgt2");
				Statement stmt = conn.createStatement()) {
		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>投稿完了画面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + ret + "件の投稿が完了しました。</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
