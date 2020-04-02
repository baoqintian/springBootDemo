package com.aop.controller;

import com.aop.annotation.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	@Action("hello")
	public String hello() {
		return "Hello Spring Boot";
	}
}