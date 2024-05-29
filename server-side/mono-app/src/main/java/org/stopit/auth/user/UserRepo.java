package org.stopit.auth.user;

import org.restframework.web.annotations.markers.CompilationComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@CompilationComponent
public interface UserRepo  extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
