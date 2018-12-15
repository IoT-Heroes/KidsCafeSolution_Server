package com.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heroes.dto.JSONResult;
import com.heroes.service.BatchService;
import com.heroes.service.CafeVisitingRecordService;
import com.heroes.service.DataService;
import com.heroes.service.IoTMakersService;
import com.heroes.vo.FoodVo;

import api.ResponseHandler;
import api.Status;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/data")
public class DataController {
	@Autowired
	private DataService dataService;
	ResponseHandler responseHandler = new ResponseHandler();

	@ResponseBody
	@RequestMapping(value = "/food", method = RequestMethod.GET)
	public ResponseEntity<Object> select() {

		List<FoodVo> results = dataService.selectFoodList();
		return responseHandler.success(results, Status.SELECT_SUCCESS);
	}
}
