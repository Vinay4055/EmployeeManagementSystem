package com.apiconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiconsumer.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
