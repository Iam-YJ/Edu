package com.nhnacademy.command;

import com.nhnacademy.domain.User;
import com.nhnacademy.repo.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessingController implements Command {
    private UserRepository userRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        ServletContext servletContext = req.getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");


        for (User user : userRepository.getUsers()) {
            if (user.getId().equals(id) && user.getPassword().equals(pwd)) {
                HttpSession session = req.getSession();
                session.setAttribute("id", id);
                if (id.equals("admin")) {
                    return "/adminBoard.jsp";
                } else {
                    return "/assignedBoard.jsp";
                }
            }
        }
        return "/loginForm.jsp";
    }
}
