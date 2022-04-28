package com.nhnacademy.initializer;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class
})

public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        servletContext.setInitParameter("counterFileName", "counter.dat");
        servletContext.setInitParameter("onion","onion");
        servletContext.setInitParameter("egg","egg");
        servletContext.setInitParameter("welshOnion","welshOnion");
        servletContext.setInitParameter("appleName","apple");
        servletContext.setAttribute("onionQty","2");
        servletContext.setAttribute("eggQty","5");
        servletContext.setAttribute("welshOnionQty","10");
        servletContext.setAttribute("appleQty","20");
        servletContext.setInitParameter("onionPrice","1000");
        servletContext.setInitParameter("eggPrice","2000");
        servletContext.setInitParameter("welshOnionPrice","500");
        servletContext.setInitParameter("applePrice","2000");
        servletContext.setInitParameter("counterFileName", "counter.dat");

        servletContext.setAttribute("ko", "한국어");
        servletContext.setAttribute("en","English");

    }
}

