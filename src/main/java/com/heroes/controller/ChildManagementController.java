package com.heroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroes.service.ChildService;
import com.heroes.vo.ChildVo;

import api.ResponseHandler;
import api.Status;
import api.ValidationStatus;
import api.Validator;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/child/management")
public class ChildManagementController {

	@Autowired
	private ChildService childService;
	ResponseHandler responseHandler = new ResponseHandler();

	Validator validator = new Validator();

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody List<ChildVo> childVoList) {
		Status status;

		validator.validate(childVoList, ValidationStatus.CHILD_INSERT_VALIDATION);

		status = childService.insert(childVoList);
		return responseHandler.sendResponse(childVoList, status);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> select(@ModelAttribute ChildVo childVo) {

		validator.validate(childVo, ValidationStatus.CHILD_SELECT_VALIDATION);

		List<ChildVo> results = null;
		results = childService.selectList(childVo);
		return responseHandler.success(results, Status.SELECT_SUCCESS);
	}
}
