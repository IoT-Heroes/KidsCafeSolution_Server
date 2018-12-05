package com.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heroes.dto.JSONResult;
import com.heroes.service.CafeVisitingRecordService;
import com.heroes.vo.CafeVisitingRecordVo;

@Controller
@RequestMapping("/visitingrecord/management")
public class CafeVisitingRecordController {

  @Autowired
  private CafeVisitingRecordService cafeVisitingRecordService;

  @ResponseBody
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<Object> insert(@RequestBody CafeVisitingRecordVo cafeVisitingRecordVo) {

    if (cafeVisitingRecordService.insert(cafeVisitingRecordVo) == 1) {

      return ResponseEntity.ok(JSONResult.success(cafeVisitingRecordVo, "success"));

    } else {
      return ResponseEntity.ok(JSONResult.success(cafeVisitingRecordVo, "fail"));
    }
  }

}
