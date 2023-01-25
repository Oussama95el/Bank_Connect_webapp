package com.simplon.bank_connect.api;

import com.simplon.bank_connect.config.JwtUtil;
import com.simplon.bank_connect.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    private final AuthenticationService authenticationService;

    @PostMapping("/client")
    public ResponseEntity<AuthenticationResponse> ClientAuthenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok( authenticationService.authenticate(request) );
    }

    @PostMapping("/agent")
    public ResponseEntity<AuthenticationResponse> AgentAuthenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
