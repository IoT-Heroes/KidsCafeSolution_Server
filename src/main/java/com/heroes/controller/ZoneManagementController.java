package com.heroes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heroes.dto.JSONResult;
import com.heroes.service.ZoneService;
import com.heroes.vo.ZoneVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins="*")
@Controller
@RequestMapping("/zone/management")
public class ZoneManagementController {

	@Autowired
	private ZoneService zoneService;
	
	
	  @ApiImplicitParams({
	    @ApiImplicitParam(name = "id", value = "놀이구역ID입력하면 특정 놀이구역 / 입력하지 않으면 전체 놀이구역", required = false,dataType = "string", paramType = "query")
	  })
	@ResponseBody
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public ResponseEntity<Object> select(@ModelAttribute ZoneVo zoneVo) {
			List<ZoneVo> results = zoneService.selectList(zoneVo);
			return ResponseEntity.ok(JSONResult.success(results));
	}

}
