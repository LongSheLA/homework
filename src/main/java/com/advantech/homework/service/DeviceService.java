package com.advantech.homework.service;

import com.advantech.homework.entity.Device;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *  设备管理 service层
 */
public interface DeviceService {
    /**
     * 保存一个设备
     * @param device
     * @return
     */
    public Device saveDevice(Device device);

    /**
     * 返回所有设备
     * @return
     */
    public List<Device> getAllDevice();

    /**
     * 分页返回所有数据
     * @param page
     * @param size
     * @return
     */
    Page<Device> findAllByPageSize(Integer page,Integer size);
}
