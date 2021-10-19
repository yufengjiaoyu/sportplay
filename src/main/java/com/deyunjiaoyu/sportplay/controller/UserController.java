package com.deyunjiaoyu.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.deyunjiaoyu.sportplay.bean.QueryInfo;
import com.deyunjiaoyu.sportplay.bean.User;
import com.deyunjiaoyu.sportplay.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo) {
    int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");
    int pageStart = (queryInfo.getPageNum()-1) * queryInfo.getPageSize();
   List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
    HashMap<String,Object> res = new HashMap<>();
    res.put("numbers",numbers);
    res.put("data",users);
      String res_string =  JSON.toJSONString(res);
      return res_string;


    }
}
