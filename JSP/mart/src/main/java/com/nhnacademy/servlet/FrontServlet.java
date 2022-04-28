package com.nhnacademy.servlet;

import com.nhnacademy.command.Command;
import com.nhnacademy.controller.CartController;
import com.nhnacademy.controller.FoodController;
import com.nhnacademy.controller.LoginController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            String processingServletPath = req.getServletPath();

            Command command = resolveCommand(processingServletPath);
            String view = command.execute(req,resp);

            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.include(req, resp);

        } catch (Exception ex) {
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath) {
         Command command = null;

        if ("/cart.do".equals(servletPath)) {
//            command = new CartController();
            command = new CartController();
        } else if ("/foods.do".equals(servletPath)) {
            command = new FoodController();
        } else if ("/login.do".equals(servletPath)) {
            command = new LoginController("pyj", "123");
        }
        return command;
    }

}