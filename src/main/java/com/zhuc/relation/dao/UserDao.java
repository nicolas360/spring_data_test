package com.zhuc.relation.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhuc.relation.entity.User;

public interface UserDao extends UserDaoPlus, PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

}
