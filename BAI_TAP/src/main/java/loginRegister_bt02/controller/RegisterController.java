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

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
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
        if (userService.checkExistEmail(email)) {
            req.setAttribute("alert", "Email đã tồn tại!");
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }
        if (userService.checkExistUsername(username)) {
            req.setAttribute("alert", "Tài khoản đã tồn tại!");
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }

        // Tạo user mới
        User user = new User(0, username, fullname, password, phone, roleid, email);

        if (userService.register(user)) {
            req.setAttribute("alert", "🎉 Đăng ký thành công! Vui lòng đăng nhập.");
            req.getRequestDispatcher(Constant.LOGIN).forward(req, resp);
        } else {
            req.setAttribute("alert", "⚠️ Đăng ký thất bại!");
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
        }
    }
}
