package org.stopit;

import lombok.extern.slf4j.Slf4j;
import org.restframework.web.WebApp;
import org.springframework.boot.SpringApplication;

@Slf4j
public class SafeWebAppRunner {
    private SafeWebAppRunner() {}

    public static void safeApplicationRunner(Class<?> clazz, String[] args) {
        try {
            new WebApp(clazz)
                    .run(args);
        } catch (Exception e) {
            log.error("Error - {}", e.getMessage());
            SpringApplication.run(clazz, args);
        }
    }
}
