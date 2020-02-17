package diary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testsql
 */
@WebServlet("/Testsql")
public class Testsql extends HttpServlet {
	private static final long serialVersionUID = 1L;

		//家用
		public static final String DB_NAME = "sgt";
		public static final String HOST_NAME = "localhost:3306";
		public static final String USER_NAME = "root";
		public static final String USER_PASS = "0423";
		public static final String URL = "jdbc:mysql://" + HOST_NAME + "/" + DB_NAME + "?serverTimezone=JST";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"/>");
		out.println("<title>aaa</title>");
		out.println("</head>");
		out.println("<body>");
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				//String blog = null;
				try {

//					Class.forName("com.mysql.jdbc.Driver");
//					conn = DriverManager.getConnection(
//							"jdbc:mysql://localhost:3306/web?serverTimezone=JST",
//						"root", "yassan5800");

					//家用
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
					stmt = conn.createStatement();
					rs = stmt.executeQuery("SELECT * FROM blog");


					while (rs.next()) {
							String title =rs.getString("title");
							String date =rs.getString("date");
							String blog =rs.getString("blog_string");
							out.println("<form action=\"Blog_stringServlet\" method=\"post\">");
							//out.println(title);
							out.println("<input type=\"submit\" name="+title+" value="+ title+">");
							System.out.println(title);
							out.println("<input type=\"hidden\" id=\"title\" name=\"title\" value="+ title +">");
							out.println("<input type=\"hidden\" id=\"date\" name=\"date\" value="+ date +">");
							out.println("<input type=\"hidden\" id=\"blog\" name=\"blog\" value="+ blog +">");
							out.println("</form>");
					}
					out.println("<input type=\"button\" value=\"新規投稿\" onclick=\"location.href='./new_post.jsp'\">");

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
		out.println("</body>");
		out.println("</html>");
		}

}
