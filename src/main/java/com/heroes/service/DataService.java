package com.heroes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.DataDao;
import com.heroes.vo.FoodVo;

@Service
public class DataService {

  @Autowired
  private DataDao dataDao;

  public List<FoodVo> selectFoodList() {
    return dataDao.selectFoodList();
  }


}
