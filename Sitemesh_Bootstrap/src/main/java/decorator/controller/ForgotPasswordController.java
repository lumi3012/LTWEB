package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import decorator.entity.User;
import decorator.service.UserService;
import decorator.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/forgot")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();

    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		req.getRequestDispatcher("/views/forgot.jsp").forward(req, resp);
	}


    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String email = req.getParameter("email");

        // TODO: Implement send email logic
        req.setAttribute("message", "If this email exists, a reset link has been sent.");
        req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
	}

}
