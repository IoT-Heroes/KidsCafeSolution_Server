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
import com.heroes.service.CafeVisitingRecordService;
import com.heroes.vo.CafeVisitingRecordVo;
import api.COMMONDATA;
import api.ResponseHelper;
import api.STATUS;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/visitingrecord/management")
public class CafeVisitingRecordController {

  @Autowired
  private CafeVisitingRecordService cafeVisitingRecordService;
  ResponseHelper responseHelper = new ResponseHelper();



  /**
   * band id, child id만 설정해서 보내줄것
   * 
   * @param cafeVisitingRecordVo
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public ResponseEntity<Object> insert(@RequestBody CafeVisitingRecordVo cafeVisitingRecordVo) {

    STATUS status;
    try {
      status = cafeVisitingRecordService.insert(cafeVisitingRecordVo);
    } catch (Exception e) {
      return responseHelper.fail(cafeVisitingRecordVo, e);
    }

    if (STATUS.SUCCESS == status) {
      return responseHelper.success(cafeVisitingRecordVo, STATUS.INSERT_SUCCESS);
    } else {
      return responseHelper.fail(cafeVisitingRecordVo, STATUS.INSERT_FAIL);
    }

  }

  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "자녀 ID", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select(@ModelAttribute CafeVisitingRecordVo cafeVisitingRecordVo) {

    List<CafeVisitingRecordVo> results = null;
    try {
      results = cafeVisitingRecordService.selectList(cafeVisitingRecordVo);
      return responseHelper.success(results, STATUS.SELECT_SUCCESS);
    } catch (Exception e) {
      return responseHelper.fail(cafeVisitingRecordVo, e);
    }


  }

  @ApiImplicitParams({@ApiImplicitParam(name = "childId", value = "자녀 ID", required = true, dataType = "string", paramType = "query"), @ApiImplicitParam(name = "startDate", value = "2018-12-05 10:10:10 형태", required = true, dataType = "string", paramType = "query")})
  @ResponseBody
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<Object> put(@ModelAttribute CafeVisitingRecordVo cafeVisitingRecordVo) {

    STATUS status;
    try {
      status = cafeVisitingRecordService.update(cafeVisitingRecordVo);
    } catch (Exception e) {
      return responseHelper.fail(cafeVisitingRecordVo, e);
    }
    if (STATUS.SUCCESS == status) {
      return responseHelper.success(cafeVisitingRecordVo, STATUS.UPDATE_SUCCESS);
    } else {
      return responseHelper.fail(cafeVisitingRecordVo, STATUS.UPDATE_FAIL);
    }
  }
}
