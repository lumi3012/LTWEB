package loginRegister_bt02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import loginRegister_bt02.model.User;
import loginRegister_bt02.service.UserService;
import loginRegister_bt02.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		User user = new User(0, username, fullname, password, phone, email);
		boolean success = userService.register(user);
		
		if (success) {
			resp.sendRedirect("views/login.jsp");
		} else {
			req.setAttribute("error", "Register failed!");
			req.getRequestDispatcher("views/register.jsp").forward(req, resp);
		}
	}

}
