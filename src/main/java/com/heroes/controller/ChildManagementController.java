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
import com.heroes.dto.JSONResult;
import com.heroes.service.ChildService;
import com.heroes.vo.ChildVo;
import api.ResponseHelper;
import api.Status;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/child/management")
public class ChildManagementController {

  @Autowired
  private ChildService childService;
  ResponseHelper responseHelper = new ResponseHelper();

  @ResponseBody
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<Object> insert(@RequestBody List<ChildVo> childVoList) {
    Status status;
    status = childService.insert(childVoList);
    return responseHelper.sendResponse(childVoList, status);
  }

  @ResponseBody
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute ChildVo childVo) {

    List<ChildVo> results = null;
    results = childService.selectList(childVo);
    return responseHelper.success(results, Status.SUCCESS);
  }
}
