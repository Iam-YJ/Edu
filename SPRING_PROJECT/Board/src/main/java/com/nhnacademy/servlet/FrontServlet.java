package com.nhnacademy.servlet;

import com.nhnacademy.command.AdminBoardController;
import com.nhnacademy.command.AssignedBoardController;
import com.nhnacademy.command.BoardController;
import com.nhnacademy.command.Command;
import com.nhnacademy.command.ContentDeleteController;
import com.nhnacademy.command.ContentDeleteSuccessController;
import com.nhnacademy.command.ContentModifyController;
import com.nhnacademy.command.ContentWriteController;
import com.nhnacademy.command.ContentsController;
import com.nhnacademy.command.LangController;
import com.nhnacademy.command.LoginController;
import com.nhnacademy.command.LoginProcessingController;
import com.nhnacademy.command.LogoutController;
import com.nhnacademy.command.RegisterFormController;
import com.nhnacademy.command.RegisterSuccessController;
import com.nhnacademy.command.UserDeleteController;
import com.nhnacademy.command.UserDeleteSuccessController;
import com.nhnacademy.command.UserModifyController;
import com.nhnacademy.command.UserWriteController;
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
            Command command = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            log.error("", ex);

            req.setAttribute("exception", ex);

            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginController();
        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessingController();
        } else if ("/logout.do".equals(servletPath)) {
            command = new LogoutController();
        } else if ("/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new RegisterFormController();
        } else if ("/registerSuccess.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new RegisterSuccessController();
        } else if ("/write.do".equals(servletPath)) {
            command = new ContentsController();
        } else if ("/writeContent.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new ContentWriteController();
        } else if ("/board.do".equals(servletPath)) {
            command = new BoardController();
        } else if ("/assignedBoard.do".equals(servletPath)) {
            command = new AssignedBoardController();
        } else if ("/contentWrite.do".equals(servletPath)) {
            command = new ContentWriteController();
        } else if ("/contentModify.do".equals(servletPath)) {
            command = new ContentModifyController();
        } else if ("/contentsDelete.do".equals(servletPath)) {
            command = new ContentDeleteController();
        } else if ("/contentsDeleteSuccess.do".equals(servletPath)) {
            command = new ContentDeleteSuccessController();
        } else if ("/userWrite.do".equals(servletPath)) {
            command = new UserWriteController();
        } else if ("/userModify.do".equals(servletPath)) {
            command = new UserModifyController();
        } else if ("/userDelete.do".equals(servletPath)) {
            command = new UserDeleteController();
        } else if ("/userDeleteSuccess.do".equals(servletPath)) {
            command = new UserDeleteSuccessController();
        } else if ("/adminBoard.do".equals(servletPath)) {
            command = new AdminBoardController();
        } else if ("/userContent.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserWriteController();
        } else if ("/change-lang.do".equals(servletPath)) {
            command = new LangController();
        }

        return command;
    }
}

