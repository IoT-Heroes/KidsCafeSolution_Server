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

import com.heroes.service.CafeVisitingRecordService;
import com.heroes.vo.CafeVisitingRecordVo;

import api.ResponseHandler;
import api.Status;
import api.ValidationStatus;
import api.Validator;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/visitingrecord/management")
public class CafeVisitingRecordController {

	@Autowired
	private CafeVisitingRecordService cafeVisitingRecordService;
	ResponseHandler responseHandler = new ResponseHandler();
	Validator validator = new Validator();

	/**
	 * band id, child id만 설정해서 보내줄것
	 */
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {
		Status status;

		validator.validate(cafeVisitingRecordVo, ValidationStatus.CAFE_VISITING_RECORD_INSERT_VALIDATION);

		status = cafeVisitingRecordService.insert(cafeVisitingRecordVo);
		return responseHandler.sendResponse(cafeVisitingRecordVo, status);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "childId", value = "자녀 ID", required = true, dataType = "string", paramType = "query") })
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> select(@ModelAttribute CafeVisitingRecordVo cafeVisitingRecordVo) throws Exception {
		validator.validate(cafeVisitingRecordVo, ValidationStatus.CAFE_VISITING_RECORD_SELECT_VALIDATION);
		
		List<CafeVisitingRecordVo> results = cafeVisitingRecordService.selectList(cafeVisitingRecordVo);
		return responseHandler.success(results, Status.SELECT_SUCCESS);
	}

}
