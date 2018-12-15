package com.heroes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heroes.dto.JSONResult;
import com.heroes.service.UserService;
import com.heroes.vo.StatisticsVo;
import com.heroes.vo.UserVo;

import api.ResponseHandler;
import api.Status;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user/management")
public class UserManagementController {

	@Autowired
	private UserService userService;
	ResponseHandler responseHandler = new ResponseHandler();

	@ApiImplicitParams({
			@ApiImplicitParam(name = "userVo", value = "json형태로 id,password,name,phoneNumber 세팅", required = true, dataType = "string", paramType = "body") })
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody UserVo userVo) {

		Status status = userService.insert(userVo);
		return responseHandler.sendResponse(userVo, status);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "userVo", value = "json형태로 id,password 세팅", required = true, dataType = "string", paramType = "body") })
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public ResponseEntity<Object> login(@RequestBody UserVo userVo) {
		UserVo resultUserVo = userService.login(userVo);
		if (resultUserVo != null) {
			return responseHandler.sendResponse(resultUserVo, Status.LOGIN_SUCCESS);
		} else {
			return responseHandler.sendResponse(resultUserVo, Status.LOGIN_FAIL);
		}
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "query"), })
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Object> select(@ModelAttribute UserVo userVo) {
		List<UserVo> results = userService.selectList(userVo);
		return responseHandler.success(results, Status.SELECT_SUCCESS);
	}
}
