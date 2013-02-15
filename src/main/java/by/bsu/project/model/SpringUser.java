package by.bsu.project.model;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SpringUser extends User {
    private Long id;

    public SpringUser(Long id,
                      String username,
                      String password,
                      boolean enabled,
                      boolean accountNonExpired,
                      boolean credentialsNonExpired,
                      boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
