package diary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSession
 */
@WebServlet("/LoginSession")
//
//HttpSession session = request.getSession(false);
//if(session != null){
//
//}else {
//	response.sendReirect("NoSeesion.html");
//}
public class LoginSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String password = "xxx";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String login_password = "xxx";
		HttpSession session = request.getSession(false);

		if (session != null) {
			String url = request.getParameter("url");
			session.setMaxInactiveInterval(86400);
			response.sendRedirect(url);
			System.out.println(url);
			System.out.println("have session");
		} else {
			login_password = request.getParameter("");
			if (login_password != null) {
				if (login_password.equals(password)) {
					System.out.println("login");
					session = request.getSession(true);
					session.setMaxInactiveInterval(86400);
					//response.sendRedirect("");
				} else {
					System.out.println("miss");
					//response.sendRedirect("");
				}
			} else {
				response.sendRedirect("NoSession.html");
			}
		}

		//		String path = "/MypageServlet.java"; // フォワード先
		//	    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		//	    dispatcher.forward(request, response);
	}

}
