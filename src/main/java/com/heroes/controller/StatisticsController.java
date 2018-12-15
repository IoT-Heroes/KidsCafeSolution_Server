package com.heroes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.heroes.dto.JSONResult;
import com.heroes.service.StatisticsService;
import com.heroes.vo.StatisticsVo;
import api.ResponseHandler;
import api.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/statistics")
public class StatisticsController {

  @Autowired
  private StatisticsService statisticsService;
  ResponseHandler responseHandler = new ResponseHandler();

  @ApiImplicitParams({@ApiImplicitParam(name = "zoneId", value = "놀이구역ID", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "batchType", value = "H or D중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/airstate/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectAirstate(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectAirstate(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
  }

  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "자녀ID", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "batchType", value = "H or D중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/childactivity/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectChildActivity(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectChildActivity(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
  }

  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "자녀ID", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "batchType", value = "M or H중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/childpulse/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectChildPulse(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectChildPulse(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
  }

  @ApiImplicitParams({@ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "batchType", value = "H or D중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/income/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectIncome(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectIncome(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
  }

  @ApiImplicitParams({@ApiImplicitParam(name = "age", value = "연령대", required = true, dataType = "int", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "batchType", value = "M or H중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/usingfrequency/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectUsingfrequency(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectUsingFrequency(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
  }

  // 특정자녀가 존방문횟수(visiting record 기반)
  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "자녀 ID", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"),})
  @ResponseBody
  @RequestMapping(value = "/childusingfrequency/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectChildusingfrequency(@ModelAttribute StatisticsVo statisticsVo) {
      List<StatisticsVo> results = statisticsService.childusingfrequency(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);

  }

  /**
   * 놀이구역의 인기도를 날짜별로 구한다.
   * 
   * @param statisticsVo
   * @return
   */
  @ApiImplicitParams({@ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "batchType", value = "H or D중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/zonefrequency/select", method = RequestMethod.GET)
  public ResponseEntity<Object> selectZonefrequency(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectZonefrequency(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
  }

  /**
   * childId와 일치하는 연령대의 놀이구역 인기도를 날짜별로 구한다.
   * 
   * @param statisticsVo
   * @return
   */
  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "childId", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "endDate", value = "2018-12-05 10:10:18 형태", required = true, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "batchType", value = "H or D중 선택", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/zonefrequencybyage/select", method = RequestMethod.GET)
  public ResponseEntity<Object> zonefrequencybyage(@ModelAttribute StatisticsVo statisticsVo) {

      List<StatisticsVo> results = statisticsService.selectZonefrequencybyage(statisticsVo);
      return responseHandler.success(results, Status.SELECT_SUCCESS);
    }


}
