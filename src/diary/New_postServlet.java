package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class New_postServlet
 */
@WebServlet("/New_postServlet")
public class New_postServlet extends HttpServlet {

	//家用
	public static final String DB_NAME = "sgt";
	public static final String HOST_NAME = "localhost:3306";
	public static final String USER_NAME = "root";
	public static final String USER_PASS = "0423";
	public static final String URL = "jdbc:mysql://" + HOST_NAME + "/" + DB_NAME + "?serverTimezone=JST";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String servlet_title = request.getParameter("title");
		String posted = request.getParameter("posted");
		String servlet_date = request.getParameter("date");
		String servlet_content = request.getParameter("diary_content");

		if (posted.equals("new_post")) {


			try {
				//学校用
				//Class.forName("org.mariadb.jdbc.Driver");

				//家用
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
				Statement stmt = conn.createStatement();
				String sql = "insert into blog values('" + servlet_title + "','"+servlet_date+"','"+servlet_content+"')";
				stmt.executeUpdate(sql);


				//System.out.println("更新件数" + num);
				/*
				 * ps = conn.prepareStatement(sql);
				 *
				 * ps.setString(1, content);
				 */

			} catch (Exception ex) {
				System.out.println("error");
			}

		}

		String path = "/new_post.jsp"; // フォワード先
	    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	    dispatcher.forward(request, response);

	}

}
