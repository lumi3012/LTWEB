package validator.filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import validator.entity.User;

@WebFilter(urlPatterns = {"/user/*","/manager/*","/admin/*","/category/*"})
public class RoleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession s = req.getSession(false);
        User u = s == null ? null : (User) s.getAttribute("account");

        String path = req.getRequestURI().substring(req.getContextPath().length());

        if (u == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }

        int role = u.getRoleid();
        // allow admin to access everything
        if (role == 3) {
            chain.doFilter(request, response); return;
        }

        // restrict by pattern
        if (path.startsWith("/admin/")) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN); return;
        }
        if (path.startsWith("/manager/")) {
            if (role != 2) { resp.sendError(HttpServletResponse.SC_FORBIDDEN); return; }
        }
        if (path.startsWith("/user/")) {
            if (role != 1 && role != 3) { resp.sendError(HttpServletResponse.SC_FORBIDDEN); return; }
        }

        // for /category/*: allow any logged-in user but CRUD operations are checked in controller for ownership
        chain.doFilter(request, response);
    }
}
