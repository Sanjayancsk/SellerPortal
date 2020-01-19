package com.seller.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seller.portal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,CrudRepository<User, Integer> {
//	 public List<User> findAll();
//	    public User findByshop(int shop); 
}
