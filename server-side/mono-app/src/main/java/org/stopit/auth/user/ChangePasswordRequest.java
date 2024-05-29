package org.stopit.auth.user;

import lombok.Builder;
import lombok.Data;
import org.restframework.web.annotations.markers.CompilationComponent;

@Data
@Builder
@CompilationComponent
public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
