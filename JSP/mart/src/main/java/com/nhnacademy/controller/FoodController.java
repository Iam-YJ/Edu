package com.nhnacademy.controller;

import com.nhnacademy.command.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/foods.jsp";
    }
}
