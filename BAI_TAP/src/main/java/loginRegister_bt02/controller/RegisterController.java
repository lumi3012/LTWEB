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
import loginRegister_bt02.Constant;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(urlPatterns="/register")
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
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
		int roleid = Integer.parseInt(req.getParameter("roleid")); 
		String email = req.getParameter("email");
		
		User user = new User(0, username, fullname, password, phone, roleid, email);
		boolean success = userService.register(user);
		
		if (success) {
			resp.sendRedirect("views/login.jsp");
		} else {
			req.setAttribute("error", "Register failed!");
			req.getRequestDispatcher("views/register.jsp").forward(req, resp);
		}
	}

}
