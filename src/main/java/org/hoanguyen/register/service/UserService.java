package org.hoanguyen.register.service;


import org.hoanguyen.register.dto.UserDTO;
import org.hoanguyen.register.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

  public UserDetails loadUserByUsername (String username);

    public void saveUser(UserDTO userDTO);
    public User findUserByEmailForSecurity(String email);

    public UserDTO findUserByEmail(String email);
}