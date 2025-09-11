package decorator.filter;

import decorator.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        User user = (session != null) ? (User) session.getAttribute("account") : null;

        if (user == null || user.getRoleid() != 1) {
            req.getRequestDispatcher("/views/error/unauthorized.jsp").forward(request, response);
            return;
        }


        chain.doFilter(request, response);
    }
}
