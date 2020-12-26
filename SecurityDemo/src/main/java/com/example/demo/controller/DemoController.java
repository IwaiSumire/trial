package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Viewを使わないcontroller
public class DemoController {

	@GetMapping(path = "hello",produces = "text.html")
	public String hello() {
		return "Hello";
	}

	@GetMapping(path="success",produces = "text.html")
	public String success() {
		return "成功";
	}

	@GetMapping(path="page1",produces = "taxt.html")
	public String page1( ) {
		return "ページ１";
	}

}
