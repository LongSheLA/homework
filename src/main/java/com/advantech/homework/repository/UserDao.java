package com.advantech.homework.repository;

import com.advantech.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
}
