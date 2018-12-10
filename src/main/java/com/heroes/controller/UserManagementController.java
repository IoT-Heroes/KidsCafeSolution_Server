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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.heroes.dto.JSONResult;
import com.heroes.service.UserService;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user/management")
public class UserManagementController {

  @Autowired
  private UserService userService;

  @ApiImplicitParams({@ApiImplicitParam(name = "userVo", value = "json형태로 id,password,name,phoneNumber 세팅", required = true, dataType = "string", paramType = "body")})
  @ResponseBody
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<Object> insert(@RequestBody UserVo userVo) {
    if (userService.insert(userVo) == 1) {
      return ResponseEntity.ok(JSONResult.success(userVo));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userVo); // 로그인 실패로 보낼것.
    }

  }


  @ApiImplicitParams({@ApiImplicitParam(name = "userVo", value = "json형태로 id,password 세팅", required = true, dataType = "string", paramType = "body")})
  @ResponseBody
  @RequestMapping(value = "/login", method = RequestMethod.POST)

  public ResponseEntity<Object> login(@RequestBody UserVo userVo) {
    UserVo resultUserVo = userService.login(userVo);
    if (resultUserVo != null) {
      return ResponseEntity.ok(JSONResult.success(resultUserVo, "login success"));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userVo);
    }

  }


  @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "query"),})
  @ResponseBody
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute UserVo userVo) {

    List<UserVo> results = userService.selectList(userVo);
    return ResponseEntity.ok(JSONResult.success(results));

  }
}
