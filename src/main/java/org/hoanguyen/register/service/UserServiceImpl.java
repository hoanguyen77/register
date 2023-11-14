package org.hoanguyen.register.service;

import jakarta.transaction.Transactional;
import org.hoanguyen.register.dto.UserDTO;
import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.entity.User;

import org.hoanguyen.register.exception.UserExistException;
import org.hoanguyen.register.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleService roleService;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           @Lazy BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findUserByEmail(username);
        if(userOptional.isEmpty())
        {
            throw new UsernameNotFoundException("User doesn't exist");
        }
        else {
            User user = userOptional.get();

            List<Role> roleList = roleService.findRolesByUserId(user.getId());

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    mapRolesToAuthorities(roleList));
        }
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        Collection<? extends GrantedAuthority>
                mapRoles = roles.stream().map( role -> new SimpleGrantedAuthority(role.getName())).toList();

        return mapRoles;
    }
    @Override
    @Transactional
   public void saveUser(UserDTO userDTO) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            User user = modelMapper.map(userDTO, User.class);
            user.setRoles(Arrays.asList(roleService.findRoleByName(userDTO.getRole())));
            user.setPassword(encoder.encode(userDTO.getPassword()));
            userRepository.save(user);

    }

    @Override
    @Transactional
        public User findUserByEmailForSecurity(String email) {
//        TODO Implement when security component added
        return null;
    }

    @Override
    @Transactional
    public UserDTO findUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findUserByEmail(email);

        if(userOptional.isPresent()) {

            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            UserDTO userDTO = modelMapper.map(userOptional.get(), UserDTO.class);

            return userDTO;
        }
        else
            throw new RuntimeException("User does not exist");

    }

    }

