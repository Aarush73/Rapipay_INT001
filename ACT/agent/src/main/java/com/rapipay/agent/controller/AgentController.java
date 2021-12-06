package com.rapipay.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rapipay.agent.services.AgentService;

import com.rapipay.agent.bean.Agent;

//@CrossOrigin
@RestController
public class AgentController {

	@Autowired
	private AgentService service;

	@GetMapping("/agent/{id}")
	public Agent getAgent(@PathVariable int id) {
		return service.getAgent(id);
	}

	@GetMapping("/agent/all")
	public List<Agent> getAllAgent() {
		return service.getAllAgent();
	}

	@PostMapping("/agent/insert")
	public Agent insertAgent(@RequestBody Agent agent) {
		return service.insertAgent(agent);
	}

	@PutMapping("/agent/update/{id}")
	public Object updateAgent(@RequestBody Agent agent, @PathVariable int id) {
		return service.updateAgent(agent, id);
	}

	@DeleteMapping("/agent/delete/{id}")
	public String deleteAgent(@PathVariable int id) {
		return service.deleteAgent(id);
	}
}
