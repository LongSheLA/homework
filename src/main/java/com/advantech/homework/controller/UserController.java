package com.advantech.homework.controller;

import com.advantech.homework.entity.Device;
import com.advantech.homework.entity.ResponseDto;
import com.advantech.homework.entity.User;
import com.advantech.homework.entity.UserQuery;
import com.advantech.homework.service.DeviceService;
import com.advantech.homework.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "getAllUser",method = RequestMethod.GET)
    public String getAllUser(){
        ResponseDto responseDto = new ResponseDto();
        ResponseEntity<?> responseEntity = null;
        List<User> allUser = userService.getAllUser();
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(allUser);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        String s = JSONObject.toJSONString(responseEntity.getBody());
        return s;
    }

    @RequestMapping(path = "saveUser",method = RequestMethod.POST)
    public String  saveUser(@RequestBody User user){
        ResponseDto responseDto = new ResponseDto();
        ResponseEntity<?> responseEntity = null;
        user.setPassword("123456");
        User user1 = userService.savaUser(user);
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(user1);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        String s = JSONObject.toJSONString(responseEntity.getBody());
        return s;
    }

//    @RequestMapping(path="findAllByPage",method ={RequestMethod.GET,RequestMethod.POST})
//    public ResponseEntity<?> findAllByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
//                                           @RequestParam(value = "size", defaultValue = "5") Integer size){
//
//        ResponseDto responseDto = new ResponseDto();
//        ResponseEntity<?> responseEntity = null;
//        Page<User> allUserByPage = userService.findAllUserByPage(page-1, size);
//        responseDto.setCode("0");
//        responseDto.setErrorMessage("");
//        responseDto.setData(allUserByPage);
//
//        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
//        return responseEntity;
//    }


    @RequestMapping(path="/findAllByPage",method ={RequestMethod.GET,RequestMethod.POST})
    public String findAllByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "size", defaultValue = "5") Integer size){

        ResponseDto responseDto = new ResponseDto();
        ResponseEntity<?> responseEntity = null;
        Page<User> allUserByPage = userService.findAllUserByPage(page-1, size);
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(allUserByPage);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        String s = JSONObject.toJSONString(responseEntity.getBody());
        return s;
    }


    @RequestMapping(value = "/findUserQuery",method = {RequestMethod.GET,RequestMethod.POST})
    public String findUserQuery(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "5") Integer size, UserQuery userQuery){

        ResponseDto responseDto = new ResponseDto();
        ResponseEntity<?> responseEntity = null;
        Page<User> datas = userService.findUserByQuery(page-1,size,userQuery);
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(datas);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        String s = JSONObject.toJSONString(responseEntity.getBody());
        return s;
    }
}
