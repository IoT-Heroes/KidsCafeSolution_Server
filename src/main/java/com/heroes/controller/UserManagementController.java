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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.heroes.dto.JSONResult;
import com.heroes.service.UserService;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;
import io.swagger.annotations.Api;

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
  
  @ResponseBody
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<Object> login(@ModelAttribute UserVo userVo) {
    UserVo resultUserVo = userService.login(userVo);
    if (resultUserVo != null) {
      return ResponseEntity.ok(JSONResult.success(resultUserVo,"login success"));
    } else {
      return ResponseEntity.ok(JSONResult.success(userVo,"login fail"));
    }

  }
  
  

  @ResponseBody
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute UserVo userVo) {

    if (userVo.getId() == null) {
      List<UserVo> results = userService.selectList();
      return ResponseEntity.ok(JSONResult.success(results));
    } else {
      UserVo result = userService.selectOne(userVo);
      return ResponseEntity.ok(JSONResult.success(result));

    }
  }
}
