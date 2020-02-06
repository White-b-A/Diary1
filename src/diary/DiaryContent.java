package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
	public static final String DB_NAME   = "webapp2019_sgt2";
	private final String URL = "jdbc:mysql://" + HOST_NAME + "/" + DB_NAME + "?serverTimezone=JST";
	public static final String HOST_NAME = "10.15.121.37:3306";
	public static final String USER_NAME = "user_sgt2";
	public static final String USER_PASS = "sgt2";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String date = request.getParameter("diary_date");
		String title = request.getParameter("diary_title");
		String content = request.getParameter("diary_content");


		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);

			Statement stmt = conn.createStatement();

			String sql = "update blog set blog_string=?, day=?, title=? where id=user";
			int num = stmt.executeUpdate(sql);
			ps = conn.prepareStatement(sql);

			ps.setString(1, content);
			ps.setString(2, date);
			ps.setString(3,title);
		}catch(Exception ex) {

		}

	}

}
