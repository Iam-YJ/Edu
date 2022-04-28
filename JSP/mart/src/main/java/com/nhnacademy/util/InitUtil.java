package com.nhnacademy.util;

import com.nhnacademy.mart.Food;
import com.nhnacademy.mart.FoodStand;
import javax.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitUtil {

    private InitUtil() {
        throw new IllegalStateException();
    }

    public static FoodStand fillFood(ServletContext servletContext) {
        String onionName = servletContext.getInitParameter("onion");
        String eggName = servletContext.getInitParameter("egg");
        String welshOnionName = servletContext.getInitParameter("welshOnion");
        String appleName = servletContext.getInitParameter("appleName");

        int onionQty = Integer.parseInt((String) servletContext.getAttribute("onionQty"));
        int eggQty = Integer.parseInt((String) servletContext.getAttribute("eggQty"));
        int welshOnionQty = Integer.parseInt((String) servletContext.getAttribute("welshOnionQty"));
        int appQty = Integer.parseInt((String) servletContext.getAttribute("appleQty"));

        int onionPrice = Integer.parseInt(servletContext.getInitParameter("onionPrice"));
        int eggPrice = Integer.parseInt(servletContext.getInitParameter("eggPrice"));
        int welshOnionPrice = Integer.parseInt(servletContext.getInitParameter("welshOnionPrice"));
        int appPrice = Integer.parseInt(servletContext.getInitParameter("applePrice"));

        Food onion = new Food(onionName, onionPrice, onionQty);
        Food egg = new Food(eggName, eggPrice, eggQty);
        Food welshOnion = new Food(welshOnionName, welshOnionPrice, welshOnionQty);
        Food apple = new Food(appleName, appPrice, appQty);

        FoodStand foodStand = new FoodStand();

        foodStand.add(onion);
        foodStand.add(egg);
        foodStand.add(welshOnion);
        foodStand.add(apple);

        servletContext.setAttribute("foodStand", foodStand);
        return foodStand;
    }
}
