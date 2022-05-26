package com.nhnacademy.command;

import com.nhnacademy.repo.PostRepository;
import com.nhnacademy.repo.UserRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteSuccessController implements Command{
    private UserRepository userRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");


        String id = req.getParameter("writer");

        userRepository.remove(id);
        servletContext.setAttribute("userRepository", userRepository);
        return "/adminBoard.jsp";
    }
}
