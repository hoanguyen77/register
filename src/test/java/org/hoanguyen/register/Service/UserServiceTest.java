package org.hoanguyen.register.Service;

import org.hoanguyen.register.dto.UserDTO;
import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.entity.User;
import org.hoanguyen.register.repository.RoleRepository;
import org.hoanguyen.register.repository.UserRepository;
import org.hoanguyen.register.service.RoleService;
import org.hoanguyen.register.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    UserDTO userDTO;
    Role role;
    @BeforeAll
    public void setUp()
    {
        role = new Role();
        role.setName("ROLE_MEMBER");
        roleRepository.save(role);
    }

    @BeforeEach
    public void init() {


        userDTO = new UserDTO();
        userDTO.setPassword("12123232");
        userDTO.setEmail("x@x");
        userDTO.setPhoneNumber("818-987-1234");

    }

//        user.setRoles(Arrays.asList(new Role("ROLE_EMPLOYEE")));
        @Test
        @Order(1)
        public void testSaveUser ()
        {
            userService.saveUser(userDTO);
            Assertions.assertTrue(userRepository.count() > 0);
        }

        @Test
        @Order(2)
        public void testFindUserByEmail () {
            UserDTO userDTOActual = userService.findUserByEmail("x@x");

            Assertions.assertEquals("x@x", userDTOActual.getEmail());
        }
    }
