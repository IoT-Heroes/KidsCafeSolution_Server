package com.heroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroes.dto.JSONResult;
import com.heroes.service.DataService;
import com.heroes.service.IoTMakersService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/data")
public class DataController {
  @Autowired
  private DataService dataService;

  @Autowired
  private IoTMakersService ioTMakersService;

  @ResponseBody
  @RequestMapping(value = "/food/select", method = RequestMethod.GET)
  public ResponseEntity<Object> select() {

    ioTMakersService.test();
    return ResponseEntity.ok(JSONResult.success(dataService.selectFoodList()));

  }
}
