package validator.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validator.entity.User;
import validator.services.CategoryService;
import validator.services.CategoryServiceImpl;

/**
 * Servlet implementation class ManagerHomeController
 */
@WebServlet("/manager/home")
public class ManagerHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService cateService = new CategoryServiceImpl();
    /**
     * Default constructor. 
     */
    public ManagerHomeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = (User) req.getSession(false).getAttribute("account");
        req.setAttribute("listcate", cateService.findAllByUserId(u.getId()));
        req.getRequestDispatcher("/views/home-manager.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
