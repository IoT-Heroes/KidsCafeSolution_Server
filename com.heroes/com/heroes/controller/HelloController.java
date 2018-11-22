package com.heroes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.JSONResult;
@Controller
@RequestMapping( "/Domain1" )
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	
	
	@ResponseBody
	@RequestMapping( value="/getData", method=RequestMethod.POST )
	public ResponseEntity<Object> view(@ModelAttribute Object obj) {
		
		
		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		return ResponseEntity.ok(JSONResult.success("aaaaa"));
		
		
		
	}
	
	
}