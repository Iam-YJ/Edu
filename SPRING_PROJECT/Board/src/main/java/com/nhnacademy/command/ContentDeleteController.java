package com.nhnacademy.command;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.repo.PostRepository;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentDeleteController implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/contentsDelete.jsp";
    }
}
