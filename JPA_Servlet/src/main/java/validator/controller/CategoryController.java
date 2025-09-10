package validator.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validator.entity.Category;
import validator.entity.User;
import validator.services.CategoryService;
import validator.services.CategoryServiceImpl;


/**
 * Servlet implementation class CategoryControllers
 */
@WebServlet(urlPatterns = "/admin/categories/insert")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService cs = new CategoryServiceImpl();
    /**
     * Default constructor. 
     */
    public CategoryController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String path = req.getServletPath();
        User current = (User) req.getSession(false).getAttribute("account");

        switch (path) {
            case "/category/list":
                req.setAttribute("listcate", cs.findAll());
                req.getRequestDispatcher("/views/categories.jsp").forward(req, resp);
                break;
            case "/category/add":
                req.getRequestDispatcher("/views/add-category.jsp").forward(req, resp);
                break;
            case "/category/edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Category c = cs.findById(id);
                req.setAttribute("cate", c);
                req.getRequestDispatcher("/views/edit-category.jsp").forward(req, resp);
                break;
            case "/category/view":
                int vid = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("cate", cs.findById(vid));
                req.getRequestDispatcher("/views/view-category.jsp").forward(req, resp);
                break;
            case "/category/delete":
                int did = Integer.parseInt(req.getParameter("id"));
                Category toDel = cs.findById(did);
                if (toDel != null) {
                    // only owner or admin can delete
                    if (current.getRoleid()==3 || toDel.getUser().getId() == current.getId()) {
                        cs.delete(did);
                    } else {
                        req.setAttribute("error", "No permission to delete");
                    }
                }
                resp.sendRedirect(req.getContextPath()+"/category/list");
                break;
            default: resp.sendRedirect(req.getContextPath()+"/category/list");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
        User current = (User) req.getSession(false).getAttribute("account");

        if (path.equals("/category/insert")) {
            String name = req.getParameter("categoryName");
            String icon = req.getParameter("icon");
            Category cate = new Category();
            cate.setCatename(name);
            cate.setIcon(icon);
            cate.setUser(current);
            cs.insert(cate);
            resp.sendRedirect(req.getContextPath()+"/category/list");
        } else if (path.equals("/category/update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category cate = cs.findById(id);
            if (cate != null && (current.getRoleid()==3 || cate.getUser().getId() == current.getId())) {
                cate.setCatename(req.getParameter("categoryName"));
                cate.setIcon(req.getParameter("icon"));
                cs.update(cate);
            } else {
                req.setAttribute("error","No permission to edit");
            }
            resp.sendRedirect(req.getContextPath()+"/category/list");
        }
	}

}
