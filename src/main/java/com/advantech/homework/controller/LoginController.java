package com.advantech.homework.controller;


import com.advantech.homework.entity.ResponseDto;
import com.advantech.homework.entity.User;
import com.advantech.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Map<?,?> loginParams){
        ResponseDto responseDto = null;
        ResponseEntity<?> responseEntity = null;
        String name = null;
        String password = null;
        if( loginParams.get("userName") == null || loginParams.get("password") == null ){
            responseDto= new ResponseDto("401","缺少用户名或密码",null);
            responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
            return responseEntity;
        }
        name = (String)loginParams.get("userName");
        password = (String)loginParams.get("password");
        User u = userService.verfiyUser(name);
        if(u == null){
            responseDto= new ResponseDto("402","不存在该用户",null);
            responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
            return responseEntity;
        }
        if(!u.getPassword().equals(password)){
            responseDto= new ResponseDto("403","用户名或密码错误",null);
            responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
            return responseEntity;
        }

        responseDto= new ResponseDto("0","ok",u);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return responseEntity;
    }

}
