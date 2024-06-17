package org.stopit.components.config;

import lombok.Data;
import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@CompilationComponent
public class SecurityProperties {
//    @Value("${application.security.jwt.secret-key}")
    private String secretKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration = 86400000;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration = 604800000;
}
