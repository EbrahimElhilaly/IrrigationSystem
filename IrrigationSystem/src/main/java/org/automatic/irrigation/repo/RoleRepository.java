/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.repo;

import java.util.Optional;
import org.automatic.irrigation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BVS
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    
    Optional<Role> findByName(String name);
    
}
