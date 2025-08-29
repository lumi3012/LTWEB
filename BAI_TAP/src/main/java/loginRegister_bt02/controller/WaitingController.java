package loginRegister_bt02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import loginRegister_bt02.model.User;

/**
 * Servlet implementation class Waiting
 */
@SuppressWarnings("serial")
@WebServlet("/Waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	
		HttpSession session = req.getSession(false);
        
        if (session != null && session.getAttribute("account") != null) {
            User user = (User) session.getAttribute("account");

            // Lưu username để hiển thị ở view nếu cần
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);

            // Điều hướng theo roleid
//           if (user.getRoleid() == 1) {
//                resp.sendRedirect(req.getContextPath() + "/admin/home");
//            } else if (user.getRoleid() == 2) {
//                resp.sendRedirect(req.getContextPath() + "/manager/home");
//            } else {
//                resp.sendRedirect(req.getContextPath() + "/home");
//            }

        } else {
            // Nếu chưa login -> quay về login
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
