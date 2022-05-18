package com.nhnacademy;

import com.nhnacademy.config.MainConfig;
import com.nhnacademy.repository.Teacher;
import com.nhnacademy.service.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    private static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class)) {
            TeacherService bean = ctx.getBean(TeacherService.class);

            log.info("1 Teacher");
            log.info(bean.getTeacher(1L));
            log.info("all Teachers");
            bean.getAllTeachers().forEach(log::info);

            bean.insertAndDelete(new Teacher(5L, "선생5", new Date()));
            log.info("after insert and delete");
            bean.getAllTeachers().forEach(log::info);

            try {
                bean.insertAndDelete(new Teacher(10L, "선생5", new Date()));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllTeachers().forEach(log::info);

            try {
                bean.insertAndDeleteWithoutTransaction(new Teacher(10L, "선생5", new Date()));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllTeachers().forEach(log::info);
        }
    }
}
