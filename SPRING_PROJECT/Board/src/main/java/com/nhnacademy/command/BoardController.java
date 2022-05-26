package com.nhnacademy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/board.jsp";
    }
}
