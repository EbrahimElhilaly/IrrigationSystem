/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.automatic.irrigation.service;

import org.automatic.irrigation.repo.PlotRepository;
import java.util.List;
import java.util.Optional;
import org.automatic.irrigation.entity.Plot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BVS
 */
@Service
public class PlotService {

    @Autowired
    private PlotRepository plotRepository;

    public Plot addPlot(Plot plot) {
        return plotRepository.save(plot);
    }

    public Plot updatePlot(Plot plot) {
        return plotRepository.save(plot);
    }

    public List<Plot> getAllPlots() {
        return plotRepository.findAll();
    }

    public Optional<Plot> getPlotById(Long id) {
        return plotRepository.findById(id);
    }

    public void deletePlotById(Long id) {
        plotRepository.deleteById(id);
    }
}


