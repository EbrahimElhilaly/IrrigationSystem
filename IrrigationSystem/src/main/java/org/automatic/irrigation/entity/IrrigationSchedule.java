package org.automatic.irrigation.entity;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
public class IrrigationSchedule {
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double waterRequirement;
}
