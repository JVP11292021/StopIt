package org.utils;

import lombok.Data;
import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@CompilationComponent
@ConfigurationProperties(prefix="application.context.net")
public class NetProperties {
    private List<String> cors;
    private List<String> methods;
    private List<String> headers;
}
