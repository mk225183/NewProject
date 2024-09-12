package com.mk.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mk.entity.User;
import com.mk.entity.User1;

@Repository
public interface UserRepository1 extends CrudRepository<User1,Long> {
}