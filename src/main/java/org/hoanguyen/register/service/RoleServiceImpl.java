package org.hoanguyen.register.service;


import jakarta.transaction.Transactional;
import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.repository.RoleRepository;
import org.hoanguyen.register.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    @Override
   @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
    @Override
    @Transactional
    public List<Role> findRolesByUserId(int id) {
        return roleRepository.findRoleByUserId(id);

    }

    @Override
    @Transactional
    public List<Role> getRolesByUser(int id) {
        return roleRepository.findRoleByUserId(id);
    }
}