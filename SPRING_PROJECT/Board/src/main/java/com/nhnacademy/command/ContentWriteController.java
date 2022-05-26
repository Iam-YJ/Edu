package com.nhnacademy.command;

import com.nhnacademy.domain.GeneralUser;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import com.nhnacademy.repo.PostRepo;
import com.nhnacademy.repo.PostRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ContentWriteController implements Command {
    private PostRepository postRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String time = req.getParameter("localDateTime");
        String text = req.getParameter("text");

        ServletContext servletContext = req.getServletContext();
        postRepository = (PostRepository) servletContext.getAttribute("postRepository");
        Post post =
            new Posts(postRepository.getSize(), title, text, id, LocalDateTime.now(), 0);
        postRepository.register(post);
        servletContext.setAttribute("postRepository", postRepository);

        return "redirect:/assignedBoard.jsp";
    }
}
