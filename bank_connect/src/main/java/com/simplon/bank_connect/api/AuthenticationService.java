package com.simplon.bank_connect.api;

import com.simplon.bank_connect.agent.AgentController;
import com.simplon.bank_connect.agent.AgentService;
import com.simplon.bank_connect.client.ClientController;
import com.simplon.bank_connect.client.ClientService;
import com.simplon.bank_connect.config.JwtUtil;
import com.simplon.bank_connect.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ClientService clientService;
    private final AgentService agentService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        if (clientService.getClientByEmail(request.getEmail()) != null){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail()+"-CLIENT", request.getPassword().trim())
            );

            final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail()+"-CLIENT");

            if (user != null) {
                return AuthenticationResponse.builder()
                        .token(jwtUtil.generateToken(user,"-CLIENT"))
                        .client(clientService.getClientByEmail(request.getEmail()))
                        .build();
            }
            return null;
        }else {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail()+"-ADMIN", request.getPassword().trim())
            );

            final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail()+"-ADMIN");

            if (user != null) {
                return AuthenticationResponse.builder()
                        .token(jwtUtil.generateToken(user,"-ADMIN"))
                        .agent(agentService.getAgentByEmail(request.getEmail()))
                        .build();
            }
            return null;
        }
    }
}
