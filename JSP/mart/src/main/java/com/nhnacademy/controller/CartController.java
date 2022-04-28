package com.nhnacademy.controller;

import com.nhnacademy.command.Command;
import com.nhnacademy.exception.AmountException;
import com.nhnacademy.mart.Food;
import com.nhnacademy.mart.FoodStand;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartController implements Command {
    private FoodStand foodStand;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String[] items = request.getParameterValues("item");
        log.error(Arrays.toString(items));
        foodStand = (FoodStand) request.getServletContext().getAttribute("foodStand");
        HttpSession session = request.getSession();

        int onionCount = Integer.parseInt(request.getParameter("onion"));
        checkCount(request, "onion", onionCount);
        deleteFromFoodStand(request, "onion", onionCount);

        int eggCount = Integer.parseInt(request.getParameter("egg"));
        checkCount(request, "egg", eggCount);
        deleteFromFoodStand(request, "egg", eggCount);

        int welshOnionCount = Integer.parseInt(request.getParameter("welshOnion"));
        checkCount(request, "welshOnion", welshOnionCount);
        deleteFromFoodStand(request, "welshOnion", welshOnionCount);

        int appleCount = Integer.parseInt(request.getParameter("apple"));
        checkCount(request, "apple", appleCount);
        deleteFromFoodStand(request, "apple", appleCount);

        int result = (onionCount * 1000) + (eggCount * 2000) +
            (welshOnionCount * 500) + (appleCount * 2000);

        session.setAttribute("onionCount", onionCount);
        session.setAttribute("eggCount", eggCount);
        session.setAttribute("welshOnionCount", welshOnionCount);
        session.setAttribute("appleCount", appleCount);
        session.setAttribute("result", result);

        session.setAttribute("money",
            Integer.parseInt(session.getAttribute("money").toString()) - result);

        return "/cart.jsp";
    }

    void checkCount(HttpServletRequest request, String foodName, int count) {
        foodStand = (FoodStand) request.getServletContext().getAttribute("foodStand");
        for (Food food : foodStand.getFoods()) {
            switch (foodName) {
                case "onion":
                    if (count > Integer.parseInt(
                        (String) request.getServletContext().getAttribute("onionQty"))) {
                        throw new AmountException("onion out of stock");
                    }
                    break;
                case "egg":
                    if (count >
                        Integer.parseInt(
                            (String) request.getServletContext().getAttribute("eggQty"))) {
                        throw new AmountException("egg out of stock");
                    }
                    break;
                case "welshOnion":
                    if (count > Integer.parseInt(
                        (String) request.getServletContext().getAttribute("welshOnionQty"))) {
                        throw new AmountException("welshOnion out of stock");
                    }
                    break;
                case "apple":
                    if (count > Integer.parseInt(
                        (String) request.getServletContext().getAttribute("appleQty"))) {
                        throw new AmountException("apple out of stock");
                    }
                    break;
                default:
                    break;
            }

        }
    }

    void deleteFromFoodStand(HttpServletRequest request, String foodName, int count) {
        foodStand = (FoodStand) request.getServletContext().getAttribute("foodStand");
        for (Food food : foodStand.getFoods()) {
            switch (foodName) {
                case "onion":
                    request.getServletContext().setAttribute("onionQty", String.valueOf(
                        (Integer.parseInt(
                            (String) request.getServletContext().getAttribute("onionQty")) -
                            count)));
                    break;
                case "egg":
                    request.getServletContext().setAttribute("eggQty", String.valueOf(
                        (Integer.parseInt(
                            (String) request.getServletContext().getAttribute("eggQty")) -
                            count)));
                    break;
                case "welshOnion":
                    request.getServletContext().setAttribute("welshOnionQty", String.valueOf(
                        (Integer.parseInt(
                            (String) request.getServletContext().getAttribute("welshOnionQty")) -
                            count)));
                    break;
                case "apple":
                    request.getServletContext().setAttribute("appleQty", String.valueOf(
                        (Integer.parseInt(
                            (String) request.getServletContext().getAttribute("appleQty")) -
                            count)));
                    break;
                default:
                    break;
            }

        }
    }

}
