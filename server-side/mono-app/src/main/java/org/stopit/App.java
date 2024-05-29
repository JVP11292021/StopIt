package org.stopit;

import org.restframework.web.annotations.EnableRestConfiguration;
import org.restframework.web.annotations.RestApi;
import org.restframework.web.core.templates.TControllerEntityResponseWildcard;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static org.stopit.SafeWebAppRunner.safeApplicationRunner;

@SpringBootApplication
@EnableRestConfiguration
@RestApi(
        controller = TControllerEntityResponseWildcard.class,
        basePackage = "org.happy.plants",
        APIS = {}
)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class App {
    public static void main(String[] args) {
        safeApplicationRunner(App.class, args);
    }
}