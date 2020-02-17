package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiaryContent
 */
@WebServlet("/DiaryContent")
public class DiaryContent extends HttpServlet {

	//学校用
	/*
	public static final String DB_NAME = "webapp2019_sgt2";
	public static final String HOST_NAME = "10.15.121.37:3306";
	public static final String USER_NAME = "user_sgt2";
	public static final String USER_PASS = "sgt2";
	*/

	//家用
	public static final String DB_NAME = "sgt";
	public static final String HOST_NAME = "localhost:3306";
	public static final String USER_NAME = "root";
	public static final String USER_PASS = "0423";
	public static final String URL = "jdbc:mysql://" + HOST_NAME + "/" + DB_NAME + "?serverTimezone=JST";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String servlet_title = request.getParameter("diary_title");
		String posted = request.getParameter("posted");

		//String flag=request.getParameter("s_flag");
		//System.out.println("postedは" + posted);
		//System.out.println("flagは" + flag);

		if (posted.equals("diary_post")) {

			String content = request.getParameter("diary_content");


			// PreparedStatement ps = null;

			try {
				//学校用
				//Class.forName("org.mariadb.jdbc.Driver");

				//家用
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);

				Statement stmt = conn.createStatement();

				String sql = "update blog set blog_string= '" + content + "' where title= '" + servlet_title + "'";

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

		} else {
			try {

				//学校用
				//Class.forName("org.mariadb.jdbc.Driver");

				//家用
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);

				Statement stmt = conn.createStatement();

				String sql = "delete from blog where title = '" + servlet_title + "'";
				int num = stmt.executeUpdate(sql);
				System.out.println("削除件数" + num);

			} catch (Exception ex) {
				System.out.println("error");
			}
		}

		String path = "/Testsql.java"; // フォワード先
	    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	    dispatcher.forward(request, response);

	}

}