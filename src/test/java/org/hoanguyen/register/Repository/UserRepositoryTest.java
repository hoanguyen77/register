package org.hoanguyen.register.Repository;
import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.entity.User;
import org.hoanguyen.register.repository.RoleRepository;
import org.hoanguyen.register.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    User user;

    Role role;
    @BeforeEach
    public void init()
    {
        role = new Role();
        role.setName("ROLE_MEMBER");
        roleRepository.save(role);

        user = new User();
        user.setEmail("x@x.com");
        user.setPassword("12123232");

        user.setPhoneNumber("818-987-1234");
        user.setRoles(Arrays.asList(new Role("ROLE_MEMBER")));
        user.setPassword(passwordEncoder.encode("12345"));


    }

    @Test
    @Order(1)
    public void testSaveUser()
    {
        userRepository.save(user);
        Assertions.assertTrue(userRepository.count() > 0);
    }

    @Test
    @Order(2)
    public void testFindUserByEmail(){
        User userActual = userRepository.findUserByEmail("test@test.com").get();

        Assertions.assertEquals("test@test.com", userActual.getEmail());
    }

}
