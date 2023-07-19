/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.service;

import java.util.List;
import java.util.Optional;
import org.automatic.irrigation.entity.Role;
import org.automatic.irrigation.entity.User;
import org.automatic.irrigation.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BVS
 */

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;


    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
    
    public Role insertRole(Role role) {
      return roleRepository.save(role);
    }
     public Role findByName(String name) {
      return roleRepository.findByName(name).orElse(null);
    }
    
    
    
}
