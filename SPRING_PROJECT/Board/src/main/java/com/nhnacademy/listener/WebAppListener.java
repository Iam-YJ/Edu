package com.nhnacademy.listener;

import com.nhnacademy.domain.Counter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class WebAppListener implements ServletContextListener {
    private static final String CLASSES_DIR = "/WEB-INF/classes/";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initCounterFromFile(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        saveCounterToFile(sce.getServletContext());
    }

    private void initCounterFromFile(ServletContext servletContext) {
        String counterFile = servletContext.getInitParameter("counterFile");
        if (Objects.isNull(counterFile)) {
            log.error("ServletContext initParameter `counterFile` is null");
            return;
        }

        int counter = readCounterValueFromFile(servletContext, counterFile);
        servletContext.setAttribute(Counter.COUNTER, counter);
    }

    private void saveCounterToFile(ServletContext servletContext) {
        String counterFile = servletContext.getInitParameter("counterFile");
        if (Objects.isNull(counterFile)) {
            log.error("ServletContext initParameter `counterFile` is null");
            return;
        }

        int counter = Optional.ofNullable(servletContext.getAttribute(Counter.COUNTER))
            .map(Integer.class::cast)
            .orElse(0);

        saveCounterValueToFile(servletContext, counterFile, counter);
    }

    private int readCounterValueFromFile(ServletContext servletContext, String fileName) {
        Integer counter = null;

        String path = CLASSES_DIR + fileName;

        try (DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(path))) {
            counter = dis.readInt();
        } catch (IOException e) {
            log.warn("can't open counter file", e);
        }

        return Optional.ofNullable(counter).orElse(0);
    }

    private void saveCounterValueToFile(ServletContext servletContext, String fileName,
                                        int counter) {
        String path = CLASSES_DIR + fileName;

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(servletContext.getResource(path).toURI())))) {
            dos.writeInt(counter);
        } catch (IOException | URISyntaxException e) {
            log.error("can't write counter to file", e);
        }
    }

}
