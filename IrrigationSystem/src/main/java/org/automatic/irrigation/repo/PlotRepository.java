/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.repo;

import org.automatic.irrigation.entity.Plot;
import org.automatic.irrigation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
    
}
