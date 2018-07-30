package com.advantech.homework.service;

import com.advantech.homework.entity.Device;
import com.advantech.homework.repository.DeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public Device saveDevice(Device device){
        return  deviceDao.saveAndFlush(device);
    }

    @Override
    public List<Device> getAllDevice(){
        return deviceDao.findAll();
    }

    @Override
    public Page<Device> findAllByPageSize(Integer page, Integer size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return deviceDao.findAll(pageable);
    }


}
