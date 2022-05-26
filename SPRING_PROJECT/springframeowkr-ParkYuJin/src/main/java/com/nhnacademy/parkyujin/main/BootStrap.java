package com.nhnacademy.parkyujin.main;

import com.nhnacademy.parkyujin.aspect.LoggingAspect;
import com.nhnacademy.parkyujin.repository.BillRepository;
import com.nhnacademy.parkyujin.service.ResultReportService;
import java.io.File;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * This class for turning the spring main.
 */
public class BootStrap {
    /**
     * This method for turning the spring main.
     */
    public static void main(String[] args) {

        File csvFile =
            new File(
                BootStrap.class.getClassLoader().getResource("data/Tariff_20220331.csv").getFile());

        File jsonFile =new File(
            BootStrap.class.getClassLoader().getResource("data/Tariff_20220331.json").getFile());


        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            "com.nhnacademy.parkyujin")) {
            context.getBean("basicBillRepository", BillRepository.class)
                .csvLoad(csvFile);

//            context.getBean("basicBillRepository", BillRepository.class)
//                .jsonLoad(jsonFile);

            LoggingAspect.logger.info("> 1000");
            context.getBean("basicResultReportService", ResultReportService.class)
                .report(1000);

            LoggingAspect.logger.info("> 2000");
            context.getBean("basicResultReportService", ResultReportService.class)
                .report(2000);

            LoggingAspect.logger.info("> 3000");
            context.getBean("basicResultReportService", ResultReportService.class)
                .report(3000);
        }
    }
}
