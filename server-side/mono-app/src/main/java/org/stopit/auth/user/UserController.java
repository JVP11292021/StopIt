package org.stopit.auth.user;

import lombok.RequiredArgsConstructor;

import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stopit.InsertionService;
import org.stopit.checkup.CheckupDto;
import org.stopit.push.PushDto;
import org.stopit.stats.StatsDto;

import java.security.Principal;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/stop-it/v1/user/users")
@CompilationComponent
public class UserController {
    private final UserService service;
    private final InsertionService insertion;

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

    @PostMapping(path="/stats")
    public ResponseEntity<?> insertStats(
            @RequestBody StatsDto dto,
            Principal connectedUser
    ) {
        return ResponseEntity.ok(insertion.insertStats(dto, connectedUser));
    }

    @PostMapping(path="/checkup")
    public ResponseEntity<?> insertStats(
            @RequestBody CheckupDto dto,
            Principal connectedUser
    ) {
        return ResponseEntity.ok(insertion.insertCheckup(dto, connectedUser));
    }

    @PostMapping(path="/push")
    public ResponseEntity<?> insertStats(
            @RequestBody PushDto dto,
            Principal connectedUser
    ) {
        return ResponseEntity.ok(insertion.insertPush(dto, connectedUser));
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllUsers() {
        return ResponseEntity.ok(this.service.getAllUsers());
    }
    
}
