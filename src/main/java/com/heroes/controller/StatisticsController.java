package com.heroes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heroes.dto.JSONResult;
import com.heroes.service.StatisticsService;
import com.heroes.vo.StatisticsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/statistics")
@Api(value = "main", description = "main controller")
public class StatisticsController {

  @Autowired
  private StatisticsService statisticsService;
  
  
  
  @ApiImplicitParams({
    @ApiImplicitParam(name = "zoneId", value = "놀이구역ID", required = true,dataType = "string", paramType = "query"),
    @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10", required = true, dataType = "string", paramType = "query"),
    @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18", required = true, dataType = "string", paramType = "query"),
    @ApiImplicitParam(name = "batchType", value = "H or D중 선택", required = true, dataType = "string", paramType = "query")
})
  @ResponseBody
  @RequestMapping(value = "/airstate/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute StatisticsVo statisticsVo) {
    
      List<StatisticsVo> results = statisticsService.selectList(statisticsVo);
      return ResponseEntity.ok(JSONResult.success(results));
  }

}
