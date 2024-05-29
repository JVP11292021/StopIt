package org.stopit.auth.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.restframework.web.annotations.markers.CompilationComponent;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompilationComponent
public class AuthenticationRequest {
    private String email;
    private String password;
}
