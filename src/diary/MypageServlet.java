package diary;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SelectSampleServlet1
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	
	MypageBean1 myBean1 = new MypageBean1();
	MypageBean2 myBean2 = new MypageBean2();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String day = null;
		String title = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://10.15.121.37:3306/webapp2019_sgt2?serverTimezone=JST",
				"user_sgt2", "sgt2");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM blog");

			while (rs.next()) {
				day= rs.getString("day");
				title = rs.getString("title");
				myBean1.setDay(day);
				myBean1.setTitle(title);
				myBean2.addDiaryArray(myBean1);
				
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
		HttpSession session = request.getSession();
		session.setAttribute("myBean2", myBean2);
		getServletContext()
		.getRequestDispatcher("/Mypage.jsp").forward(request, response);
		
		
	}

}
