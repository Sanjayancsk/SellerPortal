package com.seller.portal.service;

import java.util.List;

import javax.validation.Valid;

import com.seller.portal.model.User;

public interface UserService {
 public void saveUser(User user);
 public boolean isUserAlreadyPresent(User user);
void updateUser(User user);
//public List<User> findAll();
void updateIdentity(User user);
void updateBank(User user);
void updatePassword(User user);
}
