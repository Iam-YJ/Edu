package com.nhnacademy.controller;

import com.nhnacademy.command.Command;
import com.nhnacademy.mart.BuyList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginController implements Command {
    private String configId;
    private String configPwd;

    public LoginController(String configId, String configPwd) {
        this.configId = configId;
        this.configPwd = configPwd;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        HttpSession session = request.getSession();
        if (id != null && pwd != null && id.equals(configId) && pwd.equals(configPwd)) {
            request.setAttribute("id",id);
            request.setAttribute("pwd",pwd);
            BuyList buyList = new BuyList();
            session.setAttribute("buyList",buyList);
            session.setAttribute("money", "20000");
            log.error("login OK");
            return "/mart.jsp";
        } else {
            log.error("login Fail");
        }

        return "/loginForm.jsp";
    }
}
