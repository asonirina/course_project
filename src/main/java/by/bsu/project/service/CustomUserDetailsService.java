package by.bsu.project.service;

import by.bsu.project.constants.ETestingConstants;
import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.model.SpringUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    private final static String ROLE_ADMIN = "ROLE_ADMIN";
    private final static String ROLE_USER  = "ROLE_USER";
    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserInfoService userInfoService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            UserInfoEntity entity = userInfoService.findStudentByLogin(login);

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            Integer role;
            if (entity.getForm().equals(ETestingConstants.ADMIN_ROLE)) {
                role = 1;
            } else role = 2;

            return new SpringUser(
                    entity.getId(),
                    entity.getLogin(),
                    entity.getPassword().toLowerCase(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(role));

        } catch (Exception ex) {
            logger.error("Unable to load user " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }


    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        return getGrantedAuthorities(getRoles(role));
    }

    public List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<>();

        if (role == 1) {
            roles.add(ROLE_ADMIN);

        } else if (role == 2) {
            roles.add(ROLE_USER);
        }

        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
