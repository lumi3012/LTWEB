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
 * Servlet implementation class HomeController
 */
@WebServlet("/user/home")
public class UserHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService cateService = new CategoryServiceImpl();
    /**
     * Default constructor. 
     */
    public UserHomeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listcate", cateService.findAll());
		req.getRequestDispatcher("/views/home-user.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}


