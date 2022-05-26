package com.nhnacademy.command;

import com.nhnacademy.domain.GeneralUser;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import com.nhnacademy.repo.PostRepository;
import com.nhnacademy.repo.UserRepository;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserModifyController implements Command {
    private UserRepository userRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String image = req.getParameter("image");

        User user = new GeneralUser(new Users(id, pwd, name, image));
        userRepository.modify(user);
        servletContext.setAttribute("userRepository", userRepository);
        return "/adminBoard.jsp";
    }
}
