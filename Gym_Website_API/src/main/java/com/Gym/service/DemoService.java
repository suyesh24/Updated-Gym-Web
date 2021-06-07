package com.Gym.service;

import com.Gym.model.Demo;

import antlr.collections.List;

public interface DemoService {
	boolean saveDemo(Demo demo);
	

	java.util.List<Demo> getInfo();

}
