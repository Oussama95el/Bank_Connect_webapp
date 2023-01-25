package com.simplon.bank_connect.api;

import com.simplon.bank_connect.agent.Agent;
import com.simplon.bank_connect.client.Client;
import com.simplon.bank_connect.client.ClientController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {


    private String token;

    private Client client;

    private Agent agent;

}
