package com.nhnacademy.command;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.repo.PostRepo;
import com.nhnacademy.repo.PostRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ContentModifyController implements Command {
    private PostRepository postRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        postRepository = (PostRepository) servletContext.getAttribute("postRepository");

        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String time = req.getParameter("localDateTime");
        String text = req.getParameter("text");
        long contentId = postRepository.getContentIdByUserId(id);


//        HttpSession session = req.getSession(false);
        Post post = new Posts(contentId, title, text, id, LocalDateTime.now(), 0);
        postRepository.modify(post);
        servletContext.setAttribute("postRepository", postRepository);
        return "redirect:/assignedBoard.jsp";
    }
}
