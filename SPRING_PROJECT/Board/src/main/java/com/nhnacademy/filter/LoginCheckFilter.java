package com.nhnacademy.filter;

import com.nhnacademy.util.BlackListUtils;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "*.do",
initParams = @WebInitParam(name="blacklist", value = "/register.do"))
public class LoginCheckFilter implements Filter {
    private List<String> blacklists;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        blacklists = BlackListUtils.toList(filterConfig.getInitParameter("blacklist"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if(blacklists.contains(req.getRequestURI())){
            HttpSession session = req.getSession(false);
            if(Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))){
                RequestDispatcher rd = servletRequest.getRequestDispatcher("/registerForm.jsp");
                rd.forward(servletRequest, servletResponse);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
