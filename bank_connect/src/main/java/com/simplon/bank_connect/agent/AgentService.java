package com.simplon.bank_connect.agent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AgentService {


    private final AgentRepository agentRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AgentService(AgentRepository agentRepository, PasswordEncoder passwordEncoder) {
        this.agentRepository = agentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // TODO: Add Agent methods here

    // getAgentById
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Agent with id " + id + " does not exist"));
    }

   public Agent getAgentByEmail(String email) {
        return agentRepository.findAgentByEmail(email);
   }


    public Agent saveAgent(Agent agent) {
        agent.setPassword(passwordEncoder.encode(agent.getPassword()));
        return agentRepository.save(agent);
    }
}
