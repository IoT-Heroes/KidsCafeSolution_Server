package com.heroes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heroes.repository.ChildDao;
import com.heroes.vo.ChildVo;
import com.heroes.vo.FoodVo;

@Service
public class ChildService {

  @Autowired
  private ChildDao childDao;

  public int insert(ChildVo childVo) {
    return childDao.insert(childVo);
  }
  
  public int insert(List<ChildVo> childVoList) {
    int insertCounter = 0; 
    
    for(ChildVo paramChildVo:childVoList) {
      insertCounter += childDao.insert(paramChildVo);
    }
      
    if(insertCounter != childVoList.size()) {
      // insert error occured
      // rollback!
      
    }
    return insertCounter;
  }

  public List<ChildVo> selectList(ChildVo childVo) {
    List<ChildVo> childVoList = childDao.selectList(childVo);
    for (ChildVo resChildVo : childVoList) {
      List<FoodVo> eatableFoodList = childDao.selectEatableFoodList(childVo);
      resChildVo.setEatableFoodList(eatableFoodList);
    }

    return childVoList;
  }  
}
