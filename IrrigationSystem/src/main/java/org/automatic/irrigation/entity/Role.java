/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author BVS
 */
@Entity
@Table(name ="ROLE")
@Data
@AllArgsConstructor
public class Role {

    @Id
    private Long id;

    private String name;

}
