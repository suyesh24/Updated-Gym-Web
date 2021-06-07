package com.Gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gym.model.Demo;
import com.Gym.service.DemoService;



@RestController
@RequestMapping(path = "/lead")
public class DemoController {

	@Autowired
	DemoService demoService;

	@CrossOrigin
	@PostMapping(path = "/save")
	public ResponseEntity<String> saveInfo(@RequestBody Demo demo) {
		if (demoService.saveDemo(demo)) {
			return new ResponseEntity<>("Lead saved", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lead falied to save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping(path = "/getLeads")
	public ResponseEntity<List<Demo>> getLeads() {
		return new ResponseEntity<>(demoService.getInfo(), HttpStatus.OK);
	}

}