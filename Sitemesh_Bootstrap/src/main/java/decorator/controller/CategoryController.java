package decorator.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import decorator.entity.Category;
import decorator.service.CategoryService;
import decorator.service.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = "/admin/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategoryService categoryService = new CategoryServiceImpl();

    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/category-form.jsp").forward(req, resp);
                break;
            case "edit":
                Integer id = Integer.valueOf(req.getParameter("id"));
                Category c = categoryService.findById(id);
                req.setAttribute("category", c);
                req.getRequestDispatcher("/views/category-form.jsp").forward(req, resp);
                break;
            case "delete":
                Integer delId = Integer.valueOf(req.getParameter("id"));
                categoryService.delete(delId);
                resp.sendRedirect(req.getContextPath() + "/admin/category");
                break;
            default:
                List<Category> list = categoryService.findAll();
                req.setAttribute("list", list);
                req.getRequestDispatcher("/views/category-list.jsp").forward(req, resp);
        }
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = req.getParameter("id");
        String name = req.getParameter("name");

        Category c = new Category();
        if (idStr != null && !idStr.isEmpty()) {
            c.setId(Integer.valueOf(idStr));
        }
        c.setCatename(name);

        if (c.getId() == 0) categoryService.insert(c);
        else categoryService.update(c);

        resp.sendRedirect(req.getContextPath() + "/admin/category");
	}

}
