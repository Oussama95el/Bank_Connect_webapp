package com.simplon.bank_connect.agent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agent")
public class AgentController {

    private final AgentService agentService;


    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }


    @PostMapping("/save")
    public Agent saveAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }
}
