/**
 * @Author Falco Constantine
 * @Project Users list
 * @Version 1.0
 * @Date 2018.03.17
 *
 */
package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<User, Integer> {
//no methods here
}
