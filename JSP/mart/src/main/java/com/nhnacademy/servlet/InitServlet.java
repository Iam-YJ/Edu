package com.nhnacademy.servlet;

import com.nhnacademy.mart.Food;
import com.nhnacademy.mart.FoodStand;
import com.nhnacademy.util.InitUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "initServlet", urlPatterns = "/init")
@Slf4j
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        InitUtil.fillFood(getServletContext());
        resp.sendRedirect("/foods.do");
    }
}
