package com.nhnacademy.command;

import com.nhnacademy.repo.PostRepository;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentDeleteSuccessController implements Command{
    private PostRepository postRepository;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        postRepository = (PostRepository) servletContext.getAttribute("postRepository");

        String id = req.getParameter("id");
        long contentId = postRepository.getContentIdByUserId(id);

        postRepository.remove(contentId);
        servletContext.setAttribute("postRepository", postRepository);
        return "redirect:/assignedBoard.jsp";
    }
}
