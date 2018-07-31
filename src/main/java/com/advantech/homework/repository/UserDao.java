package com.advantech.homework.repository;

import com.advantech.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

    @Query(value="SELECT * FROM user_info as u where u.name = ?1",nativeQuery = true)
    User verfiyUser(String name);
}
