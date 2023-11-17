package org.hoanguyen.register.Service;

import org.hoanguyen.register.dto.UserDTO;
import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.repository.RoleRepository;
import org.hoanguyen.register.service.RoleService;
import org.hoanguyen.register.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleServiceTest {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    RoleRepository roleRepository;

    Role role;
    UserDTO userDTO;
    @BeforeEach
    public void init()
    {
        role = new Role();
        role.setName("ROLE_SENIOR");
    }

    @Test
    @Order(1)
    public void testSaveRole(){
        roleService.saveRole(role);
        Assertions.assertTrue(roleRepository.count() > 0);
    }


    @Test
    @Order(2)
    public void testFindRoleByName()
    {
        String expectedNameofRole = "ROLE_SENIOR";

        Role actualRole =  roleService.findRoleByName(expectedNameofRole);
        Assertions.assertEquals(expectedNameofRole, actualRole.getName());
    }
}
