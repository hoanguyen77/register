package org.hoanguyen.register.Repository;

import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.repository.RoleRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    Role role;



    @BeforeEach
    public void init()
    {
        role = new Role();
        role.setName("ROLE_SENIOR");
    }

    @Test
    @Order(1)
    public void testSaveRole(){
        roleRepository.save(role);
        Assertions.assertTrue(roleRepository.count() > 0);
    }


    @Test
    @Order(2)
    public void testFindRoleByName()
    {
        String expectedNameofRole = "ROLE_SENIOR";

        Role actualRole =  roleRepository.findRoleByName(expectedNameofRole);
        Assertions.assertEquals(expectedNameofRole, actualRole.getName());
    }
}
