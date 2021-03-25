package com.controller;

import com.Services.AccountBiz;
import com.alibaba.fastjson.JSON;
import com.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping(value="/user")
public class AccountController {

    @Autowired
    private AccountBiz accountBiz;

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/superLogin",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String superLogin(@RequestBody Map<String,Object> params) throws IOException {

        int i = accountBiz.superLogin(params.get("input").toString(), params.get("password").toString());
        return i+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/login",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String administerLogin(@RequestBody Map<String,Object> params) throws IOException {

        int i = accountBiz.administerLogin(params.get("input").toString(), params.get("password").toString());
        return i+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/updateAdminister",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String updateAdminister(@RequestBody Map<String,Object> params) throws IOException {
        int i= accountBiz.setAdminister(params.get("aid").toString(), params.get("classes").toString());
        return i+"";
    }

    //ResponseBody表示不进行跳转直接打印
    @RequestMapping(value="/showAllUser",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String showAllUser(@RequestBody Map<String,Object> params) throws IOException {
        Map<String, String> map = new HashMap<>();
        List<String> userList = new ArrayList<>();
        List<Account> users = accountBiz.findAllUser();
        for(int i = 0;i<users.size();i++){
            String json= JSON.toJSONString(users.get(i));
            map.put((i+1)+"", json);
            userList.add(json);
        }

        return JSON.toJSONString(userList);
    }
//3.9
    @RequestMapping(value="/ManualImport",produces = "application/json;charset=UTF-8",method= RequestMethod.POST)
    @ResponseBody
    public String ManualImport(@RequestBody Map<String,Object> params) throws IOException {
        String aidReceive = params.get("aid").toString();
        String password=aidReceive;
        String name = params.get("name").toString();
        char classes=T;///
        String tel = params.get("tel").toString();
        String academic = params.get("academic").toString();

        int i = accountBiz.ManualImport(aidReceive,password,name,classes,tel,academic);
        return i+"";
    }
}
