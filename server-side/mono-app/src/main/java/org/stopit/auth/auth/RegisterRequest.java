package org.stopit.auth.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.stopit.auth.user.Role;
import org.restframework.web.annotations.markers.CompilationComponent;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@CompilationComponent
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;

}
