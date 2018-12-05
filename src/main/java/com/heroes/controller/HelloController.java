package com.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroes.dto.JSONResult;
import com.heroes.service.DepartmentsService;
import com.heroes.vo.DepartmentsVo;
@Controller
@RequestMapping( "/Domain1" )
public class HelloController {
	
	@Autowired
	private DepartmentsService departmentsService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	
	
	@ResponseBody
	@RequestMapping( value="/getData", method=RequestMethod.POST )
	public ResponseEntity<JSONResult> view(@RequestBody DepartmentsVo departmentsVo) {
		
		List<DepartmentsVo> results = departmentsService.getDepartments(departmentsVo);
		
		
		return ResponseEntity.ok(JSONResult.success(results));
		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		return ResponseEntity.ok(JSONResult.success("aaaaa"));
		
		
		
	}
	
	
}