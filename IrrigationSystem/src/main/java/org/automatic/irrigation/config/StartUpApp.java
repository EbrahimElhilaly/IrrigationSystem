/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.config;

import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.automatic.irrigation.entity.Role;
import org.automatic.irrigation.entity.User;
import org.automatic.irrigation.service.RoleService;
import org.automatic.irrigation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author BVS
 */
@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {

        if (roleService.getAllRoles().isEmpty()) {

            roleService.insertRole(new Role(null, "admin"));
            roleService.insertRole(new Role(null, "user"));

        }
        
         if (userService.getAllUsers().isEmpty()) {
             
             Set<Role> adminRoles = new HashSet<>();
             
        adminRoles.add(roleService.findByName("admin"));
        Set<Role> userRoles = new HashSet<>();
        adminRoles.add(roleService.findByName("user"));
            userService.insertUser(new User(null,"Ibhelali","456", adminRoles));
            userService.insertUser(new User(null,"macrooo55","555", userRoles));

        }

    }
    
    

}
