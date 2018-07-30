package com.advantech.homework.service;
import com.advantech.homework.entity.User;
import com.advantech.homework.entity.UserQuery;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 用户管理 service层
 */
public interface  UserService {
    /**
     * 保存某一个用户
     * @param user
     * @return
     */
     User savaUser(User user);

    /**
     * 获取所有的用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 删除某一个用户
     * @param user
     */
     void deleteUser(User user);

    /**
     * 分页返回数据
     * @param page
     * @param size
     * @return
     */
     Page<User> findAllUserByPage(Integer page,Integer size);
    /**
     * 根据查询条件，分页返回数据
     * @param page
     * @param size
     * @return
     */
     Page<User> findUserByQuery(Integer page, Integer size, UserQuery userQuery);




}
