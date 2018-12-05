package com.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroes.dto.JSONResult;
import com.heroes.service.UserService;
import com.heroes.vo.UserVo;

@Controller
@RequestMapping("/user/management")
public class UserManagementController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@ModelAttribute UserVo userVo) {
		if (userService.insert(userVo) == 1) {
			return ResponseEntity.ok(JSONResult.success(userVo));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userVo);
		}

	}
	
	

}