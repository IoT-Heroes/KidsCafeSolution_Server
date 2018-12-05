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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.heroes.dto.JSONResult;
import com.heroes.service.ChildService;
import com.heroes.service.UserService;
import com.heroes.vo.ChildVo;
import com.heroes.vo.UserVo;
import com.heroes.vo.ZoneVo;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("/child/management")
public class ChildManagementController {

  @Autowired
  private ChildService childService;

  @ResponseBody
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<Object> insert(@RequestBody List<ChildVo> childVoList) {
    
       
       if(childService.insert(childVoList) == childVoList.size()) {
         
         return ResponseEntity.ok(JSONResult.success(childVoList,"success"));
         
       }else {
         return ResponseEntity.ok(JSONResult.success(childVoList,"success"));
       }
         
    

  }
  

//  @ResponseBody
//  @RequestMapping(value = "/select", method = RequestMethod.GET)
//  public ResponseEntity<Object> select(@ModelAttribute ChildVo childVo) {
//
//    if (childVo.getId() == null) {
//      List<UserVo> results = childService.selectList();
//      return ResponseEntity.ok(JSONResult.success(results));
//    } else {
//      UserVo result = childService.selectOne(childVo);
//      return ResponseEntity.ok(JSONResult.success(result));
//
//    }
//  }
}
