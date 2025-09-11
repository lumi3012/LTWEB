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
import decorator.constant.Constant;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String phone    = req.getParameter("phone");
        int roleid      = Integer.parseInt(req.getParameter("roleid"));
        String email    = req.getParameter("email");

        // Check tồn tại trước khi insert
        if (userService.existByEmail(email)) {
            req.setAttribute("alert", "Email đã tồn tại!");
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
        if (userService.existByUsername(username)) {
            req.setAttribute("alert", "Tài khoản đã tồn tại!");
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleid(3);

        if (userService.register(user)) {
            req.setAttribute("alert", "🎉 Đăng ký thành công! Vui lòng đăng nhập.");
            req.getRequestDispatcher(Constant.LOGIN).forward(req, resp);
        } else {
            req.setAttribute("alert", "⚠️ Đăng ký thất bại!");
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
        }
    }
}
