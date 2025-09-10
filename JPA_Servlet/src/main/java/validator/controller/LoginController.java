package validator.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import validator.entity.User;
import validator.services.UserService;
import validator.services.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login/jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			req.setAttribute("alert", "Username/password required");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		
		User u = userService.login(username, password);
		if (u == null) {
			req.setAttribute("alert", "Invalid credentials");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		
		HttpSession s = req.getSession(true);
		s.setAttribute("account", u);
		
		int role = u.getRoleid();
		if (role == 1) resp.sendRedirect(req.getContextPath() + "/user/home");
		else if (role == 2) resp.sendRedirect(req.getContextPath() + "/manager/home");
		else if (role == 3) resp.sendRedirect(req.getContextPath() + "/admin/home");
		else resp.sendRedirect(req.getContextPath() + "/home");
	}

}
