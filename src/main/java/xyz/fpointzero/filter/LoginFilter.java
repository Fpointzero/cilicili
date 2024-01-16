package xyz.fpointzero.filter;

import xyz.fpointzero.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        urlPatterns = {
                "/api/user/*",
                "/api/creation/*"
        }
)
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取 RequestDispatcher 对象
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute("user");
        if (user == null) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
//            dispatcher.forward(httpRequest, httpResponse);
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "请先登录");
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
