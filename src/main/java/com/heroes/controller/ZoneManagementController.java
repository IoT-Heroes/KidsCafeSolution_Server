package com.heroes.controller;

import java.util.List;

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
import com.heroes.service.ZoneService;
import com.heroes.vo.DepartmentsVo;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;

@Controller
@RequestMapping("/zone/management")
public class ZoneManagementController {

	@Autowired
	private ZoneService zoneService;

	@ResponseBody
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public ResponseEntity<Object> select(@ModelAttribute ZoneVo zoneVo) {

		if (zoneVo.getId() == null) {
			List<ZoneVo> results = zoneService.selectList();
			return ResponseEntity.ok(JSONResult.success(results));
		}else {
			ZoneVo result = zoneService.selectOne(zoneVo);
			return ResponseEntity.ok(JSONResult.success(result));
			
		}

	}

}
