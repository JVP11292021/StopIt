package org.stopit.auth.user;

import lombok.RequiredArgsConstructor;

import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/stop-it/v1/user/users")
@CompilationComponent
public class UserController {
    private final UserService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        this.service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path="/owned")
    public ResponseEntity<?> getConnectedUser(Principal connectedUser) {
        return ResponseEntity.ok(this.service.getConnectedUser(connectedUser));
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllUsers() {
        return ResponseEntity.ok(this.service.getAllUsers());
    }
    
}
