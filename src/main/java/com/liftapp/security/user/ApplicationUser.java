package com.liftapp.security.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 8533039291044343363L;
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;
}
