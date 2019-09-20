package com.kadirtuna.issuemanagement.service.impl;

import com.kadirtuna.issuemanagement.entity.User;
import com.kadirtuna.issuemanagement.repository.UserRepository;
import com.kadirtuna.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private final UserRepository userRepository;

  @Override
  public User save(User user) {
    if (user.getEmail()==null) throw new IllegalArgumentException("User Email cannot be null!");
    return userRepository.save(user);
  }

  @Override
  public User getById(Long id) {
    return userRepository.getOne(id);
  }

  @Override
  public Page<User> getAllPageable(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public Boolean delete(User user) {
    userRepository.delete(user);
    return null;
  }

  @Override
  public User getByUsername(String username) {
    return userRepository.getByUsername(username);
  }
}
