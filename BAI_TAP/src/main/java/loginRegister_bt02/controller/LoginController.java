package loginRegister_bt02.controller;

import java.io.IOException;
import loginRegister_bt02.Constant;

//import org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loginRegister_bt02.model.User;
import loginRegister_bt02.service.UserService;
import loginRegister_bt02.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());

		HttpSession session = req.getSession(false);
//		if (session != null && session.getAttribute("account") != null) {
//			resp.sendRedirect(req.getContextPath() + "/waiting");
//			return;
//		}
		
		if (session != null && session.getAttribute("account") != null) {
		    resp.sendRedirect(req.getContextPath() + "/views/login.jsp"); // tạm thời
		    return;
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					//resp.sendRedirect(req.getContextPath() + "/waiting");
					resp.sendRedirect(req.getContextPath() + "/views/login.jsp"); // tạm thời
					return;
				}
			}
		}
		req.getRequestDispatcher("views/login.jsp").forward(req, resp);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		UserService service = new UserServiceImpl();
		User user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			//resp.sendRedirect(req.getContextPath() + "/waiting");
			resp.sendRedirect(req.getContextPath() + "/views/login.jsp"); // tạm thời
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}
	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}
}

