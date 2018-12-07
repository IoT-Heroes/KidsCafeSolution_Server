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
import com.heroes.service.CafeVisitingRecordService;
import com.heroes.vo.CafeVisitingRecordVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins="*")
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
  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "자녀 ID", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute CafeVisitingRecordVo cafeVisitingRecordVo) {

    if (cafeVisitingRecordVo.getChildId() != null) {
      List<CafeVisitingRecordVo> results = cafeVisitingRecordService.selectList(cafeVisitingRecordVo);
      return ResponseEntity.ok(JSONResult.success(results));
    } else {
      return ResponseEntity.ok(JSONResult.success(null));

    }
  }

}
