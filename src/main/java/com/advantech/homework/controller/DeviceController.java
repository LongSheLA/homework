package com.advantech.homework.controller;

import com.advantech.homework.entity.Device;
import com.advantech.homework.entity.ResponseDto;
import com.advantech.homework.entity.User;
import com.advantech.homework.excption.Controller500Exception;
import com.advantech.homework.service.DeviceService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/getAllDevicePagation",method = RequestMethod.GET)
    public  ResponseEntity<?> findAllDeviceByPageSize(@RequestParam(value = "page",defaultValue = "0")Integer page,
                                         @RequestParam(value="size",defaultValue = "5")Integer size)  {
        ResponseDto responseDto = new ResponseDto();
        ResponseEntity<?> responseEntity = null;
        Page<Device> allUserByPage = deviceService.findAllByPageSize(page-1,size);
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(allUserByPage);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        return responseEntity;
    }



    @RequestMapping(value = "/saveDevcie",method = RequestMethod.POST)
    public String saveDevcie(@RequestBody Device device){
        ResponseDto responseDto = new ResponseDto();
        ResponseEntity<?> responseEntity = null;
        Device device1 = deviceService.saveDevice(device);
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(device1);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        String s = JSONObject.toJSONString(responseEntity);
        return s;
    }

    @RequestMapping(value = "/getAllDevice",method = RequestMethod.GET)
    public String getAllDevice(){
        ResponseEntity<?> responseEntity = null;
        ResponseDto responseDto = new ResponseDto();
        List<Device> allDevice = deviceService.getAllDevice();
        responseDto.setCode("0");
        responseDto.setErrorMessage("");
        responseDto.setData(allDevice);
        responseEntity = new ResponseEntity<>(responseDto,HttpStatus.OK);
        String s = JSONObject.toJSONString(responseEntity.getBody());
        return s;
    }




}
