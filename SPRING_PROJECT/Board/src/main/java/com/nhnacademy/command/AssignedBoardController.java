package com.nhnacademy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AssignedBoardController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/assignedBoard.jsp";
    }
}
