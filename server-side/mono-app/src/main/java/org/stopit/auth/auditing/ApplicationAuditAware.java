package org.stopit.auth.auditing;

import org.stopit.auth.user.User;
import org.jetbrains.annotations.NotNull;
import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@SuppressWarnings("unused")
@CompilationComponent
public class ApplicationAuditAware implements AuditorAware<Integer> {
    @Override
    public @NotNull Optional<Integer> getCurrentAuditor() {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken
        ) {
            return Optional.empty();
        }

        User userPrincipal = (User) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getId());
    }
}
