package cl.fapp.restapi.security.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.restapi.security.JwtTokenUtil;
import cl.fapp.restapi.security.login.dto.JwtRequest;
import cl.fapp.restapi.security.login.dto.JwtResponse;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/fapp/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        try {
            log.info("Autenticando usuario: {}", authenticationRequest.getUsername());
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), 
                    authenticationRequest.getPassword()
                )
            );

            UserDetails userDetails = (UserDetails) authenticate.getPrincipal();
            final String jwt = jwtTokenUtil.generateToken(userDetails);
            JwtResponse jwtResponse = new JwtResponse(jwt);
            log.info("Usuario {} autenticado exitosamente", authenticationRequest.getUsername());
            return ResponseEntity.ok(jwtResponse);
        } catch (AuthenticationException e) {
            log.error("Error de autenticación", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            log.error("Error en la solicitud de login", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}