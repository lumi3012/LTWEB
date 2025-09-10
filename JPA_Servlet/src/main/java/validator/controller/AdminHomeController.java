package validator.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validator.services.CategoryService;
import validator.services.CategoryServiceImpl;


/**
 * Servlet implementation class AdminHomeController
 */
@WebServlet("/admin/home")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService cs = new CategoryServiceImpl();
    /**
     * Default constructor. 
     */
    public AdminHomeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listcate", cs.findAll()); // admin sees all
        req.getRequestDispatcher("/views/home-admin.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
