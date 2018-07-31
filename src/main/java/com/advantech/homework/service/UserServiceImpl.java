package com.advantech.homework.service;

import com.advantech.homework.entity.Device;
import com.advantech.homework.entity.User;
import com.advantech.homework.entity.UserQuery;
import com.advantech.homework.repository.DeviceDao;
import com.advantech.homework.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User savaUser(User user){
        return userDao.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUser(){
        return  userDao.findAll();
    }

    @Override
    public void deleteUser(User user){
        userDao.delete(user);
    }

    @Override
    public Page<User> findAllUserByPage(Integer page, Integer size){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<User> all = userDao.findAll(pageable);
        return remove(all);
    }

    @Override
    public Page<User> findUserByQuery(Integer page, Integer size, final UserQuery userQuery ){
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<User> bookPage = userDao.findAll(new Specification<User>(){
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(null!=userQuery.getName()&&!"".equals(userQuery.getName())){
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), userQuery.getName()));
                }
                if(null!=userQuery.getRole()&&!"".equals(userQuery.getRole())){
                    list.add(criteriaBuilder.equal(root.get("role").as(String.class), userQuery.getRole()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        return remove(bookPage);
    }

    @Override
    public User verfiyUser(String name){
        return userDao.verfiyUser(name);
//        if(user == null){
//            return 0;
//        }
//        if (!user.getPassword().equals(password)){
//            return 1;
//        }
//        return 2;

    }




    public Page<User> remove(Page<User> userPage){
        for(User user:userPage){
            List<Device> deviceList = user.getDeviceList();
            for(Device device: deviceList){
                device.setUserList(new ArrayList<>());
            }
        }
        return userPage;
    }

}
