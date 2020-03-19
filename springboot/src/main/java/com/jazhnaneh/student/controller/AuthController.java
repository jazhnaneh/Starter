package com.jazhnaneh.student.controller;

import com.jazhnaneh.student.filters.JwtToken;
import com.jazhnaneh.student.model.AuthenticationResponse;
import com.jazhnaneh.student.model.User;
import com.jazhnaneh.student.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @GetMapping(value = "/hello" )
    public String hello() {
        return "Hello World";
    }


    private Authentication authenticate(String username, String password) throws Exception {
        Authentication authenticate = null;
        try {

            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);

        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);

        }

        return authenticate;
    }


    @PostMapping(value = "/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String,Object> values) throws Exception {

            User user=null;
            String userName= (String) values.get("userName");
            String password= (String) values.get("password");
            user=new User();
            user.setUserName(userName);
            user.setPassword(password);

        Authentication authenticate = authenticate(userName, password);

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userName);

        final String jwt = jwtToken.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
