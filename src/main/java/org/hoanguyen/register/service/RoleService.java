package org.hoanguyen.register.service;



import org.hoanguyen.register.entity.Role;

import java.util.List;

public interface RoleService {

    public void saveRole(Role role);
    public Role findRoleByName(String name);
    public List<Role> getRolesByUser(int id);
    public List<Role> findRolesByUserId(int id);
}
