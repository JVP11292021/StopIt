package org.stopit.auth.user;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private Date accountCreated;
}
