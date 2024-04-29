package cl.fapp.restapi.security.login.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Value("${jwt.pwd}")
    private String jwtPwd;
    @Value("${jwt.username}")
    private String jwtUsername;
    /* 
     * Este método es llamado por Spring Security para obtener el usuario
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (jwtUsername.equals(username)) {
            return User.builder()
                       .username(jwtUsername)
                       .password(encodedPassword())
                       .authorities("ROLE_USER")
                       .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    public String encodedPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(jwtPwd);
    }
}