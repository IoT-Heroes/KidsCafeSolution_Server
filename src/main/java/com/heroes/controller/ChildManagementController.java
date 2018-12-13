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
import com.heroes.service.ChildService;
import com.heroes.vo.ChildVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins="*")
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
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(childVoList, "select fail"));
       }
  }
  
  @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "자녀ID", required = true,dataType = "string", paramType = "query"),
})
  @ResponseBody
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute ChildVo childVo) {

    if (childVo.getId() != null) {
      List<ChildVo> results = childService.selectList(childVo);
      return ResponseEntity.ok(JSONResult.success(results));
    } else {
      return ResponseEntity.ok(JSONResult.success(null));

    }
  }
}
