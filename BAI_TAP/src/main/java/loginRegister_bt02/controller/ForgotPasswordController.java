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
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet(urlPatterns = "/forgot")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
    	String email = req.getParameter("email");
        String alert = "";

        User user = userService.findByEmail(email); // cần viết thêm hàm này trong UserService
        if (user != null) {
            alert = "Mật khẩu của bạn là: " + user.getPassword(); 
        } else {
            alert = "Email không tồn tại trong hệ thống!";
        }
        req.setAttribute("alert", alert);
        req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
	}

}
