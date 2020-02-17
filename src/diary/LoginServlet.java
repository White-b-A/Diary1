package diary;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	//家用
	public static final String DB_NAME = "sgt";
	public static final String HOST_NAME = "localhost:3306";
	public static final String USER_NAME = "root";
	public static final String USER_PASS = "0423";
	public static final String URL = "jdbc:mysql://" + HOST_NAME + "/" + DB_NAME + "?serverTimezone=JST";

	//学校用
	/*
	public static final String HOST_NAME = "10.15.121.37:3306";
	public static final String DB_NAME   = "webapp2019_sgt2";
	public static final String USER_NAME = "user_sgt2";
	public static final String USER_PASS = "sgt2";
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String blog = null;
		String date = null;
		String title = null;


		try {
			//学校用
			//Class.forName("org.mariadb.jdbc.Driver");

			//家用
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM blog where title=");
			
			
		} catch (Exception ex) {
			System.out.println("error");
		}
	}
}
